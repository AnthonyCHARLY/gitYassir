package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class MalusBoxUnit extends MalusBox{

	public MalusBoxUnit(Box decoratorbox) {
		super(decoratorbox);
	}
	
	@Override
	public void effect(BoardItf b) {
		box.effect(b);
		b.getCurrentPlayer().removeUnit();
	}

	public String description() {
		return box.description() + " Vous avez perdu une unite ;";
		
	}

}
