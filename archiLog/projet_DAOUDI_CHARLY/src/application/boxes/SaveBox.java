package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class SaveBox extends DecoratorBox{

	public SaveBox(Box box) {
		super(box);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(BoardItf b) {
		box.effect(b);
		b.getCurrentPlayer().getMemento();
	}
	
	public void description() {
		box.description();
	}
	
	

}
