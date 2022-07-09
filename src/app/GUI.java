package app;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class GUI {

	private static JFrame frame;
	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnUpdate;
	private JCheckBox StartupCheckBox;
	private JList<String> CurrentMonth;
	private JList<String> NextMonth;
	private JScrollPane scrollPaneCM;
	private JScrollPane scrollPaneNM;
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public GUI() throws IOException, ParseException {
		initialize();
		new App_SystemTray(frame).load();
		
		new Engine(btnAdd, btnDel, btnUpdate, CurrentMonth, NextMonth, scrollPaneCM, scrollPaneNM, frame).load();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame("Birthday reminder");
		frame.setBounds(100, 100, 546, 401);
		frame.setLocationRelativeTo(null);
		
		File icon = new File("res/icon.png");
		Image image = ImageIO.read(icon);
		frame.setIconImage(image);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		btnDel = new JButton("Delete");	
		btnDel.setBounds(142, 302, 118, 49);
		btnDel.setFocusable(false);
		frame.getContentPane().add(btnDel);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(270, 302, 118, 49);
		btnUpdate.setFocusable(false);
		frame.getContentPane().add(btnUpdate);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 302, 118, 49);
		btnAdd.setFocusable(false);
		frame.getContentPane().add(btnAdd);
		
		StartupCheckBox = new JCheckBox("Open at startup");
		StartupCheckBox.setBounds(394, 305, 126, 43);
		StartupCheckBox.setFocusable(false);
		frame.getContentPane().add(StartupCheckBox);
		
	}
	
	/**
	 * Getter for frame
	 * @return frame Main frame of the application
	 */
	public JFrame getFrame() {
		return frame;
	}
}
