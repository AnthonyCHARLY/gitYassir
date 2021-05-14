package application;

import java.util.List;

import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class Board {
	
	private Player p1, p2, currentPlayer;
	private List<Box> boxes;
	private static Board _instance = null;
	
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
	
	public Board getInstance(String p1Name, String p2Name) {
		if(_instance == null)
			_instance = new Board(p1Name, p2Name);
		return _instance;
	}
	
	public void turn() {
		int dice = (int)Math.random() * 6 + 1;
		currentPlayer.forward(dice);
		
		if(p1.getPosition() == p2.getPosition()) { fight(); }
		
		boxes.get(currentPlayer.getPosition()).effect(currentPlayer);
		
		currentPlayer = (currentPlayer == p1) ? p2 : p1;
	}
	
	public void fight() {
		double order = Math.random();
		UnitGroup team1 = order < 0.5 ? p1.getArmy() : p2.getArmy();
		UnitGroup team2 = (team1 == p1.getArmy()) ? p2.getArmy() : p1.getArmy();
		while(team1.alive() && team2.alive()) {
			float st1 = team1.strike();
			team2.parry(st1);
			float st2 = team2.strike();
			team1.parry(st2);
		}
		Player loser = p1.getArmy().alive() ? p2 : p1;
		loser.backCheckpoint();
	}
	
	public void boardBuilder(Builder b) {
		
		b.buildHeader(); // haut de 
		b.buildBoard(); //game board
		b.buildUtil(); //buttons
		b.buildPlayers(); //players positions
		b.buildStatements(); //current player statments
		b.buildMessage(); //turn infromations 
		
	}
	
	
	
	

}
