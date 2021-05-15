package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class MalusBoxFight extends DecoratorBox{
	
	private UnitGroup army;
	
	public MalusBoxFight(Box decoratorbox) {
		super(decoratorbox);
		// TODO Auto-generated constructor stub
		resetArmy();
		
	}
	
	@Override
	public void effect(BoardItf b) {
		
		box.effect(b);
		b.fight(b.getCurrentPlayer().getArmy(), army);
		if(!army.alive()) {resetArmy();}
		
	}
	
	public void resetArmy() {
		AgeAbstractFactory unitsFactory = new AgeMiddleFactory();
		army.addUnit(unitsFactory.infantryUnit("Ai:: infantry"));
		army.addUnit(unitsFactory.riderUnit("Ai:: infantry"));
	}
	
	
	

}
