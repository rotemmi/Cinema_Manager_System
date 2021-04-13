package application;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Screening implements Serializable
{
	private String cinemaName;
	private int screenId;
	private String movieName;
	private Date date;
	private  ArrayList<Seat> seatList = new ArrayList<Seat>();
	private int numofAvailableSeats;
	private Theater theater;
	private boolean isFullScreening;
	private CinemaManager cinemaManager= CinemaManager.getCinemaManager();
	private static final long serialVersionUID = 1L;

	public Screening(Theater t)
	{
		this.theater=t;
	}

	public Screening(String cinemaName,String movieName,Date date,int theaterId)
	{
		this.isFullScreening = false;
		seatList = new ArrayList<Seat>();
		this.theater = cinemaManager.getCinemaByName(cinemaName).getTheater(theaterId);
		this.numofAvailableSeats= theater.getNumOfCols() * theater.getNumOfRows(); 
		this.cinemaName=cinemaName;
		this.movieName=movieName;
		this.date=date;
		buildScreening();
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setTheaterId(int theaterId) 
	{
		theater = cinemaManager.getCinemaByName(cinemaName).getTheater(theaterId);
	}

	public int getScreenId() 
	{
		return screenId;
	}

	public String getMovieName() 
	{
		return movieName;
	}

	public int getTheaterId()
	{
		return theater.getTheaterId();
	}

	public void buildScreening()
	{
		int rows = theater.getNumOfRows(),cols = theater.getNumOfCols();
		for (int i = 1; i<=rows;i++)
		{
			for (int j = 1; j<=cols;j++)
			{
				seatList.add(new Seat(i,j));
			}
		}
	}


	public Seat findSeat(int row, int col)
	{
		for(Seat i :seatList)
		{
			if(i.getRow()==row && i.getCol()==col)
			{
				return i;
			}	
		}
		return null;
	}


	public int checkSeat(Seat i)
	{
		if(i!=null)
			return i.isAvailable() ? 1 : 0;
		return -1;
	}

	public Seat chooseSeat(int row,int col)
	{
		Seat i = findSeat(row,col);
		switch(checkSeat(i))
		{
		case 1: i.markSeat();
		this.numofAvailableSeats--;
		if(numofAvailableSeats - (theater.getNumOfCols() *theater.getNumOfRows()) == 0)
			isFullScreening= true;
		return i;
		default:
			return null;
		}	
	}

	public ArrayList<Seat> getSeatList() {
		return seatList;
	}
	public void setSeatList(ArrayList<Seat> seatList) {
		this.seatList = seatList;
	}
	public int getNumofAvailableSeats() {
		return numofAvailableSeats;
	}
	public void setNumofAvailableSeats(int numofAvailableSeats) {
		this.numofAvailableSeats = numofAvailableSeats;
	}
	public boolean isFullScreening() {
		return isFullScreening;
	}

	@Override
	public String toString() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		return "Cinema: "+cinemaName+"\nMovie: "+movieName+"\nTheater ID: " +theater.getTheaterId() + "\nDate: " +sdf.format(date);
	}
	public Theater getTheater() {
		return theater;
	}

	public void update(Object arg) 
	{
		String screeningName = (String)arg;
		Admin admin = Admin.getAdmin();
		admin.readUsers();
		for(User u:admin.users)
		{	
			for(int i=0;i<u.getOrederList().size();i++)
			{
				String screeningStr = u.getOrederList().get(i).getScreeningName();
				if(screeningStr.equals(screeningName))
				{
					u.getOrederList().remove(i);
					break;
					
				}     
			}
		}
	}
}