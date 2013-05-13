import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class User {
	
	private int ID;
	private String name;
	private String firstName;
	private String email;
	private String filename;
	FileManager fm = new FileManager();

	
	public User(String name, String firstName, String email){
		this.name = name;
		this.firstName = firstName;
		this.email = email;
		createUser();

	}
	public void createUser(){
		ID = ID+1;
		filename = "USER"+ID;
		fm.createFile(filename+".txt");
		System.out.println("Datei "+filename+".txt erstellt");
		
		sendUserData(ID ,name, firstName, email);
		ID++;
	}
	

	public void sendUserData(Object ID, Object object1, Object object2, Object object3){

		try (final PrintWriter userWriter = new PrintWriter(FileManager.file);) {
			userWriter.println(ID);
			userWriter.println(object1);
			userWriter.println(object2);
			userWriter.println(object3);
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
