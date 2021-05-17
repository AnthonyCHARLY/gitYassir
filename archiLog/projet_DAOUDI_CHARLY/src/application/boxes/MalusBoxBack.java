package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class MalusBoxBack extends MalusBox{
	
	private int value;
	public MalusBoxBack(Box decoratorbox) {
		super(decoratorbox);
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		
		box.effect(b);
		value=(int)(Math.random() * 3) + 1;
		if(b.getCurrentPlayer().getPosition() - value >= 0)
			b.getCurrentPlayer().back(value);
		else
			b.getCurrentPlayer().back(b.getCurrentPlayer().getPosition());
	}

	public String description() {
		return box.description() + " Reculer de " + value + " cases ;";
	}

}
