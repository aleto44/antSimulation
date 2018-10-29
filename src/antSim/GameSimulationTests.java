package antSim;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameSimulationTests {

	static Board board;
	static Ant ant1;
	static Ant ant2;
	static GameSimulation simulation;
	
	@BeforeClass
	public static void testSetup() 
	{
		board = new Board(3);
		ant1 = new Ant(board);
		ant2 = new Ant(board);
		simulation = new NoDiagSimulation(board, ant1, ant2);
		
	}
	  
	@Test
	public void checkPositionTest() 
	{
		ant1.setXY(1, 1);
		ant2.setXY(1, 1);
		Assert.assertEquals(true, simulation.checkPositions());
		ant2.setXY(2, 2);
		Assert.assertEquals(false, simulation.checkPositions());
	}
	
	@Test
	public void checkCrossingTest() 
	{
		ant1.setXY(1, 1);
		ant1.setLastPoint(2, 2);
		ant2.setXY(2, 2);
		ant2.setLastPoint(1, 1);
		Assert.assertEquals(true, simulation.checkCrossing());
		ant2.setLastPoint(0, 0);
		Assert.assertEquals(false, simulation.checkCrossing());
	}
	@Test
	public void setLowerLeftTest() 
	{
		ant1.setCoordinatesLowerLeft();
		Assert.assertEquals(ant1.getX(), 0);
		Assert.assertEquals(ant1.getY(), 0);
	}
	@Test
	public void setUpperRightTest() 
	{
		ant1.setCoordinatesUpperRight();
		Assert.assertEquals(ant1.getX(), ant1.getBoard().getSideLength()-1);
		Assert.assertEquals(ant1.getY(), ant1.getBoard().getSideLength()-1);
	}
	
	
	
	

}
