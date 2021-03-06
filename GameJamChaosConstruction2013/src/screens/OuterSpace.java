package screens;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;

import engine.SpaceEngine;
import engine.Constants;
import enter.DeadlyFight;

public class OuterSpace extends JPanel implements Constants{
	
	private JTextField textField;
	private JPanel panel;
	private JFrame frame;
	private Container container;
	private SpaceEngine engine;
	private Graphics graphics;
	private DeadlyFight deadlyFight;
	private Dimension preferredSize;
	private Polygon playerShip;
	
	//constructor
	public OuterSpace(DeadlyFight deadlyFight){
		preferredSize = new Dimension(SPACE_WIDTH, SPACE_HEIGHT);
		this.deadlyFight =deadlyFight;
		engine = new SpaceEngine(this, deadlyFight);
		addMouseListener(engine);
		addMouseMotionListener(engine);
		frame = new JFrame("Test window");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.addPanelToFrame(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	public Dimension getPreferredSize(){
		return preferredSize;
	}
	
	public SpaceEngine getEngine(){
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
		//Space is black
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 500);
		int i =0;
		//Stars ix white
		while(i<500){
			g.setColor(Color.WHITE);
			g.fillRect((int)(Math.random()*500), (int)(Math.random()*500), 1, 1);
			i++;
		}
		/*
		 *To draw the player's spacecraft 
		 */
		if (playerShip!=null){
			g.setColor(Color.BLUE);
			g.fillPolygon(playerShip);
		}
		
		}

	public void setTextToField(String s){
		textField.setText(s);
		
	}

	public void placeNewShips(Polygon p){
		playerShip =p;
	}
}
