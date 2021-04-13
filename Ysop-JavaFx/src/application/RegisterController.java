package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController
{
	@FXML
	private TextField firstNameBx;
	@FXML
	private TextField lastNameBx;
	@FXML
	private TextField userNameBx;
	@FXML
	private PasswordField passBx;
	@FXML
	private TextField creditBx;
	private Register registerModel = Register.getRegister();
	private RegisterView registerView = RegisterView.getRegisterView();

	public RegisterController()
	{

	}

	@FXML
	public void signUp(ActionEvent e) throws Exception
	{
		int flag = registerModel.signUp(firstNameBx.getText(), lastNameBx.getText(), userNameBx.getText(), passBx.getText(), creditBx.getText());
		
		switch(flag)
		{
		case 1:
		{
			registerView.showMessage("Sign Up Successful");	
			break;
		}
		case 0:
		{
			registerView.showMessage("Sign Up Wrong the User Name is Exist");
			break;
		}
		case -1:
		{
			registerView.showMessage("Please Enter details");
			break;
		}
		default:
			break;
		}
	}
}
