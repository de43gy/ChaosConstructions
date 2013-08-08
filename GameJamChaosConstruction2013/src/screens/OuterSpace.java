package screens;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import engine.SpaceEngine;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class OuterSpace extends JPanel implements Constants{
	JLabel label;
	public Point point = new Point(0,0);
	int spaceship =10;
	
	Dimension preferredSize= new Dimension(SPASE_WIDTH,SPASE_HEIGHT);
	public Dimension getPreferredSize(){
		return preferredSize;
	}
	
	OuterSpace(){
		SpaceEngine spaceEngine = new SpaceEngine(this);
		addMouseListener(spaceEngine);
		addMouseMotionListener(spaceEngine);
	}
	
	void addPanelToFrame(Container container){
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(this);
		label = new JLabel("Click to see coordinates");
		container.add(label);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		
		
		g.fillRect(0, 0, SPASE_WIDTH, SPASE_HEIGHT);
		g.setColor(Color.YELLOW);
		
		g.fillRect(SPACE_SHIP_START_X, spaceship, 5, 30);
		g.setColor(Color.BLUE);
		
		g.fillOval(25,110,10,10);
		g.setColor(Color.white);
		
		g.drawRect(10,10,300,200);
		g.drawLine(160,10,160,210);
		
		if (point != null) {
			label.setText("Coordinates (x,y): " + point.x +
			", " + point.y);
			g.fillRect(point.x, point.y, 2, 2);
			}
		
		
	}
	
	public void setSpaceship_Y(int xCoordinate){
		this.spaceship = xCoordinate;
		}
	
	public int getSpaceship_Y(int xCoordinate){
		return spaceship;
		}
			
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Ping Pong Green Table");
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		OuterSpace space = new OuterSpace();
		space.addPanelToFrame(f.getContentPane());
		
		f.pack();
		f.setVisible(true);
		}
	
	
	
	
}