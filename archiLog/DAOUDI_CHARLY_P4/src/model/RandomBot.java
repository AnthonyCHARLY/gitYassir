package model;

import java.util.Random;

public class RandomBot implements P4Player{
	
	private String _name;
	
	public RandomBot() {
		this._name = "Level1Bot";
	}
	
	@Override
	public int play(P4BoardItf board) {
		Random r = new Random();
		int col = r.nextInt(board.getWidth());
		while(!board.isFree(col))
			col = r.nextInt(board.getWidth());
		return col;
	}

	@Override
	public String getName() {
		return _name;
	}
}
