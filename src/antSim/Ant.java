package antSim;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Ant 
{
	private int x;
	private int y;
	private Board board;
	private Point lastPoint;
	
	Ant(Board board)
	{
		this.board = board;
		lastPoint = new Point(-1, -1);
	}
	
	public void randomMove(List<Point> availableMoves)
	{
		lastPoint = new Point(this.x, this.y);
		
		Random rand = new Random();
		int randomIndex = rand.nextInt(availableMoves.size());
		Point nextMoveCoordinate = availableMoves.get(randomIndex);
		setXY(nextMoveCoordinate.x, nextMoveCoordinate.y);
	}
	
	public Point getLastPoint()
	{
		return lastPoint;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	public void setCoordinatesLowerLeft()
	{
		this.x = this.y = 0;
	}
	public void setCoordinatesUpperRight()
	{
		this.x = this.y = this.board.getSideLength() - 1;
	}
	public void setLastPoint(int x, int y)
	{
		this.lastPoint = new Point(x, y);
	}
	
	public Board getBoard()
	{
		return this.board;
	}
	
	protected void setXY(int x, int y)
	{
		if(x >= 0 && x < board.getSideLength()) this.x = x;
		if(y >= 0 && y < board.getSideLength()) this.y = y;
	}
	

}
