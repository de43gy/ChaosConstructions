package windows;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import engine.GameEngine;
import engine.TimeCounter;

public class MainWindow extends JPanel implements Runnable{
	
	protected int windowWidth =500;
	protected int windowHeigth =500;
	//repaint x
	protected int centerOfShip =250;
	int [] hullX = { centerOfShip-10, centerOfShip-5, centerOfShip-1, centerOfShip+1, centerOfShip+5, centerOfShip+10, centerOfShip+1, centerOfShip-1};
	protected int cockpitX =centerOfShip-8;
	//int [] rightWingX = {240, 230, 190, 190, 235, 244};
	int [] rightWingX = {centerOfShip-10, centerOfShip-20, centerOfShip-60, centerOfShip-60, centerOfShip-15, centerOfShip-6};
	//int [] leftWingX = { 259, 269, 309, 309, 264, 256};
	int [] leftWingX = { centerOfShip+9, centerOfShip+19, centerOfShip+59, centerOfShip+59, centerOfShip+14, centerOfShip+6};
	//enemy
	int enemyCenterX;
	int enemyCenterY;
	int [] enemyShipX = new int [4]; // = { enemyCenterX-10, enemyCenterX+10, enemyCenterX+10, enemyCenterX-10};
	int [] enemyShipY = { enemyCenterY+10, enemyCenterY+10, enemyCenterY-10, enemyCenterY-10};
	Polygon[] enemiesEscadra;
	int level =3;
	int enemiesNum =0;
	int count =0;
	
	
	protected int speed=2;
	protected JTextField textField;
	protected JButton button;
	protected JPanel panel;
	protected JFrame frame;

	protected Container container;
	GameEngine engine;
	TimeCounter counter;

	protected Dimension preferredSize = new Dimension(500, 500);
	public Dimension getPreferredSize(){
		return preferredSize;
	}

	public MainWindow(TimeCounter counter){
		
		engine = new GameEngine(this);
		this.counter =counter;
		addMouseListener(engine);
		addMouseMotionListener(engine);
		JFrame frame = new JFrame("Test window");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		this.addPanelToFrame(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public GameEngine getEngine(){
		return engine;
	}

	public void addPanelToFrame(Container container){
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(this);
		textField = new JTextField(0);
		container.add(textField);
	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
		int i =0;
		while(i<500){
			g.setColor(Color.WHITE);
			g.fillRect((int)(Math.random()*500), (int)(Math.random()*500), 1, 1);
			i++;
		}
		
		
		/*
		 * Players spacecraft
		 */
		//hull
		g.setColor(Color.RED);
		int [] hullY = { 450, 445, 430, 430, 445, 450, 540, 540};
		Polygon hull = new Polygon(hullX, hullY, 8);
		g.fillPolygon(hull);
		//cockpit cover
		g.setColor(Color.YELLOW);
		g.fillOval(cockpitX, 450, 15, 25);
		//right wing
		g.setColor(Color.BLUE);
		int [] rightWingY = {450, 450, 470, 475, 480, 490};
		Polygon rightWing = new Polygon(rightWingX, rightWingY, 6);
		g.fillPolygon(rightWing);
		//left wing
		g.setColor(Color.BLUE);
		int [] leftWingY = { 450, 450, 470, 475, 480, 490};
		Polygon leftWing = new Polygon(leftWingX, leftWingY, 6);
		g.fillPolygon(leftWing);
		
		/*
		 * Enemies spacecraft
		 */
		if (enemiesNum>0){
			int d=0;
			while(d<enemiesNum){
			g.fillPolygon(enemiesEscadra[d]);
			d++;
			
			}
		}
	
		
	}

	public void setTextToField(String s){
		textField.setText(s);
		
	}
	
	public void setLeftX(int goCenter){
		centerOfShip =goCenter;
		//hull
		hullX[0] =centerOfShip-10;
		hullX[1] =centerOfShip-5;
		hullX[2] =centerOfShip-1;
		hullX[3] =centerOfShip+1;
		hullX[4] =centerOfShip+5;
		hullX[5] =centerOfShip+10;
		hullX[6] =centerOfShip+1;
		hullX[7] =centerOfShip-1;
		//cockpit kover
		cockpitX =centerOfShip-8;
		//right and left wing
		rightWingX[0]=centerOfShip-10;
		rightWingX[1]=centerOfShip-20;
		rightWingX[2]=centerOfShip-60;
		rightWingX[3]=centerOfShip-60;
		rightWingX[4]=centerOfShip-15;
		rightWingX[5]=centerOfShip-6;
		leftWingX[0]=centerOfShip+9;
		leftWingX[1]=centerOfShip+19;
		leftWingX[2]=centerOfShip+59;
		leftWingX[3]=centerOfShip+59;
		leftWingX[4]=centerOfShip+14;
		leftWingX[5]=centerOfShip+6;
		repaint();
	}
	
	public void setRightX(int goCenter){
		centerOfShip =goCenter;
		//hull
		hullX[0] =centerOfShip-10;
		hullX[1] =centerOfShip-5;
		hullX[2] =centerOfShip-1;
		hullX[3] =centerOfShip+1;
		hullX[4] =centerOfShip+5;
		hullX[5] =centerOfShip+10;
		hullX[6] =centerOfShip+1;
		hullX[7] =centerOfShip-1;
		//cockpit kover
		cockpitX =centerOfShip-8;
		//right and left wing
		rightWingX[0]=centerOfShip-10;
		rightWingX[1]=centerOfShip-20;
		rightWingX[2]=centerOfShip-60;
		rightWingX[3]=centerOfShip-60;
		rightWingX[4]=centerOfShip-15;
		rightWingX[5]=centerOfShip-6;
		leftWingX[0]=centerOfShip+9;
		leftWingX[1]=centerOfShip+19;
		leftWingX[2]=centerOfShip+59;
		leftWingX[3]=centerOfShip+59;
		leftWingX[4]=centerOfShip+14;
		leftWingX[5]=centerOfShip+6;
		repaint();
	}
	
	public void enemyShipValidatorX(){
		
		int d=0;
		enemiesEscadra = new Polygon[level];
		while(d<level){
			int v =(int)(Math.random()*500);
			enemyCenterX =v;
			System.out.println(enemyCenterX);
			enemyShipX[0] =enemyCenterX-10;
			enemyShipX[1] =enemyCenterX+10;
			enemyShipX[2] =enemyCenterX+10;
			enemyShipX[3] =enemyCenterX-10;
			enemiesEscadra[d] = new Polygon(enemyShipX, enemyShipY, 4);
			d++;
			enemiesNum++;
		}
	}
	public void goEnemiesDown(){
		if (count==10000){
		if (enemyShipY[0]<500){
			enemyShipY[0]++;
			enemyShipY[1]++;
			enemyShipY[2]++;
			enemyShipY[3]++;
			count=0;
		}else{
			enemiesNum =0;
			count=0;
		}
		}else{
			count++;
		}
		

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
