package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SearchMovieByCategoryView extends UserView 
{
	protected Stage SearchMovieByCategoryStage;
	static SearchMovieByCategoryView searchMovieByCategoryView = new SearchMovieByCategoryView();

	public static SearchMovieByCategoryView getSearchMovieByCategoryView() 
	{
		return searchMovieByCategoryView;
	}

	public void SearchMovieByCategoryWindow() throws IOException 
	{	
		Parent search = FXMLLoader.load(MainController.class.getResource("/application/SearchMovieByCategory.fxml"));
		SearchMovieByCategoryStage = new Stage();
		SearchMovieByCategoryStage.initModality(Modality.APPLICATION_MODAL);
		SearchMovieByCategoryStage.initOwner(stageUser);
		Scene scene = new Scene(search);
		SearchMovieByCategoryStage.setScene(scene);
		SearchMovieByCategoryStage.showAndWait();
	}

	public static void initDetails(ComboBox<String> categoryCmbx, ArrayList<String> categoryList,
			ObservableList<String> listCat, ImageView imageView,
			TextArea abouMovieTxt) 
	{

		listCat = FXCollections.observableArrayList(categoryList);
		categoryCmbx.promptTextProperty().setValue("");
		categoryCmbx.setItems(listCat);
		
		listCat = FXCollections.observableArrayList(categoryList);
		categoryCmbx.promptTextProperty().setValue("");
		categoryCmbx.setItems(listCat);
		imageView.setImage(null);
		abouMovieTxt.setText("");
			
	}

	public static void initMoviesList(ComboBox<String> movieCmbx, ArrayList<String> movieListByCategory, ObservableList<String> listMo)
	{
		listMo = FXCollections.observableArrayList(movieListByCategory);
		movieCmbx.promptTextProperty().setValue("");
		movieCmbx.setItems(listMo);
		
	}

	public static void showDetails(String aboutMovie, TextArea abouMovieTxt, ArrayList<String> feedbackList,
			ListView<String> feedLv, ObservableList<String> listF, String imageFile, ImageView imageView) 
	{
		abouMovieTxt.setText(aboutMovie);
		listF = FXCollections.observableArrayList(feedbackList);
		feedLv.setItems(listF);
		if(imageFile!=null)
		{
			Image image = new Image(imageFile);
			imageView.setImage(image);
		}
		else
		{
			imageView.setImage(null);
		}
	}

	public static boolean checkValidateCombos(ComboBox<String> movieCmbx, ComboBox<String> categoryCmbx) 
	{
		return movieCmbx.getValue()!=null && categoryCmbx.getValue()!=null;
	}
}
