package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MainController 
{
	protected LoginView l = LoginView.getLoginView();
	protected RegisterView r = RegisterView.getRegisterView();

	@FXML
	public void Login(ActionEvent e) throws Exception  
	{	
		l.addLoginWindow();
	}

	@FXML
	public void Register(ActionEvent e) throws Exception  
	{	
		r.addRegisterWindow();

	}
	
}
