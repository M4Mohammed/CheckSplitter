package org.example.iohandlers;

import org.example.models.User;

import java.util.List;

public final class OutputHandler {

    private OutputHandler() {
        throw new IllegalStateException("Utility Class");
    }

    public static void printTabForEachUser(List<User> users) {
        for (User user : users) {
            System.out.println(user.getName() + " owes " + user.getTab());
        }
    }

}
