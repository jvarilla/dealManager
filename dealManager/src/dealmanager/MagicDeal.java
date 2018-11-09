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
 * The MagicTransaction class is used in cases where one buys temporary magic powers.
 * @author Joseph Varilla
 * @version 1.0 11/4/18
 *
 */
public class MagicDeal extends Deal {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1440153790621786764L;
	private String _magicType;
	private double _duration;
	
	/**
	 * Constructor for MagicTransaction
	 * <p>
	 * Used when a person buys a temporary dose of magic
	 * @param theId The id of the MagicTransaction
	 * @param theBuyer The buyer in the MagicTransaction
	 * @param theSeller The seller in the MagicTransaction
	 * @param theAmount The amount of the MagicTransaction
	 * @param theTimestamp The timestamp of the MagicTransaction
	 * @param theMagicType The type of magic bought
	 * @param theDuration How long the magic lasts in minutes
	 */
	
	public MagicDeal(int theId, String theBuyer, 
			String theSeller, double theAmount, String theTimestamp,
			String theMagicType, double theDuration) {
		super(theId, theBuyer, theSeller, theAmount, theTimestamp);
		_magicType = theMagicType;
		_duration = theDuration;
	}
	
	/**
	 * The type of magic bought
	 * @return The type of magic bought
	 */
	public String getMagicType() {
		return _magicType;
	}
	
	/**
	 * The duration of the magic in minutes
	 * @return The duration of the magic in minutes
	 */
	public double getDuration() {
		return _duration;
	}
	
	@Override
	/**
	 * Return String for MagicTransaction
	 * <p>
	 * Sample: [#45 | amount:$20.00 | Buyer: joe | Seller: seller | 3/4/12 Magic: dark | Duration: 45.0]
	 */
	public String toString() {
		return super.toString() 
			+ " " + String.format("Magic: %s | Duration: %s", 
					_magicType, _duration);
	}
}
