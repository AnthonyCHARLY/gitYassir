package ui;

import model.P4BoardItf;

/**
 * Creates an Text version of a Game.
 */
public class TxtBuilder implements P4Builder {
	StringBuilder str;

	@Override
	public void createNewP4Builder() {
		str = new StringBuilder();
	}

	@Override
	public void beginBoard() {
	}

	@Override
	public void endBoard(int width) {
		for(int x = 0 ; x < width ; x++)
			str.append("**");
		str.append("*\n");
	}

	@Override
	public void beginCase() {
		str.append("|");
	}

	@Override
	public void endCase() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addTokenPlayer1() {
		str.append("X");
	}

	@Override
	public void addTokenPlayer2() {
		str.append("0");
	}

	@Override
	public void endLine() {
		str.append("|\n");
	}

	@Override
	public void addEmptyCase() {
		str.append(" ");
	}

	public String getResult() {
		return str.toString();
	}

	@Override
	public void beginLine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}

}
