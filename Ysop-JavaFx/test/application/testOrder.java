package application;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testOrder {
   Order O;
   
   @Before
   public void before()
	{
		O= new Order(1,"Nemo");
	}

	@Test
	public void testaddSeat() {
		
		O.getSeats().add(new Seat(1,1));
		O.getSeats().add(new Seat(2,1));
		assertEquals("in the list need to be two seats",2,O.getSeats().size());
	}
}
 