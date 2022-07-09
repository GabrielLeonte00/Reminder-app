package app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;

public class BtnAdd {

	private JButton btnAdd; 
	
	BtnAdd(JButton btnAdd){
		this.btnAdd = btnAdd;
	}
	
	void load() throws IOException, ParseException {
		
		AddBirthdayFrame abf = new AddBirthdayFrame();
		abf.load();
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				abf.getFrame().setVisible(true);
			}
		});
		
	}
	
}
