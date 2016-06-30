package application;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;





public class StartMenue extends JFrame implements ActionListener {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JButton starten;
private JButton einstellung;
private JButton info;
private JButton ende;

	public static void main (String[]args) throws Exception{ 
		
	StartMenue frame = new StartMenue("Startmenü");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400,400);
	
	frame.setLayout(null);
	frame.setVisible(true);
	
	
	
	}
	
	public StartMenue(String title) {
		
		super(title);
		
		starten = new JButton("Spiel starten");
		starten.setBounds(130, 40, 150, 40);
		starten.addActionListener(this);
		add(starten);
		
		einstellung = new JButton("Einstellungen");
		einstellung.setBounds(120, 120, 160, 40);
		einstellung.addActionListener(this);
		add(einstellung);
	
		
		info = new JButton("Credits");
		info.setBounds(120, 200, 160, 40);
		info.addActionListener(this);
		add(info);
	
		
	    ende = new JButton("Beenden");
	    ende.setBounds(120, 280, 160, 40);
	    ende.addActionListener(this);
	    add(ende);
	   
	    
		
		JLabel label = new JLabel("Made by Jeanli (V 0.1)");
		label.setBounds(250,370,150,20);
		add(label);
	
		
	}
		
	
	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == starten){
			fenster();	
		}
		
		if (e.getSource() == info){
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(null, "Programmiert von Jeanli", "Information",

			        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,

			        null, options, options[0]);
		}
		
		if (e.getSource() == einstellung){
			Object[] options = {"OK"};
			JOptionPane.showOptionDialog(null, "Hier können sie Einstellungen vornehmen", "Information",

			        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,

			        null, options, options[0]);
		}
		
		
		if (e.getSource() == ende){
			System.exit(0);
			
			
		}
	}
	
	

	
	public static void fenster(){	
		JFrame fenster = new JFrame("Spiel");
		fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenster.setSize(1000,600);
		fenster.setVisible(true);
		fenster.add(new GUI());
	
	}
		}
	
	
		
		
	
	
 
