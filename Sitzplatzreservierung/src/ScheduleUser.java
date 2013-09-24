import java.awt.Component;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScheduleUser extends JFrame{
	
	FileManager fm = new FileManager();

	
	public ScheduleUser(){
		
		super("Schedule");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLayout(new GridLayout(4,0));
		
		JPanel titlePanel = new JPanel();
		JPanel hall1Panel = new JPanel();
		JPanel hall2Panel = new JPanel();
		JPanel hall3Panel = new JPanel();
		
		JButton hall1ok = new JButton("Auswaehlen");
		JButton hall2ok = new JButton("Auswaehlen");
		JButton hall3ok = new JButton("Auswaehlen");
		
		add(titlePanel);
		add(hall1Panel);
		add(hall2Panel);
		add(hall3Panel);
		
		String movieTitle1;
		String movieTitle2;
		String movieTitle3;
		
		JLabel title = new JLabel("Bitte waehlen Sie einen Film:");
		titlePanel.add(title);

		fm.chooseFile("hall1.txt");
		
		movieTitle1 = fm.readHall();
		JLabel hall1Label = new JLabel("Saal 1: " + movieTitle1);
		hall1Panel.add(hall1Label);
		JComboBox<String> hall1comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall1comboBox.addItem(fm.readHall());
		}
		hall1Panel.add(hall1comboBox);
		hall1Panel.add(hall1ok);

		/////////////////////////////////////////
		
		fm.chooseFile("hall2.txt");
		
		movieTitle2 = fm.readHall();
		JLabel hall2Label = new JLabel("Saal 2: " + movieTitle2);
		hall2Panel.add(hall2Label);
		JComboBox<String> hall2comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall2comboBox.addItem(fm.readHall());
		}
		hall2Panel.add(hall2comboBox);
		hall2Panel.add(hall2ok);

		
		//////////////////////////////////////////
		
		fm.chooseFile("hall3.txt");
		
		movieTitle3 = fm.readHall();
		JLabel hall3Label = new JLabel("Saal 3: " + movieTitle3);
		hall3Panel.add(hall3Label);
		JComboBox<String> hall3comboBox = new JComboBox<String>();
		while(fm.readHall().equals("DATUM")){
			hall3comboBox.addItem(fm.readHall());
		}
		hall3Panel.add(hall3comboBox);
		hall3Panel.add(hall3ok);


		
		
		
		
		
	}
	
	
	public static void main(String[]args){
		
		ScheduleUser app = new ScheduleUser();
		app.setVisible(true);
	}
}