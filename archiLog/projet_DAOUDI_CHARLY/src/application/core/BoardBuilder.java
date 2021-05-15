package application.core;

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

public class BoardBuilder extends Application implements Builder {
	
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
		
		 buildBoard();
		 buildUtil();
		 buildMessage();
		 
		 Scene scenegraph = new Scene (root,600,400) ;
		 primaryStage.setScene (scenegraph) ;
		 primaryStage.setTitle ("Jeu de l'oie");
		 primaryStage.show ();
		 
        
    }

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void buildHeader() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildBoard() {
		// TODO Auto-generated method stub
		int i,j=0;
		for( i=0; i<6; i++)
		    for( j=0; j<6; j++)
		    {
		      Rectangle rectangle = new Rectangle(50 + 50*i, 50+50*j, 50, 50);
		      rectangle.setFill(Color.TRANSPARENT);
		      rectangle.setStroke(Color.BLACK);
		     // r.setOnMouseClicked(this);
		      if((i== 0 ) || (j == 0 )) {
		    	  root.getChildren().add(rectangle);
		      }
		      else if((j == 5 ) || (i == 5 )){
			      root.getChildren().add(rectangle);
			  }
		      
		    }
	}

	@Override
	public void buildUtil() {
		// TODO Auto-generated method stub
		 buttonde= new Button();
		 buttonde.setText("Lancer le dé");
		 
		 
		 tour= new Label("Tour : 1");
		 tour.setTextFill(Color.BLACK);
		 tour.setLayoutX(500);
		 tour.setVisible(true);
		 
		 descriptionp1= new Label("Description P1: ");
		 descriptionp1.setTextFill(Color.BLACK);
		 descriptionp1.setLayoutX(400);
		 descriptionp1.setLayoutY(100);
		 descriptionp1.setVisible(true);
		 
		 descriptionp2= new Label("Description P2: ");
		 descriptionp2.setTextFill(Color.BLACK);
		 descriptionp2.setLayoutX(400);
		 descriptionp2.setLayoutY(200);
		 descriptionp2.setVisible(true);
		 
		 victory= new Label(" Victoire");
		 victory.setTextFill(Color.BLACK);
		 victory.setLayoutX(300);
		 victory.setVisible(false);
		 
		 
		 root.getChildren().addAll(buttonde,tour,descriptionp1,descriptionp2,victory);
	}

	@Override
	public void buildPlayers() {
		// TODO Auto-generated method stub
	}

	@Override
	public void buildStatements() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildMessage() {
		// TODO Auto-generated method stub
		buttonde.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
               tour.setText("Tour : " + tourInt);
               tourInt ++;
               System.out.println("Tour : " + tourInt);
               
             
            }
        });
		
		
	}

	

}
