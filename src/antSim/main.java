package antSim;

public class main {

	public static void main(String[] args) {
		//TODO: make unit tests
		//make path crossing method
		//add path crossing sim type into sim center
		
		SimulationCenter hub = new SimulationCenter();
		
		Ant ant1 = new Ant();
		Ant ant2 = new Ant();
		GameSimulation noDiag = new NoDiagSimulation(ant1, ant2);
		GameSimulation diag = new DiagSimulation(ant1, ant2);
		
		int runTimes = 10000;
		boolean backwardsAllowed = true;
		System.out.println("Avg moves for two ants to collide in " + runTimes + " trials");
		
		System.out.println("Tile Collision No Diag: " + hub.runSimulationTileCollision(runTimes, noDiag, backwardsAllowed));
		System.out.println("Tile Collision No Diag No Backwards Moves: " + hub.runSimulationTileCollision(runTimes, noDiag, !backwardsAllowed));
		System.out.println("Tile Collision Diag: " + hub.runSimulationTileCollision(runTimes, diag, backwardsAllowed));
		System.out.println("Tile Collision Diag No Backwards Moves: " + hub.runSimulationTileCollision(runTimes, diag, !backwardsAllowed));
		System.out.println();
		System.out.println("Path Collision No Diag: " + hub.runSimulationPathCollision(runTimes, noDiag, backwardsAllowed));
		System.out.println("Path Collision No Diag No Backwards Moves: " + hub.runSimulationPathCollision(runTimes, noDiag, !backwardsAllowed));
		System.out.println("Path Collision Diag: " + hub.runSimulationPathCollision(runTimes, diag, backwardsAllowed));
		System.out.println("Path Collision Diag No Backwards Moves: " + hub.runSimulationPathCollision(runTimes, diag, !backwardsAllowed));
		
	}

}
