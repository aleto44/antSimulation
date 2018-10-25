package antSim;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class NoDiagSimulation extends GameSimulation
{

	NoDiagSimulation(Ant ant1, Ant ant2)
	{
		super(ant1, ant2);
	}
	//true
	List<Point> findAvailableMoves(Ant ant, Boolean backwardsAllowed) 
	{
		List<Point> availableMoves = new ArrayList<Point>();

		for(int x = -1; x < 2; x++)
		{
			if(x+ant.getX() >= 0 && x+ant.getX() < 8 && x != 0)
			{
				if(!(ant.getX()+x == ant.lastPoint.x && ant.getY() == ant.lastPoint.y && !backwardsAllowed))
				{
					availableMoves.add(new Point(ant.getX() + x, ant.getY()));
				}
			}
		}
		
		for(int y = -1; y < 2; y++)
		{
			
			if(y+ant.getY() >= 0 && y+ant.getY() < 8 && y != 0)
			{
				if(!(ant.getX() == ant.lastPoint.x && ant.getY() + y == ant.lastPoint.y && !backwardsAllowed))
				{
					availableMoves.add(new Point(ant.getX(), ant.getY() + y));
				}
			}
		}

		return availableMoves;
	}
}
