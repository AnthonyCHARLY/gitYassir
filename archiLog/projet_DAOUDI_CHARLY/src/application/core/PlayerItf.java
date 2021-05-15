package application.core;

import soldier.core.Unit;
import soldier.core.UnitGroup;

public interface PlayerItf {
	
	public String getName();
	
	public UnitGroup getArmy();
	
	public int getPosition();
	
	public void addInfantryUnit();
	
	public void addRiderUnit();
	
	public void removeUnit();
	
	public void addDefenseWeapon();
	
	public void addAttackWeapon();
	
	public void removeEquipment();
	
	public void forward(int value);
	
	public void back(int value);
	
	public void getMemento();
	
	public void backCheckpoint();

}
