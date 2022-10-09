package org.example.models;

import org.example.iohandlers.InputHandler;

import java.util.List;

public class Item {
    private float price;
    private List<User> users;
    private static InputHandler inputHandler = new InputHandler();

    public Item() {
        this.price = inputHandler.itemPricePrompt();
        this.users = InputHandler.participantsPrompt();
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
