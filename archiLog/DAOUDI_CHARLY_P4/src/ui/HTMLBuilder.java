package ui;

/**
 * Creates an HTML version of a Game.
 */

public class HTMLBuilder implements P4Builder {

	String _str;

	@Override
	public void createNewP4Builder() {
		// TODO Auto-generated method stub
		_str = "<!doctype html>" + "<html>" + "<head>" + "<title>Puissance4Game</title>" + "</head>" + "<body>";

	}

	@Override
	public void addTokenPlayer1() {
		_str += "x";

	}

	@Override
	public void addTokenPlayer2() {
		_str += "o";
	}

	@Override
	public void addEmptyCase() {
		_str += "&nbsp&nbsp&nbsp";

	}

	@Override
	public void beginBoard() {
		_str += "<TABLE BORDER=\"1\">";

	}

	@Override
	public void endBoard(int width) {
		_str += "</Table>";

	}

	@Override
	public void beginCase() {
		_str += "<td>";

	}

	@Override
	public void endCase() {
		_str += "</td>";

	}

	@Override
	public void endLine() {
		_str += "</tr>";

	}

	@Override
	public void beginLine() {
		_str += "<tr>";
	}

	public String getResult() {
		return _str;
	}

	@Override
	public void finish() {
		_str += "</body></html>";

	}

}
