package application;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AddMovieController implements Initializable
{
	private AddMovieView addMovieView=AddMovieView.getAddMovieView();
	private CinemaManager cinemaManagerModel = CinemaManager.getCinemaManager();
	@FXML
	private TextField movieNameTxt;
	@FXML
	private ComboBox<String> CategoryTxt;
	private ObservableList<String>listcombo1;
	@FXML
	private TextArea aboutMovieTxt;
	
	@FXML
	private ImageView imageView;
  
    private String imageFile;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		init();
		
		
	}
	
	public void init()
	{
		addMovieView.initCombos(movieNameTxt,CategoryTxt,aboutMovieTxt);
		addMovieView.additemComboBox(CategoryTxt, listcombo1,cinemaManagerModel.categoryList);
		imageFile= null;
		imageView.setImage(null);
	}
	
	
	
	@FXML
	public void addMoviePressed(ActionEvent e) 
	{
		if(addMovieView.checkCombox(CategoryTxt))
		{
			switch(cinemaManagerModel.addMovie(movieNameTxt.getText(),CategoryTxt.getValue(),aboutMovieTxt.getText(),imageFile))
			{
			case 1: addMovieView.showMessage("Movie added Successfully");
					init();
					break;
			case-1:  addMovieView.showMessage("Please Enter Details");
					break;
			case 0 : 
					int choose = addMovieView.showAlertOverride();
					if(choose==1)
					{
						cinemaManagerModel.setCurrentMovieName(movieNameTxt.getText());
						cinemaManagerModel.overrideMovie(cinemaManagerModel.currentMovie,CategoryTxt.getValue(),aboutMovieTxt.getText(),imageFile);
						init();
					}
			break;
			default:
				break;
			}
		}
		else
		{
			addMovieView.showMessage("please enter Details");
		}
	}

	@FXML
	public void deleteMoviePressed(ActionEvent e) 
	{
		String deleteChoose = addMovieView.showMovieDialog(cinemaManagerModel.getMovieNameList());
		cinemaManagerModel.deleteMovie(deleteChoose);
	}
	
    public void pickImage (ActionEvent actionEvent) throws MalformedURLException 
    {
    	imageFile = addMovieView.pickImage(imageFile,imageView);
    }

	

}
