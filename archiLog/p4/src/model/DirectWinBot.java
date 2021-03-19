package model;

public class DirectWinBot extends P4PlayerDecorator{

	public DirectWinBot(P4Player _deco) {
		super(_deco);
	}
	
	public int play(P4BoardItf board) {
		for (int position=0; position < P4BoardItf.WIDTH; ++position) { 
			if (board.checkWin(position, this))
				return position;
		}
		return super.play(board);
	}

}
