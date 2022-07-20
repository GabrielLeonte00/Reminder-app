package app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class DeleteAction {

	private JButton btnDel;
	private int deleteIndex = -1;
	private static MouseListener delAction;
	private static MouseListener preDelAction;
	private static boolean OK = false;
	private static int Selected = 0;
	static int CurrentOrNext = -1;
	
	DeleteAction(JButton btnDel, int deleteIndex){
		this.btnDel = btnDel;
		this.deleteIndex = deleteIndex;
	}
	
	void preload() {
		preDelAction = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Unselected birthday to be removed, please choose one", "InfoBox: " + "Delete birthday", JOptionPane.INFORMATION_MESSAGE);
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
		};
		btnDel.addMouseListener(preDelAction);
	}
	
	void postpreload() {
		btnDel.removeMouseListener(preDelAction);
	}
	
	void load() {
		if(OK == false) {
			createAction();
			btnDel.addMouseListener(delAction);
			OK = true;	
		} else {
			btnDel.removeMouseListener(delAction);
			createAction();
			btnDel.addMouseListener(delAction);
		}
	}
	
	void createAction() {
		if(Selected == 0) {
			Selected = 1;
			btnDel.removeMouseListener(preDelAction);
		}
		
		delAction = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(CurrentOrNext == 0 && GUI.CurrentMonth.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "Unselected birthday to be removed, please choose one", "InfoBox: " + "Delete birthday", JOptionPane.INFORMATION_MESSAGE);
				} else if(CurrentOrNext == 1 && GUI.NextMonth.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Unselected birthday to be removed, please choose one", "InfoBox: " + "Delete birthday", JOptionPane.INFORMATION_MESSAGE);
				} else {
					System.out.println(deleteIndex);
					if(CurrentOrNext == 0) {
						
						Months.tempList.remove(BtnDel.CurrentMonth.getSelectedIndex());
					}
					if(CurrentOrNext == 1) {
						Months.tempListNew.remove(BtnDel.NextMonth.getSelectedIndex());
					}
					if(deleteIndex != 0) {
						try {
							new FileDeleteIndex().deleteBirthday(deleteIndex);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						
					}
				}
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
		};
	}
	
}
