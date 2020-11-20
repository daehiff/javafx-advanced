package org.openjfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ControlElementsController extends MyViewController {


    public TextField inputTextfield;

    public Button sayItButton;

    public Label sayItLabel;


    public void initialize() {
        inputTextfield.clear();
    }


    @FXML
    public void onBack(ActionEvent e) {
        try {
            this.mainApp.showPrimaryScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


