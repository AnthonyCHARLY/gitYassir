package application;

import soldier.core.Unit;

public interface PlayerItf {
	
	public String getName();
	
	public void addInfantryUnit();
	
	public void addRiderUnit();
	
	public void addDefenseWeapon();
	
	public void addAttackWeapon();
	
	public void removeUnit(Unit u);
	
	

}
