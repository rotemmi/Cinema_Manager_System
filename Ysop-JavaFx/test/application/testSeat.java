package application;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class testSeat {
	Seat S;
	
	 
	@Before
    public void before()
	{
		S= new Seat(1,1);
	}

	@Test
	public void testMarkSeat()
	{
		assertTrue("the Seat need to be first empty",S.isAvailable());
		S.markSeat();
		assertFalse("the seat was mark so its change to false",S.isAvailable());
		
	}

}
 