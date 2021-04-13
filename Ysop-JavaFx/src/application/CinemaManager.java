package application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Observable;

public class CinemaManager extends Observable implements Serializable
{

	protected ArrayList<Movie> movieList = new ArrayList<>();
	protected ArrayList<String> categoryList = new ArrayList<>(Arrays.asList("Comedy", "Horror", "Voltage")); 
	protected ArrayList<Cinema> cinemaList = new ArrayList<>();
	protected String cinemaFile = "cinema.txt"; 
	protected String movieFile = "movie.txt";
	static CinemaManager cinemaManager = new CinemaManager();
	protected Cinema currentCinema;
	protected Movie currentMovie;
	protected ArrayList<Date> dateList = new ArrayList<>(); 
	private static final long serialVersionUID = 1L;



	public static Date makeDate(int year,int month,int date,int hour,int minute,int second)
	{
		Calendar myCalendar = new GregorianCalendar();
		myCalendar.set(year, month, date, hour, minute, second);
		return myCalendar.getTime();	
	}

	private void buildDateList() 
	{
		Date d1 = makeDate(2001,8,4,8,0,0);
		Date d2 = makeDate(2001,8,4,11,0,0);
		Date d3 = makeDate(2001,8,4,14,0,0);
		Date d4 = makeDate(2001,8,4,16,0,0);
		Date d5 = makeDate(2001,8,4,20,0,0);

		Date d6 = makeDate(2001,8,5,8,0,0);
		Date d7 = makeDate(2001,8,5,11,0,0);
		Date d8 = makeDate(2001,8,5,14,0,0);
		Date d9 = makeDate(2001,8,5,16,0,0);
		Date d10 =makeDate(2001,8,5,20,0,0);

		dateList.add(d1);
		dateList.add(d2);
		dateList.add(d3);
		dateList.add(d4);
		dateList.add(d5);
		dateList.add(d6);
		dateList.add(d7);
		dateList.add(d8);
		dateList.add(d9);
		dateList.add(d10);

	}


	private CinemaManager()
	{
		buildDateList();
		readCinemaFile();
		readMovieFile();
		for(Cinema i:cinemaList)
		{
			addObserver(i);
		}
	}


	public ArrayList<String> getMovieListByCategory(String category) 
	{
		ArrayList<String> movieListByCategory = new ArrayList<String>();
		for(Movie i: movieList)
		{
			if(i.getCategory().equals(category))
			{
				movieListByCategory.add(i.getName());
			}
		}
		return movieListByCategory;
	}

	public Cinema getCurrentCinema() 
	{
		return currentCinema;
	}
	public void setCurrentCinema(Cinema currentCinema) 
	{
		this.currentCinema = currentCinema;
	}


	public void setCurrentCinemaName(String cinemaName) 
	{
		for(Cinema i : cinemaList)
		{
			if(i.getCinemaName().equals(cinemaName))		
			{
				currentCinema=i;
			}
		}
	}

	public Cinema getCinemaByName(String cinemaName) 
	{
		for(Cinema i : cinemaList)
		{
			if(i.getCinemaName().equals(cinemaName))
			{
				return i;
			}
		}
		return null;
	}

	public Movie getCurrentMovie() 
	{
		return currentMovie;
	}
	public void setCurrentMovie(Movie currentMovie) 
	{
		this.currentMovie = currentMovie;
	}

	public void setCurrentMovieName(String movieName) 
	{
		for(Movie i : movieList)
		{
			if(i.getName().equals(movieName))
			{
				currentMovie=i;
			}
		}
	}

	public Movie getMovieByName(String movieName) 
	{
		for(Movie i : movieList)
		{
			if(i.getName().equals(movieName))
			{
				return i;
			}
		}
		return null;
	}


	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public static CinemaManager getCinemaManager() 
	{
		return cinemaManager;
	}

	protected int addCinema(String cinemaName,String address,String phoneNumber,String numofTheaters)
	{
		if(cinemaName.equals("") || address.equals("")  ||  phoneNumber.equals("") || numofTheaters.equals(""))
			return -1;
		for(Cinema i: cinemaList )
		{
			if(i.getCinemaName().equals(cinemaName))
			{
				return 0;
			}
		}
		Cinema c = new Cinema(cinemaName, address, phoneNumber, numofTheaters);
		cinemaList.add(c);
		addObserver(c);

		writeCinemaList();
		return 1;	
	}

