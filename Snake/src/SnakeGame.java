import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Arrays;

public class SnakeGame extends Canvas implements Runnable, KeyListener{
	SplashScreen menu = new SplashScreen(); 
	public static void main(String args[]) { 
		new SnakeGame();
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800, HEIGHT = 800;
	/**
	 * 
	 */
	private Thread thread; //how the entire game is going to run within this thread
	private Body b;
	private ArrayList<Body> snake;
	
	private int x = 10, y = 10, size = 5;
	
	private int ticks = 0; //game runs
	
	private boolean running = false;
	private boolean right = true, left = false, up = false, down = false;
	

	
	public SnakeGame() {
		new Runner(WIDTH, HEIGHT, "Snake!", this);
		
		snake = new ArrayList<Body>();
		
		start();
		
	}
	
	public void start() {
		//this is going start up our thread
		thread = new Thread(this);
		thread.start();
		//initializing thread as a new thread
		//so that thread can be ran
		running = true;
	}
	public void stop() {
		//try and catch is like an if-statement
		
		try {
			thread.join(); //kills off the thread, stops it
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
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
	
	boolean first = true;
	public void paint(Graphics g) {
		
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(int i = 0; i < WIDTH/10; i++) {
			g.drawLine(i  * 10,  0,i * 10  , HEIGHT);
			
		}
		
		for(int i = 0; i < HEIGHT/10; i++) {
			g.drawLine(i * 10,  0, HEIGHT , i*10);
			
		}
		for(int i = 0; i < snake.size(); i ++) {
			snake.get(i).draw(g);
		}
		if(first) {
			menu.paint(g);
		}
	
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
				
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		/* call the helper methods for the Board object data*/
		System.out.println(arg0.getKeyCode());
		first = false;
		/* you can add tester code to invoke helper methods */
		//int[] result = data.getCol(data.getBoard(),0);
		//System.out.println(Arrays.toString(result));
		
		switch(arg0.getKeyCode()) {
			
			//slide right
			case 39:
				//data.right();
				//data.combineRight();
				menu.disappear();
				
				break;
				
				
			case 37: //left
				//data.slideLeft();
				//data.combineLeft();
				menu.disappear();

				
				break;
			case 38: //up
				//what to do if keyCode is 38?
				//data.slideUp();
				//data.combineUp();
				menu.disappear();

				
				break;
			case 40: //down
				//data.slideDown();
				//data.combineDown();
				menu.disappear();

				break;
				
		}
		
		//data.populateOne();
		//update();
		
		
		/** reset the game if all tiles are populated **/
		//if(data.gameOver()) {
		//	data = new Board();
			//update();
		//}
	}


	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
//Java Programming: Let's Build a Game #2 RealTutsGML
