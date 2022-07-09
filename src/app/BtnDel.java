package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JList;

public class BtnDel {

	private JButton btnDel; 
	private JList<String> CurrentMonth;
	private JList<String> NextMonth;
	private MouseListener listenerNextMonth;
	private boolean OK = false;
	
	BtnDel(JButton btnDel, JList<String> CurrentMonth){
		this.btnDel = btnDel;
		this.CurrentMonth = CurrentMonth;
	}
	BtnDel(){
		
	}
	
	void load() {
		
		CurrentMonth.addMouseListener(new MouseListener() {

			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				String temp = CurrentMonth.getSelectedValue();
				FileDeleteIndex tempDI = null;
				try {
					tempDI = new FileDeleteIndex();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = tempDI.getDeleteIndex(temp);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	void loadNext(JList<String> NextMonth) {
		
		this.NextMonth = NextMonth;
		if(OK == false) {
			createListener();
			NextMonth.addMouseListener(listenerNextMonth);
			OK = true;
		} else {
			NextMonth.removeMouseListener(listenerNextMonth);
			createListener();
			NextMonth.addMouseListener(listenerNextMonth);
		}
		
	}
	
	void createListener() {
		
		listenerNextMonth = new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				String temp = NextMonth.getSelectedValue();
				FileDeleteIndex tempDI = null;
				try {
					tempDI = new FileDeleteIndex();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int i = tempDI.getDeleteIndex(temp);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
}
