package org.example.models;

import java.util.List;

public class ShoppingCart {
    public List<Item> MyShoppingCart;

    public ShoppingCart(List<Item> myShoppingCart) {
        this.MyShoppingCart = myShoppingCart;
    }

    public void addItem(Item item) {
        MyShoppingCart.add(item);
    }

    public void removeItem(Item item) {
        MyShoppingCart.remove(item);
    }

    public List<Item> getMyShoppingCart() {
        return MyShoppingCart;
    }

}
