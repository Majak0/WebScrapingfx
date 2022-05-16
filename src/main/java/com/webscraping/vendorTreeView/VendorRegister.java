package com.webscraping.vendorTreeView;

import com.webscraping.model.Model;

import javafx.scene.layout.*;

import static com.webscraping.Boot.*;
import static com.webscraping.model.Model.findAllVendors;

public class VendorRegister extends Pane {

    public VendorRegister(){
        Pane paneListVendor = new Pane();
        paneListVendor.setPrefSize(500,300);

        paneListVendor.getChildren().addAll();
        getChildren().add(paneListVendor);
    }

    /**
     * Back to the menu
     */
    void menu() {
        Model.vendors = findAllVendors();
        primaryStage.setWidth(1200);
        primaryStage.setScene(scene_menu);
    }
}