package application;

public class MalusBoxEquipment extends DecoratorBox{

	public MalusBoxEquipment(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		box.effect(b);
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}
