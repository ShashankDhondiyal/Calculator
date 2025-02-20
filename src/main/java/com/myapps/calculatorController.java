package com.myapps;

import java.io.IOException;
import javafx.fxml.FXML;

public class calculatorController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void handleNumberClick() throws IOException {
        // display on display
        // add to calculator class arraylist
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
