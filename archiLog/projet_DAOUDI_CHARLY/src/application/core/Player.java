package application.core;

import java.util.Iterator;

import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;

public class Player implements PlayerItf, Cloneable{
	
	private int position;
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	private Memento checkpoint;
	
	private class PlayerMemento implements Memento{
		
		public Player save = null;
		
		public PlayerMemento(Player origin) {
			save = origin.clone();
		}
		
	}
	
	public Player(String name, AgeAbstractFactory armyFactory) {
		this.position = 0;
		this.name = name;
		this.army = new UnitGroup(name + ":: army");
		this.armyFactory = armyFactory;
		getMemento();
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addInfantryUnit() {
		army.addUnit(armyFactory.infantryUnit(name + ":: infantry"));
	}

	@Override
	public void addRiderUnit() {
		army.addUnit(armyFactory.infantryUnit(name + ":: rider"));
	}
	
	@Override
	public void removeUnit() {
		Iterator<Unit> itUnit = army.subUnits();
		if(itUnit.hasNext()) { army.removeUnit(itUnit.next());}
	}

	@Override
	public void addDefenseWeapon() {
		army.addEquipment(armyFactory.attackWeapon());
	}

	@Override
	public void addAttackWeapon() {
		army.addEquipment(armyFactory.defenseWeapon());
	}

	@Override
	public int getPosition() {
		return position;
	}
	
	@Override
	public void forward(int value) {
		position += value;
	}

	@Override
	public void back(int value) {
		if(position - value <= 0)
			position = 0;
		else
			position -= value;
	}

	@Override
	public void getMemento() {
		checkpoint = new PlayerMemento(this);
	}
	
	@Override
	public Player clone() {
		Player res = null;
		try {
			res = (Player)super.clone();
		}
		catch(Exception e) {}
		return res;
	}
	
	@Override
	public UnitGroup getArmy() {
		return army;
	}

	@Override
	public void backCheckpoint() {
		PlayerMemento pm = (PlayerMemento)checkpoint;
		addInfantryUnit();
		addRiderUnit();
		this.position = pm.save.getPosition();		
	}

	@Override
	public void setPosition(int newPosition) {
		this.position= newPosition;
	}

}
