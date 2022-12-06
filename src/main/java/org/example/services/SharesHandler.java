package org.example.services;


import org.example.models.Item;

public class SharesHandler {
    private static SharesHandler uniqueInstance = new SharesHandler();

    private SharesHandler() {
    }

    public static SharesHandler getInstance() {
        return uniqueInstance;
    }

    public float calculateFarmerShareOfItem(Item item){
        float MoneyOwed;

        MoneyOwed = item.getPrice() / item.returnNumberOfParticipants();

        return MoneyOwed;
    }

}
