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

import dealmanager.GrandMasterDeal;
import dealmanager.MagicDeal;
import dealmanager.Deal;
import dealmanager.DealManager;

public class Test2 {

	public static void main(String[] args) {
		
		//Instantiate TransactionManager
		DealManager tm = new DealManager();
		
		//Add PurchaseReceipts to Transaction Manager
		tm.add(new Deal(2, "joe", "seller", 20.00 , "3/4/12"));
		tm.add(new Deal(1, "buyer", "kelly", 20.00 , "3/4/12"));
		tm.add(new MagicDeal(45, "joe", "seller", 20.00 , "3/4/12", "dark", 45.00));
		tm.add(new MagicDeal(45, "joe", "seller", 20.00 , "3/4/12", "dark", 45.00));
		tm.add(new MagicDeal(4, "buyer", "seller", 20.00 , "3/4/12", "light", 45.00));
		tm.add(new GrandMasterDeal(3, "buyer", "seller", 20.00 , "3/4/12", "???", "Dumbeldore",  90.00));
		tm.add(new GrandMasterDeal(7, "buyer", "kelly", 20.00 , "3/4/12", "water", "Dr. Who",  56.00));
		
		//Test the Transaction Manager
		System.out.println("Transaction Manager toString()\n" + tm);
		System.out.println("Find Buyer 'joe'\n" + tm.findBuyer("joe"));
		System.out.println("Find Seller 'seller'\n" + tm.findSeller("seller"));
		System.out.println("Find by id #7\n" + tm.findId(7));
		System.out.println("Display All Sorted by id\n" + tm.displayAll());
		
		//Save the tm's contents to tm1.ser
		String savedMessage = tm.save("tm1.ser") ? "Saved Successfully" : "Error Saving";
		System.out.println(savedMessage);
		
		//Create a Second TransactionManager
		DealManager tm2 = new DealManager();
		System.out.println("tm2 BEFORE loading from tm1.ser\n" + tm2);
		
		
		//Load the contents of tm1.ser into tm2
		String loadedMessage = tm2.load("tm1.ser") ? "Loaded Successfully" : "Error Loading";
		System.out.println(loadedMessage);

		
		//Remove PurchaseReceipt with id=1 from tm2
		System.out.println("Removed id=1 from tm2:\n" + tm2.remove(1));
		
		//Print Out Both Transaction Managers to verify that load and removal were successful
		//tm2 should look like tm but it is missing the first PurchaseReceipt
		System.out.println("tm:\n" + tm);
		System.out.println("tm2:\n" + tm2);
		
		
	}

}
