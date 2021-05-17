package application.boxes;

import java.util.Random;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class BonusBoxForward extends BonusBox{
	
	private int value;
	public BonusBoxForward(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		
		box.effect(b);
		value=(int)Math.random() * 3 + 1;
		b.getCurrentPlayer().forward(value);
		
	}

	public String description() {
		// TODO Auto-generated method stub
		return box.description() + " , forward  "
				+ value +" case more ";
	}

}
