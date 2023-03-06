package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Receipt {

    private final List<Participant> participants;
    public List<Item> items;

    public void addItem(Item item) {
        items.add(item);
    }

}
