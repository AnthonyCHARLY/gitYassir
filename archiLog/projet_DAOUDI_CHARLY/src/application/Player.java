package application;

import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;

public class Player implements PlayerItf, Cloneable{
	
	private int position;
	private String name;
	private UnitGroup army;
	private AgeAbstractFactory armyFactory;
	
	private class PlayerMemento implements Memento{
		
		public Player save = null;
		
		public PlayerMemento(Player origin) {
			save = origin.clone();
		}
		
	}
	
	public Player(String name, AgeAbstractFactory armyFactory) {
		this.position = 0;
		this.name = name;
		this.army = new UnitGroup(name + "'s army");
		this.armyFactory = armyFactory;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void addInfantryUnit() {
		army.addUnit(armyFactory.infantryUnit(name + "'s infantry"));
	}

	@Override
	public void addRiderUnit() {
		army.addUnit(armyFactory.infantryUnit(name + "'s rider"));
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
	public void removeUnit(Unit u) {
		// TODO Auto-generated method stub
		
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
	public Memento getMemento() {
		return new PlayerMemento(this);
	}

	@Override
	public void setMemento(Memento m) {
		PlayerMemento pm = (PlayerMemento)m;
		this.army = pm.save.army;
		this.position = pm.save.position;
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

}
