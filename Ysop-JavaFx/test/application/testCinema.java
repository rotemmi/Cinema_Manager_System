package application;
import org.junit.Before;
import org.junit.Test;
import application.Cinema;
import static org.junit.Assert.assertEquals;
public class testCinema 
{
	Cinema C;

	@Before
	public void before()
	{
		C= new Cinema();
	}

	@Test
	public void testAddTheaters()
	{

		C.addTheaters(1);
		assertEquals("when adding new Theater,the number is 1",1,C.getTheaterList().size());
	}

	@Test
	public void testDeleteTheater()
	{
		C.addTheaters(3);
		int num=C.deleteTheater(2);
		int num2=C.deleteTheater(4);
		int num3=C.deleteTheater(-1);
		assertEquals("when delete theater exist return 1",1,num);
		assertEquals("when delete theater not exist return 0",0,num2);
		assertEquals("when try to  delete  negative theater return -1",-1,num3);
	}
}