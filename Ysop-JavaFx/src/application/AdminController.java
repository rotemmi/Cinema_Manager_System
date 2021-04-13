package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AdminController 
{

	private AdminView adminView = AdminView.getAdminView();
	private Admin adminModel = Admin.getAdmin();
	private AddCinemaView addCinemaView = AddCinemaView.getAddCinemaView();
	private AddMovieView addMovieView=AddMovieView.getAddMovieView();
	private AddScreeningView addScreeningView = AddScreeningView.getAddScreeningView();
	private CinemaManager cinemaManagerModel = CinemaManager.getCinemaManager();

	@FXML
	public void deleteUserPress(ActionEvent e)
	{
		adminModel.deleteUser(adminView.deleteUserPress(adminModel.getUserNameList()));

	}

	@FXML
	public void addCinemaWindow(ActionEvent e) throws IOException
	{
		addCinemaView.addCinemaWindow();

	}

	@FXML
	public void addMovieWindow(ActionEvent e) throws IOException
	{
		addMovieView.addMovieWindow();

	}

	@FXML
	public void addScreeningWindow(ActionEvent e) throws IOException
	{
		String name = addScreeningView.chooseCinemaWindow(cinemaManagerModel.getCinemaNameList());
		if(!name.equals(""))
		{
			Cinema i =cinemaManagerModel.getCinemaByName(name);
			cinemaManagerModel.setCurrentCinema(i);
			addScreeningView.addScreeningWindow();
		}

	}
	
	@FXML
	protected void addAdminTutorialWindow(ActionEvent e) throws IOException
	{
		UserTutorialConroller.isUser=false;
		UserTutorialView.getUserTutorialView().addUserTutorialWindow();
	}
}
