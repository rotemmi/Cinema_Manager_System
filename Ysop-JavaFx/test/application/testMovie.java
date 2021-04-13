package application;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testMovie {
   Movie M;
   
   @Before
   public void before()
	{
		M= new Movie("nemo","adventure","movie for all the famliy","fish");
	}

	@Test
	public void testaddSeat() {
		
		M.getFeedbackList().add("good movie");
		assertEquals("in the list need to be 1 feedback we added",1,M.getFeedbackList().size());
	}
}

