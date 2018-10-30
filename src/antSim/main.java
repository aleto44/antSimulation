package antSim;

public class Main {

	public static void main(String[] args) {
		
		//using default constructors 
		SimulationCenter hub = new SimulationCenter();
		GameSimulation noDiag = new NoDiagSimulation();
		GameSimulation diag = new DiagSimulation();
		
		//adjust settings
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
