package org.example.services;


import org.example.models.Item;

public class SharesHandler implements ISharesHandler {
    @Override
    public float calculateFarmerShareOfItem(Item item){
        float MoneyOwed;

        MoneyOwed = item.getPrice() / item.returnNumberOfParticipants();

        return MoneyOwed;
    }

}
