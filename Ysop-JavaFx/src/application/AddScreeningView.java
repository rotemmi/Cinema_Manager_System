package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddScreeningView extends AdminView
{
	protected Stage stageAddScreening;
	static AddScreeningView addScreeningView= new AddScreeningView();

	public static AddScreeningView getAddScreeningView() 
	{
		return addScreeningView;
	} 
	protected void addScreeningWindow() throws IOException
	{
		Parent Screen = FXMLLoader.load(MainController.class.getResource("/application/AddScreeningsLocalCinema.fxml"));
		stageAddScreening = new Stage();
		stageAddScreening.initModality(Modality.APPLICATION_MODAL);
		stageAddScreening.initOwner(stageAdmin);
		Scene scene = new Scene(Screen);
		stageAddScreening.setScene(scene);
		stageAddScreening.showAndWait();
	}
	protected String chooseCinemaWindow(ArrayList<String> choices) throws IOException
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>();
		dialog.getItems().addAll(choices);
		dialog.setTitle("Select Cinema");
		dialog.setHeaderText("Select Cinema");
		dialog.setContentText("Select Cinema");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();	
		}
		return "";
	}

	protected void showMessage(String msg)
	{
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Add Screening");
		a.setHeaderText(msg);
		a.show();
	}

	protected void addItemComboBoxTheater(ComboBox<Integer> comboBox1,ObservableList<Integer>listcombo,ArrayList<Integer>list)
	{

		listcombo = FXCollections.observableArrayList(list);
		comboBox1.promptTextProperty().setValue("");
		comboBox1.setItems(listcombo);

	}
	protected void addItemComboBox(ComboBox<String> comboBox1,ObservableList<String>listcombo,ArrayList<String>list)
	{

		listcombo = FXCollections.observableArrayList(list);
		comboBox1.promptTextProperty().setValue("");
		comboBox1.setItems(listcombo);

	}	

	public void initTextCombos(ComboBox<Integer> theaterid, ComboBox<String> movieName,ComboBox<String> date,Label l,String cinemaName) 
	{
		theaterid.getSelectionModel().clearSelection();
		movieName.getSelectionModel().clearSelection();
		date.getSelectionModel().clearSelection();
		l.setText("Current Cinema : "+cinemaName);
	}

	public boolean checkSelectedComboxes(ComboBox<String> movieName, ComboBox<String> date,
			ComboBox<Integer> theaterId) 
	{
		return movieName.getValue()!=null && date.getValue()!=null && theaterId.getValue()!=null;
	}

	public String showScreenDialog(ArrayList<String> choices) 
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Select Screening", choices);
		dialog.setTitle("Select Screening");
		dialog.setHeaderText("Select Screening");
		dialog.setContentText("Select Screening to Delete ");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return "";
	}
}
