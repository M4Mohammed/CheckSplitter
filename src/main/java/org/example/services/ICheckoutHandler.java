package org.example.services;

import org.example.models.ShoppingCart;

public interface ICheckoutHandler {
    void calculateMoneyOwedByEachParticipant(ShoppingCart MyShoppingCart);

    static void getInstance() {
    }
}
