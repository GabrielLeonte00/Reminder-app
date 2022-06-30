package app;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private boolean enabled = false;

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		initialize();
		new App_SystemTray(frame).load();
		frame.getContentPane().setLayout(null);
		
		JButton btnDel = new JButton("Delete reminder");	
		btnDel.setBounds(70, 109, 183, 49);
		btnDel.setFocusable(false);
		frame.getContentPane().add(btnDel);
		
		JButton btnView = new JButton("View reminders");
		btnView.setBounds(70, 169, 183, 49);
		btnView.setFocusable(false);
		frame.getContentPane().add(btnView);
		
		JButton btnEnable = new JButton("Enable startup");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enabled == false) {
					btnEnable.setText("Disable startup");
					enabled = true;
				} else {
					btnEnable.setText("Enable startup");
					enabled = false;
				}
			}
		});
		btnEnable.setBounds(70, 229, 183, 49);
		btnEnable.setFocusable(false);
		frame.getContentPane().add(btnEnable);
		
		JButton btnAdd = new JButton("Add reminder");
		btnAdd.setBounds(70, 49, 183, 49);
		btnAdd.setFocusable(false);
		frame.getContentPane().add(btnAdd);
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
	}
	
	/**
	 * Getter for frame
	 * @return frame Main frame of the application
	 */
	public JFrame getFrame() {
		return frame;
	}
}
