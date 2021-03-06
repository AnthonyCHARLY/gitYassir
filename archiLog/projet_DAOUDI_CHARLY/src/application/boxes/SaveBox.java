package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;

public class SaveBox extends DecoratorBox{

	public SaveBox(Box box) {
		super(box);
	}
	
	@Override
	public void effect(BoardItf b) {
		box.effect(b);
		b.getCurrentPlayer().getMemento();
	}
	
	public String description() {
		return box.description() + " Vous avez atteint un point de sauvegard ;";
	}

	@Override
	public String getType() {
		return "Save";
	}
	
	

}
