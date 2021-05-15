package application.core;

public interface Builder {
	
	void buildHeader(); // haut de 
	void buildBoard(); //game board
	void buildUtil(); //buttons
	void buildPlayers(); //players positions
	void buildStatements(); //current player statments
	void buildMessage(); //turn infromations 
}
