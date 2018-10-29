package antSim;

public class SimulationCenter {
	
	SimulationCenter(){}
	
	public int runSimulationTileCollision(int runTimes, GameSimulation simulation, Boolean backwardsAllowed)
	{
		long startTime = System.currentTimeMillis();
		int totalTurns = 0;
		for(int i = 0; i < runTimes; i ++)
		{
			simulation.resetSimulation();
			while(!simulation.checkPositions())
			{
				simulation.bothMove(backwardsAllowed);
				totalTurns++;
				if(System.currentTimeMillis() - startTime > 10000) return -1;
			}
		}
		return totalTurns/runTimes;
	}
	
	//basically a copy, find way to change out while loop verify
	public int runSimulationPathCollision(int runTimes, GameSimulation simulation, Boolean backwardsAllowed)
	{
		long startTime = System.currentTimeMillis();
		int totalTurns = 0;
		for(int i = 0; i < runTimes; i ++)
		{	
			simulation.resetSimulation();
			while(!simulation.checkCrossing())
			{
				simulation.bothMove(backwardsAllowed);
				totalTurns++;
				if(System.currentTimeMillis() - startTime > 10000) return -1;
			}
		}
		return totalTurns/runTimes;
	}
	
}
