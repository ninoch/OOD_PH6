package graphics;

import users.LoginedUser;
import users.Users;
import users.UsersDB;
import graphics.Admin.AdminUI;
import graphics.Doctor.DoctorUI;
import graphics.Patient.PatientUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passw;
	private int state = 0;

	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 240);
		mainPage();
	}
	
	private void mainPage()
	{
		setTitle("\u0648\u0631\u0648\u062F");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton login = new JButton("\u0648\u0631\u0648\u062F");
		login.setBounds(28, 159, 89, 23);
		contentPane.add(login);
		
		JButton forgetPass = new JButton("\u0641\u0631\u0627\u0645\u0648\u0634\u06CC \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		forgetPass.setBounds(127, 159, 127, 23);
		contentPane.add(forgetPass);
		
		JButton signup = new JButton("\u062B\u0628\u062A \u0646\u0627\u0645");
		signup.setBounds(264, 159, 89, 23);
		contentPane.add(signup);
		
		username = new JTextField();
		username.setToolTipText("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC \u062E\u0648\u062F \u0631\u0627 \u0648\u0627\u0631\u062F \u06A9\u0646\u06CC\u062F");
		username.setBounds(164, 33, 189, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel label = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(264, 11, 89, 11);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(264, 61, 89, 11);
		contentPane.add(label_1);
		
		passw = new JPasswordField();
		passw.setBounds(164, 83, 189, 20);
		contentPane.add(passw);
		
		JCheckBox showPass = new JCheckBox("\u0646\u0645\u0627\u06CC\u0634 \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		showPass.setBounds(164, 110, 189, 23);
		contentPane.add(showPass);
		
		JLabel warning = new JLabel("نام کاربری و یا کلمه عبور؛اشتباه است.");
		warning.setForeground(Color.RED);
		warning.setBounds(28, 135, 223, 23);
		warning.setVisible(false);
		contentPane.add(warning);
		
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JCheckBox showPass = (JCheckBox) changeEvent.getSource();
				if (showPass.isSelected())
		            passw.setEchoChar((char)0);
			    else
			    	passw.setEchoChar('*');
			}
		};
	    showPass.addChangeListener(changeListener);
	    
	    login.addActionListener( new ActionListener()
	    {
	        @SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
	        {
	        	warning.setVisible(false);
	        	
	        	if(username.getText().equals("admin") && passw.getText().equals("admin"))
        		{
	        		System.err.println("here");
	        		AdminUI a = new AdminUI();
	        		a.setVisible(true);
		        	LoginUI.this.dispose();
	        	}
	        	
	        	else if( UsersDB.login(username.getText(), passw.getText()))
	        	{	
	        		System.err.println(UsersDB.getByUserName(username.getText()).getType());
	        		new LoginedUser(UsersDB.getByUserName(username.getText()));
	        		if(UsersDB.getByUserName(username.getText()).getType().equals("GeneralDoctor")
	        		 || UsersDB.getByUserName(username.getText()).getType().equals("SepecialDoctor"))
	        		{
		        		DoctorUI d = new DoctorUI();
		        		d.setVisible(true);
		        	}	

	        		else if(UsersDB.getByUserName(username.getText()).getType().equals("Patient"))
	        		{
		        		PatientUI d = new PatientUI();
		        		d.setVisible(true);
		        	}    
	        		LoginUI.this.dispose();
	        	}
	        	else
	        	{
	        		warning.setText("Username or password is incorrect");
	        		warning.setVisible(true);
	        	}
	        }
	    });
	    
	    forgetPass.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	contentPane.setVisible(false);
				ForgetPass();
	        }
	    });
	    
	    signup.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	LoginUI.this.dispose();
	        	try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        }
	    });
	}

	Users usr = null;
	
	private void ForgetPass() {
		setTitle("\u0641\u0631\u0627\u0645\u0648\u0634\u06CC \u06A9\u0644\u0645\u0647 \u0639\u0628\u0648\u0631");
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		JLabel ls = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC:");
		ls.setHorizontalAlignment(SwingConstants.RIGHT);
		ls.setBounds(264, 11, 89, 11);
		contentPane.add(ls);
		
		JButton show = new JButton("\u0646\u0645\u0627\u06CC\u0634");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		show.setBounds(109, 168, 89, 23);
		contentPane.add(show);
		
		JButton back = new JButton("\u0628\u0627\u0632\u06AF\u0634\u062A");
		back.setBounds(14, 168, 89, 23);
		contentPane.add(back);
		
		JTextField username = new JTextField();
		username.setBounds(109, 25, 259, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel label = new JLabel("\u0646\u0627\u0645 \u06A9\u0627\u0631\u0628\u0631\u06CC:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(255, 11, 109, 14);
		label.setVisible(false);
		contentPane.add(label);
		
		JLabel passw = new JLabel("");
		passw.setHorizontalAlignment(SwingConstants.LEFT);
		passw.setBounds(14, 137, 354, 20);
		contentPane.add(passw);
		
		JLabel question = new JLabel("\u0633\u0648\u0627\u0644 \u0627\u0645\u0646\u06CC\u062A\u06CC \u0634\u0645\u0627\u061F");
		question.setHorizontalAlignment(SwingConstants.RIGHT);
		question.setBounds(14, 56, 354, 14);
		question.setVisible(false);
		contentPane.add(question);
		
		JLabel label_1 = new JLabel("\u067E\u0627\u0633\u062E \u0627\u0645\u0646\u06CC\u062A\u06CC:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(259, 81, 109, 14);
		label_1.setVisible(false);
		contentPane.add(label_1);
		
		JTextField answer = new JTextField();
		answer.setColumns(10);
		answer.setBounds(109, 106, 259, 20);
		answer.setVisible(false);
		contentPane.add(answer);
		
		JLabel warning = new JLabel("\u062E\u0637\u0627!");
		warning.setForeground(Color.RED);
		warning.setBounds(208, 172, 159, 14);
		warning.setVisible(false);
		contentPane.add(warning);

		show.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	    		warning.setVisible(false);
	        	if(state == 0)
	        	{
	        		usr = UsersDB.getByUserName(username.getText());
	        		if(usr == null)
	        		{
	        			warning.setText("Please Register!");
	        			warning.setVisible(true);
	        		}
	        		else
	        		{
	        			System.err.println(usr.getForgetQuestion());
	        			question.setText(usr.getForgetQuestion());
	        			question.setVisible(true);
	        			label_1.setVisible(true);
	        			answer.setVisible(true);
	        			state ++;
	        		}
	        	}
	        	else if(state == 1)
	        	{
	        		System.err.println(usr.getForgetAnswer());
	        		if(!answer.getText().equals(usr.getForgetAnswer()))
	        		{
	        			warning.setText("Wrong Answer");
	        			warning.setVisible(true);
	        		}
	        		else
	        		{
	        			passw.setText(usr.getPassword());
	        			passw.setVisible(true);
		        		state = 0;
	        		}
	        	}
	        	
	        }
	    });
		
		back.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	contentPane.setVisible(false);
	        	mainPage();
	        }
	    });

	}
}
