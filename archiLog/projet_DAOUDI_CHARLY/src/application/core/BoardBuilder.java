package application.core;

import java.awt.Button;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardBuilder extends Application implements Builder {
	
	@Override
    public void start(Stage primaryStage) {/**
		// Also add a text which will be centered
        primaryStage.setTitle("Hello JavaFX");
        
        HBox root = new HBox();
        // JavaFX uses Scenes for content
        Scene scene = new Scene(root, 400, 400);

        // Scenes are displayed by a Stage
        primaryStage.setTitle("Jeu de l'oie ");
        primaryStage.setScene(scene);
        primaryStage.show();
        
     //  root.setSpacing(10);
        root.setPadding(new Insets(15,20, 10,10));
        
        // Button 1
        Button button1= new Button("Button1");
        
		
        // Build a first grid
        GridPane grid1 = new GridPane();
        grid1.setGridLinesVisible(true); // Useful for debug

        // Create and add text to the grid
        Text header = new Text("Number one");
        grid1.add(header, 0, 0);

        // This text is adjusted through CSS
        Text another = new Text("Number two");
        another.setStyle("-fx-font: 24 arial;");
        grid1.add(another, 1, 1);

        // Build a second grid
        GridPane grid2 = new GridPane();
        grid2.setGridLinesVisible(true);

        // Adjust the grid style
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(0, 10, 0, 10));

        // Simpler API only for rows
        grid2.addRow(0, new Text("Row one"));
        grid2.addRow(1, new Text("Row two"));
        grid2.addColumn(1, new Text("Col three"));

        // Put the two grids in a column
        VBox col = new VBox();
        col.setAlignment(Pos.CENTER);
        col.getChildren().add(grid1);
        col.getChildren().add(grid2);
        
        **/
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
		
	}

	@Override
	public void buildUtil() {
		// TODO Auto-generated method stub
		
		Button buttongame = new Button("Jouer");
		
		
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
		
	}

	

}
