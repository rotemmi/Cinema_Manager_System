package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable
{
	private ArrayList<Seat> seats = new ArrayList<Seat>();
	private int numOfTickets;
	private String screeningName;
	private static final long serialVersionUID = 1L;
	public ArrayList<Seat> getSeats() 
	{
		return seats;
	}
	
	
	public Order(int numOfTickets, String screeningName)
	{
		this.numOfTickets = numOfTickets;
		this.screeningName = screeningName;
	}
	public Order()
	{
		
	}
   
	public int getNumOfTickets() {
		return numOfTickets;
	}


	public void setNumOfTickets(int numOfTickets) {
		this.numOfTickets = numOfTickets;
	}


	public void addSeat(Seat s) {
		seats.add(s);
	}
	
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	public String getScreeningName() {
		return screeningName;
	}
	public void setScreeningName(String screeningName) {
		this.screeningName = screeningName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() 
	{
		return "Num of Tickets: " +Integer.toString(numOfTickets)+"\n"+screeningName+"\n"+seats;
	
	}
}
