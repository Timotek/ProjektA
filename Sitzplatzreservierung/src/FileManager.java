import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class FileManager {
	
	String filename;
	static File file;
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
	

	//createFile-Methode durchsucht Hauptverzeichnis nach bestimmter Datei
	//Bisher nur m�glich, die Dateien im lokalen Hauptverzeichnis zu speicher,
	//die Pfade m�ssen noch angepasst werden...	
	
	public void createFile(String filename){
		file = new File("User\\"+filename);
		try (final PrintWriter fileWriter = new PrintWriter(file);) {
		
		}
		catch (FileNotFoundException e) {
			
		}
		
	}
	
	//searchFile-Methode durchsucht Hauptverzeichnis nach bestimmter Datei
	//Bisher nur m�glich, die Dateien im lokalen Hauptverzeichnis zu speicher,
	//die Pfade m�ssen noch angepasst werden...
	
	public boolean searchFile(String Filename){
		filename = "\\"+Filename;
		System.out.println("Dateiname, nach dem gesucht wird: "+filename);
		File f = new File("\\");
		File[] fileArray = f.listFiles();
		
		for (int i = 0; i < fileArray.length; i++){
			String arrayFileName = fileArray[i].getPath().toString();
			System.out.println(arrayFileName);
			if (arrayFileName.equalsIgnoreCase(filename)){
				return true;
			}
		}
		return false;
	}
	
	
	/*
	public static void main(String[]args){
		
		FileManager app = new FileManager();
	}
	*/
	
}