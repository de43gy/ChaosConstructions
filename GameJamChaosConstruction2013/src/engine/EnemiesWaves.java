package engine;

import gameobject.SpaceShip;

public class EnemiesWaves {
	private int sizeArrays;
	private SpaceShip [] spaceShip;
	
	public void createEnemiesWaves(int sizeArrays){
		this.sizeArrays = sizeArrays;
		spaceShip = new SpaceShip[sizeArrays];
	}
	
	public void addSpaceshipToWaves(int numSpaceship, SpaceShip spaceShip){
		this.spaceShip[numSpaceship] =spaceShip;
	}
	
	public int getArraySize(){
		return spaceShip.length;
	}

}
