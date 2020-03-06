package game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Help extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	    Image returnImage = new Image("return.png");
	    ImageView returnImageView = new ImageView(returnImage);
	    
	    Button returnButton = new Button();
	    returnButton.setGraphic(returnImageView);
	    returnButton.setOnAction(e->{
			Main mainMenu=new Main();
			try
			{
				mainMenu.start(new Stage());
				primaryStage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
	    DropShadow shadow = new DropShadow();
		//当鼠标移动到Button上时，增加一个阴影效果
		returnButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		    returnButton.setEffect(shadow);
		});
		 
		//当鼠标离开Button时，移除阴影效果
		returnButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		    returnButton.setEffect(null);
		});
	    grid.add(returnButton, 0, 50);
	    Scene scene=new Scene(grid,450,600);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("俄罗斯方块");
		scene.getStylesheets().add(Main.class.getResource("Help.css").toExternalForm());

	    primaryStage.show();
		
	}

}
