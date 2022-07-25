package app;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.UnsupportedLookAndFeelException;

public class Engine {

	static BtnDel tempDel;
	static Months tempMon;
	
	Engine(){
	}
	
	void load() throws IOException, ParseException, UnsupportedLookAndFeelException{
		new Startup().load();
		tempMon = new Months();
		BtnAdd tempAdd = new BtnAdd();
		tempMon.load();
		tempMon.birthday();
		tempAdd.load();
		tempDel = new BtnDel();
		tempDel.load();
		new FileDeleteIndex();
		new DarkMode().load();
	}
	
}
