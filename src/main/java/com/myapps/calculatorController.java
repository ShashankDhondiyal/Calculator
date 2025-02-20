package com.myapps;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class calculatorController {

    @FXML
    private Rectangle Display;

    @FXML
    private Label displayLabel;

    private Logic logic = new Logic();
    private boolean solved = false;

    @FXML
    public void handleButtonClick(javafx.event.ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String value = clickedButton.getText();
        if (solved) {
            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                solved = false;
            } else {
                logic.clearEquation();
                solved = false;
            }
        }
        logic.addToEquation(value);
        updateDisplay();
    }

    @FXML
    private void handleSolve() throws IOException {
        String equation = logic.getEquation();
        logic.setEquation(equation);
        String postfix = Logic.toPostfix(equation);
        Logic.TreeNode root = Logic.buildTree(postfix);
        double result = Logic.evaluate(root);
        displayLabel.setText(formatResult(result));
        logic.setSingleValue(formatResult(result));
        solved = true;
    }

    @FXML
    private void handleClear() throws IOException {
        logic.clearEquation();
        updateDisplay();
        solved = false;
    }

    private void updateDisplay() {
        displayLabel.setText(logic.getEquation());
    }

    private String formatResult(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            BigDecimal bd = new BigDecimal(result).setScale(3, RoundingMode.HALF_UP);
            return bd.stripTrailingZeros().toPlainString();
        }
    }
}
