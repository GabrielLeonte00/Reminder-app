package app;

import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Engine {

	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnUpdate;
	private JList<String> CurrentMonth;
	private JList<String> NextMonth;
	private JScrollPane scrollPaneCM;
	private JScrollPane scrollPaneNM;
	private JFrame frame;
	
	Engine(JButton btnAdd, JButton btnDel, JButton btnUpdate, JList<String> CurrentMonth, JList<String> NextMonth, JScrollPane scrollPaneCM, JScrollPane scrollPaneNM, JFrame frame){
		this.btnAdd = btnAdd;
		this.btnDel = btnDel;
		this.btnUpdate = btnUpdate;
		this.CurrentMonth = CurrentMonth;
		this.NextMonth = NextMonth;
		this.scrollPaneCM = scrollPaneCM;
		this.scrollPaneNM = scrollPaneNM;
		this.frame = frame;
	}
	
	void load() throws IOException, ParseException{
		Months tempMon = new Months(CurrentMonth, NextMonth, scrollPaneCM, scrollPaneNM, frame);
		BtnAdd tempAdd = new BtnAdd(btnAdd);
		BtnUpdate tempUpdate = new BtnUpdate(btnUpdate);	
		tempMon.load();
		tempMon.birthday();
		tempAdd.load();
		tempUpdate.load();
		BtnDel tempDel = new BtnDel(btnDel, tempMon.getCurrentMonth());
		tempDel.load();
		new FileDeleteIndex();
		
	}
	
}
