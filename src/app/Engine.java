package app;

import java.io.IOException;
import java.text.ParseException;

public class Engine {

	static BtnDel tempDel;
	static Months tempMon;
	
	Engine(){
	}
	
	void load() throws IOException, ParseException{
		tempMon = new Months();
		BtnAdd tempAdd = new BtnAdd();
		tempMon.load();
		tempMon.birthday();
		tempAdd.load();
		tempDel = new BtnDel();
		tempDel.load();
		new FileDeleteIndex();
	}
	
}
