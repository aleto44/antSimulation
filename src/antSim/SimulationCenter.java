package antSim;

public class SimulationCenter {
	
	SimulationCenter(){}
	
	public int runSimulationTileCollision(int runTimes, GameSimulation simulation, Boolean backwardsAllowed)
	{
		int totalTurns = 0;
		for(int i = 0; i < runTimes; i ++)
		{
			long startTime = System.currentTimeMillis();
			simulation.resetSimulation();
			while(!simulation.checkPositions())
			{
				simulation.bothMove(backwardsAllowed);
				totalTurns++;
				if(System.currentTimeMillis() - startTime > runTimes/10 + 5000) return -1;
			}
		}
		return totalTurns/runTimes;
	}
	
	//basically a copy, find way to change out while loop verify
	public int runSimulationPathCollision(int runTimes, GameSimulation simulation, Boolean backwardsAllowed)
	{
		int totalTurns = 0;
		for(int i = 0; i < runTimes; i ++)
		{	
			simulation.resetSimulation();
			long startTime = System.currentTimeMillis();
			while(!simulation.checkCrossing())
			{
				simulation.bothMove(backwardsAllowed);
				totalTurns++;
				if(System.currentTimeMillis() - startTime > runTimes/100 + 1000) return -1;
			}
		}
		return totalTurns/runTimes;
	}
	
}
