package org.example.services;


import org.example.models.Item;

public class SharesHandler {
    private static SharesHandler uniqueInstance;

    private SharesHandler() {
    }

    public static SharesHandler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SharesHandler();
        }
        return uniqueInstance;
    }

    public double calculateFarmerShareOfItem(Item item){
        double MoneyOwed;

        MoneyOwed = item.getPrice() / item.returnNumberOfParticipants();

        return MoneyOwed;
    }

}
