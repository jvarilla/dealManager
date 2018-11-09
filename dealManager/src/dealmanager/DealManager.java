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
package dealmanager;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * TransactionManager is used to search, sort, save/load multiple PurchaseReceipts at a time.
 * @author Joseph Varilla
 * @version 1.0 11/4/18
 */
public class DealManager implements Serializable {
	private static final String targetDirectory = "./userSavedWork/";
	private static final long serialVersionUID = 2339216835588928883L;
	private HashMap<Integer, PurchaseRecord> _col;
	
	/**
	 * Constructor for the TransactionManager
	 */
	public DealManager() {
		_col = new HashMap<Integer, PurchaseRecord>();
	}
	
	/**
	 * Add a PurchaseReceipt to the TransactionManager
	 * @param thePurchaseReceipt the PurchaseReceipt to manage.
	 */
	public void add(PurchaseRecord thePurchaseReceipt) {
		if (!_col.containsKey(thePurchaseReceipt.getId())) {
			//Only add unique PurchaseReceipt with a unique ID to avoid collisions
			_col.put(thePurchaseReceipt.getId(), thePurchaseReceipt);
		}
	}
	
	/**
	 * Count the number of PurchaseReceipts in the TransactionManager
	 * @return the number of PurchaseReceipts in the TransactionManager
	 */
	public int count() {
		return _col.size();
	}
	
	/**
	 * Get all the Purchase Receipts in the Transaction Manager sorted by id
	 * @return Returns and ArrayList of Purchase Receipts in the Transaction Manager sorted by id
	 */
	public ArrayList<PurchaseRecord> displayAll() {
		ArrayList<PurchaseRecord> allValues = new ArrayList<PurchaseRecord>();
		for(PurchaseRecord item : _col.values()) {
			allValues.add(item);
		}
		Collections.sort(allValues);
		return allValues;
	}
	
	/**
	 * Get all PurchaseReceipts with a specified buyer.
	 * @param theBuyer The buyer to search for
	 * @return Returns an ArrayList of PurchaseReceipts with the theBuyer as a buyer, sorted by id
	 */
	public ArrayList<PurchaseRecord> findBuyer(String theBuyer) {
		ArrayList<PurchaseRecord> results = new ArrayList<PurchaseRecord>();
		for(PurchaseRecord receipt : _col.values( )) {
		    if(receipt.getBuyer().equals(theBuyer)) {
		    	results.add(receipt);
		    }
		}
		Collections.sort(results);
		
		return results;
	}
	
	/**
	 * Get all the PurchaseReceipts with a specified Seller
	 * @param theSeller The seller to search for
	 * @return Returns an ArrayList of PurchaseReceipts with the theSeller as a seller, sorted by id
	 */
	public ArrayList<PurchaseRecord> findSeller(String theSeller) {
		ArrayList<PurchaseRecord> results = new ArrayList<PurchaseRecord>();
		for(PurchaseRecord receipt : _col.values( )) {
		    if(receipt.getSeller().equals(theSeller)) {
		    	results.add(receipt);
		    }
		}
		Collections.sort(results);
		
		return results;
	}
	
	
	/**
	 * Get the PurchaseReceipt with by id
	 * @param theId The id of the PurchaseReceipt
	 * @return the PuchaseReceipt with id equivalent to theId
	 */
	public PurchaseRecord findId(int theId) {
		for(PurchaseRecord receipt : _col.values( )) {
		    if(receipt.getId() == theId) {
		    	return receipt;
		    }
		}
		return null;
	}
	
	
	@SuppressWarnings({ "unchecked", "resource" })
	/**
	 * Loads Transactions/PurchaseReceipt collection from a file.
	 * @param fileName The location and name of the file to load from.
	 * @return Returns true if loaded successfully and false if not.
	 */
	public boolean load(String fileName) {
		ObjectInputStream inStream = null;
		try {
			inStream = new ObjectInputStream(
			new FileInputStream(targetDirectory + fileName));
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
		
		try {
			_col =  (HashMap<Integer, PurchaseRecord>) inStream.readObject( );
		} catch (ClassNotFoundException | IOException e) {
			//e.printStackTrace();
			return false;
		}
		try {
			inStream.close( );
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Removes a PurchaseReceipt from the Transaction Manager
	 * @param theId The id of the PurchaseReceipt to remove.
	 * @return Returns the PuchaseReceipt removed or null if it was not in the TransactionManager
	 */
	public PurchaseRecord remove(int theId) {
		/*since all hashmap keys are based on the transaction id
		 * Just pass the id in the Hashmap.remove() method
		 */
		return _col.remove(theId);
	}
	

	/**
	 * Saves the TransactionManager's contents into a serializable form
	 * @param fileName fileName The destination file for TransactionManager's contents
	 * @return Returns true if loaded successfully and false if not
	 */
	@SuppressWarnings("resource")
	public boolean save(String fileName) {
		ObjectOutputStream outStream = null;
		try {
			outStream = new ObjectOutputStream(
			new FileOutputStream(targetDirectory + fileName));
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
		try {
			outStream.writeObject(_col);
		} catch (IOException e1) {
			//e1.printStackTrace();
			return false;
		}
		
		// Close object.
		try {
			outStream.close( );
		} catch (IOException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * Return String for the TransactionManager
	 */
	public String toString() {
		//ArrayList<PurchaseReceipt> results =  _col.values();
		return _col.toString();
	}
}
