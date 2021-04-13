package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdminView extends LoginView
{
	protected Stage stageAdmin;
	static AdminView adminView= new AdminView();


	public static AdminView getAdminView() 
	{
		return adminView;
	}


	protected void addAdminWindow() throws IOException
	{
		Parent logIn = FXMLLoader.load(MainController.class.getResource("/application/Admin.fxml"));
		stageAdmin = new Stage();
		stageAdmin.initModality(Modality.APPLICATION_MODAL);
		stageAdmin.initOwner(loginStage);
		Scene scene = new Scene(logIn);
		stageAdmin.setScene(scene);
		stageAdmin.showAndWait();

	}
	protected String deleteUserPress(ArrayList<String>choices)
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Select User Name", choices);
		dialog.setTitle("Delete User Name");
		dialog.setHeaderText("Delete User Name");
		dialog.setContentText("Choose User to Delete ");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return "";
	}


}
