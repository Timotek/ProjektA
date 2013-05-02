import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HallAdmin extends JFrame{
	
	public static Map<String,JCheckBox> seatList = new HashMap<>();
	public static Map<String,JPanel> rowList = new HashMap<>();

	
	public HallAdmin(){
		
		super("Hall Overview - Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(9,1));
		
		for(int i = 1; i <= 9 ; i++){
			
			String row = "row"+i;
			rowList.put(row, new JPanel());
			JPanel panel = rowList.get(row);
			add(panel);			
			
			for(int j = 1; j <= 13; j++){
				
				String seat = "seat"+j;
				seatList.put(seat, new JCheckBox());
				panel.add(seatList.get(seat));
				
			}			
		}
	}
	
	
	
	public static void main(String [] args){
		
		HallAdmin app = new HallAdmin();
		app.setVisible(true);
	}
	
}