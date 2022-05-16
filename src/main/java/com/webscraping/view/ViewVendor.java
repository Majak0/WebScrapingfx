package com.webscraping.view;

import com.webscraping.model.Category;
import com.webscraping.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import static com.webscraping.Boot.*;

public class ViewVendor extends Pane{

    final Model model;
    final Pane pane;

    ChoiceBox<String> choiceBoxLevels;

    public ViewVendor(Model model, Pane pane, int vendorNumber) {

        this.model = model;
        this.pane = pane;
        pane.getChildren().clear();

        Pane vendorProductsPane = new Pane();
        vendorProductsPane.setPrefSize(1000,800);

        // Autocall the init method to set up the vendor.
        loadVendor(Model.vendors.get(vendorNumber));

        // Button return menu
        Button buttonMenu = new Button();
        buttonMenu.setLayoutX(925);
        buttonMenu.setLayoutY(610);
        buttonMenu.setOnAction(e -> returnMenu());
        ImageView imageView = new ImageView(new Image("file:src/main/resources/com/webscraping/icons/back.png"));
        buttonMenu.setGraphic(imageView);
        buttonMenu.setPrefSize(40, 40);
        buttonMenu.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT,null,null)));

        vendorProductsPane.getChildren().addAll(buttonMenu);
        pane.getChildren().add(vendorProductsPane);
    }

    /**
     * Load requested vendorName
     * @param nameVendor : requested level name
     */
    public void loadVendor(String nameVendor) {
        Pane vendor = new Pane();

        Label vendorName = new Label(nameVendor);
        vendorName.setFont(new Font(50));
        vendorName.setStyle("-fx-font-weight: bold; -fx-text-fill: black");
        vendorName.setLayoutX(50); vendorName.setLayoutY(50);

        Label categorySelector = new Label("Choisissez quelle page produit charger");
        categorySelector.setFont(new Font(35));
        categorySelector.setStyle("fx-font-weight: bold; -fx-text-fill: black");
        categorySelector.setLayoutX(225); categorySelector.setLayoutY(175);

        showCategories();

        vendor.getChildren().addAll(vendorName, categorySelector);
        pane.getChildren().add(vendor);
    }

    /**
     * Will go through the vendor_categories.txt
     * and load the treeMap
     */
    public void showCategories(){
        Pane treeMap = new Pane();

        HashSet<Category> listOfCategories = new HashSet<>();
        String[] categoriesSplitter;
        int tailleMax=0;

        // A MODIFIER NON GÉNÉRIQUE POUR LE MOMENT
        try {
            Scanner input = new Scanner(new File("src/main/resources/com/webscraping/input_txt/cat_Pizzato.txt"));
            while (input.hasNext()){
                categoriesSplitter = input.nextLine().split("https://www.pizzato.com/fr/catalogue/");
                listOfCategories.add(new Category(categoriesSplitter[1]));
            }

            // 1er passage : récupérer le nb max de category
            // 2ème passage : vider la liste + ajouter les nouvelles valeurs à la nouvelle liste en comptant les "/" + put dans le HashMap (nbSlashs, ListeDeCategorieDeProfondeurNbSlashs)

            Map<Integer, String> categories = new HashMap<Integer, String>();
            for (Category cat :
                    listOfCategories) {
                if ((cat.getUrl().split("/")).length>tailleMax)tailleMax=(cat.getUrl().split("/")).length;
                categories.put((cat.getUrl().split("/")).length, cat.getName());
            }
            System.out.println(categories.get(1));
            /**
            for (int nbCat = 0; nbCat<tailleMax; nbCat++){
                ObservableList<String> categorySelector = FXCollections.observableArrayList();
                for (int index=0; index<categories.size(); index++){
                    if (categories.)
                }
            }
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pane.getChildren().add(treeMap);
    }

    public void returnMenu() {
        model.state = Model.STATE_INITIAL;
        primaryStage.setScene(scene_menu);
    }
}
