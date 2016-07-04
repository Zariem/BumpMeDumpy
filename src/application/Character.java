package application;

import javax.swing.ImageIcon;

public class Character extends GameObject {

	int jumpHeight;
	//boolean inAir; // is the Character currently in the air?
	
	public Character(int x, int y, int objWidth, int objHeight, ImageIcon[] objIcons, int objTimesteps, int objSpeed) {
		super(x, y, objWidth, objHeight, objIcons, objTimesteps, objSpeed, false);
		// note: characters are NOT solid
	}

	
	
	public void jump() {
		// check if in air (or colliding from below!)
		// option for double jump?!
		// try to make a parabola
	}
	
}
