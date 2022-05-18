package com.webscraping;

import com.webscraping.controller.Controller;
import com.webscraping.model.Model;
import com.webscraping.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Boot extends Application {
    public static View view;
    public static Model model;
    public static Controller controller;
    public static Stage primaryStage;
    public static Scene scene_artdata;
    public static Scene scene_parameters;
    public static Scene scene_vendorsLister;
    public static Scene scene_treeView;
    public static Scene scene_menu;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        model = new Model();
        view = new View(model);
        controller = new Controller(model, view);

        // Load all the FXML
        loadFXML();

        stage.setTitle("~ Data Web Scrapping ~");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene_menu);
        stage.show();
    }

    private void loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
        Parent root_menu = fxmlLoader.load();

        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/tree.fxml"));
        Parent root_tree = fxmlLoader.load();

        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/vendorLister.fxml"));
        Parent root_vendor = fxmlLoader.load();

        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/rapprochement.fxml"));
        Parent root_rapprochement = fxmlLoader.load();

        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/parametres.fxml"));
        Parent root_parameters = fxmlLoader.load();

        // SCENES PRINCIPALES
        scene_menu = new Scene(root_menu, model.width, model.height);
        scene_treeView = new Scene(root_tree, model.width,model.height);
        scene_vendorsLister = new Scene(root_vendor,model.width, model.height);
        scene_parameters = new Scene(root_parameters,model.width, model.height);
        scene_artdata = new Scene(root_rapprochement,model.width, model.height);
    }
}