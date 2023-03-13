package org.example.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Item {
    private String name;
    private double price;
    private int quantity;
    private List<Participant> participants;

}
