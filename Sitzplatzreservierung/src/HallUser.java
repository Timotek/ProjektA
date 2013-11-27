import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HallUser extends JFrame{
	
	//Hier werden zwei HashMaps erstellt, in denen spaeter die 
	//Reihen als JPanels und die Sitze als JCheckboxen
	//gespeichert werden
	public static Map<String,JCheckBox> seatList = new HashMap<>();
	public static Map<String,JPanel> rowList = new HashMap<>();
	public static Map<Integer,Boolean> idList = new HashMap<>();

	
	//Die zwei Buttons...
	JButton save = new JButton("Speichern");
	JButton discard = new JButton("Zurueck");
	
	//Objekt vom FileManager erstellen
	FileManager fm = new FileManager();

	//Laufvariable fuer die idList-HashMap
	int seatID = 0;

	

	
	public HallUser(){
		
		//Standard-Kontruktor...
		super("Hall Overview");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(9,1));
		
		//Datei waehlen 
		fm.chooseFile("seats.txt");

		save.addActionListener(new SaveListener());

		
		//Erste For-Schleife: Hier werden die Reihen erstellt,
		//dann in die HashMap geladen und dem JFrame hinzugefuegt
		for(int i = 1; i <= 9 ; i++){
			
			String row = "row"+i;
			rowList.put(row, new JPanel());
			JPanel panel = rowList.get(row);
			add(panel);
			int k = 1;
			
			if(i<=8){
				
				JLabel label = new JLabel("Reihe"+i);
				panel.add(label);
				
			} else { 
				
				panel.add(save);
				panel.add(discard);
				
			}
			
			
			//Verschachtelte For-Schleife: Hier werden die Sitze 
			//erstellt, in die HashMap geladen und dem JPanel hinzugefuegt
			for(int j = k; j <= 13; j++){
				
				if(i==9){
					break; //"Reihe" 9 bleibt frei fuer die Buttons
				}
				
				//JCheckBox instanzieren und in SeatList packen
				String seatString = "seat"+i+j;
				seatList.put(seatString, new JCheckBox());
				
				//JCheckBox aus der SeatList holen
				JCheckBox checkBox = seatList.get(seatString);
				
				//idList-Eintrag erstellen und Laufvariable hochzaehlen
				idList.put(seatID, true);
				seatID ++;
				
				//Ueberpruefen ob Sitz verfuegbar mittel methode aus dem FileManager
				int isGrey = fm.readFile();
				if(isGrey == seatID){
					checkBox.setEnabled(true);
					//System.out.println("passt");
				} else {
					checkBox.setEnabled(false);
					//checkBox.setLabel("G");
					//System.out.println("passt nicht");
				}

				//Checkbox hinzufuegen
				panel.add(checkBox);

			}			
		}
	}
	
	
	//Dieser Action Listener uberpruft, welch Checkboxen ausgewählt sind
	public class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JCheckBox tempBox;
			fm.chooseFileWrite("seats2.txt");

			
			for(int i = 1; i <= 8 ; i++){
				
				for(int j = 1; j <= 13; j++){
					
					//System.out.println(seatList.get("seat"+i+j));

					tempBox = seatList.get("seat"+i+j);
					
					if(tempBox.isSelected() == true){
						
						try {
							fm.writeFile("true");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//System.out.println("DIKKA");
					} else {
						
						try {
							fm.writeFile("false");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						//System.out.println("LALA");
					}
				}
			}
		}
	}
	
	
	
	public static void main(String [] args){
		
		HallUser app = new HallUser();
		app.setVisible(true);

	}
}