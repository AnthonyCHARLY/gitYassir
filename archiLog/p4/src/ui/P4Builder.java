package ui;

/**
 * Design Pattern : Builder
 */

public interface P4Builder {

	public void createNewP4Builder();

	public void addTokenPlayer1();

	public void addTokenPlayer2();

	public void addEmptyCase();

	public void beginBoard();

	public void endBoard(int width);

	public void beginCase();

	public void endCase();

	public void beginLine();

	public void endLine();

	public void finish();

}
