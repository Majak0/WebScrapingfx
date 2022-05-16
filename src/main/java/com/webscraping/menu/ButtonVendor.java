package com.webscraping.menu;

import com.webscraping.Boot;
import javafx.scene.control.Button;

public class ButtonVendor extends Button {
    public ButtonVendor(String name, double x, double y) {
        super();
        setText(name);
        setLayoutX(x);
        setLayoutY(y);
        setPrefSize(150, 75);
        String css = "-fx-border-color: transparent;"+
                "-fx-border-width: 0;"+
                "-fx-background-color: transparent;"+
                "-fx-font: 22 Arial;"+
                "-fx-font-weight: bold;"+
                "-fx-background-repeat: no-repeat;"+
                "-fx-background-size: 150 70;";
        setStyle(css);
        setStyle(getStyle() + "-fx-background-image: url('" + Boot.class.getResource("icons/button.png") + "')");
        setOpacity(100);
    }
}