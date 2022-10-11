package org.example.services;

import org.example.models.ShoppingCart;

public interface ICheckoutHandler {
    public void calculateMoneyOwedByEachParticipant(ShoppingCart MyShoppingCart);

    public static void getInstance() {
    }
}
