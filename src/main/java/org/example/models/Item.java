package org.example.models;

import java.util.List;

public class Item {
    private float price;
    private List<User> users;
//    private static InputHandler inputHandler;

//    public Item() {
//        this.price = inputHandler.itemPricePrompt();
//        this.users = InputHandler.participantsPrompt();
//    }

    public Item(float itemPricePrompt, List<User> participantsPrompt) {
        this.price = itemPricePrompt;
        this.users = participantsPrompt;
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
