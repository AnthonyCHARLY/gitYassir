package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class MalusBoxBack extends MalusBox{
	
	private int value;
	public MalusBoxBack(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		
		box.effect(b);
		value=(int)Math.random() * 3 + 1;
		b.getCurrentPlayer().back(value);
	}

	public String description() {
		// TODO Auto-generated method stub
		return box.description() + " , back " + value + " case less";
	}

}
