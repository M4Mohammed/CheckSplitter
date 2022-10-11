package org.example;

import org.example.iohandlers.InputHandler;
import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;
import org.example.services.CheckoutHandler;
import org.example.services.ICheckoutHandler;
import org.example.services.SharesHandler;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

     ICheckoutHandler ICheckoutHandler = new CheckoutHandler(new SharesHandler());
        ShoppingCart MyShoppingCart = new ShoppingCart(new ArrayList<>());

        List<Participant> participants = InputHandler.createParticipantGroupPrompt();

        while(!InputHandler.isDoneAddingItems()) {
            MyShoppingCart.addItem(new Item(InputHandler.itemPricePrompt(), InputHandler.chooseItemParticipantsPrompt(participants)));
        }

        ICheckoutHandler.calculateMoneyOwedByEachParticipant(MyShoppingCart);

        //print out the tab for each participant
        participants.stream().forEach(participant -> System.out.println(participant.getName() + " owes " + participant.getTab()));


    }
}