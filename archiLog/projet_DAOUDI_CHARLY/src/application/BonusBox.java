package application;

import soldier.core.Unit;
import soldier.units.UnitHorseMan;

public class BonusBox implements Box{

	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		Unit horse = new UnitHorseMan("piccolo");
		player.getArmy().removeUnit(horse);
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		System.out.println(" Vous avez gagné un nouvel allié de la famille des UnitRider  ");
	}

}
