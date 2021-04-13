package application;

import java.io.Serializable;

public class Seat implements Serializable
{
	private int row;
	private int col;
	private boolean available = true;
	private static final long serialVersionUID = 1L;
	
	public Seat(int row, int col) 
	{
		this.row=row;
		this.col=col;
	}

	public int getRow() 
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	public void markSeat()
	{
		this.available=false;
	}
	
	public boolean isAvailable()
	{
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() 
	{
		return "Row: "+Integer.toString(row)+" col: "+Integer.toString(col)+"";
	}		
}
