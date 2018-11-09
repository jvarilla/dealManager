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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dealmanager.GrandMasterDeal;
import dealmanager.MagicDeal;
import dealmanager.Deal;

class Test1 {
	Deal t = new Deal(2, "buyer", "seller", 20.00 , "3/4/12");
	MagicDeal mt = new MagicDeal(3, "joe", "seller", 20.00 , "3/4/12", "dark", 45.00);
	GrandMasterDeal gmt = new GrandMasterDeal(3, "buyer", "seller", 20.00 , "3/4/12", "???", "Dumbledore",  90.00);
	@Test
	void test() {
		//fail("Not yet implemented");
		//Test Transaction
		assertEquals(2, t.getId());
		assertEquals("buyer", t.getBuyer());
		assertEquals("seller", t.getSeller());
		assertEquals(20.00, t.getAmount());
		assertEquals("3/4/12", t.getTimestamp());
		
		
		//Test Magic Transaction
		assertEquals(3, mt.getId());
		assertEquals("joe", mt.getBuyer());
		assertEquals("seller", mt.getSeller());
		assertEquals(20.00, mt.getAmount());
		assertEquals("3/4/12", mt.getTimestamp());
		assertEquals("dark", mt.getMagicType());
		assertEquals(45.00, mt.getDuration());
		
		
		//Test GrandMaster Transaction
		assertEquals(3, gmt.getId());
		assertEquals("buyer", gmt.getBuyer());
		assertEquals("seller", gmt.getSeller());
		assertEquals(20.00, gmt.getAmount());
		assertEquals("3/4/12", gmt.getTimestamp());
		assertEquals("???", gmt.getSpecialty());
		assertEquals("Dumbledore", gmt.getGrandMasterName());
		assertEquals(90.00, gmt.getServedTime());
		
		
		//Test Comparators
		assertEquals(-1, t.compareTo(mt));
		assertEquals(0, mt.compareTo(gmt));
		assertEquals(1, gmt.compareTo(t));
	}

}
