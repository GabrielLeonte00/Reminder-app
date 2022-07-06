package app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;

public class BtnView {

	private JButton btnView; 
	private Vector<String> dates = new Vector<>();
	private Vector<String> fnames = new Vector<>();
	private Vector<String> lnames = new Vector<>();
	private Filefirstname ffn = new Filefirstname();
	private Filelastname fln = new Filelastname();
	private Filebirthdays fb = new Filebirthdays();
	
	BtnView(JButton btnView){
		this.btnView = btnView;
	}
	
	void load() {

		btnView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					dates = fb.getDates();
					fnames = ffn.getfname();
					lnames = fln.getlname();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(int i = 1; i < dates.size(); i++) {
					System.out.println(fnames.get(i)+" "+lnames.get(i)+" "+dates.get(i));
				}
			}
		});
	}
	
	void birthday() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date date = new Date(); 
	    dates = fb.getDates();
		fnames = ffn.getfname();
		lnames = fln.getlname();
		
		for(int i = 1; i < dates.size(); i++) {
			if(formatter.format(date).equals(dates.get(i))) {
				System.out.println("Today is " + fnames.get(i) + " " + lnames.get(i) + "'birthday!");
			}
		}
	}
	
}
