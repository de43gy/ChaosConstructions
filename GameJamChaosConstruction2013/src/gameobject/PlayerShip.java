package gameobject;

import java.awt.Polygon;

import engine.Constants;

public class PlayerShip extends SpaceShip implements Constants {
	private int playerShipH =15; //Height ship
	private int playerShipW =10; //Width ship
	private int startPosicionY; 
	private int startPosicionX;
	private int centerX;
	private int [] playerShipY;
	private int [] playerShipX;
	private Polygon playersPolygon;

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
		centerX=startPosicionX;
		playersPolygon = new Polygon(playerShipX, playerShipY, 3);
	}
	
	public Polygon getShip(){
		return playersPolygon;
	}
	
	private void moveToX(){
		playersPolygon.xpoints[0] =centerX;
		playersPolygon.xpoints[1] =centerX+playerShipW/2;
		playersPolygon.xpoints[2] =centerX-playerShipW/2;
	}
	
	public void setNewPosition(int x){
		if (x<centerX){
			centerX-=SPEED_PLAYER_SPACESHIP;
			this.moveToX();
		}else if(x>centerX){
			centerX+=SPEED_PLAYER_SPACESHIP;
			this.moveToX();
		}
	}
}
