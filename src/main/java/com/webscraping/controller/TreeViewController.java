package com.webscraping.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import static com.webscraping.Boot.*;

public class TreeViewController {

    @FXML
    Label vendorIdentifiant;

    /**
     * Return to the menu
     */
    public void returnBack(ActionEvent actionEvent) {
        primaryStage.setScene(scene_vendorsLister);
    }
}
