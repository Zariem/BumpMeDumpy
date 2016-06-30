package application;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GUI extends JPanel implements ActionListener{
	

Timer time;	
Image img;
Image img2;

int left = 0;

int key;

int nx,nx2;

Block block1;
int coin_score;

int char_y = 430;

int X_Bild;
int laufen;

int anzahl = 0;
int anzahl2 = 0;


public GUI(){
	
	
	nx = 0;
	nx2 = 2048;
	
	key = 0;
	laufen = 0;
	
	setFocusable(true);
	ImageIcon u = new ImageIcon ((getClass().getResource("Hintergrund.jpg")));
	img = u.getImage();
	
	ImageIcon s = new ImageIcon((getClass().getResource("Charakter.png")));
	img2 = s.getImage();
	
	addKeyListener(new ActionListen());
	
	block1 = new Block(100,300,100,100,Color.GREEN);
	
	Sprung sprung = new Sprung();
	
	time = new Timer(5,this);
	time.start();
}

public void actionPerformed(ActionEvent e){
	bewegen();
	
	char_y = Sprung.sprungposition;
	
	repaint();
	
}

public void paint(Graphics g){
	
	super.paint(g);
	Graphics2D f2 = (Graphics2D) g;
	
	if(getXBild() == (anzahl * 4096)){
		anzahl += 1;
		nx = 0;
	}
	
	if(getXBild() == 2048+ (anzahl2 * 4096)){
		anzahl2 += 1;
		nx2 = 0;
	}
	
	if(getXBild() >= 0){
		f2.drawImage(img, 2048-nx, 0, null);
	}
	
	f2.drawImage(img, 2048-nx2,0,null);
	
	f2.drawImage(img2,left,char_y,null);
	
	f2.setColor(block1.getColor());
	f2.fillRect(block1.getX_Block()-getXBild(), block1.getY_Block(), block1.getWidth(), block1.getHeight());
	
	block1.Kollision(block1.getX_Block()-getXBild(), block1.getY_Block()+block1.getHeight(), left + (100-20) , char_y);
	
	if(block1.coin == true){
		coin_score = 1;
	}
	
	f2.drawString("Score", 10, 15);
}

private int getXBild() {
	return X_Bild;
}

public void bewegen(){
	
	if(laufen != -2){
		
		if(left + laufen <= 75){
			left += laufen;
		}
		else{
			X_Bild += laufen;
			nx += laufen;
			nx2 += laufen;
		}
	}
	else{
		if(left+laufen > 0){
			left += laufen;
		}
	}
	
	
}

private class ActionListen extends KeyAdapter{
	public ActionListen(){
		
	}
	
	public void keyPressed(KeyEvent e){
		
		
		key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT){
			laufen = -2;
		}
		
		
		if(key == KeyEvent.VK_RIGHT){
			laufen = 2;
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
		if(key == KeyEvent.VK_SPACE){
			Sprung();
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT){
			laufen = 0;
		}
			
	}
	
}

public void Sprung(){
	Sprung SprungAnimation = new Sprung();
	SprungAnimation.start();
}

}
