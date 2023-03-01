package org.example.models;

public class Participant {
    public double tab;
    public final String name;

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTab(double userShareOfItem) {
        tab += userShareOfItem;
    }

    public double getTab() {
        return tab;
    }
}
