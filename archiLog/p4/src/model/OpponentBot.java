package model;

public class OpponentBot extends P4PlayerDecorator{

	public OpponentBot(P4Player _deco) {
		super(_deco);
	}

	@Override
	public int play(P4BoardItf board) {
		P4Player _opponent;
		if (board.player1() != this)
			_opponent = board.player1();
		else
			_opponent = board.player2();
		for (int position=0; position < P4BoardItf.WIDTH ; ++position) { 
			if (board.checkWin(position, _opponent))
				return position;
		}
		return super.play(board);
	}
	
	

}
