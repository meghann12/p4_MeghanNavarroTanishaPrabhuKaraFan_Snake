/*import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;




public class MenuFrame {
<<<<<<< HEAD
		private static int x = 0;
		private static int y = 0;
		private static Image img;
=======
		private int x = 0,y = 0;
		private Image img;
>>>>>>> refs/remotes/origin/master
		private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
		public MenuFrame() {
			//img1 = getImage("IMG_3064.png"); //load the image for Tree
			img = getImage("IMG_3065.png"); 				//initialize the location of the image
			init(x, y); 				//initialize the location of the image
			
		}
		/*public static void disappear(){
			if(img != null) {
				boolean showImage = false;
				Random r;
				r = new Random();
				if(!showImage) {
					int w = img.getWidth(null);
					 int h = img.getHeight(null);
	                    int rx = getWidth() - w;
	                    int ry = getHeight() - h;
	                    if (rx > -1 && ry > -1)
	                    {
	                        x = r.nextInt(rx);
	                        y = r.nextInt(ry);
	                    }
	                   showImage = !showImage;
	                   
				}
			}
		}*/
		

		/*
		private static int getHeight() {
			// TODO Auto-generated method stub
			return 0;
		}
		private static int getWidth() {
			// TODO Auto-generated method stub
			return 0;
		}*/

		

		//public void paint(Graphics g) {
			
			
			
			//these are the 2 lines of code needed draw an image on the screen
		//	Graphics2D g2 = (Graphics2D) g;
		//	g2.drawImage(img, tx, null);   
			
	//	}
		
		//private void init(double a, double b) {
			//tx.setToTranslation(a, b);
			//tx.scale(1, 1);
		//}

		//private Image getImage(String path) {
		//	Image tempImage = null;
		//	try {
			//	URL imageURL = MenuFrame.class.getResource(path);
		//	//	tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		//	} catch (Exception e) {
				//e.printStackTrace();
		//	}
		//	return tempImage;
		//}

//}
//*/