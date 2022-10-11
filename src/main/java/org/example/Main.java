package org.example;

import org.example.IOHandlers.InputHandler;
import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;
import org.example.services.CheckoutHandler;
import org.example.services.SharesHandler;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Participant MH = new Participant("Mohamed");
//        Participant MG = new Participant("Momen");
//        Participant YG = new Participant("Youssef");
//        CheckoutHandler checkoutHandler = new CheckoutHandler(new SharesHandler());
//
//        List<Participant> MMY = new ArrayList<>();
//        MMY.add(MH);
//        MMY.add(MG);
//        MMY.add(YG);
//
//        List<Participant> MHY = new ArrayList<>();
//        MHY.add(MH);
//        MHY.add(YG);
//
//        List<Participant> MGY = new ArrayList<>();
//        MGY.add(MG);
//        MGY.add(YG);
//
//        List<Participant> MHMG = new ArrayList<>();
//        MHMG.add(MH);
//        MHMG.add(MG);
//
//
//        ShoppingCart MyShoppingCart = new ShoppingCart(new ArrayList<>());
//        MyShoppingCart.addItem(new Item(75, MMY));
//        MyShoppingCart.addItem(new Item(100, MMY));
//        MH.addItemToTab(6.5f);
//        YG.addItemToTab(-37.95f);
//
//        checkoutHandler.calculateMoneyOwedByEachParticipant(MyShoppingCart);
//
//        System.out.println(MH.getTab());
//        System.out.println(YG.getTab());
//        System.out.println(MG.getTab());

        CheckoutHandler checkoutHandler = new CheckoutHandler(new SharesHandler());
        ShoppingCart MyShoppingCart = new ShoppingCart(new ArrayList<>());

        List<Participant> participants = InputHandler.createParticipantGroupPrompt();

        while(!InputHandler.isDoneAddingItems()) {
            MyShoppingCart.addItem(new Item(InputHandler.itemPricePrompt(), InputHandler.chooseItemParticipantsPrompt(participants)));
        }

        checkoutHandler.calculateMoneyOwedByEachParticipant(MyShoppingCart);

        //print out the tab for each participant
        participants.stream().forEach(participant -> System.out.println(participant.getName() + " owes " + participant.getTab()));


    }
}