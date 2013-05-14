import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


	public class Register extends JFrame {

		//Organisation

		
		// Variablen für Klasse User
		String name;
		String firstName;
		String email;
		String userName;       						  
		String pw;              					  

		private JLabel instructionsLabel = new JLabel();
		private JLabel firstNameLabel = new JLabel();
		private JLabel nameLabel = new JLabel();
		private JLabel birthdayLabel = new JLabel();
		private JLabel emailLabel = new JLabel();
		private JLabel userNameLabel = new JLabel();    	   
		private JLabel pwLabel = new JLabel();          	   
		
		public JPanel northPanel;
		public JPanel westPanel;
		public JPanel eastPanel;
		public JPanel southPanel;

		public JTextField firstNameTF = new JTextField(25);
		public JTextField nameTF = new JTextField(25);
		public JTextField birthdayTF = new JTextField(25);
		public JTextField emailTF = new JTextField(25);
		public JTextField userNameTF = new JTextField(25);				
		public JTextField pwTF = new JTextField(25);					

		////////////////////////////////////////////////////

		public Register(){
			super("Registrierung");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(600,600);
			setLayout(new BorderLayout());

			//Header-Panel
			northPanel = new JPanel(new GridLayout(10,0));
			add(northPanel, BorderLayout.NORTH);

			instructionsLabel.setText("Bitte füllen Sie folgendes Formular vollständig aus: ");
			northPanel.add(instructionsLabel);

			//Formular-Panel
			westPanel = new JPanel(new GridLayout(12,0));
			add(westPanel, BorderLayout.WEST);
			eastPanel = new JPanel(new GridLayout(12,0));
			add(eastPanel, BorderLayout.EAST);
			southPanel = new JPanel(new FlowLayout());
			add(southPanel, BorderLayout.SOUTH);

			firstNameLabel.setText(" Vorname: ");
			nameLabel.setText(" Name: ");
			userNameLabel.setText(" Username:");									
			pwLabel.setText(" Passwort");										
			birthdayLabel.setText(" Geburtsdatum:   (TT.MM.JJJJ)");
			emailLabel.setText(" Email-Adresse:   (mustermann@domain.de)");
			
			westPanel.add(firstNameLabel);
			westPanel.add(nameLabel);
			westPanel.add(userNameLabel);						
			westPanel.add(pwLabel);								
			westPanel.add(birthdayLabel);
			westPanel.add(emailLabel);

			eastPanel.add(firstNameTF);	
			eastPanel.add(nameTF);
			eastPanel.add(userNameTF);							
			eastPanel.add(pwTF);								
			eastPanel.add(birthdayTF);
			eastPanel.add(emailTF);

			//Actionlistener für Registerbutton
			JButton registerButton = new JButton("Registrieren");
			registerButton.addActionListener (new NameActionListener (firstNameTF, nameTF, emailTF, userNameTF, pwTF));
			southPanel.add(registerButton);

		}

		////////////////////////////////////////////////////////////////////////
		
		//ActionListener für 5 Usereingaben
		
		//ActionEvents für UserDaten
		public class NameActionListener implements ActionListener {

			private JTextField nameTF;
			private JTextField firstNameTF;
			private JTextField emailTF;
			private JTextField userNameTF;
			private JTextField pwTF;

			public NameActionListener (JTextField nameTF, JTextField firstNameTF, JTextField emailTF, JTextField userNameTF, JTextField pwTF){
				this.nameTF = nameTF;
				this.firstNameTF = firstNameTF;
				this.emailTF = emailTF;
				this.userNameTF = userNameTF;
				this.pwTF = pwTF;
				
			}

			@Override
			public void actionPerformed (ActionEvent e){
				name = nameTF.getText();
				firstName = firstNameTF.getText();
				email = emailTF.getText();
				userName = userNameTF.getText();
				pw = pwTF.getText();
				System.out.println (name);
				System.out.println (firstName);
				System.out.println (email);
				System.out.println (userName);
				System.out.println (pw);
				sendData();
			}
		}


		
		

	   //Übergabe der Userdaten an User.java
		public void sendData(){

			new User(name, firstName, email, userName, pw);
			System.out.println("SendData wurde ausgeführt");
			
		}
		
		///////////////////////////////////////////////


		public static void main (String[] args){
			Register app = new Register();
			app.setVisible(true);

		}
	}