package application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserView extends LoginView
{
	protected static Stage stageUser;
	static UserView userView=new UserView();

	protected void addUserWindow() throws IOException
	{
		Parent logIn = FXMLLoader.load(MainController.class.getResource("/application/User.fxml"));
		stageUser = new Stage();
		stageUser.initModality(Modality.APPLICATION_MODAL);
		stageUser.initOwner(loginStage);
		Scene scene = new Scene(logIn);
		stageUser.setScene(scene);
		stageUser.showAndWait();
	}

	public static UserView getUserView() {
		return userView;
	}

	protected String chooseMovieWindow(ArrayList<String>choices)
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Select Movie", choices);
		dialog.setTitle("Select Movie");
		dialog.setHeaderText("Select Movie");
		dialog.setContentText("Select Movie");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return null;
	}
	
	public String addFeedBackWindow() 
	{
	    TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText("FeedBack");
        dialog.setTitle("FeedBack");
        dialog.setGraphic(null);
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) 
        {
          return result.get();
        }
        return null;
	}
}
