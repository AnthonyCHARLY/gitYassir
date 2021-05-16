package application.core;

import soldier.core.UnitGroup;

public interface BoardItf {
	
	public Player getCurrentPlayer();
	
	public Player getPlayer1();
	
	public Player getPlayer2();
	
	public void turn();
	
	public void endTurn();
	
	public void fight(UnitGroup team1, UnitGroup team2);
	
	public void makeBoxes();
	
	public void boardBuilder(Builder b);
	
	public void reset();
	
	public boolean isGameOver();
	
}
