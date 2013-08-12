package enter;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import engine.GameEngine;
import engine.TimeCounter;

import windows.MainWindow;


public class StartTest {
	
	public static void main(String[] args) {
		
		GameEngine engine;
		int xPositionOld =0;
		int xPositionNew =0;
		int xPositionCentr =250;
		int xSpeed =1;
		boolean mouseOn =false;
		TimeCounter counter = new TimeCounter();
		Thread worker = new Thread(counter);
	    worker.start();  // вызывает метод run()
	    MainWindow window = new MainWindow(counter);
		engine =window.getEngine();
		boolean i =true;
		window.enemyShipValidatorX();
		while(i){
			xPositionNew =engine.getMouseXPosition();
			mouseOn =engine.getMouseOn();
			window.goEnemiesDown();
				if (xPositionNew>xPositionCentr){
					while(xPositionNew>xPositionCentr){
						//System.out.println("Go to right: xPositionCentr="+xPositionCentr+" xPositionNew="+xPositionNew);
						xPositionCentr+=xSpeed;
						window.setRightX(xPositionCentr);
						xPositionNew =engine.getMouseXPosition();
					}
					
				}else if(xPositionNew<xPositionCentr){
					while(xPositionNew<xPositionCentr){
						//System.out.println("Go to left: xPositionCentr="+xPositionCentr+" xPositionNew="+xPositionNew);
						xPositionCentr-=xSpeed;
						window.setRightX(xPositionCentr);
						xPositionNew =engine.getMouseXPosition();
					}
				}else{
					//System.out.println("Stop_position: xPositionOld="+xPositionOld+" xPositionNew="+xPositionNew);
					xPositionNew =engine.getMouseXPosition();
					window.setRightX(xPositionCentr);
				}
			
		}

	}


}
