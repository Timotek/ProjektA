import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
	
	String line;
	FileReader fileReader;
	BufferedReader bufferedReader;
	
	public FileManager(){

		try {
			fileReader = new FileReader("test.txt");
			bufferedReader = new BufferedReader(fileReader);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public int readFile(){

		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    int stringToInt = Integer.parseInt(line);
		return stringToInt;
		
	}
	
	public static void main(String[]args){
		
		FileManager app = new FileManager();
		//app.readFile();
	}
	
}