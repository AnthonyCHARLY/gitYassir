package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class MalusBoxUnit extends MalusBox{

	public MalusBoxUnit(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		box.effect(b);
		b.getCurrentPlayer().removeUnit();
	}

	public String description() {
		// TODO Auto-generated method stub
		return box.description() + " Vous avez perdu une unite ;";
		
	}

}
