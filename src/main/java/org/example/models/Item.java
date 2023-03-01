package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private double price;

    private List<Participant> participants;
    public int returnNumberOfParticipants() {
        return participants.size();
    }

}
