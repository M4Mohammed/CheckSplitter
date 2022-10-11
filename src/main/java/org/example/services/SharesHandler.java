package org.example.services;


import org.example.models.Item;

public class SharesHandler implements ISharesHandler {
    private static SharesHandler uniqueInstance = new SharesHandler();

    private SharesHandler() {
    }

    public static SharesHandler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SharesHandler();
        }
        return uniqueInstance;
    }
    @Override
    public float calculateFarmerShareOfItem(Item item){
        float MoneyOwed;

        MoneyOwed = item.getPrice() / item.returnNumberOfParticipants();

        return MoneyOwed;
    }

}
