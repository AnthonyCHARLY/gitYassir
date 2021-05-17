package application.boxes;

import application.core.BoardItf;
import application.core.Box;
import application.core.DecoratorBox;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.UnitGroup;

public class FinalBossBox extends DecoratorBox {
	
	private UnitGroup army;

	public FinalBossBox(Box box) {
		super(box);
		// TODO Auto-generated constructor stub
		army = new UnitGroup("Boss");
		AgeAbstractFactory unitsFactory = new AgeMiddleFactory();
		army.addUnit(unitsFactory.infantryUnit("Boss:: infantry1"));
		army.addUnit(unitsFactory.riderUnit("Boss:: Rider1"));
		army.addUnit(unitsFactory.infantryUnit("Boss:: infantry2"));
		army.addUnit(unitsFactory.riderUnit("Boss:: Rider2"));
		
		army.addEquipment(unitsFactory.attackWeapon());
		army.addEquipment(unitsFactory.attackWeapon());
		army.addEquipment(unitsFactory.attackWeapon());
		army.addEquipment(unitsFactory.attackWeapon());
		
		army.addEquipment(unitsFactory.defenseWeapon());
		army.addEquipment(unitsFactory.defenseWeapon());
		army.addEquipment(unitsFactory.defenseWeapon());
		army.addEquipment(unitsFactory.defenseWeapon());
		
		System.out.println(army.getHealthPoints());
		System.out.println(army.strike());
		
	}
	
	@Override
	public void effect(BoardItf b) {
		box.effect(b);;
		b.fight(b.getCurrentPlayer().getArmy(), army);
		System.out.println(army.getHealthPoints());
		System.out.println(army.strike());
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Boss";
	}
	
	

}
