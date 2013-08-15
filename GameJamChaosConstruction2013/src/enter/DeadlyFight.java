package enter;
//java packages
import java.util.concurrent.TimeUnit;


//game packages
import screens.OuterSpace;
import engine.CollectorWaves;
import engine.Constants;
import engine.EnemiesWaves;
import engine.SpaceEngine;
import gameobject.PlayerShip;

public class DeadlyFight implements Constants {
	/*
	 * Variables
	 */
	//Objects
	private SpaceEngine engine;
	private OuterSpace space;
	private Thread gameSpeed;
	private PlayerShip playerShip;
	private CollectorWaves collectorWaves;
	private EnemiesWaves enemiesWaves;
	//Mouse coordinates
	private int xPositionOld =0;
	private int xPositionNew =0;
	private int xPositionCentr =250;
	//Other
	private int xSpeed =1;
	private int counter =0;
	private int denominator=1;
	private boolean gamePause=true;
	
	DeadlyFight(){
		space = new OuterSpace(this);
		engine =space.getEngine();
		collectorWaves = new CollectorWaves();
		
	}
	public void startTime(){
		playerShip =new PlayerShip();
		space.placeNewShips(playerShip.getShip());
		enemiesWaves = (collectorWaves.createWaves(0));
		while (gamePause) {
			space.setTextToField(""+counter);
			try {
				TimeUnit.MILLISECONDS.sleep(SPACE_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//game cycle
			xPositionNew =engine.getMouseXPosition();
			playerShip.setNewPosition(xPositionNew);
			//check out: wave created and, if so, whether there is someone in it
			//esli eto ne proydet - cikl, proveraushiy po ocheredi vse yacheyki massiva
			if(enemiesWaves!=null && enemiesWaves.getArraySize()>0){
				
			}
			space.repaint();
			//space.repaintAll();
			counter+=denominator;
		}
	}
	
	public void setPauseOn(){
		gamePause =false;
	}
	public void setPauseOff(){
		gamePause =true;
	}

	public static void main(String[] args){
		
		DeadlyFight fight =new DeadlyFight();
		fight.startTime();

}
}
