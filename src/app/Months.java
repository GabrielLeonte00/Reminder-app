package app;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JMonthChooser;

public class Months {

	static Vector<String> dates = new Vector<>();
	static Vector<String> fnames = new Vector<>();
	static Vector<String> lnames = new Vector<>();
	private Filefirstname ffn = new Filefirstname();
	private Filelastname fln = new Filelastname();
	private Filebirthdays fb = new Filebirthdays();
	private JTextField txtCurrentMonth;
	static DefaultListModel<String> tempList;
	static DefaultListModel<String> tempListNew;
	private PropertyChangeListener monthChooserListener;
	static JMonthChooser monthChooser;
	static int CequalM = 0;
	
	Months(){
	}
	
	void load() throws ParseException {
		SimpleDateFormat formatter_month = new SimpleDateFormat("MMMM");  
	    Date date = new Date(); 
	    
	    txtCurrentMonth = new JTextField();
		txtCurrentMonth.setEditable(false);
		txtCurrentMonth.setText(formatter_month.format(date)+"'s birthdays");
		txtCurrentMonth.setHorizontalAlignment(SwingConstants.CENTER);
		txtCurrentMonth.setBounds(10, 11, 250, 30);
		GUI.frame.getContentPane().add(txtCurrentMonth);
		txtCurrentMonth.setColumns(10);
		txtCurrentMonth.setFocusable(false);
		
		monthChooser = new JMonthChooser();
		monthChooser.setBounds(341, 11, 125, 30);
		GUI.frame.getContentPane().add(monthChooser);
		
		GUI.scrollPaneCM = new JScrollPane();
		GUI.scrollPaneCM.setBounds(10, 41, 250, 250);
		GUI.frame.getContentPane().add(GUI.scrollPaneCM);
		
		GUI.scrollPaneNM = new JScrollPane();
		GUI.scrollPaneNM.setBounds(270, 41, 250, 250);
		GUI.frame.getContentPane().add(GUI.scrollPaneNM);
		
		try {
			dates = fb.getDates();
			fnames = ffn.getfname();
			lnames = fln.getlname();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		tempList = new DefaultListModel<String>();
		String tempLine;
		for(int i = 1; i < dates.size(); i++) {
			int cont = 0;
			Date temp = new SimpleDateFormat("dd MMMM").parse(dates.get(i));
			if(formatter_month.format(date).equals(formatter_month.format(temp))) {
				tempLine = dates.get(i) + " - " + fnames.get(i) + " " + lnames.get(i);
				tempList.add(cont, tempLine);
				cont++;
			}
		}
		OrderDaysMonth list = new OrderDaysMonth(tempList, dates, fnames, lnames);
		tempList = list.getOrder();
		GUI.CurrentMonth = new JList<String>(tempList);
		GUI.scrollPaneCM.setViewportView(GUI.CurrentMonth);
		
		int nextMonth = getNextMonth(formatter_month.format(date));
		monthChooser.setMonth(nextMonth);
		
		monthChooserListener = new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				try {
					dates = fb.getDates();
					fnames = ffn.getfname();
					lnames = fln.getlname();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tempListNew = new DefaultListModel<String>();
				String tempLineNew;
				for(int i = 1; i < dates.size(); i++) {
					int contNew = 0;
					Date tempNew = null;
					try {
						tempNew = new SimpleDateFormat("dd MMMM").parse(dates.get(i));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					if(formatter_month.format(tempNew).equals(getMonth(monthChooser.getMonth()))) {		
						tempLineNew = dates.get(i) + " - " + fnames.get(i) + " " + lnames.get(i);
						tempListNew.add(contNew, tempLineNew);
						contNew++;
					}
				}
				if(formatter_month.format(date).equals(getMonth(monthChooser.getMonth()))) {
					CequalM = 1;
				} else {
					CequalM = 0;
				}
				OrderDaysMonth listNew = new OrderDaysMonth(tempListNew, dates, fnames, lnames);
				try {
					tempListNew = listNew.getOrder();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				GUI.NextMonth = new JList<String>(tempListNew);
				GUI.NextMonth.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				GUI.scrollPaneNM.setViewportView(GUI.NextMonth);
				new BtnDel().loadNext(GUI.NextMonth, GUI.btnDel);
				
			}
		};
		monthChooser.addPropertyChangeListener(monthChooserListener);
	}

	void birthday() throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM");  
	    Date date = new Date(); 
	    dates = fb.getDates();
		fnames = ffn.getfname();
		lnames = fln.getlname();
		for(int i = 1; i < dates.size(); i++) {
			if(formatter.format(date).equals(dates.get(i))) {
				String birthday = "Today is " + fnames.get(i) + " " + lnames.get(i) + "'birthday!";
				new App_SystemTray().BirthdayMessage(birthday);
			}
		}
	}
	
	String getMonth(int i) {
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return months[i];
	}
	
	int getNextMonth(String currentMonth) {
		int nextMonth = 0;
		String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		for(int i=0; i<months.length; i++) {
			if(currentMonth.equals(months[i])) {
				if(i == months.length) {
					nextMonth = 0;
				} 
				else {
					nextMonth = i+1;
				}
			}
		}
		return nextMonth;
	}
	
	void refreshCurrentMonth() throws ParseException {
		
		SimpleDateFormat formatter_month = new SimpleDateFormat("MMMM");  
	    Date date = new Date();
		try {
			dates = fb.getDates();
			fnames = ffn.getfname();
			lnames = fln.getlname();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		tempList = new DefaultListModel<String>();
		String tempLine;
		for(int i = 1; i < dates.size(); i++) {
			int cont = 0;
			Date temp = new SimpleDateFormat("dd MMMM").parse(dates.get(i));
			if(formatter_month.format(date).equals(formatter_month.format(temp))) {
				tempLine = dates.get(i) + " - " + fnames.get(i) + " " + lnames.get(i);
				tempList.add(cont, tempLine);
				cont++;
			}
		}
		OrderDaysMonth list = new OrderDaysMonth(tempList, dates, fnames, lnames);
		tempList = list.getOrder();
		GUI.CurrentMonth.setModel(tempList);
	}
	
	void refreshNextMonth() {
		SimpleDateFormat formatter_month = new SimpleDateFormat("MMMM");  
	    try {
			dates = fb.getDates();
			fnames = ffn.getfname();
			lnames = fln.getlname();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tempListNew = new DefaultListModel<String>();
		String tempLineNew;
		for(int i = 1; i < dates.size(); i++) {
			int contNew = 0;
			Date tempNew = null;
			try {
				tempNew = new SimpleDateFormat("dd MMMM").parse(dates.get(i));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(formatter_month.format(tempNew).equals(getMonth(monthChooser.getMonth()))) {		
				tempLineNew = dates.get(i) + " - " + fnames.get(i) + " " + lnames.get(i);
				tempListNew.add(contNew, tempLineNew);
				contNew++;
			}
			OrderDaysMonth listNew = new OrderDaysMonth(tempListNew, dates, fnames, lnames);
			try {
				tempListNew = listNew.getOrder();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GUI.NextMonth.setModel(tempListNew);
		}
	}
	
}
