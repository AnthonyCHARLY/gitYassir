package application;

public class BonusBoxEquipment extends DecoratorBox{

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

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}