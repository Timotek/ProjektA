import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	JLabel userLabel = new JLabel("Username");
	JLabel passLabel = new JLabel("Password");
	
	JTextField userField = new JTextField();
	JTextField passField = new JTextField();
	
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("New Here? Sing up!");
	
	public Login(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //das muessen wir spaeter wohl rausnehmen, hab gelesen, dass das stoeren kann, wenn man den jframe im browser darstellen moechte
		setSize(300,100);
		setLayout(new GridLayout(3,2));
		
		add(userLabel);
		add(userField);
		add(passLabel);
		add(passField);
		add(loginButton);
		add(registerButton);
		
	}
	
	public static void main(String[]args){
		Login app = new Login();
		app.setVisible(true);
			
	}
}

