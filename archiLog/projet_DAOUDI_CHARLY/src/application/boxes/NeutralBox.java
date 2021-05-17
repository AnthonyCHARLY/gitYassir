package application.boxes;

import application.core.BoardItf;
import application.core.Box;

public class NeutralBox implements Box{

	@Override
	public void effect(BoardItf b) {
		
	}

	@Override
	public String description() {
		return "";
	}

	@Override
	public String getType() {
		return "Neutral";
	}

}
