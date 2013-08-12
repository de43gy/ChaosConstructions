package enter;
//java packages
import java.util.concurrent.TimeUnit;
//game packages
import screens.OuterSpace;
import engine.PlayerShip;
import engine.SpaceEngine;

public class DeadlyFight {
	/*
	 * Variables
	 */
	//Objects
	protected SpaceEngine engine;
	protected OuterSpace space;
	protected Thread gameSpeed;
	protected PlayerShip playerShip;
	//Mouse coordinates
	protected int xPositionOld =0;
	protected int xPositionNew =0;
	protected int xPositionCentr =250;
	//Other
	protected int xSpeed =1;
	protected int counter =0;
	protected int timeSpeed =5;
	protected int denominator=1;
	protected boolean gamePause=true;
	
	DeadlyFight(){
		space = new OuterSpace(this);
		engine =space.getEngine();
		
	}
	public void startTime(){
		space.enemyShipValidatorX();
		playerShip =new PlayerShip();
		space.placeNewShips(playerShip.getShip());
		while (gamePause) {
			space.setTextToField(""+counter);
			try {
				TimeUnit.MILLISECONDS.sleep(timeSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//game cycle
			xPositionNew =engine.getMouseXPosition();
			if (xPositionNew>xPositionCentr){
				xPositionCentr+=xSpeed;
				space.setRightX(xPositionCentr);
				xPositionNew =engine.getMouseXPosition();				
			}else if(xPositionNew<xPositionCentr){
					xPositionCentr-=xSpeed;
					space.setRightX(xPositionCentr);
					xPositionNew =engine.getMouseXPosition();
			}else{
				xPositionNew =engine.getMouseXPosition();
				space.setRightX(xPositionCentr);
			}
			counter+=denominator;
		}
	}
	
	public void setPauseOn(){
		gamePause =false;
	}
	public void setPauseOff(){
		gamePause =true;
	}

	public static void main(String[] args) {
		
		DeadlyFight fight =new DeadlyFight();
		fight.startTime();

}
}
