module com.webscraping {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports com.webscraping;
    exports com.webscraping.model;
    exports com.webscraping.view;
    exports com.webscraping.controller;
    opens com.webscraping to javafx.fxml;
    opens com.webscraping.controller to javafx.fxml;
    exports com.webscraping.vendorTreeView;
    opens com.webscraping.vendorTreeView to javafx.fxml;
    opens com.webscraping.model to javafx.fxml;
    exports com.webscraping.menu;
    opens com.webscraping.menu to javafx.fxml;
}