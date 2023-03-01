package org.example.services;

import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutHandler {
    private final SharesHandler sharesHandler;

    @Autowired
    public CheckoutHandler(SharesHandler sharesHandler) {
        this.sharesHandler = sharesHandler;
    }

    public void calculateMoneyOwedByEachParticipant(ShoppingCart MyShoppingCart) {

        for (Item item :
                MyShoppingCart.getMyShoppingCart()) {
            calculateParticipantSharePerItem(sharesHandler, item);
        }
    }

    private void calculateParticipantSharePerItem(SharesHandler sharesHandler, Item item) {
        for (Participant participant :
                item.getFarmers()) {
            participant.addItemToTab(sharesHandler.calculateFarmerShareOfItem(item));
        }
    }

}
