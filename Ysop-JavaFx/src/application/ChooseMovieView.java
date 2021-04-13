package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChooseMovieView extends UserView 
{
	protected static Stage chooseMovieStage;
	protected static ChooseMovieView chooseMovieView =  new ChooseMovieView();
	
	public static ChooseMovieView getChooseMovieView()
	{
		return chooseMovieView;
	}

	public void addChooseMovieWindow() throws IOException 
	{
		Parent chooseMovie = FXMLLoader.load(MainController.class.getResource("/application/ChooseMovieTicket.fxml"));
		chooseMovieStage = new Stage();
		chooseMovieStage.initModality(Modality.APPLICATION_MODAL);
		chooseMovieStage.initOwner(stageUser);
		Scene scene = new Scene(chooseMovie);
		chooseMovieStage.setScene(scene);
		chooseMovieStage.showAndWait();
	}

	public void initCombo(ComboBox<String> combo, ObservableList<String> listO,
			ArrayList<String> listModel) 
	{
		listO = FXCollections.observableArrayList(listModel);
		combo.setItems(listO);
		
	}


	public boolean checkValidate(ComboBox<String> cinemaTxt) {
		return cinemaTxt.getValue()!=null;
	}
	
}
