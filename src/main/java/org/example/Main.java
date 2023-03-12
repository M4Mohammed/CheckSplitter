package org.example;

import org.example.models.Receipt;
import org.example.services.IOService;
import org.example.services.ReceiptSplitterService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Receipt receipt;


        while (true) {

            IOService.mainMenuPrompt();
            int option = IOService.mainMenuInput();

            switch (option) {
                case 1:
                    IOService.createParticipantGroupPrompt();
                    receipt = new Receipt(IOService.createParticipantGroupInput(), new ArrayList<>());

                    while (true) {
                        IOService.itemDataPrompt(receipt);
                        receipt.addItem(IOService.itemDataInput(receipt));

                        IOService.addAnotherItemPrompt();
                        if (!IOService.addAnotherItemInput()) {
                            break;
                        }
                    }

                    IOService.receiptPrompt();
                    IOService.receiptItemPrompt(receipt);

                    ReceiptSplitterService.calculateShares(receipt);
                    break;
                case 2:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please select again.");
            }
        }
    }
}
