package application;

import javax.swing.ImageIcon;

public class GameObject {
	// the parent of all of our objects
	public static int height;
	public static int width;
	public int posX; // left boundary of our object
	public int posY; // upper boundary of our object
	ImageIcon[] icons; // if more than one icon, character may be animated
	int timesteps; // in how many timesteps should the icon be replaced by the next one
	int movementSpeed; // how fast it moves
	
	public GameObject(int x, int y, int objWidth, int objHeight, ImageIcon[] objIcons, int objTimesteps, int objSpeed) {
		posX = x;
		posY = y;
		height = objHeight;
		width = objWidth;
		icons = objIcons;
		timesteps = objTimesteps;
		movementSpeed = objSpeed;
	}
	
	public void move(int dx, int dy) {
		// moves the character to the right by 'dx' pixels and down by 'dy' pixels
		posX += dx;
		posY += dy;
	}
}
