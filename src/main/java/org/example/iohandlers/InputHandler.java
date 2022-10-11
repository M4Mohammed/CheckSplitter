package org.example.iohandlers;

import org.example.models.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    public static Scanner consoleInput = new Scanner(System.in);

    public static int itemPricePrompt() {
        System.out.println("Enter item price: ");
        return Integer.parseInt(InputHandler.consoleInput.nextLine());
    }

    public static List<Participant> createParticipantGroupPrompt() {
        List<Participant> participants = new ArrayList<>();
        System.out.println("Define the group of participants for this shopping cart: ");
        List<String> participantsNames = Arrays.asList(InputHandler.consoleInput.nextLine().split(","));
        for (String name : participantsNames) {
            participants.add(new Participant(name));
        }

        return participants;
    }


    public static List<Participant> chooseItemParticipantsPrompt(List<Participant> participants) {
        participants.stream().forEach(participant -> System.out.println(participant.getName()));
        System.out.println("Choose the participants for this item: ");

        List<String> participantsNames = Arrays.asList(InputHandler.consoleInput.nextLine().split(","));

        List<Participant> chosenParticipants = new ArrayList<>();
        participantsNames.stream().forEach(participantName -> {
            for (Participant participant : participants) {
                if (participant.getName().equals(participantName)) {
                    chosenParticipants.add(participant);
                }
            }
        });
        return chosenParticipants;
    }


    public static boolean isDoneAddingItems() {
        System.out.println("Are you done adding items? (y/n)");
        return InputHandler.consoleInput.nextLine().toLowerCase().equals("y");
    }
}
