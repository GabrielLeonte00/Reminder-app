package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatNightOwlContrastIJTheme;

public class DarkMode {

	private File darkmodeOK = new File("res/darkmode");
	private Path bpath = Paths.get(darkmodeOK.getAbsolutePath());
	private PropertyChangeListener update;
	private int OK;
	
	DarkMode() throws IOException, UnsupportedLookAndFeelException{
		BufferedReader brOK = Files.newBufferedReader(bpath);
		String bline = brOK.readLine();
		OK = Integer.parseInt(bline);
		updateAtStart();
		brOK.close();
	}
	
	void load() throws IOException {
		GUI.DarkModeCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedWriter writer;
				try {
					writer = Files.newBufferedWriter(Paths.get(darkmodeOK.getAbsolutePath()));
					writer.write("");
					if(GUI.DarkModeCheckBox.isSelected()) {
						OK = 1;
						writer.write("1");
						UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
						AddBirthdayFrame.dateChooser.getDateEditor().removePropertyChangeListener(update);
						updateDateEditor();
						SwingUtilities.updateComponentTreeUI(GUI.frame);
						SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.frame);
						SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.dateChooser);
					} else {
						OK = 0;
						writer.write("0");
						UIManager.setLookAndFeel(new FlatSolarizedLightIJTheme());
						AddBirthdayFrame.dateChooser.getDateEditor().removePropertyChangeListener(update);
						updateDateEditor();
						SwingUtilities.updateComponentTreeUI(GUI.frame);
						SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.frame);
						SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.dateChooser);
					}
					writer.close();
				} catch (IOException | UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
	}
	
	void updateAtStart() throws UnsupportedLookAndFeelException {
		if(OK == 1) {
			GUI.DarkModeCheckBox.setSelected(true);
			UIManager.setLookAndFeel(new FlatNightOwlContrastIJTheme());
			AddBirthdayFrame.dateChooser.getJCalendar().setForeground(Color.black);
			updateDateEditor();
			SwingUtilities.updateComponentTreeUI(GUI.frame);
			SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.frame);
			SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.dateChooser);
		} else {
			GUI.DarkModeCheckBox.setSelected(false);
			UIManager.setLookAndFeel(new FlatSolarizedLightIJTheme());
			AddBirthdayFrame.dateChooser.getJCalendar().setForeground(Color.black);
			updateDateEditor();
			SwingUtilities.updateComponentTreeUI(GUI.frame);
			SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.frame);
			SwingUtilities.updateComponentTreeUI(AddBirthdayFrame.dateChooser);
		}
	}
	
	void updateDateEditor() {
		if(OK == 1) {
			update = new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					// TODO Auto-generated method stub
					AddBirthdayFrame.dateChooser.getDateEditor().getUiComponent().setForeground(Color.white);
				}
				
			};
		AddBirthdayFrame.dateChooser.getDateEditor().addPropertyChangeListener(update);
		} else {
			update = new PropertyChangeListener() {

				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					// TODO Auto-generated method stub
					AddBirthdayFrame.dateChooser.getDateEditor().getUiComponent().setForeground(Color.black);
				}
				
			};
		AddBirthdayFrame.dateChooser.getDateEditor().addPropertyChangeListener(update);	
		}
	}
	
}
