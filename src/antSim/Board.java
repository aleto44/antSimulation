package antSim;

public class Board {

	private int sideLength;
	
	Board()
	{
		this.sideLength = 8;
	}
	
	Board(int sideLength)
	{
		this.sideLength = sideLength;
	}
	
	public int getSideLength()
	{
		return sideLength;
	}
}
