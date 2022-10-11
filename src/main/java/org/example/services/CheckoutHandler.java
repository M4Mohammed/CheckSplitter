package org.example.services;

import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;

public class CheckoutHandler {
    SharesHandlerService sharesHandlerService;

    public CheckoutHandler(SharesHandlerService sharesHandlerService) {
        this.sharesHandlerService = sharesHandlerService;
    }

    public void calculateMoneyOwedByEachParticipant(ShoppingCart MyShoppingCart) {

        for (Item item :
                MyShoppingCart.getMyShoppingCart()) {
            calculateParticipantSharePerItem(sharesHandlerService, item);
        }
    }

    private void calculateParticipantSharePerItem(SharesHandlerService sharesHandlerService, Item item) {
        for (Participant participant :
                item.getFarmers()) {
            participant.addItemToTab(sharesHandlerService.calculateFarmerShareOfItem(item));
        }
    }
}
