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
import javax.swing.JDialog;


	public class Register extends JFrame {

		//Organisation
		
		// Variablen für Klasse User
		String firstName;
		String name;
		String email;
		String userName;       						  
		String pw;  
		String pw2;

		private JLabel instructionsLabel = new JLabel();
		private JLabel firstNameLabel = new JLabel();
		private JLabel nameLabel = new JLabel();
		private JLabel birthdayLabel = new JLabel();
		private JLabel emailLabel = new JLabel();
		private JLabel userNameLabel = new JLabel();    	   
		private JLabel pwLabel = new JLabel();    
		private JLabel pw2Label = new JLabel();  
		
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
		public JTextField pw2TF = new JTextField(25);

		public static JButton closeButton;
		////////////////////////////////////////////////////////////////////////////////

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
			pw2Label.setText(" Passwort wiederholen:");
			birthdayLabel.setText(" Geburtsdatum:   (TT.MM.JJJJ)");
			emailLabel.setText(" Email-Adresse:   (mustermann@domain.de)");
			
			westPanel.add(firstNameLabel);
			westPanel.add(nameLabel);
			westPanel.add(userNameLabel);						
			westPanel.add(pwLabel);	
			westPanel.add(pw2Label);	
			westPanel.add(birthdayLabel);
			westPanel.add(emailLabel);

			eastPanel.add(firstNameTF);	
			eastPanel.add(nameTF);
			eastPanel.add(userNameTF);							
			eastPanel.add(pwTF);	
			eastPanel.add(pw2TF);
			eastPanel.add(birthdayTF);
			eastPanel.add(emailTF);

			//Actionlistener für Registerbutton
			JButton registerButton = new JButton("Registrieren");
			registerButton.addActionListener (new DataActionListener (firstNameTF, nameTF, emailTF, userNameTF, pwTF, pw2TF));
			southPanel.add(registerButton);
		}

		/////////////////////////////////////////////////////////////////////////////////
		
		//ActionListener für 5 Usereingaben
		
		//ActionEvents für UserDaten
		public class DataActionListener implements ActionListener {

			private JTextField firstNameTF;
			private JTextField nameTF;
			private JTextField emailTF;
			private JTextField userNameTF;
			private JTextField pwTF;
			private JTextField pw2TF;

			public DataActionListener (JTextField firstNameTF, JTextField nameTF, JTextField emailTF, JTextField userNameTF, JTextField pwTF, JTextField pw2TF){
				this.firstNameTF = firstNameTF;
				this.nameTF = nameTF;
				this.emailTF = emailTF;
				this.userNameTF = userNameTF;
				this.pwTF = pwTF;
				this.pw2TF = pw2TF;
			}
			@Override
			public void actionPerformed (ActionEvent e){
				firstName = firstNameTF.getText();
				name = nameTF.getText();
				email = emailTF.getText();
				userName = userNameTF.getText();
				pw = pwTF.getText();
				pw2 = pw2TF.getText();
				System.out.println (firstName);
				System.out.println (name);
				System.out.println (email);
				System.out.println (userName);
				System.out.println (pw);
				System.out.println (pw2);
				if(comparePassword()==true){
					sendData();
				}
			}
		}

		//Vergleich der Passworteingabe
		public boolean comparePassword(){
			if(pw.equals(pw2)) {
			    System.out.println("gleich");
			    return true;
			}
			 else {
				 System.out.println("ungleich");
				 pwDialog();  
			     return false;
			    }
			}
		
		//JDialog Fenster falls das Passwort falsch ist
		public void pwDialog() {
			final JDialog pwDialog = new JDialog();
	        pwDialog.setTitle("Achtung");
	        pwDialog.setSize(200,200);
	        pwDialog.setModal(false);
	        pwDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	        pwDialog.setSize(200,200);
	        pwDialog.setLayout(new FlowLayout());
	        pwDialog.add(new JLabel("Passwörter nicht identisch!"));    
	        JButton closeButton = new JButton("schließ verflucht");
	        pwDialog.add(closeButton);       
	        pwDialog.setVisible(true);
	        closeButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e) {
	        		pwDialog.dispose();	
	        	}
	        });  
	    }
		
	   //Übergabe der Userdaten an User.java
		public void sendData(){
			new User(firstName, name, email, userName, pw);
			System.out.println("SendData wurde ausgeführt");	
		}
		
		/////////////////////////////////////////////////////////////////////

		public static void main (String[] args){
			Register app = new Register();
			app.setVisible(true);
		}
	}