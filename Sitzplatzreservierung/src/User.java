import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class User {
	
  //private int ID;
	private String name;
	private String firstName;
	private String email;
	private String userName;							//neu
	private String pw;									//neu
	private String filename;
	FileManager fm = new FileManager();

	//IDim Konstruktor hinzugefügt
	public User(String name, String firstName, String email, String userName, String pw){
	  //this.ID = ID;
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		this.userName = userName;
		this.pw = pw;
		createUser();

	}
	public void createUser(){				// ID auskommentiert
	//	ID = ID+1;
	//	filename = "USER" + ID;
		filename = userName;
		fm.createFile(filename + ".txt");
		System.out.println("Datei " + filename + ".txt erstellt");
		
		sendUserData(name, firstName, email, userName, pw);
	//	ID++;
	}
	

	public void sendUserData(Object object1, Object object2, Object object3, Object object4, Object object5){

		try (final PrintWriter userWriter = new PrintWriter(FileManager.file);) {
		//	userWriter.println(ID);
			userWriter.println(object1);
			userWriter.println(object2);
			userWriter.println(object3);
			userWriter.println(object4);
			userWriter.println(object5);
			userWriter.close();
		}
		catch (FileNotFoundException e) {
			
		}
		
	}
	
	
/*	public static void main (String[] args){
		new User("Wurst", "Hans", "mist@wurst.de");	
		new User("Arte", "Tom", "tom@arte.de");	
		
	}
*/	
}
