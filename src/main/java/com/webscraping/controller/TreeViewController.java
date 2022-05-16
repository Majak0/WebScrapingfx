package com.webscraping.controller;

import javafx.event.ActionEvent;

import static com.webscraping.Boot.primaryStage;
import static com.webscraping.Boot.scene_menu;

public class TreeViewController {

    /**
     * Return to the menu
     */
    public void returnMenu(ActionEvent actionEvent) {
        primaryStage.setScene(scene_menu);
    }
}
