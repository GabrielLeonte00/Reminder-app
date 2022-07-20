package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class Filelastname {

	private Vector<String> lnames = new Vector<>();
	File lname = new File("res/data_last_name");
	Path lpath = Paths.get(lname.getAbsolutePath());	
	
	Filelastname(){	
		
	}
	
	public Vector<String> getlname() throws IOException{
		lnames.clear();
		BufferedReader br_lname = Files.newBufferedReader(lpath);
		String lline = null;
		while((lline = br_lname.readLine()) != null) { 
			lnames.add(lline);		
		}
		br_lname.close();
		return lnames;
	}

	public Path getpath() {
		return lpath;
	}
	
}
