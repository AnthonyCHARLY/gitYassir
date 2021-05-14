package application;

import soldier.core.Unit;
import soldier.units.UnitHorseMan;
/****
 * 
 * Decorator for Level Box 
 * 
 * ****/
public abstract class DecoratorBox implements Box {

	protected Box box;

	public DecoratorBox(Box box) {
		super();
		this.box = box;
	}
	
	public void effect(Player player) {
		// TODO Auto-generated method stub
		box.effect(player);
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}
	
	
}
