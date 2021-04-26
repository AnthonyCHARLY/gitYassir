/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package test;

import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;
import soldier.core.UnitInfantry;
import soldier.core.UnitRider;
import soldier.core.UnitVisitor;


class VisitorAffiche implements UnitVisitor{

	@Override
	public void visit(UnitGroup unitGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnitInfantry infantry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnitRider rider) {
		System.out.println("Visitor ========> : "+rider.getName());
	}
	
}
class VisitorCountNbSoldier implements UnitVisitor{
	
	int res = 0;
	
	@Override
	public void visit(UnitGroup unitGroup) {
		 while (unitGroup.subUnits().hasNext())
			 res++;
	}

	@Override
	public void visit(UnitInfantry infantry) {
		res = 1;
	}

	@Override
	public void visit(UnitRider rider) {
		res = 1;
	}
	
}

public class MainFightTwoAges {

	public static Unit createTeam(AgeAbstractFactory fact, String prefix)  {
		UnitGroup sg = new UnitGroup(prefix + "Animals");
		UnitGroup bl  = new UnitGroup(prefix + "Worms");
		bl.addUnit(fact.infantryUnit(prefix + "nicky"));
		bl.addUnit(fact.infantryUnit(prefix + "tomy"));
		sg.addUnit(bl);
		bl.addEquipment(fact.attackWeapon());
		bl.addEquipment(fact.defenseWeapon());
		bl.addEquipment(fact.attackWeapon());
		UnitGroup pig = new UnitGroup(prefix + "Pigs");
		pig.addUnit(fact.riderUnit(prefix + "jenny"));
		pig.addUnit(fact.riderUnit(prefix + "kenny"));
		sg.addUnit(pig);
		pig.addEquipment(fact.defenseWeapon());
		pig.addEquipment(fact.defenseWeapon());
		pig.addEquipment(fact.attackWeapon());
		return sg;
	}
	
	public static void main(String[] args) {

		AgeAbstractFactory age1 = new AgeMiddleFactory();
		AgeAbstractFactory age2 = new AgeFutureFactory();

		Unit team1 = createTeam(age1, "Team1::"); 
		Unit team2 = createTeam(age2, "Team2::"); 
		
		UnitVisitor v = new VisitorAffiche();
		team1.accept(v);
		
		

		int round = 0;
		while(team1.alive() && team2.alive()) {
			System.out.println("Round  #" + round++);
			float st1 = team1.strike();
			System.out.println(team1.getName() + " attack with force : " + st1);
			team2.parry(st1);
			float st2 = team2.strike();
			System.out.println(team2.getName() + " attack with force : " + st2);
			team1.parry(st2);
		}
		System.out.println("The end ... " + (team1.alive() ? team1.getName() : team2.getName()) + " won." );
	}

}
