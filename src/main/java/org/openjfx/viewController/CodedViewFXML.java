package org.openjfx.viewController;

import javafx.fxml.FXML;

import java.io.IOException;

public class CodedViewFXML extends MyViewController {

    @FXML
    public void onBackButton() {
        try {
            this.mainApp.showPrimaryScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
