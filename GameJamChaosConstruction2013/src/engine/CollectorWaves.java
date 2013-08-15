package engine;

import gameobject.SpaceShip;

public class CollectorWaves {
	private int numWaves;
	private EnemiesWaves enemiesWaves;
	
	public EnemiesWaves createWaves(int numWaves){
		this.numWaves = numWaves;
		enemiesWaves = new EnemiesWaves();
		return enemiesWaves;
	}

}
