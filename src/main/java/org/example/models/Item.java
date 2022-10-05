package org.example.models;

import java.util.List;

public class Item {
    private float price;

    private List<User> users;

    public Item(float price, List<User> users) {
        this.price = price;
        this.users = users;
    }

    public int returnNumberOfParticipants() {
        return users.size();
    }

    public List<User> getFarmers() {
        return users;
    }

    public void setFarmers(List<User> users) {
        this.users = users;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
