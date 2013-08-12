package engine;

import java.awt.Polygon;

public class PlayerShip implements Constants {
	protected int playerShipH =15; //Height ship
	protected int playerShipW =10; //width ship
	protected int startPosicionY;
	protected int startPosicionX;
	protected int [] playerShipY;
	protected int [] playerShipX;
	protected Polygon playersPolygon;

	public PlayerShip(){
		startPosicionY =SPACE_HEIGHT-(10+playerShipH);
		startPosicionX =SPACE_WIDTH/2;
		playerShipX = new int[3];	
		playerShipX[0] =startPosicionX;
		playerShipX[1] =startPosicionX+playerShipW/2;
		playerShipX[2] =startPosicionX-playerShipW/2;
		playerShipY = new int[3];
		playerShipY[0] =startPosicionY-playerShipH/2;
		playerShipY[1] =startPosicionY+playerShipH/2;
		playerShipY[2] =startPosicionY+playerShipH/2;
		
		playersPolygon = new Polygon(playerShipX, playerShipY, 3);
	}
	
	public Polygon getShip(){
		return playersPolygon;
	}
	
	public void getNewPosicion(int x, int y){
	
	}
}
