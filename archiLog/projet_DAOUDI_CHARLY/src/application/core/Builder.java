package application.core;

public interface Builder {
	
	void buildHeader(); // haut de 
	void buildBoard(); //game board
	void buildUtil(Player p1, Player p2); //buttons
	void buildPlayers(Player p1, Player p2); //players positions
	void buildStatements(); //current player statments
	void buildMessage(); //turn infromations 
}
