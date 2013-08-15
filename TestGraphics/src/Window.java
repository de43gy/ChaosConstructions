import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Box.Filler;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class Window extends JPanel{

	protected Dimension preferredSize;
	protected int windowWidth;
	protected int windowHeight;
	protected Polygon polygon;
	protected int [] triangleX;
	protected int [] triangleY;
	protected JFrame frame;
	protected JTextField fieldX;
	protected JTextField fieldY;
	protected JButton button;
	protected Engine engine;
	
	
	public Window(){
		engine = new Engine(this);
		windowWidth =500;
		windowHeight =500;
		preferredSize =new Dimension(windowWidth, windowHeight);
		frame = new JFrame("Test window");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addPanelToFrame(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
		triangleX =new int[3];
		triangleY =new int[3];
		
		triangleX[0] =100;
		triangleX[1] =90;
		triangleX[2] =110;
		triangleY[0] =100;
		triangleY[1] =115;
		triangleY[2] =115;
		polygon =new Polygon(triangleX, triangleY, 3);
	}
	                 
	public Dimension getPreferredSize(){
		return preferredSize;
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
		
		
		g.setColor(Color.BLUE);
		System.out.println("fillpolygon.xpoints[0]="+polygon.xpoints[0]);
		System.out.println("fillpolygon.xpoints[1]="+polygon.xpoints[1]);
		System.out.println("fillpolygon.xpoints[2]="+polygon.xpoints[2]);
		System.out.println("fillpolygon.ypoints[0]="+polygon.ypoints[0]);
		System.out.println("fillpolygon.ypoints[1]="+polygon.ypoints[1]);
		System.out.println("fillpolygon.ypoints[2]="+polygon.ypoints[2]);
		System.out.println("fillpolygon.npoints="+polygon.npoints);
		g.fillPolygon(polygon);
	}
	
	public void addPanelToFrame(Container container){
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(this);
		fieldX =new JTextField("200");
		container.add(fieldX);
		fieldY =new JTextField("200");
		container.add(fieldY);
		button =new JButton("Ok");
		button.addActionListener(engine);
		container.add(button);
	
	
	
	}
	
	public void setTextX(String text){
		fieldX.setText(text);
	}
	
	public void setTextY(String text){
		fieldY.setText(text);
	}
	
	public String getTextX(){
		return fieldX.getText();
	}
	
	public String getTextY(){
		return fieldY.getText();
	}
	
	public void moveTriangle(int x, int y){
		
		System.out.println("polygon.npoints="+polygon.npoints);
		polygon.reset();
		System.out.println("polygon.npoints="+polygon.npoints);
		polygon.npoints = 3;
		polygon.xpoints[0] =x;
		System.out.println("polygon.xpoints[0]="+polygon.xpoints[0]);
		polygon.xpoints[1] =x+10;
		System.out.println("polygon.xpoints[1]="+polygon.xpoints[1]);
		polygon.xpoints[2] =x-10;
		System.out.println("polygon.xpoints[2]="+polygon.xpoints[2]);
		polygon.ypoints[0] =y;
		System.out.println("polygon.ypoints[0]="+polygon.ypoints[0]);
		polygon.ypoints[1] =y+15;
		System.out.println("polygon.ypoints[1]="+polygon.ypoints[1]);
		polygon.ypoints[2] =y+15;
		System.out.println("polygon.ypoints[2]="+polygon.ypoints[2]);
		System.out.println("polygon.npoints="+polygon.npoints);
		System.out.println("repaint?");
		this.repaint();
	}
}
