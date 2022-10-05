package org.example.services;

import org.example.models.User;
import org.example.models.Item;
import org.example.models.ShoppingCart;

public class CheckoutHandler {
    SharesHandlerService sharesHandlerService;

    public CheckoutHandler(SharesHandlerService sharesHandlerService) {
        this.sharesHandlerService = sharesHandlerService;
    }

    public void calculateTotalSumForEachFarmer(ShoppingCart MyShoppingCart) {

        for (Item item :
                MyShoppingCart.getMyShoppingCart()) {
            calculateParticipantShare(sharesHandlerService, item);
        }
    }

    private void calculateParticipantShare(SharesHandlerService sharesHandlerService, Item item) {
        for (User user :
                item.getFarmers()) {
            user.addItemToTab(sharesHandlerService.calculateFarmerShareOfItem(item));
        }
    }
}
