package org.example.models;

import java.util.List;

public class Item {
    private double price;

    private List<Participant> participants;

    public Item(double itemPricePrompt, List<Participant> participants) {
        this.price = itemPricePrompt;
        this.participants = participants;
    }

    public int returnNumberOfParticipants() {
        return participants.size();
    }

    public List<Participant> getFarmers() {
        return participants;
    }

    public void setFarmers(List<Participant> participants) {
        this.participants = participants;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
