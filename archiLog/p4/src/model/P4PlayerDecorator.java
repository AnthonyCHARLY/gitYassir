package model;

/**
 * Design Pattern : Decorator
 */

public abstract class P4PlayerDecorator implements P4Player{
	
	P4Player _deco;
	
	
	public P4PlayerDecorator(P4Player _deco) {
		this._deco = _deco;
	}
	
	@Override
	public int play(P4BoardItf board) {
		return _deco.play(board);
	}

}
