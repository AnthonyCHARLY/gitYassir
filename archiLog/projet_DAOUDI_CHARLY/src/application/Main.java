package application;
	
import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;

import application.core.Board;
import application.core.BoardItf;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application {
	
	
	private Group root = new Group();
	private Button buttonde;
	private Button buttonnotify;
	private Label tour;
	private Label descriptionp1;
	private Label descriptionp2;
	private Label victory;
	private int tourInt=1;
	
	@Override
    public void start(Stage primaryStage) {
		BoardItf board = Board.getInstance("yassir", "anthony");
		
		HashMap<Integer,Rectangle> mapRectangle = new HashMap<Integer,Rectangle>();
		

		Image imagePlayer1 = new Image("/smile.png",20,20,true,true);
		Image imagePlayer2 = new Image("/smileyas.png",20,20,true,true);
		 
		 
		ImageInput imageInput = new ImageInput();

	    //Setting the position of the image
		ImageView imgViewp1 = new ImageView(imagePlayer1);
		ImageView imgViewp2 = new ImageView(imagePlayer2);

		 
		 
		int indiceMap=0;
		int width,height=0;
		for( width=0; width<6; width++)
			for( height=0; height<6; height++){
				
		    	Rectangle rectangle = new Rectangle(60 + 60*width, 60+60*height, 60, 60);
		    	rectangle.setFill(Color.TRANSPARENT);
		    	rectangle.setStroke(Color.BLUE);
		      
		        rectangle.setArcHeight(20.0d);
		        rectangle.setArcWidth(20.0d);
		        // r.setOnMouseClicked(this);
		        
		        if((width== 0 ) && (height == 0 )) {

		    	 
		        	imgViewp1.setX(rectangle.getX()+30);
		        	imgViewp1.setY(rectangle.getY()+30);
		 	    
		        	imgViewp2.setX(rectangle.getX());
		        	imgViewp2.setY(rectangle.getY());
			    	  
			    	root.getChildren().addAll(rectangle,imgViewp1,imgViewp2);
			    	
		       }
		       
		       else if((width== 0 ) || (height == 0 )|| (height == 5 ) || (width == 5 )) {
		    	   
		    	   
		    	   //String type = board.getBoxes().get(indiceMap).getType();
		    	   //System.out.println(type);
		    	   // type = Neutral/Malus/Bonnus/Boss
		    	   root.getChildren().add(rectangle);
		    	   mapRectangle.put(indiceMap, rectangle);
		    	   indiceMap++;
		    	   
		      }
		     
		      
		    }
		
		buttonde= new Button();
		 buttonde.setText("Lancer le dé");
		 
		 
		 tour= new Label("Tour : 1");
		 tour.setTextFill(Color.BLACK);
		 tour.setLayoutX(500);
		 tour.setVisible(true);
		 
		 descriptionp1= new Label("Description " + board.getPlayer1().getName()+": \n Puissance \n " + board.getPlayer1().getArmy().strike()+" Point de vie "+board.getPlayer1().getArmy().getHealthPoints());
		 descriptionp1.setTextFill(Color.BLACK);
		 descriptionp1.setLayoutX(500);
		 descriptionp1.setLayoutY(100);
		 descriptionp1.setVisible(true);
		 
		 descriptionp2= new Label("Description " + board.getPlayer2().getName() +": \n Puissance \n" + board.getPlayer2().getArmy().strike()+" Point de vie "+board.getPlayer2().getArmy().getHealthPoints());
		 descriptionp2.setTextFill(Color.BLACK);
		 descriptionp2.setLayoutX(500);
		 descriptionp2.setLayoutY(200);
		 descriptionp2.setVisible(true);
		 
		 victory= new Label(" Victoire");
		 victory.setTextFill(Color.BLACK);
		 victory.setLayoutX(300);
		 victory.setVisible(false);
		 
		 root.getChildren().addAll(buttonde,tour,descriptionp1,descriptionp2,victory);
		
		 buttonde.setOnAction(new EventHandler<ActionEvent>() {
			 
	            @Override
	            public void handle(ActionEvent event) {
	               tour.setText("Tour : " + tourInt);
	               tourInt ++;
	               System.out.println("Tour : " + tourInt);
	               
	             
	            }
	        });
		
		Scene scenegraph = new Scene (root,750,500) ;
		 primaryStage.setScene (scenegraph) ;
		 primaryStage.setTitle ("Jeu de l'oie");
		 primaryStage.show ();
		
    }

    public static void main(String[] args) {
        launch(args);
    }
}
