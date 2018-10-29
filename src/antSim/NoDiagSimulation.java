package antSim;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class NoDiagSimulation extends GameSimulation
{

	NoDiagSimulation(Board board, Ant ant1, Ant ant2)
	{
		super(board,ant1, ant2);
	}
	NoDiagSimulation()
	{
		super();
	}

	
	List<Point> findAvailableMoves(Ant ant, Boolean backwardsAllowed) 
	{
		List<Point> availableMoves = new ArrayList<Point>();

		for(int x = -1; x < 2; x++)
		{
			if(x+ant.getX() >= 0 && x+ant.getX() < ant.getBoard().getSideLength() && x != 0)
			{
				if(!(ant.getX()+x == ant.getLastPoint().x && ant.getY() == ant.getLastPoint().y && !backwardsAllowed))
				{
					availableMoves.add(new Point(ant.getX() + x, ant.getY()));
				}
			}
		}
		
		for(int y = -1; y < 2; y++)
		{
			
			if(y+ant.getY() >= 0 && y+ant.getY() < ant.getBoard().getSideLength() && y != 0)
			{
				if(!(ant.getX() == ant.getLastPoint().x && ant.getY() + y == ant.getLastPoint().y && !backwardsAllowed))
				{
					availableMoves.add(new Point(ant.getX(), ant.getY() + y));
				}
			}
		}

		return availableMoves;
	}
}
