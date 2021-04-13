package application;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginView extends Main  
{
	protected Stage loginStage;
	static LoginView loginView=new LoginView();
	public static LoginView getLoginView() 
	{
		return loginView;
	}

	protected void viewSignInAlert(int flag)
	{
		switch(flag)
		{
		case 0: 

			Alert a = new Alert(AlertType.INFORMATION);
			a.setTitle("Login Message");
			a.setHeaderText("Login Wrong");
			a.show();
			break;
		case 2:
			Alert b = new Alert(AlertType.INFORMATION);
			b.setTitle("Login Message");
			b.setHeaderText("check Password again");
			b.show();
			break;
		default:
			break;
		}
	}


	protected void addLoginWindow() throws IOException
	{
		Parent logIn = FXMLLoader.load(Main.class.getResource("/application/Login.fxml"));
		loginStage = new Stage();
		loginStage.initModality(Modality.APPLICATION_MODAL);
		loginStage.initOwner(primaStage);
		Scene scene = new Scene(logIn);
		loginStage.setScene(scene);
		loginStage.showAndWait();
	}
}
