package application.boxes;

import java.util.Random;

import application.core.Board;
import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class BonusBoxForward extends BonusBox{
	
	private int value;
	public BonusBoxForward(Box decoratorbox) {
		super(decoratorbox);
	}
	
	@Override
	public void effect(BoardItf b) {
		
		box.effect(b);
		value=(int)(Math.random() * 3) + 1;
		if(Board.MAX_BOXES > b.getCurrentPlayer().getPosition()+value)
			b.getCurrentPlayer().forward(value);
		else
			b.getCurrentPlayer().forward(Board.MAX_BOXES-b.getCurrentPlayer().getPosition());
		
	}

	public String description() {
		return box.description() + " Avancer de "
				+ value +" cases ;";
	}

}
