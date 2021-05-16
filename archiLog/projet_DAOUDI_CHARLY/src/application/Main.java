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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	
	
	private Group root = new Group();
	private Button buttonde;
	private Button buttondeplayer2;
	private Button buttonnotify;
	private Label tour;
	private Label descriptionp1;
	private Label descriptionp2;
	private Label victory;
	private int tourInt=1;
	private BoardItf board;
	private int indiceMap;
	private int newposition =1;
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
		
		createBoardGame(mapRectangle,imgViewp1,imgViewp2,board);
		boardUtil(board);
		boardEvent();
		
		forwardEvent(mapRectangle, imgViewp1, board );
		forwardEventp2(mapRectangle, imgViewp2, board );
		
		
		Scene scenegraph = new Scene (root,750,500) ;
		 primaryStage.setScene (scenegraph) ;
		 primaryStage.setTitle ("Jeu de l'oie");
		 primaryStage.show ();
		
    }

	public void createBoardGame(HashMap<Integer,Rectangle> mapRectangle,ImageView imgViewp1,ImageView imgViewp2,BoardItf board) {
		
		int indiceMap=0;
		int width,height=0;
		for( width=0; width<6; width++)
			for( height=0; height<6; height++){
				
		    	Rectangle rectangle = new Rectangle(60 + 60*width, 60+60*height, 60, 60);
		    	//rectangle.setFill(Color.TRANSPARENT);
		    	//rectangle.setStroke(Color.BLUE);
		      
		        rectangle.setArcHeight(20.0d);
		        rectangle.setArcWidth(20.0d);
		        // r.setOnMouseClicked(this);
		        
		        if((width== 0 ) && (height == 0 )) {

		    	 
		        	imgViewp1.setX(rectangle.getX()+30);
		        	imgViewp1.setY(rectangle.getY()+30);
		 	    
		        	imgViewp2.setX(rectangle.getX());
		        	imgViewp2.setY(rectangle.getY());
			    	
		        	rectangle.setFill(Color.TRANSPARENT);
			    	rectangle.setStroke(Color.BLUE);
			    	rectangle.setAccessibleRoleDescription("depart");
			    	root.getChildren().addAll(rectangle,imgViewp1,imgViewp2);
			    	board.getPlayer1().setPosition(indiceMap);
			    	board.getPlayer2().setPosition(indiceMap);
			    	indiceMap++;
		       }

		       
		       else if((width== 0 ) || (height == 0 )|| (height == 5 ) || (width == 5 )) {
		    	   
		    	   String type="Malus";
		    	   //String type = board.getBoxes().get(indiceMap).getType();
		    	   //System.out.println(type);
		    	   // type = Neutral/Malus/Bonnus/Boss
		    	   switch(type) {
		    	   		case "Neutral": rectangle.setFill(Color.TRANSPARENT);
		    	   			rectangle.setStroke(Color.BLUE);
		    	   			rectangle.setAccessibleRoleDescription("Neutral");
		    	   			break;
		    	   		case "Malus": rectangle.setFill(Color.TRANSPARENT);
	    	   				rectangle.setStroke(Color.RED);
	    	   				rectangle.setAccessibleRoleDescription("Malus");
	    	   				break;
		    	   		case "Bonus": rectangle.setFill(Color.TRANSPARENT);
	    	   				rectangle.setStroke(Color.GREEN);
	    	   				rectangle.setAccessibleRoleDescription("Bonus");
	    	   				break;
		    	   		case "Boss": rectangle.setFill(Color.TRANSPARENT);
	    	   				rectangle.setStroke(Color.YELLOW);
	    	   				rectangle.setAccessibleRoleDescription("Boss");
	    	   				break;
		    	   		
		    	   }
		    	   root.getChildren().add(rectangle);
		    	   mapRectangle.put(indiceMap, rectangle);
		    	   indiceMap++;
		    	   	
		    	}
		    	   
		    	   

		      }
		     	      
	}
	
	public void boardUtil(BoardItf board) {
		 buttonde= new Button();
		 buttonde.setText("Lancer le dé "  + board.getPlayer1().getName());
		 
		 buttondeplayer2= new Button();
		 buttondeplayer2.setText("Lancer le dé " + board.getPlayer2().getName());
		 buttondeplayer2.setLayoutX(300);
		 buttondeplayer2.setDisable(true);
		 
		 
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
		 
		 root.getChildren().addAll(buttonde,buttondeplayer2,tour,descriptionp1,descriptionp2,victory);
		
		
	}
	public void boardEvent() {
		 buttonde.setOnAction(new EventHandler<ActionEvent>() {
			 
	            @Override
	            public void handle(ActionEvent event) {
	               tour.setText("Tour : " + tourInt);
	               tourInt ++;
	               System.out.println("Tour : " + tourInt);
	               
	             
	            }
	        });
	}
	
	public void forwardEvent(HashMap<Integer,Rectangle> mapRectangle,ImageView imgViewp1,BoardItf board ) {
		buttonde.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	
            	for (HashMap.Entry<Integer,Rectangle> entry : mapRectangle.entrySet()) {
        		    if(entry.getKey()==newposition) {
        		    	imgViewp1.setX(entry.getValue().getX()+30);
        	        	imgViewp1.setY(entry.getValue().getY()+30);
        	        	board.getPlayer1().setPosition(newposition);
        	        	System.out.println(entry.getValue().getAccessibleRoleDescription());
        	        	switch(entry.getValue().getAccessibleRoleDescription()) {
        	        		case "Malus": malusMessageEvent();
        	        					  break;
        	        		case "Neutral":
        	        					   break;
        	        		case "Bonus": bonusMessageEvent();
        	        					  break;
        	        		case "Boss":  bossMessageEvent();
        	        					  break;
        	        	}
        	        	
        		    }
        		}
            	newposition ++;
            	buttondeplayer2.setDisable(false);
	            buttonde.setDisable(true);
            }
        });
		
		
	}
	
	public void forwardEventp2(HashMap<Integer,Rectangle> mapRectangle,ImageView imgViewp1,BoardItf board ) {
		buttondeplayer2.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	
            	for (HashMap.Entry<Integer,Rectangle> entry : mapRectangle.entrySet()) {
        		    if(entry.getKey()==newposition) {
        		    	imgViewp1.setX(entry.getValue().getX()+2);
        	        	imgViewp1.setY(entry.getValue().getY()+2);
        	        	board.getPlayer2().setPosition(newposition);
        	        	System.out.println(entry.getValue().getAccessibleRoleDescription());
        	        	switch(entry.getValue().getAccessibleRoleDescription()) {
        	        		case "Malus": malusMessageEvent();
        	        					  break;
        	        		case "Neutral":
        	        					   break;
        	        		case "Bonus": bonusMessageEvent();
        	        					  break;
        	        		case "Boss":  bossMessageEvent();
        	        					  break;
        	        	}
        	        	
        		    }
        		}
            	newposition ++;
            	tourInt ++;
            	tour.setText("Tour : " + tourInt);
	            buttondeplayer2.setDisable(true);
	            buttonde.setDisable(false);
	            
            }
        });
		
	}
	
	public void malusMessageEvent() {
		        Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Malus");
		        alert.setHeaderText("");
		        alert.setContentText("mettre la description du malus");
		        alert.showAndWait();    
	}
	
	public void bonusMessageEvent() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Malus");
        alert.setHeaderText("");
        alert.setContentText("mettre la description du bonus");
        alert.showAndWait();    
	}
	
	public void bossMessageEvent() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Malus");
        alert.setHeaderText("");
        alert.setContentText("mettre la description du boss!");
        alert.showAndWait();    
	}
    public static void main(String[] args) {
        launch(args);
    }
}
