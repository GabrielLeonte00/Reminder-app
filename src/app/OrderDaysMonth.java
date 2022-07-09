package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultListModel;

public class OrderDaysMonth {

	private DefaultListModel<String> list;
	private Vector<String> dates;
	private Vector<String> fnames;
	private Vector<String> lnames;
	private Vector<String> dates_month = new Vector<>();
	private Vector<String> fnames_month = new Vector<>();
	private Vector<String> lnames_month = new Vector<>();
	
	OrderDaysMonth(DefaultListModel<String> list, Vector<String> dates, Vector<String> fnames, Vector<String> lnames){
		this.list = list;
		this.dates = dates;
		this.fnames = fnames;
		this.lnames = lnames;
	}
	
	DefaultListModel<String> getOrder() throws ParseException {
		SimpleDateFormat formatter_month = new SimpleDateFormat("MMMM");  
	    Date date = new Date(); 
	    
	    for(int i = 1; i < dates.size(); i++) {
	    	Date temp = new SimpleDateFormat("dd MMMM").parse(dates.get(i));
			if(formatter_month.format(date).equals(formatter_month.format(temp))) {	
				dates_month.add(dates.get(i));
				fnames_month.add(fnames.get(i));
				lnames_month.add(lnames.get(i));
			}
	    }
	    order();
	    return list;
	}
	
	void order() throws ParseException {
		Vector<String> listTemp = new Vector<>();
		for(int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			listTemp.add(i, temp);
		}
		for(int i = 0; i < listTemp.size()-1; i++) {
			for(int j = i+1; j < listTemp.size(); j++) {
				Date dti = new SimpleDateFormat("dd").parse(listTemp.get(i));
				Date dtj = new SimpleDateFormat("dd").parse(listTemp.get(j));
				if(dti.after(dtj)) {
					String temp = listTemp.get(i);
					listTemp.set(i, listTemp.get(j));
					listTemp.set(j, temp);
				}
			}
		}
		for(int i = 0; i < listTemp.size(); i++) {
			list.set(i, listTemp.get(i));
		}
	}

}
