package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class UserTutorialConroller implements Initializable
{
	@FXML
	private MediaView mV;
	@FXML
	private MediaPlayer mp;
	@FXML
	private Media tutorial;
	@FXML
	private Slider volume;
	public static boolean isUser=true;


	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		String path;
		if(!isUser) 
		{

			path  = new File("src/Media/tutAdmin.mp4").getAbsolutePath();
		}
		else
			path  = new File("src/Media/tutUser.mp4").getAbsolutePath();
		tutorial = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(tutorial);
		mV.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width  = mV.fitWidthProperty();
		DoubleProperty height  = mV.fitHeightProperty();
		width.bind(Bindings.selectDouble(mV.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mV.sceneProperty(), "height"));	
		volume.setValue(mp.getVolume()*100);
		volume.valueProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) 
			{
				mp.setVolume(volume.getValue()/100);
			}
		});
	}

	public void play(ActionEvent e)
	{
		mp.play();
		mp.setRate(1);
	}

	public void pause (ActionEvent e)
	{
		mp.pause();
	}
	public void fast (ActionEvent e)
	{
		mp.setRate(2);
	}
	public void slow (ActionEvent e)
	{
		mp.setRate(0.5);
	}
	public void reload (ActionEvent e)
	{
		mp.seek(mp.getStartTime());
		mp.play();
	}
	public void start (ActionEvent e)
	{
		mp.seek(mp.getStartTime());
		mp.stop();
	}
	public void last (ActionEvent e)
	{
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}
}
