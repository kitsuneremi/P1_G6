package com.raven.bar;

import java.awt.Color;

public class ModelBarLegend {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ModelBarLegend(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public ModelBarLegend() {
    }

    private String name;
    private Color color;
}
