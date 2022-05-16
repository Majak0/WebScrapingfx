package com.webscraping.menu;

import com.webscraping.Boot;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import static com.webscraping.Boot.*;


public class OptionsMenu extends Pane {

    public static Pane paneOptionsMenu;
    public static Button buttonMenu;

    public OptionsMenu() {

        // Pane general
        paneOptionsMenu = new Pane();
        paneOptionsMenu.setPrefSize(1000, 700);

        // Button return to menu
        buttonMenu = new Button();
        buttonMenu.setLayoutX(950);
        buttonMenu.setLayoutY(650);
        buttonMenu.setOnAction(e -> returnMenu());
        buttonMenu.setStyle("-fx-background-image: url('"+ Boot.class.getResource("icons/back.png")+"');-fx-background-color: transparent;-fx-background-repeat: no-repeat; -fx-background-size: 100%");
        buttonMenu.setPrefSize(125, 125);
        paneOptionsMenu.getChildren().add(buttonMenu);

        getChildren().add(paneOptionsMenu);
    }

    public void returnMenu() {
        primaryStage.setScene(scene_menu);
    }
}