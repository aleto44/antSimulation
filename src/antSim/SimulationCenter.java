package antSim;

public class SimulationCenter {
	
	SimulationCenter(){}
	
	public int runSimulationTileCollision(int runTimes, GameSimulation simulation, Boolean backwardsAllowed)
	{
		int totalTurns = 0;
		for(int i = 0; i < runTimes; i ++)
		{
			simulation.ant1.setCoordinatesLowerLeft();
			simulation.ant2.setCoordinatesUpperRight();
			while(!simulation.checkPositions())
			{
				simulation.bothMove(backwardsAllowed);
				totalTurns++;
			}
		}
		return totalTurns/runTimes;
	}
	
	//basically a copy of that, find way to change out method easily(in the while loop)
	public int runSimulationPathCollision(int runTimes, GameSimulation simulation, Boolean backwardsAllowed)
	{
		int totalTurns = 0;
		for(int i = 0; i < runTimes; i ++)
		{
			simulation.ant1.setCoordinatesLowerLeft();
			simulation.ant2.setCoordinatesUpperRight();
			while(!simulation.checkCrossing())
			{
				simulation.bothMove(backwardsAllowed);
				totalTurns++;
			}
		}
		return totalTurns/runTimes;
	}
	
}
