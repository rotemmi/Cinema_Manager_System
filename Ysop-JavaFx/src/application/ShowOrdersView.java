package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowOrdersView extends UserView
{
	protected static Stage showOrdersStage;
	protected static ShowOrdersView showOrdersView=new ShowOrdersView();
	
	protected  void addshowOrdersViewWindow() throws IOException
	{
		Parent showOrders = FXMLLoader.load(MainController.class.getResource("/application/ShowOrders.fxml"));
		showOrdersStage = new Stage();
		showOrdersStage.initModality(Modality.APPLICATION_MODAL);
		showOrdersStage.initOwner(stageUser);
		Scene scene = new Scene(showOrders);
		showOrdersStage.setScene(scene);
		showOrdersStage.showAndWait();
	}

	public static ShowOrdersView getshowOrdersView() 
	{
		return showOrdersView;
	}

	public void setOrderView(ListView<String> lV, ObservableList<String> lO,
			ArrayList<String> orederListString) 
	{

		lO = FXCollections.observableArrayList(orederListString);
		lV.setItems(lO);
		
	}
}
