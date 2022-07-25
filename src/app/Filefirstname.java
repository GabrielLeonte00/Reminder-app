package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class Filefirstname {

	private Vector<String> fnames = new Vector<>();
	private File fname = new File("res/data_first_name");
	private Path fpath = Paths.get(fname.getAbsolutePath());	
	
	Filefirstname(){		
	}
	
	public Vector<String> getfname() throws IOException{
		fnames.clear();
		BufferedReader br_fname = Files.newBufferedReader(fpath);
		String fline = null;
		while((fline = br_fname.readLine()) != null) { 
			fnames.add(fline);		
		}
		br_fname.close();
		return fnames;
	}

	public Path getpath() {
		return fpath;
	}
	
}
	
