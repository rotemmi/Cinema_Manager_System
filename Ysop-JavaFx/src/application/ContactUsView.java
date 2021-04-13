package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContactUsView extends UserView
{
	protected Stage ContactUsViewStage;
	protected static ContactUsView contactUsView= new ContactUsView();

	public static ContactUsView getContactUsView() 
	{
		return contactUsView;
	}

	protected void addContactUsViewWindow() throws IOException
	{
		Parent contact = FXMLLoader.load(MainController.class.getResource("/application/ContactUs.fxml"));
		ContactUsViewStage = new Stage();
		ContactUsViewStage.initModality(Modality.APPLICATION_MODAL);
		ContactUsViewStage.initOwner(stageUser);
		Scene scene = new Scene(contact);
		ContactUsViewStage.setScene(scene);
		ContactUsViewStage.showAndWait();
	}

	protected String showCinemaNameList(ArrayList<String>choices)
	{
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Choose Cinema", choices);
		dialog.setTitle("Choose Cinema");
		dialog.setHeaderText("Choose Cinema for Contact");
		dialog.setContentText("Choose Cinema for Contact ");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent())
		{
			return result.get();
		}
		return null;
	}
	protected void initLabelContact(Label l1,Label l2,Label l3, String choose, String address, String phoneNumber)
	{
		l1.setText("Cinema Name: "+choose);
		l2.setText("Address: "+address);
		l3.setText("Phone Number: "+phoneNumber);
	}

}
