import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Engine implements ActionListener{

	protected Window window;
	protected int x;
	protected int y;
	
	public Engine(Window window){
		this.window = window;
	}
	public void actionPerformed(ActionEvent arg0) {
		x = Integer.parseInt(window.getTextX());
		y = Integer.parseInt(window.getTextY());
		System.out.println("x="+x+", y="+y);
		window.moveTriangle(x, y);
		
	}

}
