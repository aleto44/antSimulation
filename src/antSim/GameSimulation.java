package antSim;

import java.awt.Point;
import java.util.List;

public abstract class GameSimulation 
{

	private Board board;
	private Ant ant1;
	private Ant ant2;
	
	GameSimulation(Board board, Ant ant1, Ant ant2)
	{
		this.board = board;
		this.ant1 = ant1;
		this.ant2 = ant2;
	}
	
	GameSimulation()
	{
		this.board = new Board();
		this.ant1 = new Ant(this.board);
		this.ant2 = new Ant(this.board);
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

	public boolean checkCrossing()
	{
		return (ant1.getX() == ant2.getLastPoint().x) && (ant1.getY() == ant2.getLastPoint().y) && (ant1.getLastPoint().x == ant2.getX()) && (ant1.getLastPoint().y == ant2.getY());
	}
	
	public void resetSimulation()
	{
		ant1.setCoordinatesLowerLeft();
		ant2.setCoordinatesUpperRight();
		ant1.setLastPoint(-1,-1);
		ant2.setLastPoint(-1,-1);
	}
	
	public Board getBoard()
	{
		return this.board;
	}
	
	abstract List<Point> findAvailableMoves(Ant ant, Boolean backwardsAllowed);

}
