package application;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class UserTutorialView extends UserView
{
	protected Stage UserTutorialStage;
	protected static UserTutorialView userTutorialView=new UserTutorialView();
	
	
	public static UserTutorialView getUserTutorialView() {
		return userTutorialView;
	}

	protected void addUserTutorialWindow() throws IOException
	{
		Parent tutorial = FXMLLoader.load(MainController.class.getResource("/application/UserTutorial.fxml"));
		UserTutorialStage = new Stage();
		UserTutorialStage.initModality(Modality.APPLICATION_MODAL);
		UserTutorialStage.initOwner(stageUser);
		Scene scene = new Scene(tutorial);
		UserTutorialStage.setScene(scene);
		UserTutorialStage.setTitle("Tutorial");
		UserTutorialStage.showAndWait();
	}
}
