package main;


/**
 * Author : Anthony CHARLY AND Yassir DAOUDI.
 */

import model.BotAbstractFactory;
import model.HumanPlayer;
import model.Level1Bot;
import model.Level3Bot;
import model.P4BoardImpl;
import model.P4BoardItf;
import model.P4Player;
import ui.TxtBuilder;
import ui.P4Builder;
import ui.TxtBuilder;

public class P4Main {

	public static void run(P4BoardItf board, P4Builder builder) {
		System.out.println(board.toString());
		while (!board.isGameOver()) {
			
			System.out.println(board.getCurrentPlayer().getName() + " turn");
			board.play(board.getCurrentPlayer().play(board));
			board.builder(builder);
			System.out.println(((TxtBuilder) builder).getResult());
		}
		System.out.println(board);
	}

	public static void main(String argv[]) {
		P4BoardItf board = P4BoardImpl.createintance();

		BotAbstractFactory factory = new Level3Bot();
		BotAbstractFactory factory2 = new Level1Bot();
		//P4Player p1 = factory.create();
		P4Player p1 = new HumanPlayer();
		P4Player p2 = factory2.create();
		board.init(p1, p2);
		P4Builder builder = new TxtBuilder();

		run(board, builder);
	}

}
