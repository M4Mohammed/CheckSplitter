package org.example;

import org.example.models.User;
import org.example.models.Item;
import org.example.models.ShoppingCart;
import org.example.services.CheckoutHandler;
import org.example.services.SharesHandler;
import org.example.services.SharesHandlerService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SharesHandlerService sharesHandlerService = new SharesHandler();

        User MH = new User("Mohamed");
        User MG = new User("Momen");
        User YG = new User("Youssef");
        CheckoutHandler checkoutHandler = new CheckoutHandler(sharesHandlerService);

        List<User> MMY = new ArrayList<>();
        MMY.add(MH);
        MMY.add(MG);
        MMY.add(YG);

        List<User> MHY = new ArrayList<>();
        MHY.add(MH);
        MHY.add(YG);

        List<User> MGY = new ArrayList<>();
        MGY.add(MG);
        MGY.add(YG);

        List<User> MHMG = new ArrayList<>();
        MHMG.add(MH);
        MHMG.add(MG);


        ShoppingCart MyShoppingCart = new ShoppingCart(new ArrayList<>());
        MyShoppingCart.addItem(new Item(16.95f, MMY));
        MyShoppingCart.addItem(new Item(14.5f, MHY));
        MH.addItemToTab(6.5f);
        YG.addItemToTab(-37.95f);

        checkoutHandler.calculateTotalSumForEachFarmer(MyShoppingCart);

        System.out.println(MH.getTab());
        System.out.println(YG.getTab());
        System.out.println(MG.getTab());


    }
}