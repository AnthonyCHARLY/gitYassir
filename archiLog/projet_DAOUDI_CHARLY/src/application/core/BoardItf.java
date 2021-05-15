package application.core;

import soldier.core.UnitGroup;

public interface BoardItf {
	
	public BoardItf getInstance(String p1Name, String p2Name);
	
	public Player getCurrentPlayer(); 
	
	public void turn();
	
	public void endTurn();
	
	public void fight(UnitGroup team1, UnitGroup team2);
	
	public void makeBoxes();
	
	public void boardBuilder(Builder b);
	
	public void endGame();
	
	public boolean isGameOver();
	
}
