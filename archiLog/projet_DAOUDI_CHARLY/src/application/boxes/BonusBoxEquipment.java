package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class BonusBoxEquipment extends BonusBox{

	public BonusBoxEquipment(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		box.effect(b);
		b.getCurrentPlayer().addAttackWeapon();
	}

	public String description() {
		// TODO Auto-generated method stub
		return box.description() + " , you won an equipment ";
	}

}