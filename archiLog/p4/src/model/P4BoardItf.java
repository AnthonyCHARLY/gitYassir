package model;

public interface P4BoardItf {

	public static final int WIDTH  = 7;
	public static final int HEIGHT = 7;
	
	public void init(P4Player p1, P4Player p2);
	
	public P4Player getPlayer1();
	public P4Player getPlayer2();
	public P4Player getCurrentPlayer();
	
	
	public void play(int col);
	
	public String toString();
	public boolean isFree(int col);
	
	public boolean checkAlignment(int col, P4Player player);	
	public boolean isGameOver();
	
}
