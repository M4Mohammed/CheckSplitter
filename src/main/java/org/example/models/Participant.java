package org.example.models;

public class Participant {
    public double tab;
    public String name;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItemToTab(double userShareOfItem) {
        tab += userShareOfItem;
    }

    public double getTab() {
        return tab;
    }
}
