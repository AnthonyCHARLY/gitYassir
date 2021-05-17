package application.boxes;

import application.core.BoardItf;
import application.core.Box;

public class NeutralBox implements Box{

	@Override
	public void effect(BoardItf b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		System.out.println(" Nothing ");
		return "Nothing";
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Neutral";
	}

}
