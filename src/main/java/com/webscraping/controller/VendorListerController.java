package com.webscraping.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import static com.webscraping.Boot.*;

public class VendorListerController {

    @FXML
    GridPane gridPane;
    @FXML
    TextField elementToSearch;
    @FXML
    RadioButton buttonRef;
    @FXML
    RadioButton buttonUrl;

    public void retourMenu(ActionEvent actionEvent) {
        primaryStage.setScene(scene_menu);
    }

    public void buttonRefClicked(ActionEvent actionEvent) {
        if (!buttonUrl.isSelected()){
            buttonUrl.setSelected(true);
            buttonRef.setSelected(false);
        } else {
            buttonUrl.setSelected(false);
            buttonRef.setSelected(true);
        }
    }

    public void buttonUrlClicked(ActionEvent actionEvent) {
        if (!buttonRef.isSelected()){
            buttonRef.setSelected(true);
            buttonUrl.setSelected(false);
        } else {
            buttonRef.setSelected(false);
            buttonUrl.setSelected(true);
        }
    }

    public void search(ActionEvent actionEvent) {
        String pattern = elementToSearch.getText();
        if (pattern.equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informations needed");
            alert.setHeaderText("Please verify you have entered the correct type of string you want to search");
            alert.setContentText("Failed to search products !");
            alert.showAndWait();
        }
    }

    public void goToViewVendor(ActionEvent actionEvent) {
        primaryStage.setScene(scene_treeView);
    }

    public void createGrid(ActionEvent actionEvent) {

        int indexY=0;
        Label vendorName;
        for (int index = 0; index<model.vendors.size(); index++){
            System.out.println("adding a row");
            vendorName = new Label(model.vendors.get(index));
            vendorName.setFont(new Font(18));
            vendorName.setStyle("-fx-font-weight: bold");
            gridPane.addRow(index,vendorName);
        }
    }
}
