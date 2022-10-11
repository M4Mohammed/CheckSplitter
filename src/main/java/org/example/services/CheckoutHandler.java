package org.example.services;

import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;

public class CheckoutHandler implements ICheckoutHandler {
    private static CheckoutHandler uniqueInstance = new CheckoutHandler();
    ISharesHandler ISharesHandler;

    private CheckoutHandler() {
        ISharesHandler = SharesHandler.getInstance();
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
