package org.example.services;


import org.example.models.Item;
import org.springframework.stereotype.Service;

@Service
public class SharesHandler {

    public double calculateFarmerShareOfItem(Item item){
        double MoneyOwed;

        MoneyOwed = item.getPrice() / item.returnNumberOfParticipants();

        return MoneyOwed;
    }

}
