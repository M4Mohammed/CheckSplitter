package org.example;

import org.example.iohandlers.InputHandler;
import org.example.models.Item;
import org.example.models.ShoppingCart;
import org.example.services.CheckoutHandler;
import org.example.services.SharesHandler;
import org.example.iohandlers.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SharesHandler sharesHandler = new SharesHandler();
        CheckoutHandler checkoutHandler = new CheckoutHandler(sharesHandler);
        ShoppingCart MyShoppingCart = new ShoppingCart(new ArrayList<>());

        System.out.println("Enter each item's price and participants in the item... \n");

        while (!InputHandler.exitPrompt()) {
            Item item = new Item(InputHandler.itemPricePrompt(), InputHandler.participantsPrompt());
            MyShoppingCart.addItem(item);
        }

        checkoutHandler.calculateTotalSumForEachFarmer(MyShoppingCart);

        OutputHandler.printTabForEachUser((MyShoppingCart.getMyShoppingCart().get(0).getFarmers()));

    }
}