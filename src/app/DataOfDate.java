package app;

import java.util.Date;

public class DataOfDate {

	private Date date;
	private String fname;
	private String lname;
	
	DataOfDate(Date date, String fname, String lname){
		this.date = date;
		this.fname = fname;
		this.lname = lname;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getfname() {
		return fname;
	}
	
	public String getlname() {
		return lname;
	}
	
}
