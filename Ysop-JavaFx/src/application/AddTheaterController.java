package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class AddTheaterController extends  AddCinemaController implements Initializable
{
	private AddTheaterView addTheaterView = AddTheaterView.getAddTheaterView();
	private CinemaManager cinemaManagerModel = CinemaManager.getCinemaManager();
	@FXML
	private ComboBox<Integer>chooseTheaterC;
	ObservableList<Integer>listcombo1;
	ObservableList<Integer>listcombo2;
	@FXML
	private ComboBox<Integer>numOfRows;
	@FXML
	private ComboBox<Integer>numOfCols;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{ 
		init();
	}
	public void init()
	{
		addTheaterView.initTextCombos(chooseTheaterC,numOfCols,numOfRows);
		addTheaterView.addItemComboBox(chooseTheaterC, listcombo1,cinemaManagerModel.currentCinema.getTheaterGenerateList());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=10;i++)
		{
			list.add(i);
		}
		addTheaterView.addItemComboBox(numOfRows,listcombo1,list);
		addTheaterView.addItemComboBox(numOfCols,listcombo2,list);
	}

	@FXML
	public void chooseRows(ActionEvent e) 
	{
		addTheaterView.chooseRows(numOfRows,numOfCols);
	
	}
	
	@FXML
	public void addTheaterPressed(ActionEvent e) 
	{
		if(addTheaterView.checkSelectedComboxes(chooseTheaterC,numOfRows,numOfCols))
		{
			cinemaManagerModel.currentCinema.setTheater(chooseTheaterC.getValue(),numOfRows.getValue(),numOfCols.getValue());		
			addTheaterView.showMessage("Theater added Successfully");
			init();
		}
		else
		{
			addTheaterView.showMessage("please enter Details");
		}
	}
	
	@FXML
	public void deleteTheaterPressed(ActionEvent e) 
	{
		int deleteChoose = addTheaterView.showTheaterDialog(cinemaManagerModel.currentCinema.getTheaterListId());
		cinemaManagerModel.currentCinema.deleteTheater(deleteChoose);	
		init();
	}
	
	
	
	
	
	
	
}
