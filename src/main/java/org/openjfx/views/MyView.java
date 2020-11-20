package org.openjfx.views;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.openjfx.viewController.CodedViewController;


public class MyView extends BorderPane {


    private CodedViewController controller;


    public MyView() {
        VBox center = new VBox();
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10.0);
        center.setPrefWidth(500.0);
        center.setPrefHeight(200.0);

        Label startDescription = new Label("You want to start your game?");
        Button startButton = new Button("Start");
        center.getChildren().addAll(startDescription, startButton); // order matters!

        this.setCenter(center);


        VBox top = new VBox();
        top.setPrefWidth(500.0);

        Button backButton = new Button("Back");
        backButton.setOnAction(this::onBackButton);
        top.getChildren().addAll(backButton);

        this.setTop(top);


        this.setHeight(250.0);
        this.setWidth(500.0);
    }


    private void onBackButton(ActionEvent e) {
        this.controller.moveBack();
    }


    public void setController(CodedViewController controller) {
        this.controller = controller;
    }
}


