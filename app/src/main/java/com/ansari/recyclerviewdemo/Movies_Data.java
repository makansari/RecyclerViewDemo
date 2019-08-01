package com.ansari.recyclerviewdemo;

public class Movies_Data {

    String title;
    String generic;
    String date;

    public Movies_Data(String title, String generic, String date) {
        this.title = title;
        this.generic = generic;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
