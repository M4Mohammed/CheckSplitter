package org.example.iohandlers;

import org.example.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public final class InputHandler {

    private InputHandler() {
        throw new IllegalStateException("Utility Class");
    }

    private static final Scanner consoleInput = new Scanner(System.in);

    public static float itemPricePrompt () {
        System.out.println("Enter Item Price: ");
        return Float.parseFloat(consoleInput.nextLine());
    }


    public static List<User> participantsPrompt () {
        List<User> users = new ArrayList<>();
        System.out.println("Enter Participants: ");
        List<String> participants = Arrays.asList(consoleInput.nextLine().split(","));
        for (String participant : participants) {
            users.add(new User(participant));
        }
        return users;
    }


    public static boolean exitPrompt () {
        System.out.println("Exit ? (y/n)");
        return consoleInput.nextLine().equals("y");
    }


}
