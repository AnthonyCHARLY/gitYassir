package application;

import soldier.core.Unit;
import soldier.units.UnitHorseMan;

public class BonusBox implements Box{

	@Override
	public void effect(PlayerItf player) {
		// TODO Auto-generated method stub
		player.addRiderUnit();
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println(" Vous avez gagné un nouvel allié ");
	}

}
