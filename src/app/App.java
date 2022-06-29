package app;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {
	
	private static Vector<Date> Data_dates=new Vector<>();
	
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
						GUI window = new GUI();
						window.getFrame().setVisible(true);
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
	    }
	    finally {
	      if (socket != null)
	          try{ socket.close(); } catch(Exception e){}
	    }
		
	}
	
	public Vector<Date> getData_dates() {
		return Data_dates;
	}
	
}
