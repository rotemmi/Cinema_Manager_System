package application;

import java.io.Serializable;

public class Theater implements Serializable
{
	private int theaterId;
	private int numOfRows=0;
	private int numOfCols=0;
	private static final long serialVersionUID = 1L;
	
	public Theater(int theaterId)
	{
		this.theaterId=theaterId;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public int getNumOfRows() {
		return numOfRows;
	}

	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}

	public int getNumOfCols() 
	{
		return numOfCols;
	}

	public void setNumOfCols(int numOfCols) {
		this.numOfCols = numOfCols;
	}
}
