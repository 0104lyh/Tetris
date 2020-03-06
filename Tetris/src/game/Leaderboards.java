package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Leaderboards extends Application{

//	private static Pane group = new Pane();
//	private static Scene scene = new Scene(group, 450,600);
	private static int i=0;
	public static List score() throws FileNotFoundException{
		ArrayList<User> List=new ArrayList<User>();
		ListIterator<User> it = List.listIterator();
		Scanner in = new Scanner(new File("score.txt"));//为myfile.txt这个File创建一个扫描器in
		while(in.hasNextLine()){//判断扫描器是否还有下一行未读取，该循环把文件的每一行都读出
			String line = in.nextLine();//读出myfile.txt的下一行
			Scanner linescanner = new Scanner(line);//对每一行的内容建立一个扫描器
			linescanner.useDelimiter(" ");//使用空格作为分隔符
			String name = linescanner.next();
			String str = linescanner.next();
			int score=Integer.parseInt(str); 
			User temp=new User(name,score);
			it.add(temp);
		}
		in.close();//读入完毕，最后需要对其进行close。
		//进行排序

		Collections.sort(List,new ScoreComparator());
		return List;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(grid, 450,600);
		// TODO Auto-generated method stub
		Image image = new Image("map.jpg");
		ImageView imageView = new ImageView(image);
		
//		Text scoretext = new Text("Score: ");
//		scoretext.setStyle("-fx-font: 20 arial;");
//		scoretext.setY(50);
//		scoretext.setX(300);
//		scoretext.setFill(Color.GREEN);
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
//		grid.add(scoretext, 0, 2);
		grid.add(returnButton, 0, 10);
		
		  //排行榜
  		List List=new ArrayList<User>();
  		List=score();
  		ListIterator<User> listIterator = List.listIterator();
  		int count=10;
  		int i=0;
  		String rankString = new String();
  		while(listIterator.hasNext())
  		{
  			i++;
  			User s =  listIterator.next();
  			rankString=rankString+i+".     "+s.getName()+" "+s.getScore()+"\n";
  			count=count+1;
  			
  			if(i==10)
  				break;
  		}
  		Text t = new Text(rankString);
		t.setStyle("-fx-font: 30 arial;");
		t.setFill(Color.BROWN);
		grid.add(t, 0, 2);
		primaryStage.setScene(scene);
		primaryStage.setTitle("俄罗斯方块");
		scene.getStylesheets().add(Leaderboards.class.getResource("Leaderboards.css").toExternalForm());
		primaryStage.show();
	}

}
