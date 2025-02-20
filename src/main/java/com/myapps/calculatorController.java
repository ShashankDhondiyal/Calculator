package com.myapps;

import java.io.IOException;
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

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void handleButtonClick(javafx.event.ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String number = clickedButton.getText();
        logic.addToEquation(number);
        updateDisplay();
    }

    private void updateDisplay() {
        displayLabel.setText(logic.getEquation());
    }

    @FXML
    private void handleSolve() throws IOException {
        // call calculator class
    }

    @FXML
    private void handleClear() throws IOException {
        logic.clearEquation();
        updateDisplay();
    }
}
