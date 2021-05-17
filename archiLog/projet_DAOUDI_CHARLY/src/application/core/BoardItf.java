package application.core;

import java.util.Map;

import soldier.core.UnitGroup;

public interface BoardItf {
	
	public static final int MAX_BOXES = 20;

	public Player getCurrentPlayer();
	
	public Player getPlayer1();
	
	public Player getPlayer2();
		
	public int turn();
	
	public void endTurn();
	
	public void fight(UnitGroup team1, UnitGroup team2);
	
	public void makeBoxes();
	
	public Map<Integer,Box> getBoxes();
	
	public void reset();
	
	public boolean isGameOver();
	
}
