package model;

public class OpponentBot extends P4PlayerDecorator{

	private String _name;
	
	public OpponentBot(P4Player _deco) {
		super(_deco);
		_name = "Level2Bot";
	}

	@Override
	public int play(P4BoardItf board) {
		P4Player _opponent;
		
		if (board.getPlayer1() != this)
			_opponent = board.getPlayer1();
		else
			_opponent = board.getPlayer2();
		
		for (int col=0; col < board.getWidth() ; ++col) { 
			if (board.checkAlignment(col, _opponent))
				return col;
		}
		
		return super.play(board);
	}
	
	@Override
	public String getName() {
		return _name;
	}
	
	

}
