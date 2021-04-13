package application;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class testScreening 
{
	Screening S;

	@Before
	public void before()
	{
		Theater t=new Theater(0);
		S= new Screening(t);
	}

	@Test 
	public void testfindSeat()
	{

		S.getSeatList().add(new Seat(0,1));
		assertNull("Check that seat(2,2) not Exist",S.findSeat(2,2));
		assertNotNull("check that seat(0,1) Exist",S.findSeat(0,1));
	}

	@Test
	public void testcheckSeat()
	{
		Seat s1=new Seat(1,1);
		assertEquals("when the seat is available you get 1",1,S.checkSeat(s1));
		s1.markSeat();
		assertEquals("when the seat is available you get 0",0,S.checkSeat(s1));
		assertEquals("when the seat is not exist you get -1",-1,S.checkSeat(null));

	}
	@Test
	public void testchooseSeat()
	{
		//	S.getgetSeatList().add(new Seat(1,1));
		//S.setTheater(new Theater(0));
		S.getSeatList().add(new Seat(1,1));
		S.getTheater().setNumOfCols(1);
		S.getTheater().setNumOfRows(1);
		S.setNumofAvailableSeats(1);
		assertNotNull("the seat(1,1) is first available beacuse no one choose him so you will get him",S.chooseSeat(1,1));
		assertNull("the seat(1,1) chose so it is not available and you will not get the requested chair",S.chooseSeat(1,1));

	}
}



