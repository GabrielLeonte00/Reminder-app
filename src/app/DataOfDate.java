package app;

import java.util.Date;

public class DataOfDate {

	private Date date;
	private String txt;
	
	DataOfDate(Date date, String txt){
		this.date = date;
		this.txt = txt;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getTxt() {
		return txt;
	}
	
	
}
