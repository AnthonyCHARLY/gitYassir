package application;

import java.util.List;

import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class Board implements BoardItf{
	
	private Player p1, p2, currentPlayer;
	private List<Box> boxes;
	private static Board _instance = null;
	private static final int MAX_BOXES = 20;
	
	private Board(String p1Name, String p2Name) {
		
		AgeAbstractFactory FutureFactory = new AgeFutureFactory();
		AgeAbstractFactory MiddleFactory = new AgeMiddleFactory();
		
		p1 = new Player(p1Name, FutureFactory);
		p2 = new Player(p2Name, MiddleFactory);
		
		p1.addInfantryUnit();
		p1.addRiderUnit();
		p2.addInfantryUnit();
		p2.addRiderUnit();
		
		currentPlayer = p1;
	}
	
	@Override
	public BoardItf getInstance(String p1Name, String p2Name) {
		
		if(_instance == null)
			_instance = new Board(p1Name, p2Name);
		return _instance;
		
	}
	
	@Override
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	@Override
	public void turn() {
		
		int dice = (int)Math.random() * 6 + 1;
		currentPlayer.forward(dice);
		
		if(p1.getPosition() == p2.getPosition()) { fight(p1.getArmy(),p2.getArmy()); }
		
		boxes.get(currentPlayer.getPosition()).effect(this);
		
		endTurn();
	}
	
	@Override
	public void endTurn() {
		if(!p1.getArmy().alive()) {
			p1.backCheckpoint();
		}
		if(!p2.getArmy().alive()) {
			p2.backCheckpoint();
		}
		currentPlayer = (currentPlayer == p1) ? p2 : p1;
	}
	
	@Override
	public void fight(UnitGroup team1, UnitGroup team2) {
		
		while(team1.alive() && team2.alive()) {
			
			double order = Math.random();
			
			if(order < 0.5) {
				float st1 = team1.strike();
				team2.parry(st1);
				float st2 = team2.strike();
				team1.parry(st2);
			}
			else {
				float st2 = team2.strike();
				team1.parry(st2);
				float st1 = team1.strike();
				team2.parry(st1);
			}
		}
		
	}
	
	@Override
	public void boardBuilder(Builder b) {
		
		b.buildHeader(); // haut de 
		b.buildBoard(); //game board
		b.buildUtil(); //buttons
		b.buildPlayers(); //players positions
		b.buildStatements(); //current player statments
		b.buildMessage(); //turn infromations 
		
	}
	
	
	
	

}
