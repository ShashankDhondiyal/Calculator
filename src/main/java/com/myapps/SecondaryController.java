package com.myapps;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToCalculator() throws IOException {
        App.setRoot("calculator");
    }
}