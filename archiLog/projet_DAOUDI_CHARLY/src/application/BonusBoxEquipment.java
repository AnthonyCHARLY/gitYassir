package application;

public class BonusBoxEquipment extends DecoratorBox{

	public BonusBoxEquipment(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(PlayerItf player) {
		// TODO Auto-generated method stub
		box.effect(player);
		
		player.addAttackWeapon();
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}