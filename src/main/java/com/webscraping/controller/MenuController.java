package com.webscraping.controller;

import com.webscraping.menu.VendorsMenu;
import javafx.scene.Scene;

import static com.webscraping.Boot.*;

public class MenuController {

    public static Scene scene_vendors;


    /**
     * Search button
     */
    public void search() {
        VendorsMenu vendorsMenu = new VendorsMenu();
        scene_vendors = new Scene(vendorsMenu.scrollPane, 1000, 700);
        primaryStage.setScene(scene_vendors);
    }

    /**
     * Listing button
     */
    public void ListingVendor() {
        primaryStage.setScene(scene_treeView);
    }

    /**
     * Options button
     */
    public void options() {
        primaryStage.setScene(scene_vendorsLister);
    }

    public void quit() {
        System.exit(0);
    }
}