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
	public void effect(PlayerItf player) {
		// TODO Auto-generated method stub
		box.effect(player);
		player.addRiderUnit();
		
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}


