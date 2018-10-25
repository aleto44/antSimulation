package antSim;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Ant 
{
	private int x;
	private int y;
	
	Point lastPoint = new Point(-1, -1);
	
	Ant(){}
	
	Ant(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void randomMove(List<Point> availableMoves)
	{
		lastPoint = new Point(this.x, this.y);
		
		Random rand = new Random();
		int randomIndex = rand.nextInt(availableMoves.size());
		Point nextMoveCoordinate = availableMoves.get(randomIndex);
		setXY(nextMoveCoordinate.x, nextMoveCoordinate.y);
	}
	public Point getLowerRectPathPoint()
	{
		Point lowerPoint = new Point((int)Math.min(this.getX(), this.lastPoint.getX()), (int)Math.min(this.getY(), this.lastPoint.getY()));
		return lowerPoint;
	}
	public Point getUpperRectPathPoint()
	{
		Point upperPoint = new Point((int)Math.max(this.getX(), this.lastPoint.getX()), (int)Math.max(this.getY(), this.lastPoint.getY()));
		return upperPoint;
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
		this.x = this.y = 7;
	}
	
	private void setXY(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	

}
