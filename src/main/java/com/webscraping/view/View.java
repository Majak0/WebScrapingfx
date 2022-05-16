package com.webscraping.view;

import com.webscraping.model.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

import static com.webscraping.Boot.primaryStage;
import static com.webscraping.Boot.scene_menu;

public class View {

    public final Pane root;
    final Model model;
    ViewVendor currentVendor;

    // PANE
    Pane paneVendor;
    public ScrollPane scrollPane;

    public View(Model model) {
        this.model = model;
        root = new Pane();
        searchProduct();
    }

    /**
     * Sets up the view to search a product
     */
    public void searchProduct() {
        scrollPane = new ScrollPane();
        scrollPane.setPrefSize(1200,700);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVvalue(scrollPane.getVmax());
        scrollPane.setStyle("-fx-border-color: black");
        scrollPane.setContent(root);
    }

    /**
     * Start the searching view (the requested vendor)
     */
    public void showVendors() {
        root.getChildren().clear();

        paneVendor = new Pane();
        paneVendor.setPrefSize(model.width, model.height);
        for (int i = 0; i < Model.vendors.size(); i++) {
            if (model.vendor - 1 == i) {
                currentVendor = new ViewVendor(model, paneVendor, i);
                break;
            }
        }
        root.getChildren().add(paneVendor);
    }

    /**
     * Return to menu
     */
    public void returnMenu(){
        primaryStage.setScene(scene_menu);
    }
}
