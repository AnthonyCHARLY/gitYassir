package model;

import java.util.Scanner;

public class HumanPlayer implements P4Player {
	
	private String _name;
	
	public HumanPlayer() {
		Scanner sc = new Scanner(System.in);
		String name = "";
		while (name.length() == 0) {
			System.out.println("Enter Name :");
			try {
				String str = sc.nextLine();
				name = str;
			} catch (Exception e) {
				System.out.println("Bad name value");
			}
		}
		_name = name;
	}

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

	@Override
	public String getName() {
		
		return _name;
	}
	
	

}
