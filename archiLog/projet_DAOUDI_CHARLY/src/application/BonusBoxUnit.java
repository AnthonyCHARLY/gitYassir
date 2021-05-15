package application;

import java.util.Random;

import soldier.core.Unit;
import soldier.units.UnitHorseMan;

public class BonusBoxUnit extends DecoratorBox{

	public BonusBoxUnit(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		box.effect(b);
		b.getCurrentPlayer().addRiderUnit();
		
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}


