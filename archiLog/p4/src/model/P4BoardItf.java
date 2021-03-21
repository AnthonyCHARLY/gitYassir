package model;

import ui.P4Builder;

public interface P4BoardItf {
	
	public void init(P4Player p1, P4Player p2);
	
	public int getWidth();
	public int getHeight();
	
	public P4Player getPlayer1();
	public P4Player getPlayer2();
	public P4Player getCurrentPlayer();
	
	
	public void play(int col);
	
	public String toString();
	public void builder(P4Builder Bbuilder);
	public boolean isFree(int col);
	
	public boolean checkAlignment(int col, P4Player player);	
	public boolean isGameOver();
	
}
