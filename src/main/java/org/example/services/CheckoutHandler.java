package org.example.services;

import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;

public class CheckoutHandler {
    private static CheckoutHandler uniqueInstance;
    SharesHandler sharesHandler;

    private CheckoutHandler() {
        sharesHandler = SharesHandler.getInstance();
    }

    public static CheckoutHandler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CheckoutHandler();
        }
        return uniqueInstance;
    }

    public void calculateMoneyOwedByEachParticipant(ShoppingCart MyShoppingCart) {

        for (Item item :
                MyShoppingCart.getMyShoppingCart()) {
            calculateParticipantSharePerItem(sharesHandler, item);
        }
    }

    private void calculateParticipantSharePerItem(SharesHandler sharesHandler, Item item) {
        for (Participant participant :
                item.getParticipants()) {
            participant.setTab(sharesHandler.calculateFarmerShareOfItem(item));
        }
    }

}
