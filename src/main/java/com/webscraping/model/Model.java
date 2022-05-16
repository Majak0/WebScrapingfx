package com.webscraping.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    // Use to indicate to the app if we're searching a product or if we're juste navigating on the interface
    public final static int STATE_INITIAL = 1;
    final static int STATE_SEARCH = 2;

    // WINDOW
    public final int width;
    public final int height;

    // LIST
    public static List<String> vendors = findAllVendors();

    // STATE
    public int state;

    // VENDOR
    public int vendor;
    public int maxCategory;

    public Model() {
        state = STATE_INITIAL;
        width = 1000;
        height = 700;
        vendor = 1;
        maxCategory = 0;
    }

    /**
     * Show the vendors already registered
     */
    public void showVendors() {
        state = STATE_SEARCH;
    }

    /**
     * Find all vendors registered in /vendors
     * @return : the list of the vendors registered
     */
    public static List<String> findAllVendors() {
        // Postresql -> afficher tout fournisseurs
        List<String> vendorsFinder = new ArrayList<>();
        try {
            String url = "jdbc:postgresql://postgresql-ppr-001.groupe-mb.net:5432/scrapingproduct";
            Connection conn = DriverManager.getConnection(url,"usr_jacquot","IkZVeP3lEN8Sxo4SoWji");
            Statement state = conn.createStatement();
            String sql = "SELECT * FROM scrapdb6.fournisseur ";
            ResultSet results = state.executeQuery(sql);
            while (results.next()){
                vendorsFinder.add(results.getString("artfrs_r1"));
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e + " - Erreur lors de l'écriture dans la BDD");
        }
        return vendorsFinder;
    }
}