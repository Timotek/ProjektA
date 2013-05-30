import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	//Inititalisierung der Swing-Komponenten
	JLabel userLabel = new JLabel("Username");
	JLabel passLabel = new JLabel("Password");
	
	JTextField userField = new JTextField();
	JTextField passField = new JTextField();
	
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("New Here? Sign up!");
	
	String userName;
	String pw;
	
	FileManager fileM = new FileManager(); // Filemanager neues Objekt
	
	public Login(){
		
		//Standard-Konstruktor
		setDefaultCloseOperation(EXIT_ON_CLOSE); //das muessen wir spaeter wohl rausnehmen, hab gelesen, dass das stoeren kann, wenn man den jframe im browser darstellen moechte
		setSize(300,100);
		setLayout(new GridLayout(3,2));
		
		//Hinzufuegen der Komponenten zum JFrame
		add(userLabel);
		add(userField);
		add(passLabel);
		add(passField);
		loginButton.addActionListener (new UserNameActionListener (userField, passField));
		add(loginButton);
		add(registerButton);
	}
	
	
	//Login Erweiterung, Vergleich des Passworts in der user.txt 
	//actionlistener für login button
	
	public class UserNameActionListener implements ActionListener {

		private JTextField userField;
		private JTextField passField;

		public UserNameActionListener (JTextField userField, JTextField passField){
			this.userField = userField;
			this.passField = passField;
			
		}
		@Override
		public void actionPerformed (ActionEvent e){
			userName = userField.getText();
			pw = passField.getText();
			System.out.println (userName);
			System.out.println(pw);
			saveUserData();
			compareUserData();		
		}
	}
	
		ArrayList userList = new ArrayList<Double>();
		//Scannen der txt Datei, Schreiben der Zeilen in ArrayList
		
		public void saveUserData(){	
			try {
				Scanner scan = new Scanner(new File(userName + ".txt"));
				while(scan.hasNextLine()) {
					userList.add(scan.nextLine());
				}
				scan.close();			
				Iterator it = userList.iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			} 
			catch(FileNotFoundException e) {
				System.out.println("Fehler: Quelldatei existiert nicht");
				System.exit(1);
			} 
			catch(Exception e) {
				System.out.println("Fehler: Ein unbekannter Fehler ist aufgetreten");
				System.exit(1);
			}
		}
			
		//nächster Schritt: arraylist durchsuchen nach eingegebenem Passwort
	
		public void compareUserData(){

			if(pw.equals(userList.get(4)) ){
				System.out.println("Passwörter sind gleich!");
				System.out.println("Eingegebenes Passwort: " + pw);
				System.out.println("Gespeichertes Passwort: " + userList.get(4));
			}
			else {
				System.out.println("Passwörter nicht gleich!");
			}
				// eigentliche Funktion: Weiterleitung zur entsprechenden Seite bei erfolgreichem Login
				// bzw. bei fehlgeschlagenem Login JDialog Meldung
	    }

	
	
	public static void main(String[]args){
		Login app = new Login();
		app.setVisible(true);
			
	}
}

