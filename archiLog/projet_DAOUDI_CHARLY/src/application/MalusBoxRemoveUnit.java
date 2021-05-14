package application;

public class MalusBoxRemoveUnit extends DecoratorBox{

	public MalusBoxRemoveUnit(Box decoratorbox) {
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
