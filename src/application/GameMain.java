package application;

import javax.swing.JFrame;

public class GameMain {

	public static void main(String[] args) {
		// starte das Spiel!
		int windowHeight = 400;
		int windowWidth = 600;
		Menu mainMenu = new Menu(windowWidth,windowHeight);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setSize(windowWidth,windowHeight);
		mainMenu.setLayout(null);
		mainMenu.setVisible(true);
		mainMenu.setResizable(false);
	}

}
