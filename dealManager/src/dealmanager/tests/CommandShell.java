/*
 * Name: Joseph Varilla
 * Project Name: Transaction Classes
 * Project Number: 4
 * Submission Date: 11/4/2018
 * 
 * IT 313 | Project 4: Transaction Classes
 * About: Project contains interfaces and classes
 *        to create and monitor Purchase Receipts
 */
package dealmanager.tests;

import java.util.ArrayList;

//Command shell for Project 4.
//Your project should reference the project that contains
//the definition for the PurchaseReceipt interface
//in the package it313.proj4.

import java.util.Scanner;

import dealmanager.*;
public class CommandShell {

 public static void main(String[] args) {
     Scanner fromKeyboard = new Scanner(System.in);
     DealManager _manager = new DealManager( );
     System.out.println("List of command shell commands:");

     System.out.println("adddeal [-magic, -grandmaster]");
     System.out.println("load save searchbyid");
     System.out.println("remove exit");
     System.out.println("sellers buyers displayall");
     
     System.out.println("exit load save sellers"); 
     
     // abc is a string not equal to any shell command
     String command = "abc";
     while(!command.equals("exit")) {
         System.out.print(">> ");
         command = fromKeyboard.nextLine( );
         switch(command) {
         
             // Note: write your own add commands for classes
             //       derived from Transaction, for example
             //       addlumber and addgold.
             case "adddeal":
                 System.out.println("Enter data for a generic transaction.");
                 System.out.print("Enter ID: ");
                 int id = Integer.parseInt(fromKeyboard.nextLine( ));
                 System.out.print("Enter Buyer: ");
                 String buyer = fromKeyboard.nextLine( );
                 System.out.print("Enter Seller: ");
                 String seller = fromKeyboard.nextLine( );
                 System.out.print("Enter Price: ");
                 double price = Double.parseDouble(fromKeyboard.nextLine( ));
                 System.out.print("Enter Timestamp: ");
                 String timestamp = fromKeyboard.nextLine( );
                  _manager.add(new Deal(id, buyer, seller, price, timestamp));
                 break;
             case "adddeal -magic":
                 System.out.println("Enter data for magic transaction.");
                 System.out.print("Enter ID: ");
                 int idM = Integer.parseInt(fromKeyboard.nextLine( ));
                 System.out.print("Enter Buyer: ");
                 String buyerM = fromKeyboard.nextLine( );
                 System.out.print("Enter Seller: ");
                 String sellerM = fromKeyboard.nextLine( );
                 System.out.print("Enter Price: ");
                 double priceM = Double.parseDouble(fromKeyboard.nextLine( ));
                 System.out.print("Enter Timestamp: ");
                 String timestampM = fromKeyboard.nextLine( );
                 System.out.print("Enter Magic Type: ");
                 String magictypeM = fromKeyboard.nextLine( );
                 System.out.print("Enter Duration(mins): ");
                 double durationM = Double.parseDouble(fromKeyboard.nextLine( ).trim());
                  _manager.add(new MagicDeal(idM, buyerM, sellerM, priceM, timestampM, magictypeM, durationM));
                 break;
             case "adddeal -grandmaster":
                 System.out.println("Enter data for a grand master transaction.");
                 System.out.print("Enter ID: ");
                 int idG = Integer.parseInt(fromKeyboard.nextLine( ));
                 System.out.print("Enter Buyer: ");
                 String buyerG = fromKeyboard.nextLine( );
                 System.out.print("Enter Seller: ");
                 String sellerG = fromKeyboard.nextLine( );
                 System.out.print("Enter Price: ");
                 double priceG = Double.parseDouble(fromKeyboard.nextLine( ));
                 System.out.print("Enter Timestamp: ");
                 String timestampG = fromKeyboard.nextLine( );
                 System.out.print("Enter Grand Master's Name: ");
                 String grandmasternameG = fromKeyboard.nextLine( );
                 System.out.print("Enter Grand Master's Specialty: ");
                 String specialtyG = fromKeyboard.nextLine( );
                 System.out.print("Enter Time Served By Grand Master in minutes: ");
                 double servedtimeG = Double.parseDouble(fromKeyboard.nextLine( ).trim());
                  _manager.add(new GrandMasterDeal(idG, buyerG, sellerG, priceG, timestampG, 
                		  		grandmasternameG, specialtyG, servedtimeG));
                 break;
             
             case "buyers":
                 System.out.println("Enter name of buyer: ");
                 buyer = fromKeyboard.nextLine( );
                 System.out.println("Transactions with buyer " + buyer + ":");
                 for(PurchaseRecord pr : _manager.findBuyer(buyer)) {
                     System.out.println(pr + "\n");
                 }
                 break;
                 
             case "displayall":
                 System.out.println("Display all transactions:");
                 ArrayList<PurchaseRecord> dpResults = _manager.displayAll();
                 for(PurchaseRecord pr : dpResults) {
                     System.out.println(pr + "\n");
                 }
                 System.out.println( );
                 break;
                 
             case "load":
                 System.out.println("Load transactions from disk...");
                 System.out.println("Loaded File Name & Location:"); 
                 String loadFileName = fromKeyboard.nextLine().trim();
                 String loadMsg = _manager.load(loadFileName) ? "Loaded Successfully" : "Error Loading" ;
                 System.out.println(loadMsg);
                 break;
                  
             case "save":
                 System.out.println("Save transactions from disk...");
                 System.out.println("Default location ./userSavedWork/"); 
                 System.out.println("Destination File Name & Location:"); 
                 String destinationFileName = fromKeyboard.nextLine().trim();
                 String savedMsg = _manager.save(destinationFileName) ? "Saved Successfully" : "Error Saving" ;
                 System.out.println(savedMsg);
                 break;
                 
             case "sellers":
                 System.out.println("Enter name of seller: ");
                 seller = fromKeyboard.nextLine( );
                 System.out.println("Transactions with seller " + seller + ":");
                 for(PurchaseRecord pr : _manager.findSeller(seller)) {
                     System.out.println(pr + "\n");
                 }
                 break;                    
             case "searchbyid":
            	 System.out.println("Enter id of transaction:");
            	 int searchid = Integer.parseInt(fromKeyboard.nextLine());
            	 System.out.println(_manager.findId(searchid));
            	 break;
             case "remove":
            	 System.out.println("Enter id of transaction to remove:");
            	 int removeid = Integer.parseInt(fromKeyboard.nextLine());
            	 System.out.println("Removed :" + _manager.remove(removeid));
            	 break;
             case "exit":
                 System.exit(0);
                 break;
         }
     }
     fromKeyboard.close( );
 }
}