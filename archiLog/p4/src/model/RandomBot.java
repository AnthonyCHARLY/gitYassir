package model;

import java.util.Random;

public class RandomBot implements P4Player{

	@Override
	public int play(P4BoardItf board) {
		Random r = new Random();
		int position = r.nextInt(P4BoardItf.WIDTH);
		while(!board.isFree(position))
			position = r.nextInt(P4BoardItf.WIDTH);
		return position;
	}

}
