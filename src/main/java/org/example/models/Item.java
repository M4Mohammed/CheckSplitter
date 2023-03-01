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

    public List<Participant> getParticipants() {
        return participants;
    }

    public double getPrice() {
        return price;
    }

}
