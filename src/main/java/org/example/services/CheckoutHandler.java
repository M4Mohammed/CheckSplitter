package org.example.services;

import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;

public class CheckoutHandler implements ICheckoutHandler {
    private static CheckoutHandler uniqueInstance;
    ISharesHandler ISharesHandler;

    private CheckoutHandler() {
        ISharesHandler = SharesHandler.getInstance();
    }

    public static CheckoutHandler getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new CheckoutHandler();
        }
        return uniqueInstance;
    }

    @Override
    public void calculateMoneyOwedByEachParticipant(ShoppingCart MyShoppingCart) {

        for (Item item :
                MyShoppingCart.getMyShoppingCart()) {
            calculateParticipantSharePerItem(ISharesHandler, item);
        }
    }

    private void calculateParticipantSharePerItem(ISharesHandler ISharesHandler, Item item) {
        for (Participant participant :
                item.getFarmers()) {
            participant.addItemToTab(ISharesHandler.calculateFarmerShareOfItem(item));
        }
    }

}
