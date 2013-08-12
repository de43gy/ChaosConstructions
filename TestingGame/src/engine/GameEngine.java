package engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import windows.MainWindow;

public class GameEngine implements MouseListener, MouseMotionListener{
	
	MainWindow mainWindow;
	static int xOld =0;
	static int xNew =0;
	static int xBuffer =250;
	static boolean mouseOn =false;
	
	public GameEngine(MainWindow mainWindow){
		this.mainWindow = mainWindow;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//mainWindow.setTextToField(e.getX() + " " + e.getY());
		xNew=e.getX();
			
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		mouseOn =true;
		/*
		if (xOld!=0){
			if (xNew>xOld){
				mainWindow.setRightX();
				xOld=xNew;
			}else{
				mainWindow.setLeftX();
				xOld=xNew;
			}
		}else{
			xOld=xNew;
		}
		*/
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseOn =false;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getMouseOn(){
		return mouseOn;
	}
	
	public int getMouseXPosition(){
		return xNew;
	}

}
