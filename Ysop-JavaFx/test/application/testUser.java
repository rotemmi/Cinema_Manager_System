package application;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class testUser {
	User U;
	@Before
	public void naor()
	{
		U= new User("naor","cohen","naor123","123","111",false);
	}

	@Test
	public void testGetOrderListString()
	{
		U.getOrederList();
		U.getOrederList().add(new Order(3,"harryPoter"));
		assertEquals("when added new order to list the number order is 1",1,U.getOrederListString().size());

	}
	
	@Test
	public void testAddOrders()
	{
		 Order order1=new Order(1,"harryPoter");
		 U.addOrders(order1);
		 assertEquals("when added new order to list the number order is 1",1,U.getOrederListString().size());
	}
		
}
