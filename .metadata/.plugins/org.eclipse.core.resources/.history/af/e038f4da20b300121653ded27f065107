import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HallAdmin extends JFrame{
	
	public static Map<String,JCheckBox> seatList = new HashMap<>();
	
	public HallAdmin(){
		
		super("Hall Overview - Admin");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(3,3));
		JPanel row01 = new JPanel();
		add(row01);
		
		for(int i = 1; i <= 60; i++){
			
			String seat = "seat"+i;
			seatList.put(seat, new JCheckBox());
			row01.add(seatList.get(seat));
			
			
		}
		
	}
	
	
	
	public static void main(String [] args){
		
		HallAdmin app = new HallAdmin();
		app.setVisible(true);
	}
	
}