package model;

public class DirectWinBot extends P4PlayerDecorator{

	private String _name;
	
	public DirectWinBot(P4Player _deco) {
		super(_deco);
		_name="Level3Bot";
	}
	
	public int play(P4BoardItf board) {
		for (int col=0; col < board.getWidth(); ++col) { 
			if (board.checkAlignment(col, this))
				return col;
		}
		return super.play(board);
	}

	@Override
	public String getName() {
		return _name;
	}

}
