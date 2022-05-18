package com.webscraping.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.Map;

import static com.webscraping.Boot.*;

public class VendorListerController {

    @FXML
    GridPane vendorsContainer;
    @FXML
    TextField elementToSearch;
    @FXML
    RadioButton buttonRef;
    @FXML
    RadioButton buttonUrl;
    @FXML
    Label actualVendor;

    /**
     * return to the menu
     */
    public void retourMenu(ActionEvent actionEvent) {
        primaryStage.setScene(scene_menu);
    }

    /**
     * Change the value of the button url when the button reference is pressed
     * @param actionEvent
     */
    public void buttonRefClicked(ActionEvent actionEvent) {
        if (!buttonUrl.isSelected()){
            buttonUrl.setSelected(true);
            buttonRef.setSelected(false);
        } else {
            buttonUrl.setSelected(false);
            buttonRef.setSelected(true);
        }
    }

    /**
     * Change the value of the button reference when the button url is pressed
     * @param actionEvent
     */
    public void buttonUrlClicked(ActionEvent actionEvent) {
        if (!buttonRef.isSelected()){
            buttonRef.setSelected(true);
            buttonUrl.setSelected(false);
        } else {
            buttonRef.setSelected(false);
            buttonUrl.setSelected(true);
        }
    }

    /**
     * Will look the information given by the user and if it's correct apply the filter
     * @param actionEvent
     */
    public void search(ActionEvent actionEvent) {
        boolean error = true;
        String pattern = elementToSearch.getText();
        if (pattern.equals("")){
            ActionEvent action;
            createGrid(action = new ActionEvent());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informations manquantes");
            alert.setHeaderText("Merci d'entrer une valeur afin de pouvoir appliquer le filtre");
            alert.setContentText("Impossible d'effectuer la recherche !");
            alert.showAndWait();
        } else {
            if (buttonRef.isSelected()) {
                pattern = pattern.toUpperCase();
                for (Map.Entry mapOfVendors : model.vendors.entrySet()) {
                    if (pattern.equals(mapOfVendors.getKey())) {
                        vendorsContainer.getChildren().clear();
                        vendorsContainer.setGridLinesVisible(false);
                        Button vendorName = createButton((String) mapOfVendors.getKey());
                        Button vendorUrl = createButton((String) mapOfVendors.getValue());

                        vendorsContainer.add(vendorName, 0, 0);
                        vendorsContainer.add(vendorUrl, 1, 0);
                        error = false;
                    }
                }
            } else {
                for (Map.Entry mapOfVendors : model.vendors.entrySet()) {
                    if (pattern.equals(mapOfVendors.getValue())) {
                        vendorsContainer.getChildren().clear();
                        vendorsContainer.setGridLinesVisible(false);
                        Button vendorName = createButton((String) mapOfVendors.getKey());
                        Button vendorUrl = createButton((String) mapOfVendors.getValue());

                        vendorsContainer.add(vendorName, 0, 0);
                        vendorsContainer.add(vendorUrl, 1, 0);
                        error = false;
                    }
                }
            }
            if (error){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informations erronées");
                alert.setHeaderText("Merci de vérifier que vous ayez entrer les bonnes valeurs");
                alert.setContentText("Aucun produit ne correspond à votre recherche !");
                alert.showAndWait();
            }
        }
    }

    /***
     * Go to the page of the vendor when one is selected
     * @param actionEvent
     */
    public void goToViewVendor(ActionEvent actionEvent) {
        if (!actualVendor.getText().equals("")) primaryStage.setScene(scene_treeView);
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fournisseur manquant");
            alert.setHeaderText("Merci de sélectionner un fournisseur avant de continuer");
            alert.setContentText("Aucun fournisseur sélectionné !");
            alert.showAndWait();
        }
    }

    /**
     * Create the grid with every vendor
     * @param actionEvent
     */
    public void createGrid(ActionEvent actionEvent) {
        vendorsContainer.getChildren().clear();

        int index_X=1; int index_Y=1;
        Button vendorName; Button vendorUrl;
        // Add the child to the grid
        Label ref = new Label("Références"); ref.setFont(new Font(18)); ref.setStyle("-fx-font-weight: bold");
        Label url = new Label("Url fournisseurs"); url.setFont(new Font(18)); url.setStyle("-fx-font-weight: bold");
        vendorsContainer.add(ref,0,0);
        vendorsContainer.add(url,1,0);
        for (Map.Entry mapOfVendors : model.vendors.entrySet()) {
            vendorName = createButton(""+mapOfVendors.getKey());
            vendorUrl = createButton(""+mapOfVendors.getValue());

            vendorsContainer.add(vendorName,0,index_X);
            vendorsContainer.add(vendorUrl,index_Y,index_X);
            index_X++;
        }
    }

    public Button createButton(String name){
        Button button = new Button(name);
        button.setPrefSize(250,10);
        button.setFont(new Font(10)); button.setStyle("-fx-font-weight: bold");
        button.setOnAction(e -> {
            for (Map.Entry entry : model.vendors.entrySet()) {
                if (name.equals(entry.getKey()) || name.equals(entry.getValue())) {
                    model.currentVendor = (String) entry.getKey();
                    actualVendor.setText(String.valueOf(entry.getKey()));
                }
            }
        });
        return button;
    }
}
