package application.boxes;

import java.util.Random;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class BonusBoxForward extends BonusBox{

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
