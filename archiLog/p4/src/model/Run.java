package model;

public class Run {

    public static void run(P4BoardItf board) {

        while(!board.isGameOver()) {
            System.out.println(board);
            System.out.println("Player " + board.getCurrentPlayer() +  " turn");
            board.play(board.getCurrentPlayer().play(board));
        }

        System.out.println(board);
    }
}