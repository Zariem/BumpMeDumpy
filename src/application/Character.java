package application;

import javax.swing.ImageIcon;

public class Character extends GameObject {

	int jumpHeight;
	
	
	public Character(int x, int y, int objWidth, int objHeight, ImageIcon[] objIcons, int objTimesteps, int objSpeed) {
		super(x, y, objWidth, objHeight, objIcons, objTimesteps, objSpeed);
	}

	
	
}
