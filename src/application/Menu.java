package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends JFrame implements ActionListener {

	private int buttonHeight = 40;
	private int buttonWidth;

	private JButton start;
	private JButton info;
	private JButton end;
	private JButton settings;
	
	public Menu(int frameWidth, int frameHeight) {
		super("Menu");
		
		int x = (frameWidth)/2;
		buttonWidth = (3*frameWidth)/8;
		
		start = new JButton("START");
		start.setBounds(x,40,buttonWidth,buttonHeight);
		start.addActionListener(this);
		add(start);
		
		info = new JButton("INFO");
		info.setBounds(x,120,buttonWidth,buttonHeight);
		info.addActionListener(this);
		add(info);
		
		settings = new JButton("SETTINGS");
		settings.setBounds(x,200,buttonWidth,buttonHeight);
		settings.addActionListener(this);
		add(settings);
		
		end = new JButton("END");
		end.setBounds(x,280,buttonWidth,buttonHeight);
		end.addActionListener(this);
		add(end);
		
		JLabel label = new JLabel("We did it!! OMGZ! (V.0.1)");
		label.setBounds(20, frameHeight-70, buttonWidth, 20);
		add(label);
		
		ImageIcon icon = new ImageIcon((getClass().getResource("Startbild.jpg")));
		JLabel pic = new JLabel(icon);
		pic.setBounds(25, 20, 250, 300);
		add(pic);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == start) {
			startGame();
		}
		if (e.getSource() == info) {
			Object[] options = {"HI THERE"};
			JOptionPane.showOptionDialog(null, "Hi :D", "Infos",
					                     JOptionPane.DEFAULT_OPTION,
					                     JOptionPane.PLAIN_MESSAGE,
					                     null, options, options[0]);
		}
		if (e.getSource() == settings) {
			Object[] options = {"CLICK ME!"};
			JOptionPane.showOptionDialog(null, "O_O", "Settings",
					                     JOptionPane.DEFAULT_OPTION,
					                     JOptionPane.PLAIN_MESSAGE,
					                     null, options, options[0]);
		}
		if (e.getSource() == end) {
			System.exit(0);
		}
		
	}
	
	public void startGame() {
		
		// Spiel wieder über JFrame einfügen? 
		JFrame window = new JFrame("BumpMeDumpy");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1000,600);
		window.setVisible(true);
		
	}

}

//setbounds (x, y, width, height)

