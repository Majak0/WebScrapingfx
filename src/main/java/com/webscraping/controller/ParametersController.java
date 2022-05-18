package com.webscraping.controller;

import javafx.event.ActionEvent;

import static com.webscraping.Boot.primaryStage;
import static com.webscraping.Boot.scene_menu;

public class ParametersController {

    /**
     * return to the menu
     */
    public void retourMenu(ActionEvent actionEvent) {
        primaryStage.setScene(scene_menu);
    }
}
