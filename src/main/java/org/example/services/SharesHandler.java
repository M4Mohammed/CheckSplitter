package org.example.services;


import org.example.models.Item;

public class SharesHandler {
    private static SharesHandler uniqueInstance = new SharesHandler();

    private SharesHandler() {
    }

    public static SharesHandler getInstance() {
        return uniqueInstance;
    }

    public double calculateFarmerShareOfItem(Item item){
        double MoneyOwed;

        MoneyOwed = item.getPrice() / item.returnNumberOfParticipants();

        return MoneyOwed;
    }

}
