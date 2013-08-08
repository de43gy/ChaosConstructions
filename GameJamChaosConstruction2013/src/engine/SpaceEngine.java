package engine;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import screens.Constants;
import screens.OuterSpace;

public class SpaceEngine implements MouseListener, MouseMotionListener, Constants{
	OuterSpace space;
	public int spaceship_Y = SPACE_SHIP_START_X;
	
	SpaceEngine(OuterSpace space){
		this.space =space;
	}
	
	
	
	public SpaceEngine(Object o){
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e.getX() + "è" + e.getY());
		space.point.x = e.getX();
		space.point.y = e.getY();
		
		space.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
