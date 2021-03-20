

import model.BotAbstractFactory;
import model.HumanPlayer;
import model.Level3Bot;
import model.P4BoardImpl;
import model.P4BoardItf;
import model.P4Player;

public class P4Main {

	public static void run(P4BoardItf board) {
		
		while(!board.isGameOver()) {
			System.out.println(board);
			System.out.println("Player " + board.getCurrentPlayer().getName() +  " turn");
			board.play(board.getCurrentPlayer().play(board));
		}
		
		System.out.println(board);
	}
	public static void main(String argv[]) {
		P4BoardItf board = P4BoardImpl.createintance();
		BotAbstractFactory factory = new Level3Bot();
		
		
		P4Player p1 = new HumanPlayer("Anthony");
		P4Player p2 = factory.create();
		//P4Player p2 = new DirectWinBot(p,new OpponentBot(p,new RandomBot(p)));
		board.init(p1, p2);
		run(board);
	}
	
}
