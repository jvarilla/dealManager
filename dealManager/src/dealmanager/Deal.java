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

import java.io.Serializable;

/**
 * The Transaction class is a record of deals made between two parties.
 * @author Joseph Varilla
 * @version 1.0 11/3/2018
 *
 */
public class Deal implements PurchaseRecord, Serializable {
	
	private static final long serialVersionUID = -3824539675378789915L;
	private int _id;
	private String _buyer; 
	private String _seller;
	private double _amount;
	private String _timestamp;
	
	/**
	 * Constructs the Transaction
	 * @param theId Transaction id
	 * @param theBuyer Buyer in Transaction
	 * @param theSeller Seller in Transaction
	 * @param theAmount Amount of Transaction
	 * @param theTimestamp Timestamp of Transaction
	 */
	public Deal(int theId, String theBuyer, String theSeller, double theAmount, String theTimestamp) {
		_id = theId;
		_buyer = theBuyer;
		_seller = theSeller;
		_amount = theAmount;
		_timestamp = theTimestamp;
	}
	
	/**
	 * Returns the id of the Transaction
	 */
	public int getId() {
		return _id;
	}
	
	/**
	 * Returns the buyer in the Transaction
	 */
	public String getBuyer() {
		return _buyer;
	}
	
	/**
	 * Returns the seller in the Transaction
	 */
	public String getSeller() {
		return _seller;
	}
	
	/**
	 * Returns the amount of the Transaction.
	 */
	public double getAmount() {
		return _amount;
	}
	
	/**
	 * Returns the Timestamp of the Transaction
	 * @return The timestamp of the Transaction as a String.
	 */
	public String getTimestamp() {
		return _timestamp;
	}
	
	
	@Override
	/**
	 * Returns -1 if the id is less than the id of other
	 * <p>
	 * Returns 0 if equal to id is equal to id of other 
	 * <p>
	 * Returns 1 if the id is greater than the id of other
	 */
	public int compareTo(PurchaseRecord other) {
		 if (this.getId() > other.getId()) {
	            return 1;
	        }
	        else if (this.getId() < other.getId()) {
	            return -1;
	        }
	        else {
	            return 0;
	        }
	}
	
	@Override
	/**
	 * Return string for Transaction
	 * <p>
	 * Sample: #2 | amount:$20.00 | Buyer: buyer | Seller: seller | 3/4/12, #1 | amount:$20.00 | Buyer: buyer | Seller: seller | 3/4/12
	 */
	public String toString() {
		return String.format("#%d | amount:$%.2f | Buyer: %s | Seller: %s | %s", 
				_id, _amount, _buyer, _seller, _timestamp);
	}
}
