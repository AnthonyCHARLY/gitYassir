package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class BonusBoxEquipment extends BonusBox{

	public BonusBoxEquipment(Box decoratorbox) {
		super(decoratorbox);
	}
	
	@Override
	public void effect(BoardItf b) {
		box.effect(b);
		b.getCurrentPlayer().addAttackWeapon();
	}

	public String description() {
		return box.description() + " Vous avez gagne un equipement ;";
	}

}