package antSim;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;


public class AvailableMovesTests {
	
	static GameSimulation noDiag;
	static GameSimulation diag;
	static Board board;
	static Ant ant;
	
	@BeforeClass
	public static void testSetup() 
	{
		
		noDiag = new NoDiagSimulation();
		diag = new DiagSimulation();
		board = new Board(3);
		ant = new Ant(board);
		ant.setXY(1, 1);
		ant.setLastPoint(1,0);
	}
	  
	@Test
	public void noDiagonalBackwardsMovementAllowedFindAvailableMovesTest() 
	{
		List<Point> expectedMoves = new ArrayList<Point>();
		expectedMoves.add(new Point(0,1));
		expectedMoves.add(new Point(2,1));
		expectedMoves.add(new Point(1,0));
		expectedMoves.add(new Point(1,2));
		List<Point> actualMoves = noDiag.findAvailableMoves(ant, true);
		Assert.assertEquals(expectedMoves, actualMoves);
	}
	
	@Test
	public void noDiagonalNoBackwardsFindAvailableMovesTest() {
		List<Point> expectedMoves = new ArrayList<Point>();
		expectedMoves.add(new Point(0,1));
		expectedMoves.add(new Point(2,1));
		expectedMoves.add(new Point(1,2));
		List<Point> actualMoves = noDiag.findAvailableMoves(ant, false);
		Assert.assertEquals(expectedMoves, actualMoves);
	}
	@Test
	public void diagonalAllowedBackwardsMovementAllowedFindAvailableMovesTest() {
		List<Point> expectedMoves = new ArrayList<Point>();
		expectedMoves.add(new Point(0,0));
		expectedMoves.add(new Point(0,1));
		expectedMoves.add(new Point(0,2));
		expectedMoves.add(new Point(1,0));
		expectedMoves.add(new Point(1,2));
		expectedMoves.add(new Point(2,0));
		expectedMoves.add(new Point(2,1));
		expectedMoves.add(new Point(2,2));
		List<Point> actualMoves = diag.findAvailableMoves(ant, true);
		Assert.assertEquals(expectedMoves, actualMoves);
	}
	@Test
	public void diagonalAllowedNoBackwardsFindAvailableMovesTest() {
		List<Point> expectedMoves = new ArrayList<Point>();
		expectedMoves.add(new Point(0,0));
		expectedMoves.add(new Point(0,1));
		expectedMoves.add(new Point(0,2));
		expectedMoves.add(new Point(1,2));
		expectedMoves.add(new Point(2,0));
		expectedMoves.add(new Point(2,1));
		expectedMoves.add(new Point(2,2));
		List<Point> actualMoves = diag.findAvailableMoves(ant, false);
		Assert.assertEquals(expectedMoves, actualMoves);
	}
}
