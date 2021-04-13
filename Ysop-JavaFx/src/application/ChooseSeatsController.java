package application;
import java.io.IOException;

public class ChooseSeatsController extends ChooseMovieController  
{

	public static void addWindow() throws IOException
	{
		int rows = CinemaManager.getCinemaManager().currentCinema.currentScreening.getTheater().getNumOfRows();
		int cols =CinemaManager.getCinemaManager().currentCinema.currentScreening.getTheater().getNumOfCols();
		ChooseSeatsView.addChooseSeatsWindow(rows,cols,CinemaManager.cinemaManager.currentCinema.currentScreening.getSeatList());            
	}



	public static void saveButton() 
	{
		int rows = CinemaManager.getCinemaManager().currentCinema.currentScreening.getTheater().getNumOfRows();
		int cols =CinemaManager.getCinemaManager().currentCinema.currentScreening.getTheater().getNumOfCols();
		Order o = new Order();
		boolean isBuy= ChooseSeatsView.choosedButton>0;
		if(isBuy)
		{
			for(int i=0;i<rows;i++)
			{
				for(int j=0; j<cols;j++)
				{
					if(ChooseSeatsView.buttonArray[i][j].getText().equals("Choose"))
					{
						Seat s = CinemaManager.cinemaManager.currentCinema.currentScreening.chooseSeat(i+1,j+1);
						o.addSeat(s);
					}
				}
			}
			o.setScreeningName(CinemaManager.cinemaManager.currentCinema.currentScreening.toString());
			o.setNumOfTickets(ChooseSeatsView.choosedButton);
			UserManagement.currentUser.addOrders(o);
			Login login = Login.getLogin();
			login.writeUsers();
			CinemaManager.cinemaManager.writeCinemaList();
		}
		ChooseSeatsView.choosedButton=0;
		ChooseSeatsView.showAlert(isBuy);
	}

}
