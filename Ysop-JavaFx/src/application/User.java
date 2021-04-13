package application;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable 
{
	private	String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String creditCard;
	private boolean isAdmin;
	private ArrayList<Order>orederList =new  ArrayList<Order>();
	private static final long serialVersionUID = 1L;

	public User(String firstName, String lastName,String userName,String password, String creditCard, boolean isAdmin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName=userName;
		this.password = password;
		this.creditCard = creditCard;
		this.isAdmin = isAdmin;
	}


	public ArrayList<Order> getOrederList() 
	{
		return orederList;
	}
	public ArrayList<String> getOrederListString() 
	{
		ArrayList<String>orderStringList = new ArrayList<String>();
		for(Order i : orederList)
		{
			orderStringList.add(i.toString());
		}
		return orderStringList;
	}

	public void deleteOrders() 
	{
		for(Cinema c :CinemaManager.getCinemaManager().getCinemaList())
		{
			for(Order o : orederList)
			{
				Screening s =c.getScreeningByString(o.getScreeningName());
				if(s!=null)
				{
					for(Seat sc:o.getSeats())
					{
						sc.setAvailable(true);
						for(Seat se:s.getSeatList())
						{
							if(se.getRow() == sc.getRow() && se.getCol()== sc.getCol())
							{
								se.setAvailable(true);
							}
						}
					}
					
					s.setNumofAvailableSeats(s.getNumofAvailableSeats() +o.getNumOfTickets());
					return;
				}
			}
		}
	}
	public void addOrders(Order o)
	{
		orederList.add(o);
	}
	public String getFirstName() {
		return firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "user- userName= " +userName + "firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", creditCard="
				+ creditCard + ", isAdmin=" + isAdmin ;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName=userName;
	}
}
