package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Vector;

public class FileDeleteIndex {

	private Vector<String> deleteIndex = new Vector<>();
	private Vector<String> dates = new Vector<>();
	private Vector<String> fnames = new Vector<>();
	private Vector<String> lnames = new Vector<>();
	private Filefirstname ffn = new Filefirstname();
	private Filelastname fln = new Filelastname();
	private Filebirthdays fb = new Filebirthdays();
	
	FileDeleteIndex(int postAdd){
	}
	
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
	
	public void deleteBirthday(int indexDelete) throws IOException {
		deleteDate(indexDelete);
		deleteFirstName(indexDelete);
		deleteLastName(indexDelete);
		recreateTemp();
	}
	
	
	void deleteDate(int indexDelete) throws IOException {
		Vector<String> temp = new Vector<>();
		int cont = 0;
		BufferedReader br_date = Files.newBufferedReader(fb.getpath());
		String bline = null;
		while((bline = br_date.readLine()) != null) { 
			if(cont != indexDelete && cont != 0) {
				String date = System.lineSeparator() + bline;
				temp.add(date);
			}
			cont++;
		}
		BufferedWriter writer = Files.newBufferedWriter(fb.getpath());
		writer.write("");
		for(int i = 0; i < temp.size(); i++) {
			Files.write(fb.getpath(), temp.get(i).getBytes(), StandardOpenOption.APPEND);
		}
	}
	
	void delDate(int indexDelete) throws IOException {
		
	}
	
	void deleteFirstName(int indexDelete) throws IOException {
		Vector<String> temp = new Vector<>();
		int cont = 0;
		BufferedReader br_date = Files.newBufferedReader(ffn.getpath());
		String bline = null;
		while((bline = br_date.readLine()) != null) { 
			if(cont != indexDelete && cont != 0) {
				String date = System.lineSeparator() + bline;
				temp.add(date);
			}
			cont++;
		}
		BufferedWriter writer = Files.newBufferedWriter(ffn.getpath());
		writer.write("");
		for(int i = 0; i < temp.size(); i++) {
			Files.write(ffn.getpath(), temp.get(i).getBytes(), StandardOpenOption.APPEND);
		}
	}
	
	void deleteLastName(int indexDelete) throws IOException {
		Vector<String> temp = new Vector<>();
		int cont = 0;
		BufferedReader br_date = Files.newBufferedReader(fln.getpath());
		String bline = null;
		while((bline = br_date.readLine()) != null) { 
			if(cont != indexDelete && cont != 0) {
				String date = System.lineSeparator() + bline;
				temp.add(date);
			}
			cont++;
		}
		BufferedWriter writer = Files.newBufferedWriter(fln.getpath());
		writer.write("");
		for(int i = 0; i < temp.size(); i++) {
			Files.write(fln.getpath(), temp.get(i).getBytes(), StandardOpenOption.APPEND);
		}
	}
	
	void recreateTemp() throws IOException {
		File temp = new File("res/temp");
		Path tempPath = Paths.get(temp.getAbsolutePath()); 
		BufferedWriter writer = Files.newBufferedWriter(tempPath);
		writer.write("");
		writer.close();
	}
	
}
