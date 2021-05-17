package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public abstract class BonusBox extends DecoratorBox{
	
	public BonusBox(Box box) {
		super(box);
	}

	@Override
	public abstract void effect(BoardItf b);

	@Override
	public abstract String description();

	@Override
	public String getType() {
		return "Bonus";
	}
	
}
