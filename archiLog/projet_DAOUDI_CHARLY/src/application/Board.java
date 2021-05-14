package application;

import java.util.List;

import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;

public class Board {
	
	private Player p1, p2, currentPlayer;
	private List<Box> boxes;
	private static Board _instance = null;
	
	private Board(String p1Name, String p2Name) {
		AgeAbstractFactory FutureFactory = new AgeFutureFactory();
		AgeAbstractFactory MiddleFactory = new AgeMiddleFactory();
		p1 = new Player(p1Name, FutureFactory);
		p2 = new Player(p2Name, MiddleFactory);
		currentPlayer = p1;
	}
	
	public Board getInstance(String p1Name, String p2Name) {
		if(_instance == null)
			_instance = new Board(p1Name, p2Name);
		return _instance;
	}
	
	public void move() {
		int dice = (int)Math.random() * (7-1) + 1;
		boxes.get(currentPlayer.getPositon()).effect(currentPlayer);
	}

}
