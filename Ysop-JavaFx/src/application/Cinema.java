package application;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;



public class Cinema implements Serializable,Observer
{
	static int cinemaId;
	protected String cinemaName;
	protected String address;
	protected String phoneNumber;
	protected  ArrayList<Theater> theaterList= new ArrayList<>();
	protected  ArrayList<Screening> screenlist=new ArrayList<>();
	protected Screening currentScreening;
	protected CinemaManager cinemaManager= CinemaManager.getCinemaManager();
	private static final long serialVersionUID = 1L;

	public Cinema(String cinemaName,String address,String phoneNumber,String numofTheaters)
	{
		cinemaId++;
		this.cinemaName = cinemaName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		addTheaters(Integer.parseInt(numofTheaters));
	}
	
	public Cinema()
	{
		
	}
	
	public Screening getScreeningByString(String screening)
	{
		for(Screening i : screenlist)
		{
			if(i.toString().equals(screening))
			{
				return i;
			}
		}
		return null;
	}
	public static int getCinemaId() {
		return cinemaId;
	}


	public static void setCinemaId(int cinemaId) {
		Cinema.cinemaId = cinemaId;
	}


	public CinemaManager getCinemaManager() {
		return cinemaManager;
	}


	public void setCinemaManager(CinemaManager cinemaManager) {
		this.cinemaManager = cinemaManager;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public boolean addScreening(String movieName,String dateName,Integer theaterId ) 
	{
		//Date date;
		try {
			Date date = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a").parse(dateName);
			Screening s = new Screening(cinemaName, movieName, date, theaterId);
			screenlist.add(s);
			cinemaManager.writeCinemaList();
			return true;
		} 
		catch (ParseException e) 
		{
			return false;

		} 
	}

	public boolean removeScreening(String screeningString )
	{
		if(screeningString.equals(""))
			return false;

		for(Screening i: screenlist)
		{
			if(i.toString().equals(screeningString))
			{

				i.update(i.toString());
				Admin admin =Admin.getAdmin();
				admin.writeUsers();
				screenlist.remove(i);
				cinemaManager.writeCinemaList();
				return true;
			}
		}
		return false;

	}



	public void addTheaters(int numofTheaters )
	{
		for(int i=0 ;i< numofTheaters;i++)
		{
			theaterList.add(new Theater(i+1));
		}
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public ArrayList<Theater> getTheaterList() {
		return theaterList;
	}

	public void setTheaterList(ArrayList<Theater> theaterList) {
		this.theaterList = theaterList;
	}

	public ArrayList<Screening> getScreenlist() {
		return screenlist;
	}

	public void setScreenlist(ArrayList<Screening> screenlist) {
		this.screenlist = screenlist;
	}

	protected Theater getTheater(int theaterId)
	{
		for(Theater i :theaterList)
		{
			if(i.getTheaterId()==theaterId)
			{
				return i;
			}
		}
		return null;
	}

	protected void setTheater(int theaterId,int rows,int cols)
	{
		Theater t = getTheater(theaterId);
		t.setNumOfRows(rows);
		t.setNumOfCols(cols);
		cinemaManager.writeCinemaList();
	}

	protected ArrayList<Integer> getTheaterListId()
	{
		ArrayList<Integer>idList=new ArrayList<>();
		for(Theater i : theaterList)
		{
			if(i.getNumOfCols()!=0 && i.getNumOfRows()!=0 )
			{
				idList.add(i.getTheaterId());
			}
		}
		return idList;
	}


	public Integer deleteTheater(int theaterId) 
	{
		if(theaterId==-1)
			return -1;
		for(Theater i :theaterList)
		{
			if(i.getTheaterId()==theaterId)
			{
				i.setNumOfRows(0);
				i.setNumOfCols(0);
				return 1;
			}
		}
		return 0;

	}

	public ArrayList<Integer>getTheaterGenerateList() 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(Theater i: theaterList)
		{
			if(i.getNumOfRows()==0 && i.getNumOfCols()==0 )
			{
				list.add(i.getTheaterId());
			}
		}
		return list;
	}

	public ArrayList<String> dateListFormat(ArrayList<Date>list)
	{
		ArrayList<String> dateListFormat = new ArrayList<String>();
		for(Date i: list)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
			dateListFormat.add(sdf.format(i));
		}
		return dateListFormat;

	}
	public ArrayList<String>getAvailableDateString(int theaterId) 
	{
		ArrayList<Date> usedDates = new ArrayList<Date>();
		ArrayList<String> nonUsedDates = new ArrayList<String>();
		ArrayList<String> dateListFormat = dateListFormat(cinemaManager.dateList);
		boolean check=false;
		for(Screening i: screenlist)
		{
			if(i.getTheaterId() == theaterId)
			{
				usedDates.add(i.getDate());
				check=true;
			}
		}
		if(check)
		{	

			for(String i: dateListFormat)
			{
				if(findDate(i,usedDates)==null)
				{
					nonUsedDates.add(i);
				}
			}
			return nonUsedDates;
		}
		return dateListFormat;
	}

	public Date findDate(String dateString,ArrayList<Date>list)
	{
		for(Date i: list)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
			if(sdf.format(i).equals(dateString))
				return i;
		}
		return null;
	}

	public ArrayList<String>getMovieList() 
	{
		ArrayList<String> movieList = new ArrayList<String>();
		for(Screening i:screenlist)
		{
			movieList.add(i.getMovieName());
		}
		List<String> newList = movieList.stream().distinct().collect(Collectors.toList()); 
		return (ArrayList<String>) newList;
	}



	public ArrayList<String>getStringScreeningList() 
	{
		ArrayList<String> stringScreeningList = new ArrayList<String>();
		for(Screening i:screenlist)
		{
			stringScreeningList.add(i.toString());
		}
		return stringScreeningList;		
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		String movieName = (String)arg;

		for(int i=0;i<screenlist.size();i++)
		{
			Screening s = screenlist.get(i);
			if(s.getMovieName().equals(movieName))
			{
				s.update(s.toString());
				Admin admin =Admin.getAdmin();
				admin.writeUsers();
				screenlist.remove(i);
				i--;
			}     
		}	
	}


	public ArrayList<String> getDayListScreeningByMovie(String movieName) 
	{
		ArrayList<String> stringDayList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		for(Screening i:screenlist)
		{
			if(i.getMovieName().equals(movieName))
			{
				stringDayList.add(sdf.format(i.getDate()));
			}
		}
		return stringDayList;
	}

	public ArrayList<String> getScreeningListByMovieAndDate(String movieName,String Date) 
	{
		ArrayList<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
		for(Screening i:screenlist)
		{
			if(i.getMovieName().equals(movieName) && sdf.format(i.getDate()).equals(Date))
			{
				list.add(i.toString());
			}
		}
		return list;
	}
}
