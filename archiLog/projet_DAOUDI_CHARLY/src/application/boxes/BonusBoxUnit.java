package application.boxes;

import java.util.Random;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;
import soldier.core.Unit;
import soldier.units.UnitHorseMan;

public class BonusBoxUnit extends BonusBox{

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

	public String description() {
		// TODO Auto-generated method stub
		return box.description() + " Vous avez gagner une unite ;";
	}

}


