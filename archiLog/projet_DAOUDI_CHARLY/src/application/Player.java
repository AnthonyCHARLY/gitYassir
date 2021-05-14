package application;

import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;

public class Player implements PlayerItf{
	
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

}
