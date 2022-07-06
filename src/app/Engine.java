package app;

import java.io.IOException;
import java.text.ParseException;
import javax.swing.JButton;

public class Engine {

	private JButton btnAdd;
	private JButton btnDel;
	private JButton btnView;
	private JButton btnEnable;
	
	Engine(JButton btnAdd, JButton btnDel, JButton btnView, JButton btnEnable){
		this.btnAdd = btnAdd;
		this.btnDel = btnDel;
		this.btnView = btnView;
		this.btnEnable = btnEnable;
	}
	
	void load() throws IOException, ParseException{
		
		BtnAdd tempAdd = new BtnAdd(btnAdd);
		BtnView tempView = new BtnView(btnView);
		BtnDel tempDel = new BtnDel(btnDel);
		BtnEnable tempEnable = new BtnEnable(btnEnable);
		tempAdd.load();
		tempView.load();
		tempDel.load();
		tempEnable.load();
		tempView.birthday();
	}
	
}
