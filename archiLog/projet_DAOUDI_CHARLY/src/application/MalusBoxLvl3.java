package application;

public class MalusBoxLvl3 extends DecoratorBox{

	public MalusBoxLvl3(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(Player player) {
		// TODO Auto-generated method stub
		box.effect(player);
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}
