package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCinemaController 
{
	@FXML
	private TextField cinemaName;
	@FXML
	private TextField address;
	@FXML
	private TextField phoneNumber;
	@FXML
	private TextField numOfTheaters;
	private CinemaManager cinemaManagerModel = CinemaManager.getCinemaManager();
	private AddCinemaView addCinemaView = AddCinemaView.getAddCinemaView();
	private AddTheaterView addTheaterView = AddTheaterView.getAddTheaterView();

	@FXML
	public void addCinemaPress(ActionEvent e) throws IOException
	{

		int flag = cinemaManagerModel.addCinema(cinemaName.getText(),address.getText(),phoneNumber.getText(),numOfTheaters.getText());
		switch(flag)
		{
		case -1 : addCinemaView.showMessage("Please Enter Details");
		break;
		case 0: cinemaManagerModel.setCurrentCinemaName(cinemaName.getText());
				int choose = addCinemaView.showAlertOverride();
				if(choose==1)
				{
				
					cinemaManagerModel.overrideCinema(cinemaManagerModel.currentCinema, address.getText(), phoneNumber.getText(), numOfTheaters.getText());
					addTheaterView.addTheaterWindow();
				}
				break;
		default: 
			cinemaManagerModel.setCurrentCinemaName(cinemaName.getText());
			addTheaterView.addTheaterWindow();
			break;
		}	
	}

	@FXML
	public void deleteCinemaPress(ActionEvent e)
	{
		cinemaManagerModel.deleteCinema(addCinemaView.deleteCinemaPress(cinemaManagerModel.getCinemaNameList()));
	}
}
