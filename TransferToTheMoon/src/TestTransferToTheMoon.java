import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class TestTransferToTheMoon {
	private VisaProcess thistest;
	@Before
	public void SetUp() {
		thistest=new VisaProcess();
	}
	@Test
	public void testaddingpeople() {
		//testing if the class succesfully adds people to the queue as well as the credentials map
		thistest.addApplicants("Hi", "WildWest1");
		thistest.addApplicants("Hello", "WildWest2");
		thistest.addApplicants("Oof", "WildWest3");
		assertEquals(3,thistest.getsizemap());
		assertEquals(3,thistest.getsizequeue());
	}
	@Test
	public void testgivingvisatopeople() throws NoSuchElementException {
		//also test lookup features to check if removing from queue affects it
		try{
			thistest.giveVisa();
			fail();
		}
		catch (NoSuchElementException ex){
			//nothingness
		}
		thistest.addApplicants("Hi", "WildWest1");
		thistest.addApplicants("Hello", "WildWest2");
		thistest.addApplicants("Oof", "WildWest3");
		thistest.giveVisa();
		thistest.giveVisa();
		assertEquals(1,thistest.getsizequeue());
		assertEquals("WildWest2",thistest.lookup("Hello"));
		assertEquals("WildWest3",thistest.lookup("Oof"));
	}

}
