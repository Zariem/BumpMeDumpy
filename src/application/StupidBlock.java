package application;

import java.awt.Color;

public class StupidBlock{
	
	final int X, Y;
	final int WIDTH, HEIGHT;
	boolean coin = false;
	final Color COLOR;
	
	public StupidBlock(int p_x, int p_y, int p_width, int p_height, Color p_color){
		X = p_x;
		Y = p_y;
		WIDTH = p_width;
		HEIGHT = p_height;
		COLOR = p_color;
	}
	


	public boolean Kollision(int x_block, int y_block, int x_char, int y_char){
		if(x_char >= x_block && y_char >= y_block && y_char <= y_block+HEIGHT) {
			if(x_char <= x_block+WIDTH){
				// charakter ist IM block!
				coin = true;
				return true;
			}
			else{
				if(x_char-50 <= x_block+WIDTH){
					// charakter ist IM Block oder 50 Einheiten davor...
					coin = true;
					return true;
				}
			}
		}
		else{
			return false;
		}
		return false;
	}
	
	public int getX_Block(){
		return X;
	}
	
	public int getY_Block(){
		return Y;
	}
	
	public int getWidth(){
		return WIDTH;
	}
	
	public int getHeight(){
		return HEIGHT;
	}
	
	public Color getColor(){
		return COLOR;
	}
	
	public boolean Coin(){
		return coin;
	}
}





















