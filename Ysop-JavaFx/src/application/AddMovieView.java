package application;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddMovieView extends AdminView 
{
	protected Stage stageAddMovie;
	static AddMovieView addMovieView= new AddMovieView();

	public static AddMovieView getAddMovieView() 
	{
		return addMovieView;
	} 

	protected void addMovieWindow() throws IOException
	{
		Parent movie = FXMLLoader.load(MainController.class.getResource("/application/AddRemoveMovie.fxml"));
		stageAddMovie = new Stage();
		stageAddMovie.initModality(Modality.APPLICATION_MODAL);
		stageAddMovie.initOwner(stageAdmin);
		Scene scene = new Scene(movie);
		stageAddMovie.setScene(scene);
		stageAddMovie.showAndWait();
	}

	public boolean checkCombox(ComboBox<String> categoryTxt) 
	{

		return categoryTxt.getValue()!=null;
	}

	public void showMessage(String msg) 
	{
		Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Add Movie");
		a.setHeaderText(msg);
		a.show();

	}

	public int showAlertOverride() 
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Warning");
		alert.setContentText("The Movie is exist , do you want to Override?");
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

	public void additemComboBox(ComboBox<String> categoryTxt, ObservableList<String> listcombo1,
			ArrayList<String> categoryList)
	{
		listcombo1 = FXCollections.observableArrayList(categoryList);
		categoryTxt.setItems(listcombo1);

	}

	public void initCategoryCombo(ComboBox<String> category) 
	{

	}

	public void initCombos(TextField movieName, ComboBox<String> category, TextArea aboutMovieTxt)
	{
		movieName.setText("");
		category.getSelectionModel().clearSelection();
		aboutMovieTxt.setText("");	
	}

	public String showMovieDialog(ArrayList<String> choices) 
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>();
		dialog.getItems().addAll(choices);
		dialog.setTitle("Delete Movie");
		dialog.setHeaderText("Delete Movie");
		dialog.setContentText("Choose Movie to Delete ");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return "";
	}

	public String pickImage(String imageFile, ImageView imageView ) throws MalformedURLException 
	{
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Image File");
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("Image Files",
						"*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image files
		File selectedFile = fileChooser.showOpenDialog(stageAddMovie.getScene().getWindow());

		if (selectedFile != null) 
		{

			imageFile = selectedFile.toURI().toURL().toString();

			Image image = new Image(imageFile);
			imageView.setImage(image);
		} 
		return imageFile;
	}
}

