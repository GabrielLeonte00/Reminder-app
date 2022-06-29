package app;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GUI {

	private JFrame frame;

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		initialize();
		new App_SystemTray(frame).load();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setLocationRelativeTo(null);
		
		File icon = new File("res/icon.png");
		Image image = ImageIO.read(icon);
		frame.setIconImage(image);
		frame.setResizable(false);
	}
	
	/**
	 * Getter for frame
	 * @return frame Main frame of the application
	 */
	public JFrame getFrame() {
		return frame;
	}

}
