package com.webscraping.model;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class Model {

    // Use to indicate to the app if we're searching a product or if we're juste navigating on the interface
    public final static int STATE_INITIAL = 1;
    final static int STATE_SEARCH = 2;

    // WINDOW
    public final int width;
    public final int height;

    // LIST
    public static HashMap<String, String> vendors = findAllVendors();

    // STATE
    public int state;

    // VENDOR
    public int vendor;
    public int maxCategory;
    public String currentVendor;

    public Model() {
        state = STATE_INITIAL;
        width = 1000;
        height = 700;
        vendor = 1;
        maxCategory = 0;
        currentVendor = "";
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
    public static HashMap<String, String> findAllVendors() {
        // Postresql -> afficher tout fournisseurs
        HashMap<String, String> vendorsFinder = new HashMap<>();
        try {
            String url = "jdbc:postgresql://postgresql-ppr-001.groupe-mb.net:5432/scrapingproduct";
            Connection conn = DriverManager.getConnection(url,"usr_jacquot","IkZVeP3lEN8Sxo4SoWji");
            Statement state = conn.createStatement();
            String sql = "SELECT url,artfrs_r1 FROM scrapdb6.siteweb\n" +
                    "RIGHT JOIN scrapdb6.fournisseur ON scrapdb6.fournisseur.id_fournisseur = scrapdb6.siteweb.id_fournisseur";
            ResultSet results = state.executeQuery(sql);
            while (results.next()){
                vendorsFinder.put(results.getString("artfrs_r1"), results.getString("url"));
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