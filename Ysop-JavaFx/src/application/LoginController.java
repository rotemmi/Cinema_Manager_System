package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController 
{
	@FXML
	protected TextField userName;
	@FXML
	private PasswordField pass;
	private LoginView loginView =LoginView.getLoginView();
	private Login loginModel = Login.getLogin();
	private AdminView adminView = AdminView.getAdminView();
	private UserView userView = UserView.getUserView();

	@FXML
	public void signIn(ActionEvent e) throws Exception
	{
		int flag = loginModel.authentication(userName.getText(),pass.getText());
		switch(flag)
		{
		case 1:adminView.addAdminWindow();
		break;
		case -1: userView.addUserWindow();
		break;
		default: loginView.viewSignInAlert(flag);
		break;
		}
	}
}
