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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddTheaterView  extends AddCinemaView
{
	protected Stage stageAddTheater;
	static AddTheaterView addTheaterView= new AddTheaterView();



	public static AddTheaterView getAddTheaterView() 
	{
		return addTheaterView;
	}


	protected void addTheaterWindow() throws IOException
	{
		Parent logIn = FXMLLoader.load(MainController.class.getResource("/application/AddTheaters.fxml"));
		stageAddTheater = new Stage();
		stageAddTheater.initModality(Modality.APPLICATION_MODAL);
		stageAddTheater.initOwner(stageAddCinema);
		Scene scene = new Scene(logIn);
		stageAddTheater.setScene(scene);
		stageAddTheater.showAndWait();

	}

	protected void addItemComboBox(ComboBox<Integer> comboBox1,ObservableList<Integer>listcombo,ArrayList<Integer>list)
	{

		listcombo = FXCollections.observableArrayList(list);
		comboBox1.promptTextProperty().setValue("");
		comboBox1.setItems(listcombo);
		
	}	

	protected void chooseRows(ComboBox<Integer> comboBox1,ComboBox<Integer> comboBox2)
	{
		comboBox2.setValue(comboBox1.getValue());	
	}


	public boolean checkSelectedComboxes(ComboBox<Integer> chooseTheaterC, ComboBox<Integer> numOfRows,
			ComboBox<Integer> numOfCols) 
	{
		return chooseTheaterC.getValue()!=null && numOfRows.getValue()!=null && numOfCols.getValue()!=null;
	}
	
	protected int showTheaterDialog(ArrayList<Integer>choices)
	{
		ChoiceDialog<Integer> dialog = new ChoiceDialog<>();
		dialog.getItems().addAll(choices);
		dialog.setTitle("Delete Theater");
		dialog.setHeaderText("Delete Theater");
		dialog.setContentText("Choose Theater to Delete ");
		Optional<Integer> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return -1;
	}
	
	
	
	protected void showMessage(String msg)
	{
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Add Theater");
		a.setHeaderText(msg);
		a.show();
	}


	public void initTextCombos(ComboBox<Integer> chooseTheaterC, ComboBox<Integer> numOfCols,ComboBox<Integer> numOfRows) 
	{
		chooseTheaterC.getSelectionModel().clearSelection();
		numOfRows.getSelectionModel().clearSelection();
		numOfCols.getSelectionModel().clearSelection();
	}

}


