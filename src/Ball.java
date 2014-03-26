public class Ball extends Thread{
	
	/**
	 * - Ball v1.0
	 */
	
	  ///////////////////
	 // - Variables - //
	///////////////////
	
	private int x;			 // - represents the x coordinate of the ball
	private int y;			 // - represents the y coordinate of the ball
	private double xv;      	 // - x velocity 
	private double yv;      	 // - y velocity
	private int radius;		 // - radius of the ball
	private int   HEIGHT;
	private int   WIDTH;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		move();
		try {
			sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		// - Set text color - //
		
	}// *<-- end of the run --> //
	
	public Ball(int x, int y, double xv, double yv, int radius, int WIDTH, int HEIGHT) {
		super();
		this.x = x;
		this.y = y;
		this.xv = xv;
		this.yv = yv;
		this.radius = radius;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
	}
 

	public void move(){
		if(x + xv > (WIDTH-radius) - 7){ // - Calibrate the screen layer - //
			x= (WIDTH-radius)-7; // - set the position of the ball
			xv = xv * -1; // - set the velocity of the ball

		}
		
		if(x + xv < 9){  // - Calibrate the screen layer - //
			x = 9;
			xv = xv *-1;
		}
		
		if(y + yv < radius/2+7){ // - Calibrate the screen layer - //
			y = 29;
			yv = yv * -1;
		}
		
		if(y + yv > (HEIGHT - radius) - 6) // - Calibrate the screen layer - //
		{
			y = (HEIGHT-radius)-6; 
			yv = yv * -1;
			
		}
		x += xv;
		y += yv;

	}
	
	  ///////////////////////////
	 // - Getters & Setters - //
	///////////////////////////
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getXv() {
		return xv;
	}
	public void setXv(double xv) {
		this.xv = xv;
	}
	public double getYv() {
		return yv;
	}
	public void setYv(double yv) {
		this.yv = yv;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	}// *<--end of the Class -->* //
