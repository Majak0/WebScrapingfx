package com.webscraping.model;

public class Category {

    String url;
    String name;
    String parentCategory="";

    public Category(String url){
        this.url = url;
        if (url.contains("/")){
            String[] path = url.split("/");

            // Set the name of the current category
            name = path[path.length-1];

            // Set the parent category of the current category
            for (int index=1; index<path.length;index++){
                if (path[index].equals(name)) parentCategory = path[index-1];
            }
        } else {
            name = url;
        }
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("---------------------------"+
                "\n- Url : "+url+
                "\n- Name : "+name+
                "\n- Parent : "+parentCategory);
    }
}
