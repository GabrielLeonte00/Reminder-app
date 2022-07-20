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
import javax.swing.ListSelectionModel;

public class GUI {

	static JFrame frame;
	static JButton btnAdd;
	static JButton btnDel;
	static JCheckBox StartupCheckBox;
	static JList<String> CurrentMonth;
	static JList<String> NextMonth;
	static JScrollPane scrollPaneCM;
	static JScrollPane scrollPaneNM;
	static Engine startApp;
	
	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public GUI() throws IOException, ParseException {
		initialize();
		new App_SystemTray().load();
		startApp = new Engine();
		startApp.load();
		CurrentMonth.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 302, 118, 49);
		btnAdd.setFocusable(false);
		frame.getContentPane().add(btnAdd);
		
		StartupCheckBox = new JCheckBox("Open at startup");
		StartupCheckBox.setBounds(334, 305, 186, 43);
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
	
	void reinitialize() {
		btnDel = new JButton("Delete");	
		btnDel.setBounds(142, 302, 118, 49);
		btnDel.setFocusable(false);
		frame.getContentPane().add(btnDel);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 302, 118, 49);
		btnAdd.setFocusable(false);
		frame.getContentPane().add(btnAdd);
		
		StartupCheckBox = new JCheckBox("Open at startup");
		StartupCheckBox.setBounds(394, 305, 126, 43);
		StartupCheckBox.setFocusable(false);
		frame.getContentPane().add(StartupCheckBox);
	}
	
}
