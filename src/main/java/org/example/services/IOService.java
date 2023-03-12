package org.example.services;

import org.example.models.Item;
import org.example.models.Participant;
import org.example.models.Receipt;

import java.util.*;
import java.util.stream.Collectors;

public final class IOService {
    private IOService() {
    }

    public static final Scanner consoleInput = new Scanner(System.in);

    //main menu
    public static void mainMenuPrompt() {
        System.out.println("\nWelcome to the Receipt Splitter App");
        System.out.println("Please select an option: ");
        System.out.println("1. Create a new receipt");
        System.out.println("2. Exit");
    }

    public static int mainMenuInput() {
        while (true) {
            try {
                return Integer.parseInt(consoleInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }



    public static void createParticipantGroupPrompt() {
        System.out.println("\nDefine the group of participants for this shopping cart (separated by commas): ");
    }

    public static List<Participant> createParticipantGroupInput() {
        List<Participant> participants = new ArrayList<>();
        String[] participantsNames = consoleInput.nextLine().strip().split(",");
        for (String name : participantsNames) {
            participants.add(new Participant(name));
        }

        return participants;
    }

    public static void itemDataPrompt(Receipt receipt) {
        System.out.println("Enter the name of the item, the price, the quantity, and the participants (separated by commas): \n");
        receipt.getParticipants().forEach(p -> System.out.print(p.getName() + " "));
        System.out.println();
    }

    public static Item itemDataInput(Receipt receipt) {
        while (true) {
            try {
                String[] itemData = consoleInput.nextLine().split(",");

                String name = itemData[0];
                double price = Double.parseDouble(itemData[1]);
                int quantity = Integer.parseInt(itemData[2].strip());

                List<Participant> itemParticipants = new ArrayList<>();
                if (itemData.length > 3) {
                    String[] participantNames = itemData[3].split("\\s+");
                    for (String pName : participantNames) {
                        Participant participant = receipt.getParticipants().stream()
                                .filter(p -> p.getName().equals(pName))
                                .findFirst()
                                .orElse(new Participant(pName));
                        itemParticipants.add(participant);
                    }
                }

                return Item.builder().
                        name(name).
                        price(price).
                        quantity(quantity).
                        participants(itemParticipants).
                        build();

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input! Please make sure the price and quantity are numbers and you provide all the required data.");
            }
        }
    }


    public static void addAnotherItemPrompt() {
        System.out.println("Do you want to add another item? (Y/N)");
    }

    public static boolean addAnotherItemInput() {
        while (true) {
            String input = consoleInput.nextLine();
            if (input.equalsIgnoreCase("Y")) {
                return true;
            } else if (input.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input! Please enter Y or N.");
            }
        }
    }

    public static void receiptPrompt() {
        System.out.println("Receipt:");
    }

    public static void receiptItemPrompt(Receipt receipt) {
        receipt.getItems()
                .forEach(item -> System.out.println(item.getName() + " " + item.getPrice() + " " + item.getQuantity() + " " + item.getParticipants()));
    }
}
