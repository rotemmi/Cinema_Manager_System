package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class SearchMovieByCategoryController extends UserController implements Initializable
{
	@FXML
	ComboBox<String> categoryCmbx;
	ObservableList<String>listCat;

	@FXML
	ComboBox<String> movieCmbx;
	ObservableList<String>listMo;

	@FXML
	TextArea abouMovieTxt;

	@FXML
	ListView<String>feedLv;
	ObservableList<String>listF;

	@FXML
	ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		init();

	}

	public void init()
	{
		SearchMovieByCategoryView.initDetails(categoryCmbx,cinemaManager.getCategoryList(),listCat,imageView,abouMovieTxt);
	}

	@FXML
	public void categoryChoosed(ActionEvent e)  
	{
		SearchMovieByCategoryView.initMoviesList(movieCmbx,cinemaManager.getMovieListByCategory(categoryCmbx.getValue()),listMo);
	}

	@FXML
	public void detailsPressed(ActionEvent e)  
	{
		if(SearchMovieByCategoryView.checkValidateCombos(movieCmbx,categoryCmbx))
			SearchMovieByCategoryView.showDetails(cinemaManager.getMovieByName(movieCmbx.getValue()).getAboutMovie(),abouMovieTxt,cinemaManager.getMovieByName(movieCmbx.getValue()).getFeedbackList(),feedLv,listF,cinemaManager.getMovieByName(movieCmbx.getValue()).getImage(),imageView);
	}
}
