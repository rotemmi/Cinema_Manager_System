package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class AddScreeningController implements Initializable
{
	private AddScreeningView addScreeingView=AddScreeningView.getAddScreeningView();
	private CinemaManager cinemaManagerModel = CinemaManager.getCinemaManager();

	@FXML
	private ComboBox<String>dateCmbx;
	ObservableList<String>listComboDate;

	@FXML
	private ComboBox<String>movieCmbx;
	ObservableList<String>listComboMovie;

	@FXML
	private ComboBox<Integer>theaterCmbx;
	ObservableList<Integer>listComboTheater;
	
	@FXML
	private Label currencCinemaLbl;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		init();
	}

	public void init()
	{
		addScreeingView.initTextCombos(theaterCmbx,dateCmbx,movieCmbx,currencCinemaLbl,cinemaManagerModel.currentCinema.getCinemaName());
		addScreeingView.addItemComboBoxTheater(theaterCmbx, listComboTheater,cinemaManagerModel.currentCinema.getTheaterListId());
		addScreeingView.addItemComboBox(movieCmbx, listComboMovie, cinemaManagerModel.getMovieNameList());
	}


	
	@FXML
	public void theaterIdChoosed(ActionEvent e)  
	{
		addScreeingView.addItemComboBox(dateCmbx, listComboDate, cinemaManagerModel.currentCinema.getAvailableDateString(theaterCmbx.getValue()));
	}
	

	@FXML
	public void addScreeingPress(ActionEvent e)  
	{
		if (addScreeingView.checkSelectedComboxes(movieCmbx, dateCmbx, theaterCmbx))
		{
			if (cinemaManagerModel.currentCinema.addScreening(movieCmbx.getValue(), dateCmbx.getValue(), theaterCmbx.getValue()))
			{
				addScreeingView.showMessage("Screen Add Successfully");
				addScreeingView.addItemComboBox(dateCmbx, listComboDate, cinemaManagerModel.currentCinema.getAvailableDateString(theaterCmbx.getValue()));
			}
		}
		else
		{
			addScreeingView.showMessage("There is a problem");
		}
	}
	
	@FXML
	public void removeScreeingPress(ActionEvent e)  
	{
		String deleteChoose = addScreeingView.showScreenDialog(cinemaManagerModel.currentCinema.getStringScreeningList());
		cinemaManagerModel.currentCinema.removeScreening(deleteChoose);	
		if(!deleteChoose.equals("") && theaterCmbx.getValue()!=null)
		{
			addScreeingView.addItemComboBox(dateCmbx, listComboDate, cinemaManagerModel.currentCinema.getAvailableDateString(theaterCmbx.getValue()));
		}
	}

	@FXML
	public void moviePress(ActionEvent e)  
	{
		 if(addScreeingView.checkSelectedComboxes(movieCmbx, dateCmbx, theaterCmbx))
			 addScreeingView.addItemComboBox(dateCmbx, listComboDate, cinemaManagerModel.currentCinema.getAvailableDateString(theaterCmbx.getValue()));
	}
}
