package model;

import java.util.Scanner;

public class HumanPlayer implements P4Player {
	
	@Override
	public int play(P4BoardItf board) {
		Scanner sc = new Scanner(System.in);
		int position = -1;
		while (!board.isFree(position)) {
			System.out.println("Enter column :");
			try {
				String str = sc.nextLine();
				position = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.println("Bad width value");
			}
		}
		//sc.close();
		return position;
	}
	
	

}
