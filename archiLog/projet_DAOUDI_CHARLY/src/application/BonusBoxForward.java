package application;

import java.util.Random;

public class BonusBoxForward extends DecoratorBox{

	public BonusBoxForward(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		int bonus =2;
		box.effect(b);
		Random rand = null;
		b.getCurrentPlayer().forward((int)Math.random() * 3 + 1);
		
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}
