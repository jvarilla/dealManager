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
 * The GrandMasterTransaction class is used when one rents the services of a Grand Master.
 * @author Joseph Varilla
 * @version 1.0 11/3/18
 */
public class GrandMasterDeal extends Deal {
	
	private static final long serialVersionUID = -4812845818965266010L;
	private String _specialty;
	private String _grandMasterName;
	private double _servedTime;
	
	
	/**
	 * Constructor for GrandMasterTransaction
	 * <p>
	 * Used when a person rents the services of a Grand Master.
	 * @param theId The id of the GrandMasterTransaction
	 * @param theBuyer the buyer in the GrandMasterTransaction
	 * @param theSeller the seller in the GrandMasterTransaction may be the Grand Master of their agency.
	 * @param theAmount the amount of the GrandMasterTransaction
	 * @param theTimestamp the timestamp of the GrandMasterTransaction
	 * @param theSpecialty the specialty of the Grand Master
	 * @param theGrandMasterName the name of the Grand Master
	 * @param theServedTime the amount of time (minutes) worked by the Grand Master in the transaction
	 */
	public GrandMasterDeal(int theId, String theBuyer, 
			String theSeller, double theAmount, String theTimestamp,
			String theSpecialty, String theGrandMasterName, 
			double theServedTime) {
		
		super(theId, theBuyer, theSeller, theAmount, theTimestamp);
		_specialty = theSpecialty;
		_grandMasterName = theGrandMasterName;
		_servedTime = theServedTime;
	}
	
	
	/**
	 * The specialty of the Grand Master
	 * @return The specialty of the Grand Master
	 */
	public String getSpecialty() {
		return _specialty;
	}
	
	/**
	 * The name of the Grand Master
	 * @return the name of the Grand Master
	 */
	public String getGrandMasterName() {
		return _grandMasterName;
	}
	
	/**
	 * The amount of time served by the Grand Master in minutes
	 * @return the number of minutes the Grand Master worked
	 */
	public double getServedTime() {
		return _servedTime;
	}
	
	@Override
	/**
	 * Return String for GrandMasterTransaction
	 * <p>
	 * Sample: [#3 | amount:$20.00 | Buyer: buyer | Seller: seller | 3/4/12 Specialty: ??? | Grand Master: Dumbeldore| Served Time: 90.0mins]
	 */
	public String toString() {
		return super.toString() + " "
			+ String.format("Specialty: %s | Grand Master: %s" 
					+ "| Served Time: %s mins",
					_specialty, _grandMasterName, _servedTime);
	}
}
