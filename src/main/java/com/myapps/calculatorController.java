package com.myapps;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class calculatorController {
    
    private String text;

    @FXML
    private Text DisplayText;

    @FXML
    private Rectangle Display;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void handleNumberClick(javafx.event.ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        text = clickedButton.getText();
        DisplayText.setText(text);
    }

    @FXML
    private void handleOperatorClick() throws IOException {
        // display on display 
        // add to calculator class arraylist
    }

    @FXML
    private void handleSolve() throws IOException {
        // call calculator class
    }

    @FXML
    private void handleClear() throws IOException {
        // set display to clear
    }
}
