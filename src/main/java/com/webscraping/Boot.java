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

public class Boot extends Application {
    public static View view;
    public static Model model;
    public static Controller controller;
    public static Stage primaryStage;
    public static Scene scene_vendorsLister;
    public static Scene scene_treeView;
    public static Scene scene_vendors;
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

        // FXML
        FXMLLoader fxmlLoaderMenu = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
        Parent root_menu = fxmlLoaderMenu.load();

        FXMLLoader fxmlLoaderTree = new FXMLLoader(getClass().getResource("fxml/tree.fxml"));
        Parent root_tree = fxmlLoaderTree.load();

        FXMLLoader fxmlLoaderVendors = new FXMLLoader(getClass().getResource("fxml/vendorLister.fxml"));
        Parent root_vendor = fxmlLoaderVendors.load();

        // SCENES PRINCIPALES
        scene_menu = new Scene(root_menu, model.width, model.height);
        scene_vendors = new Scene(view.scrollPane, model.width, model.height);
        scene_treeView = new Scene(root_tree, model.width,model.height);
        scene_vendorsLister = new Scene(root_vendor,model.width, model.height);

        stage.setTitle("~ Data Web Scrapping ~");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene_menu);
        stage.show();
    }
}