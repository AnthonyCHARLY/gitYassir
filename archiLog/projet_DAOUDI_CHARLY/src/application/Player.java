package application;

import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class Player {
	
	private int position;
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	
	public Player(String name, AgeAbstractFactory armyFactory) {
		this.position = 0;
		this.name = name;
		this.army = new UnitGroup(name + "'s army");
		this.armyFactory = armyFactory;
	}
	
	public String getName() {
		return name;
	}
	
	public UnitGroup getArmy() {
		return army;
	}
	
	public AgeAbstractFactory getArmyFactory() {
		return armyFactory;
	}
	
	public int getPositon() {
		return position;
	}

}
