package org.example.models;

public class User {
    public float tab;
    public String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addItemToTab(float FarmerShareOfItem) {
        tab += FarmerShareOfItem;
    }

    public float getTab() {
        return tab;
    }
}
