package engine;
//java packages
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//game packages
import screens.OuterSpace;
import enter.DeadlyFight;

public class SpaceEngine implements MouseListener, MouseMotionListener{
	
	private DeadlyFight deadlyFight;
	private OuterSpace space;
	private int xOld =0;
	private int xNew =0;
	private int xBuffer =250;
	
	public SpaceEngine(OuterSpace space, DeadlyFight deadlyFight){
		this.space =space;
		this.deadlyFight =deadlyFight;
	}

	public void mouseMoved(MouseEvent e) {
		xNew=e.getX();
	}
	
	public void getMouseOn(){
		deadlyFight.setPauseOff();
	}
	
	public int getMouseXPosition(){
		return xNew;
	}
	
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	
	


}
