package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Item {
    private String name;
    private double price;
    private int quantity;
    private List<Participant> participants;

}
