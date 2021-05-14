package application;

public class MalusBoxRemoveEquipment extends DecoratorBox{

	public MalusBoxRemoveEquipment(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(PlayerItf player) {
		// TODO Auto-generated method stub
		box.effect(player);
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}
