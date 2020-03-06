package game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
//		launch(Tetris.class,args);
		launch(args);
	}


	@Override
	public void start(Stage stage) throws Exception
	{
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
//		Image cover = new Image("cover.jpg");
//		ImageView coverImageView = new ImageView();
//		coverImageView.setImage(cover);

		Image btImage = new Image("button.png");
		ImageView btImageView = new ImageView();
		btImageView.setImage(btImage);
		Button button=new Button();
//		button.setLayoutX(225);
//		button.setLayoutY(100);
		
	
		button.setGraphic(btImageView);
		button.setPadding(Insets.EMPTY);
//		button.setCursor(Cursor.HAND);
		button.getStyleClass().add("button");
		button.setOnAction(e->{
			Tetris open=new Tetris();
			try
			{
				open.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});

		DropShadow shadow = new DropShadow();
		//当鼠标移动到Button上时，增加一个阴影效果
		button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		    button.setEffect(shadow);
		});
		 
		//当鼠标离开Button时，移除阴影效果
		button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		    button.setEffect(null);
		});
		grid.add(button, 0, 4);
		Button rankButton = new Button();
		Image rankImage = new Image("rank.png");
		ImageView rankImageView = new ImageView(rankImage);
		rankButton.setGraphic(rankImageView);
		rankButton.setOnAction(e->{
			Leaderboards rankboards=new Leaderboards();
			try
			{
				rankboards.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});

		//当鼠标移动到Button上时，增加一个阴影效果
		rankButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			rankButton.setEffect(shadow);
		});
		 
		//当鼠标离开Button时，移除阴影效果
		rankButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			rankButton.setEffect(null);
		});
		
		grid.add(rankButton, 0, 8);
		
		Button helpButton = new Button();
		Image helpImage = new Image("help.png");
		ImageView helpImageView = new ImageView(helpImage);
		helpButton.setGraphic(helpImageView);

		//当鼠标移动到Button上时，增加一个阴影效果
		helpButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			helpButton.setEffect(shadow);
		});
		 
		//当鼠标离开Button时，移除阴影效果
		helpButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			helpButton.setEffect(null);
		});
		helpButton.setOnAction(e->{
			Help helpPage=new Help();
			try
			{
				helpPage.start(new Stage());
				stage.hide(); 
			} 
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
		});
		grid.add(helpButton, 0, 9);

//	    notification.clear();
//	    grid.add(notification, 0, 5);
	    
//		pane.getChildren().add(coverImageView);
//		pane.getChildren().add(button);
//		pane.getChildren().add(notification);
//		grid.getChildren().add(button);
	    
		Scene scene=new Scene(grid,450,600);
		//使用css文件
		scene.getStylesheets().add(Main.class.getResource("MainCss.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("俄罗斯方块");
		
		stage.show();
		
	}
 

}
