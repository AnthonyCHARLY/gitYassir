package soldier.core;

public interface UnitVisitor {
	
	void visit(UnitGroup unitGroup);
	void visit(UnitInfantry infantry);
	void visit(UnitRider rider);
	
	
	

}
