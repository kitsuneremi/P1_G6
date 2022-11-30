package com.raven.model;


public class ModelCard {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValues() {
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    public ModelCard(String title, double values) {
        this.title = title;
        this.values = values;
    }

    public ModelCard() {
    }

    private String title;
    private double values;
}
