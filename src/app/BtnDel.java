package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JList;

public class BtnDel {

	private JButton btnDel; 
	static JList<String> CurrentMonth;
	static JList<String> NextMonth;
	private MouseListener listenerNextMonth;
	private static int Selected = 0;
	private boolean OK = false;
	private DeleteAction delete;
	
	BtnDel(){
		this.btnDel = GUI.btnDel;
		BtnDel.CurrentMonth = GUI.CurrentMonth;
	}
	
	void load() {
		delete = new DeleteAction(btnDel, -1);
		delete.preload();
		loadCurrent();
	}
	
	void loadCurrent() {
		
		
		MouseListener actionCurrent = new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				DeleteAction.CurrentOrNext = 0;
				
				if(Selected == 0) {
					Selected = 1;
					delete.postpreload();
				}
				
				String temp = CurrentMonth.getSelectedValue();
				FileDeleteIndex tempDI = null;
				try {
					tempDI = new FileDeleteIndex();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int deleteIndex = tempDI.getDeleteIndex(temp);
				System.out.println(deleteIndex);
					delete = new DeleteAction(btnDel, deleteIndex);
					delete.load();
				
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
		};
		CurrentMonth.addMouseListener(actionCurrent);
	}
	
	void loadNext(JList<String> NextMonth,JButton btnDel) {
		BtnDel.NextMonth = NextMonth;
		if(OK == false) {
			createListener(btnDel);
			NextMonth.addMouseListener(listenerNextMonth);
			OK = true;
		} else {
			NextMonth.removeMouseListener(listenerNextMonth);
			createListener(btnDel);
			NextMonth.addMouseListener(listenerNextMonth);
		}
		
	}
	
	void createListener(JButton btnDel) {
		listenerNextMonth = new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub	
				
				DeleteAction.CurrentOrNext = 1;
				
				String temp = NextMonth.getSelectedValue();
				FileDeleteIndex tempDI = null;
				try {
					tempDI = new FileDeleteIndex();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int deleteIndex = tempDI.getDeleteIndex(temp);
					//System.out.println(deleteIndex);
					delete = new DeleteAction(btnDel, deleteIndex);
					delete.load();
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
