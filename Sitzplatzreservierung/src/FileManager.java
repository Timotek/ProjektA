import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
	
	String filename;
	File file;
	String line;
	FileReader fileReader;
	BufferedReader bufferedReader;
	
	public FileManager(){
		/*
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	
	public void chooseFile(String filename){
		
		this.filename = filename;
		file = new File(filename);
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public String readHall(){

		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(line);

	    //int stringToInt = Integer.parseInt(line);
		return line;
	}
	
	
	

	public int readFile(){

		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(line);

	    int stringToInt = Integer.parseInt(line);
		return stringToInt;
	}
	
	/*
	public static void main(String[]args){
		
		FileManager app = new FileManager();
		//app.readFile();
	}
	*/
	
}