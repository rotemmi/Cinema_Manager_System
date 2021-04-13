package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application
{
	protected Stage primaStage;
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primarystage) throws Exception 
	{
		primaStage = primarystage;
		Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
		Scene scene = new Scene(root);
		primaStage.setScene(scene);
		primaStage.show();
		primaStage.setTitle("Cinema Managment");
	}
}
