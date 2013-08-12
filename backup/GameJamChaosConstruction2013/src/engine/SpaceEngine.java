package engine;
//java packages
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//game packages
import screens.OuterSpace;
import enter.DeadlyFight;

public class SpaceEngine implements MouseListener, MouseMotionListener{
	
	DeadlyFight deadlyFight;
	OuterSpace space;
	static int xOld =0;
	static int xNew =0;
	static int xBuffer =250;
	
	public SpaceEngine(OuterSpace space, DeadlyFight deadlyFight){
		this.space =space;
		this.deadlyFight =deadlyFight;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		xNew=e.getX();
			
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		deadlyFight.setPauseOff();

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		deadlyFight.setPauseOn();
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		
	}
	
	public void getMouseOn(){
		deadlyFight.setPauseOff();
	}
	
	public int getMouseXPosition(){
		
		return xNew;
	}

}
