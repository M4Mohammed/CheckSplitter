package org.example.models;

public class Participant {
    public float tab;
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

    public void addItemToTab(float userShareOfItem) {
        tab += userShareOfItem;
    }

    public float getTab() {
        return tab;
    }
}
