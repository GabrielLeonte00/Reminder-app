package app;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GUI {

	private JFrame frame;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnView;
	private JButton btnEnable;

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public GUI() throws IOException, ParseException {
		initialize();
		new App_SystemTray(frame).load();
		
		new Engine(btnAdd, btnDel, btnView, btnEnable).load();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 350, 330);
		frame.setLocationRelativeTo(null);
		
		File icon = new File("res/icon.png");
		Image image = ImageIO.read(icon);
		frame.setIconImage(image);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		btnDel = new JButton("Delete birthday");	
		btnDel.setBounds(70, 109, 183, 49);
		btnDel.setFocusable(false);
		frame.getContentPane().add(btnDel);
		
		btnView = new JButton("View birthdays");
		btnView.setBounds(70, 169, 183, 49);
		btnView.setFocusable(false);
		frame.getContentPane().add(btnView);
		
		btnEnable = new JButton("Enable startup");
		btnEnable.setBounds(70, 229, 183, 49);
		btnEnable.setFocusable(false);
		frame.getContentPane().add(btnEnable);
		
		btnAdd = new JButton("Add birthday");
		btnAdd.setBounds(70, 49, 183, 49);
		btnAdd.setFocusable(false);
		frame.getContentPane().add(btnAdd);
		
	}
	
	/**
	 * Getter for frame
	 * @return frame Main frame of the application
	 */
	public JFrame getFrame() {
		return frame;
	}
}
