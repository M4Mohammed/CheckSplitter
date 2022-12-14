package org.example;

import org.example.iohandlers.InputHandler;
import org.example.models.Participant;
import org.example.models.Item;
import org.example.models.ShoppingCart;
import org.example.services.CheckoutHandler;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //checkout handler instance
        CheckoutHandler checkoutHandler = CheckoutHandler.getInstance();
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