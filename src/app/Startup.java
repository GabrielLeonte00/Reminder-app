package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Startup {

	private File startupOK = new File("res/startup");
	private Path bpath = Paths.get(startupOK.getAbsolutePath());
	private int OK;
	
	Startup() throws IOException{
		BufferedReader brOK = Files.newBufferedReader(bpath);
		String bline = brOK.readLine();
		OK = Integer.parseInt(bline);
		if(OK == 1) {
			GUI.StartupCheckBox.setSelected(true);
		} else {
			GUI.StartupCheckBox.setSelected(false);
		}
		brOK.close();
	}
	
	void load() throws IOException {
		GUI.StartupCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedWriter writer;
				try {
					writer = Files.newBufferedWriter(Paths.get(startupOK.getAbsolutePath()));
					writer.write("");
					if(GUI.StartupCheckBox.isSelected()) {
						writer.write("1");
					} else {
						writer.write("0");
					}
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
	}
	
}
