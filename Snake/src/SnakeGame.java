import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

import javax.swing.ImageIcon;

import java.util.Random;
//snakeGame
public class SnakeGame extends Canvas implements Runnable, KeyListener{
	SplashScreen menu = new SplashScreen();  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 800;
	static final int DELAY = 75;
	/**
	 * 
	 */
	private Thread thread; //how the entire game is going to run within this thread
	private Body b;
	private ArrayList<Body> snake;
	
	private int x = 10, y = 10, size = 5;
	
	private int ticks = 0; //game runs
	
	private boolean running = false;
	private boolean right = false, left = false, up = false, down = false;
	private boolean first = false;
	private Random r;
	private Apple apple;
	private ArrayList<Apple> apples;
	
	//b
public SnakeGame() {
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	
		if(first == false) {
			menu.paint();
		}
		first = false;

		new Runner(WIDTH, HEIGHT, "Snake!", this);
		
		
		
		setFocusable(true);
		addKeyListener(this);
		
		snake = new ArrayList<Body>();
		apples = new ArrayList<Apple>();
		
		r= new Random();
		start();
		Image splash = new ImageIcon("IMG_3064").getImage();
		
	}
	public void start() {
		first = false;
		newApple();
		//this is going start up our thread
		thread = new Thread(this);
		thread.start();
		menu.paint();
		Image splash = new ImageIcon("IMG_3064").getImage();
		
		//initializing thread as a new thread
		//so that thread can be ran
		running = true;
		
		
		
	}
	
	
	
	public void newApple() {
		
	}
	
	
	public void stop() {
		//try and catch is like an if-statement
		int score = (snake.size() - 3) *10;
		
		try {
			thread.join(); //kills off the thread, stops it
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	public void tick() {
		
		if(snake.size() == 0) {
			b = new Body(x, y, 10);
			snake.add(b);
		}
		ticks++;
		if(ticks > 100000) { //ticks changes the speed
			if(right) x++;
			if(left) x--;
			if(up) y--;
			if(down) y++;
			
			if(x > 80) {
				x = 10;
				
			}
			
			
			
			ticks = 0;
			
			b = new Body(x, y, 10);
			snake.add(b);
			
			if(snake.size() > size) {
				snake.remove(0);
			}
		}
		
		first = true;
		
		if(apples.size() == 0) {
			int x = r.nextInt(40);
			int y = r.nextInt(40);
			
			apple = new Apple(x, y, 10);
			apples.add(apple);
		}
		if(first == false) {
			menu.paint();
			Image splash = new ImageIcon("IMG_3064").getImage();
			
		}
		
	}

	
	
	/*private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3); 
			//how many buffers it creates-- 3 is recommended amount of buffers
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.dispose();
		bs.show();
	}
	*/
	
	public static void main(String args[]) { 
		new SnakeGame();
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		Image splash = new ImageIcon("IMG_3064").getImage();
		g.drawImage(splash, 0, 0, this);
		
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		
		for(int i = 0; i < WIDTH/10; i++) {
			g.drawLine(i  * 10,  0,i * 10  , HEIGHT);
			
		}
		
		
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(i * 10,  0, HEIGHT , i*10);
			
		}
		for(int i = 0; i < snake.size(); i++) {
			snake.get(i).draw(g);
		}
		
		
		for(int i = 0; i < apples.size(); i++) {
			apples.get(i).draw(g);
		}
		first = false;
		
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
				
	}
	
	public void run() {
		//game loop needed or the game can't update itself
		//lastTime, now and ns are used to calculate delta
		//timer is updated based on the frames per second
		while(running) {
			
			tick();	
			repaint();
			
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		try {
			int key = e.getKeyCode();
			
			if((key == KeyEvent.VK_LEFT) && (!right)) {
				left = true;
				up = false;
				down = false;
				first = true;
				
			}
			if((key == KeyEvent.VK_RIGHT && (!left))) {
				right = true;
				up = false;
				down = false;
				first = true;
				
			}
			if((key == KeyEvent.VK_UP) && (!down)) {
				up = true;
				right = false;
				left = false;
				first = true;
				
			}
			if((key == KeyEvent.VK_DOWN) && (!up)) {
				left = false;
				down = true;
				right = false;
				first = true;
			}
		}catch(Exception e2) {
			int key = e.getKeyCode();
			
			if((key == KeyEvent.VK_LEFT) && (!right)) {
				left = true;
				up = false;
				down = false;
				first = true;
				
			}
			if((key == KeyEvent.VK_RIGHT && (!left))) {
				right = true;
				up = false;
				down = false;
				first = true;
				
			}
			if((key == KeyEvent.VK_UP) && (!down)) {
				up = true;
				right = false;
				left = false;
				first = true;
				
			}
			if((key == KeyEvent.VK_DOWN) && (!up)) {
				down = true;
				right = false;
				left = false;
				first = true;
				
			}
		}
			
	}



	
	
	

	
	
	/** reset the game if all tiles are populated **/

	


	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
//Java Programming: Let's Build a Game #2 RealTutsGML
