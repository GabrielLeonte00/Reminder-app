package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Filebirthdays {
	
	private Vector<String> dates = new Vector<>();
	File bdate = new File("res/data_birthday_date");
	Path bpath = Paths.get(bdate.getAbsolutePath());
	SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");  
	
	Filebirthdays(){
	}
	
	public Vector<String> getDates() throws IOException{
		dates.clear();
		BufferedReader br_date = Files.newBufferedReader(bpath);
		String bline = null;
		while((bline = br_date.readLine()) != null) { 
			dates.add(bline);		
		}
		br_date.close();
		return dates;
	}
	
	public Path getpath() {
		return bpath;
	}
	
}
