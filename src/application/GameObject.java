package application;

import javax.swing.ImageIcon;

public class GameObject {
	// the parent of all of our objects
	private int height;
	private int width;
	private int posX; // left boundary of our object
	private int posY; // upper boundary of our object
	private final boolean solidity;
	
	// TODO use .gif files instead of separate icons?
	ImageIcon[] icons; // if more than one icon, character may be animated
	int timesteps; // in how many timesteps should the icon be replaced by the next one
	int movementSpeed; // how fast it moves
	
	public GameObject(int x, int y, int objWidth, int objHeight, ImageIcon[] objIcons, int objTimesteps, int objSpeed, boolean isSolid) {
		posX = x;
		posY = y;
		height = objHeight;
		width = objWidth;
		icons = objIcons;
		timesteps = objTimesteps;
		movementSpeed = objSpeed;
		solidity = isSolid;
	}
	
	public void move(int dx, int dy) {
		// moves the character to the right by 'dx' pixels and down by 'dy' pixels
		posX += dx;
		posY += dy;
	}
	
	public boolean isSolid() {
		return solidity;
	}
	
	public boolean collidesWith(GameObject other) {
		// collision check with two rectangle collision boxes
		if(posX > other.posX) {
			// other's leftmost point is left of this
			if (posY > other.posY) {
				// other's uppermost point is below the highest point of this
				if ((other.posX + other.getWidth()) >= posX) {
					if ((other.posY + other.getHeight())>= posY) {
						return true;
					} //else
					return false;
				} //else
				return false;
			} else {
				// other's uppermost point is as high or higher up as the highest point of this
				if ((other.posX + other.getWidth()) >= posX) {
					if (other.posY <= (posY+getHeight())) {
						return true;
					} // else
					return false;
				} // else
				return false;
			}
		} else if (other.posY < posY) {
			if ((other.getY() + other.getHeight() >= posY)) {
				if (other.getX() <= (posX + getWidth())) {
					return true;
				} // else
				return false;
			} // else
			return false;
		} else {
			if (other.posY <= (posY+height)) {
				if (other.posX <= (posX+getWidth())) {
					return true;
				} //else
				return false;
			} // else
			return false;
		}
	}
	
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	
	public void setX(int newX) {
		posX = newX;
	}
	
	public void setY(int newY) {
		posY = newY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
}
