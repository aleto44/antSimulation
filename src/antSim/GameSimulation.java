package antSim;

import java.awt.Point;
import java.util.List;

public abstract class GameSimulation 
{

	Ant ant1;
	Ant ant2;
	
	GameSimulation(Ant ant1, Ant ant2)
	{
		this.ant1 = ant1;
		this.ant2 = ant2;
	}
	
	public void bothMove(Boolean backwardAllowed)
	{
		ant1.randomMove(findAvailableMoves(ant1, backwardAllowed));
		ant2.randomMove(findAvailableMoves(ant2, backwardAllowed));
	}
	
	public boolean checkPositions()
	{
		return ant1.getX() == ant2.getX() && ant1.getY() == ant2.getY();
	}
	//treats the last tile and current tile of ants movement as a rectangle, sees if two ants share a rectangle.
	public boolean checkCrossing()
	{
		return ant1.getLowerRectPathPoint().equals(ant2.getLowerRectPathPoint()) && ant1.getUpperRectPathPoint().equals(ant2.getUpperRectPathPoint());
	}
	
	abstract List<Point> findAvailableMoves(Ant ant, Boolean backwardsAllowed);

}
