package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class UserController  implements Initializable
{
	@FXML
	private Label currentUserId;
	
	private UserView userView= UserView.getUserView();
	protected UserTutorialView  userTutorialView= UserTutorialView.getUserTutorialView();
	protected SearchMovieByCategoryView searchMovieByCategoryView= SearchMovieByCategoryView.getSearchMovieByCategoryView();
	protected ChooseMovieView chooseMovieView= ChooseMovieView.getChooseMovieView();
	protected ShowOrdersView showOrdersView= ShowOrdersView.getshowOrdersView();
	protected ContactUsView contactUsView= ContactUsView.getContactUsView();
	protected CinemaManager cinemaManager= CinemaManager.getCinemaManager();
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{

		currentUserId.setText("Welcome "+UserManagement.currentUser.getUserName());		
	}
	
	@FXML
	public void addFeedBack(ActionEvent e) throws IOException
	{
		cinemaManager.getMovieNameList();
		String movieNameChoose = userView.chooseMovieWindow(cinemaManager.getMovieNameList());
		if(movieNameChoose!=null)
		{
			 String feedBack = userView.addFeedBackWindow();
			 if(feedBack!=null)
			 cinemaManager.getMovieByName(movieNameChoose).addFeedBack(feedBack);
		}
	}
	
	@FXML
	public void SearchMovieByCategoryWindow(ActionEvent e) throws IOException
	{
		searchMovieByCategoryView.SearchMovieByCategoryWindow();

	}

	@FXML
	public void addChooseMovieWindow(ActionEvent e) throws IOException
	{
		chooseMovieView.addChooseMovieWindow();
	}
	
	@FXML
	public void addshowOrdersViewWindow(ActionEvent e) throws IOException
	{
		showOrdersView.addshowOrdersViewWindow();
	}
	
	@FXML
	protected void addUserTutorialWindow(ActionEvent e) throws IOException
	{
		UserTutorialConroller.isUser=true;
		userTutorialView.addUserTutorialWindow();
	}
	
	@FXML
	protected void addContactUsViewWindow(ActionEvent e) throws IOException
	{
		contactUsView.addContactUsViewWindow();
	}
}
