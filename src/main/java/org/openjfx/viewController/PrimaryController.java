package org.openjfx.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class PrimaryController extends MyViewController {


    public VBox mainVBox;


    public void initialize() {
        mainVBox.setOnMouseDragged(e -> {
            System.out.println(e.getX() + " " + e.getY());
        });

    }

    @FXML
    public void onShowControlElements(ActionEvent e) {
        try {
            this.mainApp.showControlsScene();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    public void showCodedSceneFXMLStyle(ActionEvent e) {
        try {
            this.mainApp.showCodedSceneWithStyle();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onShowCodedSceneFXML(ActionEvent e) {
        try {
            this.mainApp.showCodedSceneFXML();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onShowCodedScene(ActionEvent e) {
        this.mainApp.showCodedScene();
    }
}



