package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class ShowOrdersController extends UserController implements Initializable
{
	@FXML
	protected ListView<String> lV;
	protected ObservableList<String>lO;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{ 
		showOrdersView.setOrderView(lV,lO,UserManagement.currentUser.getOrederListString());
	}
}