	public void overrideCinema(Cinema cinema,String address,String phoneNumber,String numofTheaters)
	{
		clearUsersOrder(cinema.getCinemaName());
		cinema.setAddress(address);
		cinema.setPhoneNumber(phoneNumber);
		cinema.setTheaterList(new ArrayList<Theater>());
		cinema.addTheaters(Integer.parseInt(numofTheaters));
		cinema.setScreenlist(new ArrayList<Screening>());
		writeCinemaList();
	}

	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}
	public void setCinemaList(ArrayList<Cinema> cinemaList) {
		this.cinemaList = cinemaList;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public void writeMovieList()
	{	
		ObjectOutputStream outputStream=null;
		try	{

			outputStream=new ObjectOutputStream(new FileOutputStream(movieFile));
			outputStream.writeObject(movieList);

		}
		catch(IOException e) {

		} finally {
			try {
				outputStream.close();
			} catch (IOException e1) {
			}

		}

	}

	@SuppressWarnings("unchecked")
	protected void readMovieFile()
	{
		ObjectInputStream inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(movieFile));
			movieList=(ArrayList<Movie>) inputStream.readObject();

		} 
		catch(IOException | ClassNotFoundException e) 
		{

		}	
	}



	public void writeCinemaList()
	{	
		ObjectOutputStream outputStream=null;
		try	{

			outputStream=new ObjectOutputStream(new FileOutputStream(cinemaFile));
			outputStream.writeObject(cinemaList);

		}
		catch(IOException e) {

		} finally {
			try {
				outputStream.close();
			} catch (IOException e1) {
			}

		}

	}

	@SuppressWarnings("unchecked")
	protected void readCinemaFile()
	{
		ObjectInputStream inputStream=null;
		try {
			inputStream=new ObjectInputStream(new FileInputStream(cinemaFile));
			cinemaList=(ArrayList<Cinema>) inputStream.readObject();

		} 
		catch(IOException | ClassNotFoundException e) 
		{

		}	
	}

	protected void deleteCinema(String cinemaName)
	{
		if(cinemaName.equals(""))
			return;
		for(Iterator<Cinema> i = cinemaList.iterator(); i.hasNext();) 
		{
			if(i.next().getCinemaName().equals(cinemaName))
			{
				clearUsersOrder(cinemaName);
				i.remove();
				writeCinemaList();
				return;
			}           
		}
	}

	protected void clearUsersOrder(String cinemaName)
	{
		Cinema c =  getCinemaByName(cinemaName);
		ArrayList<String> screeningList = c.getStringScreeningList();
		for(int j=0; j < screeningList.size();j++)
		{
			c.removeScreening(screeningList.get(j));
		}
	}
	protected ArrayList<String> getCinemaNameList() 
	{
		ArrayList<String> names = new ArrayList<String>();
		for(Cinema i :cinemaList)
		{
			names.add(i.getCinemaName());
		}
		return names;
	}

	public int addMovie(String movieName, String Category, String aboutMovie,String image ) 
	{
		if(movieName.equals("") || Category.equals("")  ||  aboutMovie.equals(""))
			return -1;
		for(Movie i: movieList )
		{
			if(i.getName().equals(movieName))
			{
				return 0;
			}
		}
		movieList.add(new Movie(movieName, Category, aboutMovie,image));
		writeMovieList();
		return 1;	
	}

	public ArrayList<String> getMovieNameList() 
	{
		ArrayList<String> listName= new ArrayList<String>();
		for(Movie i : movieList)
		{
			listName.add(i.getName());
		}
		return listName;
	}
	public void overrideMovie(Movie movie,String Category, String aboutMovie,String image)
	{
		movie.setCatgory(Category);
		movie.setAboutMovie(aboutMovie);
		movie.setImage(image);
		writeMovieList();

	}
	public void deleteMovie(String deleteChoose) 
	{
		if(!deleteChoose.equals(""))
		{
			Movie i = getMovieByName(deleteChoose);
			if(i!=null)
			{
				movieList.remove(i);

				writeMovieList();
			}

			setChanged(); 
			notifyObservers(deleteChoose); 
			cinemaManager.writeCinemaList();
		}
	}
	
	public void setMovieList(ArrayList<Movie> movieList)
	{
		this.movieList = movieList;
	}
}




