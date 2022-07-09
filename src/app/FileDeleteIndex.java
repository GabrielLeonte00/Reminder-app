package app;

import java.io.IOException;
import java.util.Vector;

public class FileDeleteIndex {

	private Vector<String> deleteIndex = new Vector<>();
	private Vector<String> dates = new Vector<>();
	private Vector<String> fnames = new Vector<>();
	private Vector<String> lnames = new Vector<>();
	private Filefirstname ffn = new Filefirstname();
	private Filelastname fln = new Filelastname();
	private Filebirthdays fb = new Filebirthdays();
	
	FileDeleteIndex() throws IOException{
		dates.clear();
		fnames.clear();
		lnames.clear();
		dates = fb.getDates();
		fnames = ffn.getfname();
		lnames = fln.getlname();
		deleteIndex.add("");
		for(int i = 1; i < dates.size(); i++) {
			String temp = dates.get(i) + " - " + fnames.get(i) + " " + lnames.get(i);
			deleteIndex.add(temp);
		}
	}
	
	public int  getDeleteIndex(String compare) {
		for(int i = 1; i < dates.size(); i++) {	
			if(deleteIndex.get(i).equals(compare)) {
				return i;
			}
		}
		return 0;
	}
	
}
