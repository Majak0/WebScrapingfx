package com.webscraping.controller;

import com.webscraping.model.Model;
import com.webscraping.view.View;

public class Controller {
    protected final Model model;
    protected final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Show the vendors already registered
     */
    public void showVendors() {
        model.showVendors();
        view.showVendors();
        view.root.setFocusTraversable(true);
        view.root.requestFocus();
    }
}