package com.webscraping.controller;

import static com.webscraping.Boot.*;

public class MenuController {

    /**
     * Search button
     */
    public void search() {
        primaryStage.setScene(scene_vendorsLister);
    }

    /**
     * Listing button
     */
    public void rapprochement() {
        primaryStage.setScene(scene_artdata);
    }

    /**
     * Options button
     */
    public void options() {
        primaryStage.setScene(scene_parameters);
    }

    public void quit() {
        System.exit(0);
    }
}