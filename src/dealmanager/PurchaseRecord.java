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

/**
 * The PurchaseReceipt Interface is to be implemented by classes that deal with buying and selling records
 * @author Joseph Varilla
 * @version 1.0 11/3/18
 *
 */
public interface PurchaseRecord extends Comparable<PurchaseRecord> {
	/**
	 * Returns the id of the PurchaseReceipt.
	 * @return id of PurchaseReceipt
	 */
	public int getId();
	
	/**
	 * Returns the buyer in the PurchaseReceipt.
	 * @return buyer of PurchaseReceipt
	 */
	public String getBuyer();
	
	/**
	 * Returns the seller in the PurchaseReceipt.
	 * @return seller of PurchaseReceipt
	 */
	public String getSeller();
	
	/**
	 * Returns the amount as a double in the PurchaseReceipt
	 * @return amount of PurchaseReceipt
	 */
	public double getAmount();
}
