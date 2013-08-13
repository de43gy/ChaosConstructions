package engine;

import java.awt.Polygon;

public class PlayerShip implements Constants {
	protected int playerShipH =15; //Height ship
	protected int playerShipW =10; //Width ship
	protected int startPosicionY; 
	protected int startPosicionX;
	protected int centerX;
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
		centerX=startPosicionX;
		playersPolygon = new Polygon(playerShipX, playerShipY, 3);
	}
	
	public Polygon getShip(){
		return playersPolygon;
	}
	
	protected void moveToX(){
		System.out.println("in PlayerShip(before): 0=" + playersPolygon.xpoints[0] + ", 1=" + playersPolygon.xpoints[1] + ", 2=" +playersPolygon.xpoints[2]);
		playersPolygon.xpoints[0] =centerX;
		playersPolygon.xpoints[1] =centerX+playerShipW/2;
		playersPolygon.xpoints[2] =centerX+playerShipW/2;
		System.out.println("in PlayerShip(after): 0=" + playersPolygon.xpoints[0] + ", 1=" + playersPolygon.xpoints[1] + ", 2=" +playersPolygon.xpoints[2]);
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
