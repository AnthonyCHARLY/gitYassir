package model;

import java.util.HashMap;

public class P4BoardImpl implements P4BoardItf{
	
	private P4Player [][] _tab;
	private int _freePlaces;
	private P4Player _currentPlayer, _p1, _p2;
	private boolean _isGameOver;
	/* SINGLETON AVEC THREAD*/
	private static HashMap<Long,P4BoardImpl> _Boardinstance= new HashMap<Long,P4BoardImpl>();
	//bloquer le constructeur
	private P4BoardImpl() {}
	
	public static P4BoardImpl createintance() {
		
		Thread currentThread = Thread.currentThread();
		long id_thread = currentThread.getId();
		
		if(_Boardinstance.get(currentThread)== null) {
			_Boardinstance.put(id_thread, new P4BoardImpl());
		}
		
		return _Boardinstance.get(id_thread);
	}
	
	public P4Player getCurrentPlayer() {
		return _currentPlayer;
	}

	public P4Player getPlayer1() {
		return _p1;
	}
	public P4Player getPlayer2() {
		return _p2;
	}
	public void init(P4Player p1, P4Player p2) {
		
		_p1 = p1;
		_p2 = p2;
		
		_currentPlayer = _p1;
		_tab = new P4Player[WIDTH][HEIGHT];
		
		for (int column=0; column < WIDTH; ++column)
			for (int ligne=0; ligne < HEIGHT; ++ligne)
				_tab[column][ligne] = null;
		
		_isGameOver = false;
		_freePlaces = WIDTH * HEIGHT;
	}
	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		
		for (int y=HEIGHT-1 ; y >= 0; y--) {
			
			str.append("|");
			
			for (int x=0; x < WIDTH; x++) {
				if (_tab[x][y] == _p1)
					str.append("X");
				
				if (_tab[x][y] == null)
					str.append(" ");
				
				if (_tab[x][y] == _p2)
					str.append("O");
				
				str.append("|");
			}
			
			str.append("\n");
		}
		for(int x = 0 ; x < WIDTH ; x++)
			str.append("**");
		str.append("*\n");
		return str.toString();
	}
	
	
	public boolean isFree(int col) {
		
		if(_freePlaces <= 0) 
			return false;
		
		if (col < 0 || col >= WIDTH) 
			return false;
		
		int ligne=0;
		while(ligne < HEIGHT && _tab[col][ligne] != null)
			++ligne;
		
		if (ligne >= HEIGHT)
			return false;
		
		return true;
	}
	
	private P4Player switchPlayer() {
		if (_currentPlayer == _p1)
			return _p2;
		else 
			return _p1;
	}
	
	public void play(int col) {
		
		if (isGameOver()) return;
		
		--_freePlaces;
		
		int ligne=0;
		while(ligne < HEIGHT && _tab[col][ligne] != null)
			++ligne;
		
		if (ligne >= HEIGHT) {
			//error
		}
		
		boolean res = checkAlignment(col, _currentPlayer);
		_tab[col][ligne] = _currentPlayer;
		if (res) {
			_isGameOver = true;
			System.out.println("player " + _currentPlayer.getName() + " win");
			return;
		}
		_currentPlayer = switchPlayer();
	}
	
	public boolean checkHorizonalAlignment(int ligne, int column, P4Player p) {
		
		int res = 1;
		
		for (int x = column + 1; x < WIDTH && _tab[x][ligne] == p; x++) res++;
		for (int x = column - 1; x >=  0   && _tab[x][ligne] == p; x--) res++;
		
		return res > 3;
	}
	
	public boolean checkVerticalAlignment(int ligne, int column, P4Player p) {
		
		int res = 1;
		
		for (int y = ligne + 1; y < WIDTH && _tab[column][y] == p; y++) res++;
		for (int y = ligne - 1; y >=  0   && _tab[column][y] == p; y--) res++;
		
		return res > 3;
	}
	
	public boolean checkDiagonalAlignment(int ligne, int column, P4Player p) {
		
		int botLeftTopRightRes = 1;
		int topLeftBotRightRes = 1;
		
		for (int x = column + 1, y = ligne + 1 ; x < WIDTH && y < HEIGHT && _tab[x][y] == p; x++, y++) botLeftTopRightRes++;
		for (int x = column - 1, y = ligne - 1 ; x >= 0 && y >= 0 && _tab[x][y] == p; x--, y--) botLeftTopRightRes++;
		
		for (int x = column + 1, y = ligne - 1 ; x < WIDTH && y >= 0 && _tab[x][y] == p; x++, y--) topLeftBotRightRes++;
		for (int x = column - 1, y = ligne + 1 ; x >= 0 && y < HEIGHT && _tab[x][y] == p; x--, y++) topLeftBotRightRes++;
		
		return botLeftTopRightRes > 3 || topLeftBotRightRes > 3;
	}
		
	@Override
	public boolean checkAlignment(int col, P4Player p) {
		
		if (!isFree(col)) return false;
		
		int ligne = 0;
		while(ligne < HEIGHT && _tab[col][ligne] != null)
			++ligne;
		
		_tab[col][ligne] = p;
		boolean result = checkVerticalAlignment(ligne,col,p) || checkHorizonalAlignment(ligne,col,p) || checkDiagonalAlignment(ligne,col,p);
		_tab[col][ligne] = null;
		
		return result;
	
		}

	@Override
	public boolean isGameOver() {
		return _isGameOver;
	}

}
