import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Register extends JFrame {
	
	//Organisation
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
	
	public JButton registerButton = new JButton("Registrieren");
	
	
	
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
		
		southPanel.add(registerButton);
	}
	
	public static void main (String[] args){
		Register app = new Register();
		app.setVisible(true);
	}
}
