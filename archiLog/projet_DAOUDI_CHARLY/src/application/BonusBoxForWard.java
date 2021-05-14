package application;

import java.util.Random;

public class BonusBoxForWard extends DecoratorBox{

	public BonusBoxForWard(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void effect(PlayerItf player) {
		// TODO Auto-generated method stub
		int bonus =2;
		box.effect(player);
		Random rand = null;
		player.forward(rand.nextInt((5 - 3) + 1) + 3);
		
	}

	public void description() {
		// TODO Auto-generated method stub
		box.description();
	}

}
