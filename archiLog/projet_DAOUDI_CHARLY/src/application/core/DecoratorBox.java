package application.core;

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
	
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		box.effect(b);
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}
	
	
}
