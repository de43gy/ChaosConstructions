package gameobject;

import java.awt.Polygon;

import engine.Constants;
import engine.SpaceEngine;

public class EnemiesShip extends SpaceShip implements Constants{
	private Polygon polygon;
	private int [] enemiesShipX;
	private int [] enemiesShipY;
	
	public EnemiesShip(int x, int y) {
		enemiesShipX = new int[4];
		enemiesShipX[0] =x-shipWidth/2;
		enemiesShipX[1] =x+shipWidth/2;
		enemiesShipX[2] =x+shipWidth/2;
		enemiesShipX[3] =x-shipWidth/2;
		enemiesShipY = new int[4];
		enemiesShipY[0] =y-shipHeight/2;
		enemiesShipY[1] =y-shipHeight/2;
		enemiesShipY[1] =y+shipHeight/2;
		enemiesShipY[1] =y+shipHeight/2;
		polygon = new Polygon(enemiesShipX, enemiesShipY, 4);
	}
	
}
