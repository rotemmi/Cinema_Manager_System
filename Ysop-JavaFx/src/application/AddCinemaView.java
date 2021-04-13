package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddCinemaView extends AdminView
{
	protected Stage stageAddCinema;
	static AddCinemaView addCinemaView= new AddCinemaView();

	public static AddCinemaView getAddCinemaView() 
	{
		return addCinemaView;
	} 

	protected void addCinemaWindow() throws IOException
	{
		Parent cinema = FXMLLoader.load(MainController.class.getResource("/application/AddRemoveCinema.fxml"));
		stageAddCinema = new Stage();
		stageAddCinema.initModality(Modality.APPLICATION_MODAL);
		stageAddCinema.initOwner(stageAdmin);
		Scene scene = new Scene(cinema);
		stageAddCinema.setScene(scene);
		stageAddCinema.showAndWait();

	}

	protected void showMessage(String msg)
	{
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Add Cinema Message");
		a.setHeaderText(msg);
		a.show();
	}

	protected String deleteCinemaPress(ArrayList<String>choices)
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Select Cinema Name", choices);
		dialog.setTitle("Delete Cinema");
		dialog.setHeaderText("Delete Cinema");
		dialog.setContentText("Choose Cinema to Delete ");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return "";
	}
	
	
	public Integer showAlertOverride() 
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Warning");
		alert.setContentText("The cinema is exist , do you want to Override?");
		ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonData.NO);
		alert.getButtonTypes().setAll(okButton, noButton);
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.isPresent()) 
		{
		    if(result.get().getButtonData() == ButtonData.YES)
		    {
		    	return 1;
		    }
		    return 0;
		}
		return -1;
		
	}

}
