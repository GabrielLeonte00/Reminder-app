package app;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class App_SystemTray {
	
	private JFrame frame;
	private TrayIcon trayIcon;
	
	/**
	 * Constructor with parameters
	 * @param frame GUI's frame used for the SystemTray to work with
	 */
	App_SystemTray(JFrame frame){
		this.frame = frame;
	}
	
	/**
	 * This will initialize the application into the SystemTray and it will make it possible for the application to not appear into the taskbar
	 * @throws IOException
	 */
	public void load() throws IOException {
		
		if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
		
		SystemTray systemTray = SystemTray.getSystemTray();
		File icon = new File("res/icon.png");
		Image image = ImageIO.read(icon);
		trayIcon = new TrayIcon(image);
		PopupMenu popMenu = new PopupMenu();
		
		trayIcon.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				trayIcon.setToolTip("Birthday reminder");
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		MenuItem show = new MenuItem("Show");
		show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				frame.setExtendedState(JFrame.NORMAL);
			}
		});
		
		MenuItem exit = new MenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		popMenu.add(show);
		popMenu.add(exit);
		
		trayIcon.setPopupMenu(popMenu);
		
		try {
			systemTray.add(trayIcon);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
}
