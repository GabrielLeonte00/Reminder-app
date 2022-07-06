package app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class BtnView {

	private JButton btnView; 
	private Vector<String> dates = new Vector<>();
	private Vector<String> fnames = new Vector<>();
	private Vector<String> lnames = new Vector<>();
	private Filefirstname ffn = new Filefirstname();
	private Filelastname fln = new Filelastname();
	private Filebirthdays fb = new Filebirthdays();
	
	BtnView(){
		
	}
	
	BtnView(JButton btnView){
		this.btnView = btnView;
	}
	
	void load() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 244, 328);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
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
				DefaultListModel tempList = new DefaultListModel();
				String tempLine;
				for(int i = 1; i < dates.size(); i++) {
					tempLine = fnames.get(i)+" "+lnames.get(i)+" "+dates.get(i);
					tempList.add(i-1, tempLine);
				}
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 207, 267);
				frame.getContentPane().add(scrollPane);
				JList list = new JList(tempList);
				list.setBounds(10, 11, 207, 267);
				scrollPane.setViewportView(list);
				frame.setVisible(true);
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
