package com.webscraping.menu;


import com.webscraping.model.Model;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static com.webscraping.Boot.*;
import static com.webscraping.model.Model.vendors;

public class VendorsMenu extends Pane {

    public ScrollPane scrollPane = new ScrollPane();

    public VendorsMenu() {

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Size
        setPrefSize(1000,700);

        Label title = new Label("Liste des fournisseurs");
        title.setFont(new Font(50));
        title.setStyle("-fx-font-weight: bold; -fx-text-fill: black");
        title.setLayoutX(250); title.setLayoutY(50);

        // Button return menu
        Button buttonMenu = new Button();
        buttonMenu.setLayoutX(925);
        buttonMenu.setLayoutY(610);
        buttonMenu.setOnAction(e -> returnMenu());
        ImageView imageView = new ImageView(new Image("file:src/main/resources/com/webscraping/icons/back.png"));
        buttonMenu.setGraphic(imageView);
        buttonMenu.setPrefSize(40, 40);
        buttonMenu.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));

        getChildren().addAll(title,buttonMenu);

        // Browse levels
        int nbVendorsInLigne = 0;
        int ligne = 0;
        int compteur = 1;
        for (String vendorName : vendors) {
            // Print and creation
            ButtonVendor buttonVendor = new ButtonVendor(vendorName, 100 + nbVendorsInLigne * 225, 200 + ligne * 200);
            int finalCompteur = compteur;
            buttonVendor.setOnAction(e -> selectVendor(finalCompteur));
            getChildren().add(buttonVendor);
            compteur++;
            nbVendorsInLigne++;

            // If 4 levels in a line, we start a new line
            if (nbVendorsInLigne == 4) {
                nbVendorsInLigne = 0;
                ligne++;
            }
        }
        scrollPane.setContent(this);
    }

    /**
     * Select a vendor
     * @param i : vendor number
     */
    public void selectVendor(int i) {
        if (model.state == Model.STATE_INITIAL) {
            primaryStage.setScene(scene_vendors);
            model.vendor = i;
            controller.showVendors();
        }
    }

    public void returnMenu() {
        primaryStage.setScene(scene_menu);
    }
}