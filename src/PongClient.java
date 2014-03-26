import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JFrame;


public class PongClient extends JFrame implements KeyListener, Runnable, WindowListener{

	/**
	 * Pong Client 
	 */
	
	private static final long serialVersionUID = 1L;
	  
	  ///////////////////
 	 // - Variables - //
	///////////////////
	
	// - Frame - //
	private static final String TITLE  = "ping-pong::client";	
	private static final int    WIDTH  = 800;		  // - Width  size for window - //
	private static final int    HEIGHT = 460;		  // - Height size for window - //
	boolean isRunning = false;
	
	// - Players - //
	private PlayerServer playerS;
	private PlayerClient playerC;
	private int barR      = 30;		// - Player bar width - //
	private int playerH   = 120; 	// - Player bar height - //
	private int mPLAYER   = 5; 		// - Moving of the player bar - //
	
	// - Server - //
	private static Socket clientSoc;
	private int portAdd;
	private String ipAdd;
	private boolean reset = false;
	private int countS = 0;
	
	// - Graphical - //
	private Graphics g;
	private Font sFont = new Font("TimesRoman",Font.BOLD,90);
	private Font mFont = new Font("TimesRoman",Font.BOLD,50);
	private Font nFont = new Font("TimesRoman",Font.BOLD,32);
	private Font rFont = new Font("TimesRoman",Font.BOLD,18);
    private String[] message;	// - Split Message to two piece in an array - //


    // - Constructor - //
	public PongClient(String clientname, String portAdd, String ipAdd){
			
		// - Players - //
		playerS = new PlayerServer();
		playerC = new PlayerClient(clientname);
		playerS.setName(clientname);
			
		// - Socket - //
		this.ipAdd = ipAdd;
		this.portAdd = Integer.parseInt(portAdd);
		this.isRunning = true;
			
		// - Frame - //
		this.setTitle(TITLE);
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		addKeyListener(this);
		//addWindowListener(this);
		// - 
	   }	
		
	  /////////////
	 // - Run - //
	/////////////
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// Server Socket //
   	 try {
 
        	 System.out.println("Finding server...\nConnecting to "+ipAdd+":"+portAdd);
        	 clientSoc = new Socket(ipAdd, portAdd);
    		 System.out.println("Connected to server...");
            
        	 if(clientSoc.isConnected()){
            	System.out.println("TEST");
        		 // - define get send objects - //
        		
 
            	 
            	 while(true){
            		// - Creating Streams - //
            		 ObjectOutputStream sendObj = new ObjectOutputStream(clientSoc.getOutputStream());
        			 sendObj.writeObject(playerC);
        			 sendObj = null;
        			 
        			 ObjectInputStream getObj = new ObjectInputStream(clientSoc.getInputStream());
        			 playerS = (PlayerServer) getObj.readObject();
        			 getObj = null;
        			
        			 // - For next game -> reset restart status - //
        			 if(reset){
        				 
        				if(countS>5){
        				playerC.restart = false;
        				reset = false;
        				countS = 0;
        				}
        			}
        			 countS++;
        			 repaint();
                 	}
        		 
        	 }
        	 else{
        		 System.out.println("Disconnected...");
        	 }
            
 
        }
        catch (Exception e) {System.out.println(e);}
   	
   }
		
	
	  ///////////////
	 // - Paint - //
	///////////////
	
	private Image createImage(){
		
	    BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	    g = bufferedImage.createGraphics();
	    
	    // - Table - //
	    g.setColor(new Color(15,9,9));
	    g.fillRect(0, 0, WIDTH, HEIGHT);
	    
	    // - Lines - //
	    g.setColor(Color.white);
	    g.fillRect(WIDTH/2-5, 0, 5, HEIGHT);
	    g.fillRect(WIDTH/2+5, 0, 5, HEIGHT);
	    
	    // - Score - //
	    g.setColor(new Color(228,38,36));
	    g.setFont(sFont);
	    g.drawString(""+playerS.getScoreS(), WIDTH/2-60, 120);
	    g.drawString(""+playerS.getScoreP(), WIDTH/2+15, 120);
	    
	    // - Player Names - //
	    g.setFont(nFont);
	    g.setColor(Color.white);
	    g.drawString(playerS.getName(),WIDTH/10,HEIGHT-20);
	    g.drawString(playerC.getName(),600,HEIGHT-20);
	    
	    
	    // - Player's Bar - //
	    g.setColor(new Color(57,181,74));
	    g.fillRect(playerS.getX(), playerS.getY(), barR, playerH);
	    g.setColor(new Color(57,181,74));
	    g.fillRect(playerC.getX(), playerC.getY(), barR, playerH);
	    
	    // - Ball - //
	    g.setColor(new Color(255,255,255));
	    g.fillOval(playerS.getBallx(), playerS.getBally(), 45, 45);
	    g.setColor(new Color(228,38,36));
	    g.fillOval(playerS.getBallx()+5, playerS.getBally()+5, 45-10, 45-10);
	    
	    // - Message - //
	    message = playerS.getImessage().split("-");
	    g.setFont(mFont);
	    g.setColor(Color.white);
	    if(message.length!=0){
	    	g.drawString(message[0],WIDTH/4-31,HEIGHT/2+38);
	    	if(message.length>1){
	    		if(message[1].length()>6){
	    	    	g.setFont(rFont);
	    			g.setColor(new Color(228,38,36));
	    			g.drawString(message[1],WIDTH/4-31,HEIGHT/2+100);
	    		}
	    	}
	   }
	   return bufferedImage;
	}
	
	public void paint(Graphics g){
		g.drawImage(createImage(), 0, 0, this);
		playerC.ok = true;
	}
	

	  ///////////////////////
	 // - Update Player - //
	///////////////////////
	
	// - Move bar to Up - //
	public void playerUP(){
		if(playerC.getY() - mPLAYER > playerH/2-10){
			
			playerC.setY(playerC.getY()-mPLAYER);
		}
	}
	
	// - Move bar to Down - //
	public void playerDOWN(){
		if(playerC.getY() + mPLAYER < HEIGHT - playerH - 30){
			
			playerC.setY(playerC.getY()+mPLAYER);
		}
	}

	  /////////////////////
	 // - KeyListener - //
	/////////////////////

	@Override
	public void keyPressed(KeyEvent arg0) {
	
		// TODO Auto-generated method stub
		int keycode = arg0.getKeyCode();
		if(keycode == KeyEvent.VK_UP){
			playerUP();
			repaint();
		}
		if(keycode == KeyEvent.VK_DOWN){
			playerDOWN();
			repaint();
		}
		if(playerS.isRestart()){
			playerC.restart = true;
			reset = true;
		}
		if(keycode == KeyEvent.VK_ESCAPE || keycode == KeyEvent.VK_N && playerS.isRestart()){
			try {
				this.setVisible(false);
				clientSoc.close();
				System.exit(EXIT_ON_CLOSE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		 
	}



	@SuppressWarnings("deprecation")
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
	
		Thread.currentThread().stop();
		this.setVisible(false);
		try {
			clientSoc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
 
}
