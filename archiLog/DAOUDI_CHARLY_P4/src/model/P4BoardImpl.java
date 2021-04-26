package model;

import java.util.HashMap;
import java.util.Scanner;

import ui.P4Builder;

/**
 * Design Pattern : Singleton for createinstance
 */

public class P4BoardImpl implements P4BoardItf{
	
	private int _alignementSizeVictory;
	private int _width, _height;
	private P4Player [][] _tab;
	private int _freePlaces;
	private P4Player _currentPlayer, _p1, _p2;
	private boolean _isGameOver;
	/* SINGLETON AVEC THREAD*/
	private static HashMap<Long,P4BoardImpl> _Boardinstance= new HashMap<Long,P4BoardImpl>();
	
	private P4BoardImpl() {
		Scanner sc = new Scanner(System.in);
		int width = -1;
		int height = -1;
		int alignementSize = -1;
		while (width < 0) {
			System.out.println("Enter board Width :");
			try {
				String str = sc.nextLine();
				width = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.println("Bad width value");
			}
		}
		//sc.close();
		while (height < 0) {
			System.out.println("Enter board Height :");
			try {
				String str = sc.nextLine();
				height = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.println("Bad height value");
			}
		}
		while (alignementSize < 0) {
			System.out.println("Enter alignement size for victory :");
			try {
				String str = sc.nextLine();
				alignementSize = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.println("Bad alignement size value");
			}
		}
		_alignementSizeVictory = alignementSize;
		_width = width;
		_height = height;
	}
	
	public static P4BoardImpl createintance() {
		
		Thread currentThread = Thread.currentThread();
		long id_thread = currentThread.getId();
		
		if(_Boardinstance.get(currentThread)== null) {
			_Boardinstance.put(id_thread, new P4BoardImpl());
		}
		
		return _Boardinstance.get(id_thread);
	}
	
	public int getWidth() {
		return _width;
	}
	
	public int getHeight() {
		return _height;
	}
	
	public P4Player getTab(int col, int line) {
		return _tab[col][line];
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
		_tab = new P4Player[_width][_height];
		
		for (int column=0; column < _width; ++column)
			for (int ligne=0; ligne < _height; ++ligne)
				_tab[column][ligne] = null;
		
		_isGameOver = false;
		_freePlaces = _width * _height;
	}
	
	
	public String toString() {
		
		StringBuffer str = new StringBuffer();
		
		for (int y=_height-1 ; y >= 0; y--) {
			
			str.append("|");
			
			for (int x=0; x < _width; x++) {
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
		for(int x = 0 ; x < _width ; x++)
			str.append("**");
		str.append("*\n");
		return str.toString();
	}
	
	

	public void builder(P4Builder builder) {

		builder.createNewP4Builder();

		builder.beginBoard();

		for (int y = _height - 1; y >= 0; y--) {
			builder.beginLine();
			builder.beginCase();
			for (int x = 0; x < _width; x++) {
				if (_tab[x][y] == _p1)
					builder.addTokenPlayer1();
				if (_tab[x][y] == null)
					builder.addEmptyCase();
				if (_tab[x][y] == _p2)
					builder.addTokenPlayer2();
				builder.endCase();
				if (x != _width - 1)
					builder.beginCase();
			}
			builder.endLine();
		}
		builder.endBoard(_width);
		builder.finish();
	}
	
	
	public boolean isFree(int col) {
		
		if(_freePlaces <= 0) 
			return false;
		
		if (col < 0 || col >= _width) 
			return false;
		
		int ligne=0;
		while(ligne < _height && _tab[col][ligne] != null)
			++ligne;
		
		if (ligne >= _height)
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
		while(ligne < _height && _tab[col][ligne] != null)
			++ligne;
		
		if (ligne >= _height) {
			//error
		}
		
		boolean res = checkAlignment(col, _currentPlayer);
		_tab[col][ligne] = _currentPlayer;
		if (res) {
			_isGameOver = true;
			System.out.println(_currentPlayer.getName() + " win");
			return;
		}
		_currentPlayer = switchPlayer();
	}
	
	public boolean checkHorizonalAlignment(int ligne, int column, P4Player p) {
		
		int res = 1;
		
		for (int x = column + 1; x < _width && _tab[x][ligne] == p; x++) res++;
		for (int x = column - 1; x >=  0   && _tab[x][ligne] == p; x--) res++;
		
		return res >= _alignementSizeVictory;
	}
	
	public boolean checkVerticalAlignment(int ligne, int column, P4Player p) {
		
		int res = 1;
		
		for (int y = ligne + 1; y < _width && _tab[column][y] == p; y++) res++;
		for (int y = ligne - 1; y >=  0   && _tab[column][y] == p; y--) res++;
		
		return res >= _alignementSizeVictory;
	}
	
	public boolean checkDiagonalAlignment(int ligne, int column, P4Player p) {
		
		int botLeftTopRightRes = 1;
		int topLeftBotRightRes = 1;
		
		for (int x = column + 1, y = ligne + 1 ; x < _width && y < _height && _tab[x][y] == p; x++, y++) botLeftTopRightRes++;
		for (int x = column - 1, y = ligne - 1 ; x >= 0 && y >= 0 && _tab[x][y] == p; x--, y--) botLeftTopRightRes++;
		
		for (int x = column + 1, y = ligne - 1 ; x < _width && y >= 0 && _tab[x][y] == p; x++, y--) topLeftBotRightRes++;
		for (int x = column - 1, y = ligne + 1 ; x >= 0 && y < _height && _tab[x][y] == p; x--, y++) topLeftBotRightRes++;
		
		return botLeftTopRightRes >= _alignementSizeVictory || topLeftBotRightRes >= _alignementSizeVictory;
	}
		
	@Override
	public boolean checkAlignment(int col, P4Player p) {
		
		if (!isFree(col)) return false;
		
		int ligne = 0;
		while(ligne < _height && _tab[col][ligne] != null)
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
