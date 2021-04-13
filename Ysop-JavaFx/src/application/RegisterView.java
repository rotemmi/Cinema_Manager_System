package application;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegisterView extends Main 
{
	static Stage registerStage;
	static RegisterView registerView = new RegisterView(); 

	protected static RegisterView getRegisterView() 
	{
		return registerView;
	}

	protected void addRegisterWindow() throws IOException
	{
		Parent register = FXMLLoader.load(Main.class.getResource("/application/Register.fxml"));
		registerStage = new Stage();
		registerStage.initModality(Modality.APPLICATION_MODAL);
		registerStage.initOwner(primaStage);
		Scene scene = new Scene(register);
		registerStage.setScene(scene);
		registerStage.showAndWait();
	}

	protected void showMessage(String msg)
	{
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Sign Up Message");
		a.setHeaderText(msg);
		a.show();
	}

}
