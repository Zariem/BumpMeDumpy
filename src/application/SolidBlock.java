package application;

import javax.swing.ImageIcon;

public class SolidBlock extends GameObject {

	public SolidBlock(int x, int y, int objWidth, int objHeight, ImageIcon[] objIcons, int objTimesteps, int objSpeed) {
		super(x, y, objWidth, objHeight, objIcons, objTimesteps, objSpeed, true);
	}
	

}
