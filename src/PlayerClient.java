import java.io.Serializable;


public class PlayerClient implements Serializable {
	 	
	/**
	 * - Player Properties -
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	  //////////////////////////
	 // - Client Variables - //
	//////////////////////////
	
	private String name ="";
	private int	x, y;
    	boolean ok = false;
    	boolean restart = false;
    	
	public PlayerClient(String name){
		this.name = name;
		x = 740;
		y = 210;
	}
	
	  ///////////////////////////
	 // - Getters & Setters - //
	///////////////////////////
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "PlayerClient [name=" + name + ", x=" + x + ", y=" + y + "]";
	}
}
