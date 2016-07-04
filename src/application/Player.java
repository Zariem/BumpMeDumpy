package application;

import javax.swing.ImageIcon;

public class Player extends Character {
	// that's a character which we can steer!
	
	private int horizontal; // -1 = left; 0 = no horizontal movement; 1 = right
	private int vertical; // -1 = up; 0 = no vertical movement; 1 = down
	
	public Player(int x, int y, int objWidth, int objHeight, ImageIcon[] objIcons, int objTimesteps, int objSpeed) {
		super(x, y, objWidth, objHeight, objIcons, objTimesteps, objSpeed);
		horizontal = 0;
		vertical = 0;
	}

	public void setHorizontal(int value) {
		if(value < -1 || value > 1) {
			return;
		}
		horizontal = value;
	}
	
	public void setVertical(int value) {
		if(value < -1 || value > 1) {
			return;
		}
		vertical = value;
	}
	
	public int getHorizontal() {
		return horizontal;
	}
	
	public int getVertical() {
		return vertical;
	}

			
}
