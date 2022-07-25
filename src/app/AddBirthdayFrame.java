package app;

import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class AddBirthdayFrame {

		static JFrame frame;
		static JDateChooser dateChooser;
		private JTextField txtFirstName;
		private JTextField txtLastName;
		
		
		public void load() throws IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM"); 
		Date date = new Date(); 
		Filefirstname ffn = new Filefirstname();
		Filelastname fln = new Filelastname();
		Filebirthdays fb = new Filebirthdays();
		
		frame = new JFrame("Add new birthday");
		File icon = new File("res/bdwindow.png");
		Image image = ImageIO.read(icon);
		frame.setIconImage(image);
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
		txtFirstName.setFocusable(false);
		
		txtLastName = new JTextField();
		txtLastName.setText("Last name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(153, 11, 133, 31);
		txtLastName.setFocusable(false);
		frame.getContentPane().add(txtLastName);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 53, 133, 31);
		frame.getContentPane().add(dateChooser);
		dateChooser.setDate(date);
		dateChooser.setDateFormatString("dd MMMM yyyy");
		
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowOpened( WindowEvent e ){
		        txtFirstName.setFocusable(true);
		        txtLastName.setFocusable(true);
		    }
		});
		
		txtFirstName.addFocusListener(new FocusListener(){
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFirstName.getText().equals("First name")) {
					txtFirstName.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtFirstName.getText().isEmpty()) {
					txtFirstName.setText("First name");
				}
			}
		});
		
		txtLastName.addFocusListener(new FocusListener(){
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLastName.getText().equals("Last name")) {
					txtLastName.setText(null);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtLastName.getText().isEmpty()) {
					txtLastName.setText("Last name");
				}
			}
		});
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					String newdate = System.lineSeparator() + formatter.format(dateChooser.getDate());
					if(txtFirstName.getText().equals("") || txtLastName.getText().equals("")) {
						JFrame mesaj = new JFrame();
						JOptionPane.showMessageDialog(mesaj,"Empty text in the name fields detected, please insert the full name","Info",JOptionPane.INFORMATION_MESSAGE);
						mesaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						mesaj.setFocusable(false);

					} else if(txtFirstName.getText().equals("First name") || txtLastName.getText().equals("Last name")){
						JFrame mesaj = new JFrame();
						JOptionPane.showMessageDialog(mesaj,"Default text in the name fields detected, please insert the full name","Info",JOptionPane.INFORMATION_MESSAGE);
						mesaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						mesaj.setFocusable(false);
					} else {
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
						JFrame mesaj = new JFrame();
						JOptionPane.showMessageDialog(mesaj,"Birthday successfully added","Info",JOptionPane.INFORMATION_MESSAGE);
						mesaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						mesaj.setFocusable(false);
						String newDate = newdate + " - " + txtFirstName.getText() + " " + txtLastName.getText();
						Months.tempList.addElement(newDate);
						try {
							new Months().refreshCurrentMonth();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(Months.CequalM == 1) {
							new Months().refreshNextMonth();
						}
						txtFirstName.setText("First name");
						txtLastName.setText("Last name");
						dateChooser.setDate(date);
						
						
					}
				} catch (NullPointerException e1) {
					JFrame mesaj = new JFrame();
					JOptionPane.showMessageDialog(mesaj,"Invalid date, please rechoose the date","Info",JOptionPane.INFORMATION_MESSAGE);
					mesaj.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					mesaj.setFocusable(false);
				}
			}
		});
		btnNewButton.setBounds(153, 53, 133, 31);
		frame.getContentPane().add(btnNewButton);
		
	}
	
}
