import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;


	public class Register extends JFrame {

		//Organisation
		
		// Variablen f�r Klasse User
		String firstName;
		String name;
		String birthday;
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
		public JPasswordField pwTF = new JPasswordField(25);	
		public JPasswordField pw2TF = new JPasswordField(25);

		public static JButton closeButton;
		
		////////////////////////////////////////////////////////////////////////////////

		public Register(){
			super("Registrierung");
			//Auskommentiert, damit sich nur das Register Fenster, jedoch nicht das gesamte Programm schlie�t.
			//setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(600,600);
			setLayout(new BorderLayout());

			//Header-Panel
			northPanel = new JPanel(new GridLayout(10,0));
			add(northPanel, BorderLayout.NORTH);

			instructionsLabel.setText("Bitte f�llen Sie folgendes Formular vollst�ndig aus: ");
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

			//Actionlistener f�r Registerbutton
			JButton registerButton = new JButton("Registrieren");
			registerButton.addActionListener (new DataActionListener (firstNameTF, nameTF, birthdayTF, emailTF, userNameTF, pwTF, pw2TF));
			southPanel.add(registerButton);
			JButton abortButton = new JButton("Abbrechen");
			//Button zum Abbrechen eingef�gt
			southPanel.add(abortButton);
			abortButton.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent e) {
		            dispose();
		            }
		        });
			
		}

		/////////////////////////////////////////////////////////////////////////////////
		
		//ActionListener f�r 5 Usereingaben
		
		//ActionEvents f�r UserDaten
		public class DataActionListener implements ActionListener {

			private JTextField firstNameTF;
			private JTextField nameTF;
			private JTextField birthdayTF;
			private JTextField emailTF;
			private JTextField userNameTF;
			private JPasswordField pwTF;
			private JPasswordField pw2TF;

			public DataActionListener (JTextField firstNameTF, JTextField nameTF, JTextField birthdayTF, JTextField emailTF, JTextField userNameTF, JPasswordField pwTF2, JPasswordField pw2tf2){
				this.firstNameTF = firstNameTF;
				this.nameTF = nameTF;
				this.birthdayTF = birthdayTF;
				this.emailTF = emailTF;
				this.userNameTF = userNameTF;
				this.pwTF = pwTF2;
				this.pw2TF = pw2tf2;
			}
			@Override
			public void actionPerformed (ActionEvent e){
				firstName = firstNameTF.getText();
				name = nameTF.getText();
				birthday = birthdayTF.getText();
				email = emailTF.getText();
				userName = userNameTF.getText();
				pw = String.valueOf(pwTF.getPassword());
				pw2 = String.valueOf(pw2TF.getPassword());
				System.out.println (firstName);
				System.out.println (name);
				System.out.println(birthday);
				System.out.println (email);
				System.out.println (userName);
				System.out.println (pw);
				System.out.println (pw2);
				if(comparePassword()==true && checkIfFilledIn()==true){
					sendData();
					//Fenster schlie�en.
					dispose();
					
				
					
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
		
		
		//�berpr�fen, ob alle Felder ausgef�llt
		public boolean checkIfFilledIn(){
			if (firstName.equals("") | name.equals("") | birthday.equals("") | email.equals("") | 
					userName.equals("") | pw.equals("") | pw2.equals("")){
				filledInDialog();
				return false;
			}
			else {
				return true;
			}
		}
		
		//JDialog Fester, falls nicht alle Daten ausgef�llt wurden
		public void filledInDialog(){
			final JDialog filledInDialog = new JDialog();
			filledInDialog.setTitle("Fehler");
			filledInDialog.setSize(400,100);
			filledInDialog.setModal(false);
			//filledInDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
			filledInDialog.setLayout(new GridLayout(2,1));
			filledInDialog.add(new JLabel("Bitte f�llen Sie alle Felder aus"));    
		    JButton closeButton = new JButton("schlie�en");
		    filledInDialog.add(closeButton);       
		    filledInDialog.setVisible(true);
		    closeButton.addActionListener(new ActionListener(){
		    
		    public void actionPerformed(ActionEvent e) {
		    	filledInDialog.dispose();	
		    }
		    }); 		
		}
		
		//Dialog wenn Registrierung erfolgreich war.
		public static void finishedDialog(){
			final JDialog filledInDialog = new JDialog();
			filledInDialog.setTitle("Registrierung erfolgreich!");
			filledInDialog.setSize(400,100);
			filledInDialog.setModal(false);
			//filledInDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
			filledInDialog.setLayout(new GridLayout(2,1));
			filledInDialog.add(new JLabel("Sie haben sich erfolgreich registriert!"));    
		    JButton closeButton = new JButton("schlie�en");
		    filledInDialog.add(closeButton);       
		    filledInDialog.setVisible(true);
		    closeButton.addActionListener(new ActionListener(){
		    
		    public void actionPerformed(ActionEvent e) {
		    	filledInDialog.dispose();	
		    }
		    }); 		
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
	        pwDialog.add(new JLabel("Passw�rter nicht identisch!"));    
	        JButton closeButton = new JButton("schlie�en");
	        pwDialog.add(closeButton);       
	        pwDialog.setVisible(true);
	        closeButton.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e) {
	        		pwDialog.dispose();	
	        	}
	        });  
	    }
		
	   //�bergabe der Userdaten an User.java
		public void sendData(){
			new User(firstName, name, birthday, email, userName, pw);
			System.out.println("SendData wurde ausgef�hrt");	
		}
		
		/////////////////////////////////////////////////////////////////////

		public static void main (String[] args){
			Register app = new Register();
			app.setVisible(true);
		}
	}