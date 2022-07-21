package app;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {
	
	static GUI window;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ServerSocket socket = null;
	    try {
	      socket = new ServerSocket(34567);
	      try{
	    	  EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						window = new GUI();
						GUI.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}); 
	    	  Thread.sleep(Long.MAX_VALUE); } catch(Exception e){ }
	      socket.close();
	    }
	    catch (IOException ex) {
	    	JFrame mesaj = new JFrame();
			JOptionPane.showMessageDialog(mesaj,"The application is running already","Info",JOptionPane.INFORMATION_MESSAGE);
			mesaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mesaj.setFocusable(false);
	    }
	    finally {
	      if (socket != null)
	          try{ socket.close(); } catch(Exception e){}
	    }
		
	}
	
}
