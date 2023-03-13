package org.example.models;

import lombok.Data;

import java.util.List;

@Data
public class Receipt {

    private final List<Participant> participants;
    private final List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

}
