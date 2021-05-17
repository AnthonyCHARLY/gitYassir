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
import java.util.Set;

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
	private Label tour;
	private Label descriptionp1;
	private Label descriptionp2;
	private Label victory;
	private int tourInt=1;
	private ImageView imgViewp1;
	private ImageView imgViewp2;
	@Override
    public void start(Stage primaryStage) {
		
		
		BoardItf board = Board.getInstance("Yassir","Anthony" );
		
		HashMap<Integer,Rectangle> mapRectangle = new HashMap<Integer,Rectangle>();
		

		Image imagePlayer1 = new Image("/smile.png",20,20,true,true);
		Image imagePlayer2 = new Image("/smileyas.png",20,20,true,true);
		 
		 
		ImageInput imageInput = new ImageInput();

	    //Setting the position of the image
		imgViewp1 = new ImageView(imagePlayer1);
		imgViewp2 = new ImageView(imagePlayer2);
		
		createBoardGame(mapRectangle,imgViewp1,imgViewp2,board);
		boardUtil(board);
		boardEvent();
		
		forwardEventp1(mapRectangle, board );
		
		
		Scene scenegraph = new Scene (root,750,500) ;
		
		
		Button buttonscenelogin =new Button(" Commencer ");
		buttonscenelogin.setLayoutY(200);
		buttonscenelogin.setLayoutX(300);
		buttonscenelogin.setOnAction(e ->{ primaryStage.setScene (scenegraph);  });
		Group layoutlogin = new Group();
		layoutlogin.getChildren().add(buttonscenelogin);
		
		Scene scenelogin= new Scene (layoutlogin,750,500);
		
		 primaryStage.setScene (scenelogin) ;
		 primaryStage.setTitle ("Jeu de l'oie");
		 primaryStage.show ();
		
    }

	public void createBoardGame(HashMap<Integer,Rectangle> mapRectangle,ImageView imgViewp1,ImageView imgViewp2,BoardItf board) {
		
		int indiceMap=0;
		int width = 0 ;
		int height = 0;
		for( int it=0; it<4; it++)
			for( int it2=0; it2<5; it2++){
				
				Rectangle rectangle = new Rectangle(60 + 60*width, 60 + 60*height, 55, 55);
		        rectangle.setArcHeight(30.0d);
		        rectangle.setArcWidth(30.0d);

		        	
		        	String type= board.getBoxes().get(-1).getType();
		        	
		    	   if(board.getBoxes().containsKey(indiceMap))
		    		   type = board.getBoxes().get(indiceMap).getType();
		    	   switch(type) {
		    	   		case "Neutral": rectangle.setFill(Color.TRANSPARENT);
		    	   			rectangle.setStroke(Color.BLUE);
		    	   			rectangle.setAccessibleRoleDescription("Neutral");
		    	   			break;
		    	   		case "Malus": rectangle.setFill(Color.TRANSPARENT);
	    	   				rectangle.setStroke(Color.RED);
	    	   				rectangle.setAccessibleRoleDescription("Malus");
	    	   				break;
		    	   		case "Save": rectangle.setFill(Color.TRANSPARENT);
    	   					rectangle.setStroke(Color.CHOCOLATE);
    	   					rectangle.setAccessibleRoleDescription("Save");
    	   					break;
		    	   		case "Bonus": rectangle.setFill(Color.TRANSPARENT);
	    	   				rectangle.setStroke(Color.GREEN);
	    	   				rectangle.setAccessibleRoleDescription("Bonus");
	    	   				break;
		    	   		case "Boss": rectangle.setFill(Color.TRANSPARENT);
	    	   				rectangle.setStroke(Color.BLACK);
	    	   				rectangle.setAccessibleRoleDescription("Boss");
	    	   				break;
		    	   			
		    	   		
		    	   }
				
		        if(indiceMap == 0) {

		        	imgViewp1.setX(rectangle.getX()+30);
		        	imgViewp1.setY(rectangle.getY()+30);
		 	    
		        	imgViewp2.setX(rectangle.getX());
		        	imgViewp2.setY(rectangle.getY());
			    	
			    	root.getChildren().addAll(rectangle,imgViewp1,imgViewp2);
		        }
		        else
		        	root.getChildren().add(rectangle);
		        mapRectangle.put(indiceMap, rectangle);
		        indiceMap++;
		    	
		        if(it == 0)
					height++;
				else if(it == 1)
					width++;
				else if(it == 2)
					height--;
				else if(it == 3)
					width--;

		      }
		     	      
	}
	
	public void boardUtil(BoardItf board) {
		 buttonde= new Button();
		 buttonde.setLayoutY(20);
		 buttonde.setText("Lancer le de ");
		 
		 
		 
		 tour= new Label("Tour : 1");
		 tour.setTextFill(Color.BLACK);
		 tour.setLayoutX(500);
		 tour.setVisible(true);
		 
		 descriptionp1= new Label("Description " + board.getPlayer1().getName()+": \n Puissance  " + board.getPlayer1().getArmy().strike()+"\n Point de vie "+board.getPlayer1().getArmy().getHealthPoints());
		 descriptionp1.setTextFill(Color.BLACK);
		 descriptionp1.setLayoutX(500);
		 descriptionp1.setLayoutY(100);
		 descriptionp1.setVisible(true);
		 
		 descriptionp2= new Label("Description " + board.getPlayer2().getName() +": \n Puissance " + board.getPlayer2().getArmy().strike()+" \n Point de vie "+board.getPlayer2().getArmy().getHealthPoints());
		 descriptionp2.setTextFill(Color.BLACK);
		 descriptionp2.setLayoutX(500);
		 descriptionp2.setLayoutY(200);
		 descriptionp2.setVisible(true);
		 
		 victory= new Label(" Victoire");
		 victory.setTextFill(Color.BLACK);
		 victory.setLayoutX(300);
		 victory.setVisible(false);
		 
		 root.getChildren().addAll(buttonde,tour,descriptionp1,descriptionp2,victory);
		
		
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
	
	public void forwardEventp1(HashMap<Integer,Rectangle> mapRectangle,BoardItf board ) {
		buttonde.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
            	
            	board.turn();
            	

            	actualizeSprits(mapRectangle,board);
            	
            	Alert alert = new Alert(AlertType.INFORMATION);
            	if( board.getBoxes().containsKey( board.getCurrentPlayer().getPosition() ) ) {
            		alert.setTitle(board.getBoxes().get(board.getCurrentPlayer().getPosition()).getType());
            		alert.setHeaderText("");
            		alert.setContentText(board.getBoxes().get(board.getCurrentPlayer().getPosition()).description());
            		alert.showAndWait();
            	}
            	
            	board.endTurn();
            	
            	actualizeSprits(mapRectangle,board);
            	
            	if(board.isGameOver()) {
            		Alert alertfinal = new Alert(AlertType.INFORMATION);
            		if(board.getCurrentPlayer() == board.getPlayer1()) {
            			alert.setTitle("Game Over");
                		alert.setHeaderText("");
                		alert.setContentText("Felicitation au " + board.getPlayer1().getName() +" vous avez gagné : )");
                		alert.showAndWait();
                		buttonde.setDisable(true);
            			
            		} else if (board.getCurrentPlayer() == board.getPlayer2()) {
            			alert.setTitle("Game Over");
                		alert.setHeaderText("");
                		alert.setContentText("Felicitation au " + board.getPlayer2().getName() +" vous avez gagné : )");
                		alert.showAndWait();
                		buttonde.setDisable(true);
            			
            		}
            		
            	}
            }
            
        });
		
		
	}
	
	public void actualizeSprits(HashMap<Integer,Rectangle> mapRectangle,BoardItf board ) {
		
    	if(board.getCurrentPlayer() == board.getPlayer1()) {
    		imgViewp1.setX(mapRectangle.get(board.getCurrentPlayer().getPosition()).getX()+30);
    		imgViewp1.setY(mapRectangle.get(board.getCurrentPlayer().getPosition()).getY()+30);
    		descriptionp1.setText("Description " + board.getPlayer1().getName()+": \n Puissance  " + board.getPlayer1().getArmy().strike()+"\n Point de vie "+board.getPlayer1().getArmy().getHealthPoints());
    	}
    	else {
    		imgViewp2.setX(mapRectangle.get(board.getCurrentPlayer().getPosition()).getX()+2);
    		imgViewp2.setY(mapRectangle.get(board.getCurrentPlayer().getPosition()).getY()+2);
    		descriptionp2.setText("Description " + board.getPlayer2().getName()+": \n Puissance  " + board.getPlayer2().getArmy().strike()+"\n Point de vie "+board.getPlayer2().getArmy().getHealthPoints());
    	}
    	
	}

    public static void main(String[] args) {
        launch(args);
    }
}
