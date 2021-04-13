package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ContactUsController extends UserController implements Initializable
{
	@FXML
	private Label cinemaName;
	@FXML
	private Label address;
	@FXML
	private Label tel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		String choose = contactUsView.showCinemaNameList(cinemaManager.getCinemaNameList());
		if(choose!=null)
		{
			contactUsView.initLabelContact(cinemaName,address,tel,choose, cinemaManager.getCinemaByName(choose).address, cinemaManager.getCinemaByName(choose).phoneNumber);
		}
		
	}
}
