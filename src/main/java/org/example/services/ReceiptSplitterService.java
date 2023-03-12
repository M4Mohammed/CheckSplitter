package org.example.services;

import org.example.models.Participant;
import org.example.models.Receipt;

import java.util.List;

public class ReceiptSplitterService {

    private ReceiptSplitterService() {
    }

    public static void calculateShares(Receipt receipt) {
        List<Participant> participants = receipt.getParticipants();

        // Reset each participant's total before calculating shares
        participants.forEach(participant -> participant.setTotal(0));

        // Calculate each item's share and add it to each participant's total
        receipt.getItems().forEach(item -> {
            List<Participant> itemParticipants = item.getParticipants();
            double itemTotal = item.getPrice() * item.getQuantity();
            double itemShare = itemTotal / itemParticipants.size();
            itemParticipants.forEach(participant -> participant.setTotal(participant.getTotal() + itemShare));
        });

        // Print each participant's total
        System.out.println("Here is how much each participant should pay:");
        participants.forEach(participant -> System.out.println(participant.getName() + ": " + participant.getTotal()));
    }

}
