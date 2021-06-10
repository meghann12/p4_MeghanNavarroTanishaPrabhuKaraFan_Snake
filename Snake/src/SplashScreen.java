import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;





public class SplashScreen {
	private int x = 0,y = 0;
	private Image img1; // image of the frog
	private Image img2;
	private Image img;
	private boolean collide;
	public int cntr;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public SplashScreen() {
		img1 = getImage("IMG_3064.png"); //load the image for Tree
		img = img1;
		init(x, y); 				//initialize the location of the image
		
		
	}
	public void disappear() {
		
		this.x = 2000000000; 
		this.y = 2000000000;
		
	}
	
	
	
	
	public void paint(Graphics g) {
		
		
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;

		//makes dog laugh(changing between two images)
		

		
		g2.drawImage(img, tx, null);   
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = SplashScreen.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	public void paint() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}