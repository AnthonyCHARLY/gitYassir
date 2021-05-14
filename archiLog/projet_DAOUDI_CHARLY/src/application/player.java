package application;

import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class player {
	
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	
	public player(String name, AgeAbstractFactory armyFactory) {
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

}
