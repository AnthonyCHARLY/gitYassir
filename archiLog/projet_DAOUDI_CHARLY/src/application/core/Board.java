package application.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.boxes.BonusBoxEquipment;
import application.boxes.BonusBoxForward;
import application.boxes.BonusBoxUnit;
import application.boxes.FinalBossBox;
import application.boxes.MalusBox;
import application.boxes.MalusBoxBack;
import application.boxes.MalusBoxFight;
import application.boxes.MalusBoxUnit;
import application.boxes.NeutralBox;
import application.boxes.SaveBox;
import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class Board implements BoardItf{
	
	private Player p1, p2, currentPlayer;
	private Map<Integer,Box> boxes;
	private static Board _instance = null;
	private static final int MAX_BOXES = 20;
	private boolean isGameOver;
	
	private Board(String p1Name, String p2Name) {
		
		boxes = new HashMap<Integer,Box>();
		makeBoxes();
		
		isGameOver = false;
		
		
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
	
	
	public static BoardItf getInstance(String p1Name, String p2Name) {
		
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
		
		if(boxes.keySet().contains(currentPlayer.getPosition()))
			boxes.get(currentPlayer.getPosition()).effect(this);
		else
			boxes.get(-1).effect(this);
	}
	
	@Override
	public void endTurn() {
		if(!p1.getArmy().alive()) {
			p1.backCheckpoint();
		}
		if(!p2.getArmy().alive()) {
			p2.backCheckpoint();
		}
		
		if(currentPlayer.getPosition() == MAX_BOXES)
			isGameOver = true;
		
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
	
	public void makeBoxes() {
		
		Box neutralBox = new NeutralBox();
		
		Box saveBox = new SaveBox(new NeutralBox());
		
		Box malus1 = new MalusBoxBack(new NeutralBox());
		Box malus2 = new MalusBoxUnit(new NeutralBox());
		Box malus3 = new MalusBoxUnit(new MalusBoxBack(new NeutralBox()));
		Box malus4 = new MalusBoxFight(new NeutralBox());
		
		Box bonus1 = new BonusBoxForward(new NeutralBox());
		Box bonus2 = new BonusBoxUnit(new NeutralBox());
		Box bonus3 = new BonusBoxUnit(new MalusBoxBack(new NeutralBox()));
		Box bonus4 = new BonusBoxEquipment(new BonusBoxUnit(new BonusBoxForward(new NeutralBox())));
		
		Box finalBox = new FinalBossBox(new NeutralBox());
		
		List<Box> speBoxes = new ArrayList<Box>();
		speBoxes.add(bonus1);
		speBoxes.add(bonus2);
		speBoxes.add(bonus3);
		speBoxes.add(bonus4);
		speBoxes.add(malus1);
		speBoxes.add(malus2);
		speBoxes.add(malus3);
		speBoxes.add(malus4);
		
		boxes.put(-1, neutralBox);
		
		boxes.put(5, saveBox);
		boxes.put(10, saveBox);
		boxes.put(15, saveBox);
		
		System.out.println("quoi");
		
		for(Box b : speBoxes) {
			int order = (int)(Math.random() * (MAX_BOXES-2) + 1);
			while(boxes.keySet().contains(order)) {
				order = (int)(Math.random() * (MAX_BOXES-2) + 1);
			}
			boxes.put(order,b);
		}
		
		boxes.put(MAX_BOXES-1, finalBox);
		
	}
	
	@Override
	public void boardBuilder(Builder b) {
		
		b.buildHeader(); // haut de 
		b.buildBoard(); //game board
		b.buildUtil(p1,p2); //buttons
		b.buildPlayers(p1,p2); //players positions
		b.buildStatements(); //current player statments
		b.buildMessage(); //turn infromations 
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		_instance = new Board(p1.getName(), p2.getName());
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return isGameOver;
	}

	@Override
	public Player getPlayer1() {
		// TODO Auto-generated method stub
		return p1;
	}

	@Override
	public Player getPlayer2() {
		// TODO Auto-generated method stub
		return p2;
	}


	@Override
	public Map<Integer, Box> getBoxes() {
		// TODO Auto-generated method stub
		return boxes;
	}
	
	
	
	
	

}
