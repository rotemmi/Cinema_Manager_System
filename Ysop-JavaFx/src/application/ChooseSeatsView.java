package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChooseSeatsView extends ChooseMovieView
{
	protected static Stage chooseSeatsStage ;
	protected static Button [] [] buttonArray;
	protected static  GridPane grid ;
	protected static int choosedButton ;
	protected static ChooseSeatsView chooseSeatsView=  new ChooseSeatsView();
	protected static Button buyTicket;
	
	public static ChooseSeatsView getChooseSeatsView()
	{
		return chooseSeatsView;
	}

	public static void addChooseSeatsWindow(int rows,int cols, ArrayList<Seat>s) throws IOException 
	{
		int index=0;
		chooseSeatsStage = new Stage();
		chooseSeatsStage.setHeight(1040);
		chooseSeatsStage.setWidth(800);
		 grid = new GridPane();
		 buttonArray = new Button[rows][cols];
		for (int row = 0 ; row <= rows ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col <= cols; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }
        
    	for (int i = 0 ; i < rows ; i++) 
		{
			for(int j=0; j < cols;j++)
			{

				Button button = createButton(i+1,j+1,s.get(index++).isAvailable());
				
				ChooseSeatsView.grid.add(button,j,i);
			}
		}
    	buyTicket = new Button("Buy Ticket");
    	buyTicket.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event)
			{
				ChooseSeatsController.saveButton();
			}
		});
		ChooseSeatsView.grid.add(buyTicket,cols,rows);

        
		chooseSeatsStage.initModality(Modality.APPLICATION_MODAL);
		chooseSeatsStage.initOwner(chooseMovieStage);
		Scene scene = new Scene(grid);
		chooseSeatsStage.setScene(scene);
	    chooseSeatsStage.show();
	}
	
	
	
    public static Button createButton(int i ,int j,boolean isAvilable) 
    {
    	if(!isAvilable)
    	{
    		buttonArray[i-1][j-1]  = new Button("Saved");
    		buttonArray[i-1][j-1].setDisable(true);
    	}
    	else
    	buttonArray[i-1][j-1]  = new Button("[" + Integer.toString(i) +","+Integer.toString(j)+"]");
    	buttonArray[i-1][j-1].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    	buttonArray[i-1][j-1].setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) 
			{
				if(buttonArray[i-1][j-1].getText().contains("["))
				{
					choosedButton++;
					buttonArray[i-1][j-1].setText("Choose");
				}
				else if (buttonArray[i-1][j-1].getText().equals("Choose"))
				{
					buttonArray[i-1][j-1].setText("[" + Integer.toString(i) +","+Integer.toString(j)+"]");
					choosedButton --;
				}
			}
		});
        return buttonArray[i-1][j-1] ;
    }
    
    public static void showAlert(boolean flag)
    {
    	Alert a = new Alert(AlertType.INFORMATION);
		a.setTitle("Buy Ticket");
		if(flag)
		{
		a.setHeaderText("Ticket Bought Successfully");
		}
		else
			a.setHeaderText("Never Mind Thank You");
		
		a.show();
		chooseSeatsStage.close();
    }
}
