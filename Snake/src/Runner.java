import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Runner extends Canvas{
//we've created a Jframe
	/**
	 * 
	 * 
	 */
	SplashScreen menu = new SplashScreen();
	
	private static final long serialVersionUID = 4024075373907849815L;
	
	public Runner(int width, int height, String title, SnakeGame game) {
		
		
		
		JFrame frame = new JFrame(title);
		
		//preferred dimensions
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		//close operation is the x button actually working
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//can we resize our window? No
		frame.setResizable(false);
		//window starts in the middle if null
		frame.setLocationRelativeTo(null);
		//adds game class into our frame
		frame.add(game);
		//sets frame to visible to we can see it
		frame.setVisible(true);
		//runs our game's start method
		
		game.start();
		
		menu.paint();
		
		
	
	}
	
/*	public void paint(Graphics g) {
		super.paint(g);
		menu.paint(g);
		
	}

*/}

