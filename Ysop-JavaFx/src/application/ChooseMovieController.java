package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ChooseMovieController extends UserController implements Initializable
{
	@FXML
	ComboBox<String> cinemaTxt;
	ObservableList<String>listC;

	@FXML
	ComboBox<String> movieTxt;
	ObservableList<String>listM;

	@FXML
	ComboBox<String> dateTxt;
	ObservableList<String>listD;
	
	@FXML
	ComboBox<String> screeningTxt;
	ObservableList<String>listSc;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		init();

	}
	
	public void init()
	{
		chooseMovieView.initCombo(cinemaTxt,listC,cinemaManager.getCinemaNameList());
	}
	
	@FXML
	public void cinemaPressed(ActionEvent e)  
	{
		cinemaManager.currentCinema = cinemaManager.getCinemaByName(cinemaTxt.getValue());
		chooseMovieView.initCombo(movieTxt,listM,cinemaManager.currentCinema.getMovieList());
	}
	
	@FXML
	public void moviePressed(ActionEvent e)  
	{
		if(chooseMovieView.checkValidate(cinemaTxt) && chooseMovieView.checkValidate(movieTxt) )
		{
			chooseMovieView.initCombo(dateTxt,listD,cinemaManager.currentCinema.getDayListScreeningByMovie(movieTxt.getValue()));
		}
	}
	
	@FXML
	public void dayPressed(ActionEvent e)  
	{
		if(chooseMovieView.checkValidate(cinemaTxt) && chooseMovieView.checkValidate(movieTxt) &&  chooseMovieView.checkValidate(dateTxt))
		{
			chooseMovieView.initCombo(screeningTxt,listSc,cinemaManager.currentCinema.getScreeningListByMovieAndDate(movieTxt.getValue(),dateTxt.getValue()));
		}
	}
	
	@FXML
	public void buyTicketPress(ActionEvent e) throws IOException  
	{
		if(chooseMovieView.checkValidate(cinemaTxt) && chooseMovieView.checkValidate(movieTxt) &&  chooseMovieView.checkValidate(dateTxt) && chooseMovieView.checkValidate(screeningTxt))
		{
			cinemaManager.currentCinema.currentScreening = cinemaManager.currentCinema.getScreeningByString(screeningTxt.getValue());
			ChooseSeatsController.addWindow();
		}
	}
	
}
