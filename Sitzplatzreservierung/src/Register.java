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
	
	///////////////////////
	
	private JLabel instructionsLabel = new JLabel();
	private JLabel nameLabel = new JLabel();
	private JLabel firstNameLabel = new JLabel();
	private JLabel birthdayLabel = new JLabel();
	private JLabel emailLabel = new JLabel();
	
	public JPanel northPanel;
	public JPanel westPanel;
	public JPanel eastPanel;
	public JPanel southPanel;
	
	public JTextField nameTF = new JTextField(25);
	public JTextField firstNameTF = new JTextField(25);
	public JTextField birthdayTF = new JTextField(25);
	public JTextField emailTF = new JTextField(25);
	
	//public JButton registerButton = new JButton("Registrieren");
	
	//registerButton.addActionListener (new FooActionListener (nameTF));
	
	//////////////////////////////////
	
	
	
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
		
		nameLabel.setText("Name: ");
		firstNameLabel.setText("Vorname: ");
		birthdayLabel.setText("Geburtsdatum: (TT.MM.JJJJ");
		emailLabel.setText("Email-Adresse: (mustermann@domain.de");
		westPanel.add(nameLabel);
		westPanel.add(firstNameLabel);
		westPanel.add(birthdayLabel);
		westPanel.add(emailLabel);
		
		eastPanel.add(nameTF);
		eastPanel.add(firstNameTF);		
		eastPanel.add(birthdayTF);
		eastPanel.add(emailTF);
		
		//Actionlistener für Registerbutton
		JButton registerButton = new JButton("Registrieren");
		registerButton.addActionListener (new NameActionListener (nameTF));
		registerButton.addActionListener (new FirstNameActionListener (firstNameTF));
		registerButton.addActionListener (new EmailActionListener (emailTF));
		southPanel.add(registerButton);
	}
	
	//ActionListener für Nachnamen
	public class NameActionListener implements ActionListener {
	      
	    private JTextField nameTF;
	      
	    public NameActionListener (JTextField nameTF){
	        this.nameTF = nameTF;
	    }
	      
	    @Override
	    public void actionPerformed (ActionEvent e){
	    	name = nameTF.getText();
	       System.out.println (name);
	    }
    }
	
		
	//ActionListener für Vornamen
	public class FirstNameActionListener implements ActionListener {
		      
		 private JTextField firstNameTF;
		      
		 public FirstNameActionListener (JTextField firstNameTF){
	        this.firstNameTF = firstNameTF;
	    }
		      
	  @Override
		 public void actionPerformed (ActionEvent e){
		  firstName = firstNameTF.getText();
	       System.out.println (firstName);
		 }
    }
	
	//ActionListener für E-Mail
	public class EmailActionListener implements ActionListener {
				      
	    private JTextField emailTF;
				      
	    public EmailActionListener (JTextField emailTF){
			 this.emailTF = emailTF;
	   }
				      
	   @Override
		 public void actionPerformed (ActionEvent e){
		   email = emailTF.getText();
	       System.out.println (email);
	    }
	}
	

		//////////////////////////////////
	
	
	
	public static void main (String[] args){
		Register app = new Register();
		app.setVisible(true);
		User user = new User(name, firstName, email);
	}
}
