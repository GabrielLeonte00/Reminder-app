package app;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddBirthdayFrame {

		private JFrame frame;
		private JTextField txtFirstName;
		private JTextField txtLastName;
		
		
		public void load() throws IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = new Date(); 
		Filefirstname ffn = new Filefirstname();
		Filelastname fln = new Filelastname();
		Filebirthdays fb = new Filebirthdays();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 140);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		txtFirstName = new JTextField();
		txtFirstName.setText("First name");
		txtFirstName.setBounds(10, 11, 133, 31);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(153, 11, 133, 31);
		frame.getContentPane().add(dateChooser);	
		dateChooser.setDateFormatString("dd/MM/yyyy");	
		dateChooser.setDate(date);

		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		JButton btnNewButton = new JButton("Test");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					String newdate = System.lineSeparator() + formatter.format(dateChooser.getDate());
					try {
						Files.write(fb.getpath(), newdate.getBytes(), StandardOpenOption.APPEND);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String firstname = System.lineSeparator() + txtFirstName.getText();
					try {
						Files.write(ffn.getpath(), firstname.getBytes(), StandardOpenOption.APPEND);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String lastname = System.lineSeparator() + txtLastName.getText();
					try {
						Files.write(fln.getpath(), lastname.getBytes(), StandardOpenOption.APPEND);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (NullPointerException e1) {
					System.out.println("Null date inserted, please choose a date");
				}
			}
		});
		btnNewButton.setBounds(153, 53, 133, 31);
		frame.getContentPane().add(btnNewButton);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 53, 133, 31);
		frame.getContentPane().add(txtLastName);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
}
