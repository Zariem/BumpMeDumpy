package application;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Room extends JPanel implements ActionListener {
	// a room in our game as in level or platform, etc.
	private static final long serialVersionUID = 1L;
	private int height;
	private int width;
	ImageIcon background;
	Player player;
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	
	//just testing
	Image bg, plr, blk;
	Player ghost;
	GameObject tempObj;
	SolidBlock myblock;
	
	Timer time;
	
	public Room() {
		// this is just for testing
		setFocusable(true);
		background = new ImageIcon(getClass().getResource("Hintergrund.jpg"));
		bg = background.getImage();
		height = 1152;
		width = 2048;
		ImageIcon[] icon = new ImageIcon[1];
		icon[0] = new ImageIcon(getClass().getResource("Player.png"));
		plr = icon[0].getImage();
		player = new Player(0,0,40,40,icon,0,1);
		ghost = new Player(player.getX(), player.getY(), player.getWidth(), player.getHeight(), null, 0, 1);
		
		ImageIcon[] iconBlock = new ImageIcon[1];
		iconBlock[0] = new ImageIcon(getClass().getResource("Block.png"));
		blk = iconBlock[0].getImage();
		myblock = new SolidBlock(200,200,250,100,iconBlock,0,1);
		objects.add(myblock);
		// testing D;
		
		addKeyListener(new KeyListener());
		time = new Timer(5,this);
		time.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ghost.move(player.getHorizontal(), player.getVertical());
		if (objects.size()==0) {
			player.move(player.getHorizontal(), player.getVertical());
		} else {
			for(int i = 0; i < objects.size(); i++) {
				tempObj = objects.get(i);
				if (ghost.collidesWith(tempObj)) {
					ghost.move(- player.getHorizontal(), - player.getVertical());
					break;
				}
				if ((i == (objects.size()-1))) {
					player.move(player.getHorizontal(), player.getVertical());
				}
			}
		}
		
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics2d = (Graphics2D) g;
		
		graphics2d.drawImage(bg, 0, 0, null);
		graphics2d.drawImage(plr, player.getX(), player.getY(), null);
		graphics2d.drawImage(blk, myblock.getX(), myblock.getY(), null);
		
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int newHeight) {
		height = newHeight;
	}
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	
	
	// there be dragons!	
	private class KeyListener extends KeyAdapter {
		
		public KeyListener() {
			// do nothing here
		}
		
		public void keyPressed(KeyEvent e) {
			// now check which key was pressed
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_LEFT) {
				player.setHorizontal(player.getHorizontal()-1);
			}
			
			if (key == KeyEvent.VK_RIGHT) {
				player.setHorizontal(player.getHorizontal()+1);
			}
			
			if (key == KeyEvent.VK_UP) {
				player.setVertical(player.getVertical()-1);
			}
			
			if (key == KeyEvent.VK_DOWN) {
				player.setVertical(player.getVertical()+1);
			}
			
			if(key == KeyEvent.VK_ESCAPE){
				System.exit(0);
			}
		}
		
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_LEFT) {
				player.setHorizontal(player.getHorizontal()+1);
			}
			
			if (key == KeyEvent.VK_RIGHT) {
				player.setHorizontal(player.getHorizontal()-1);
			}
			
			if (key == KeyEvent.VK_UP) {
				player.setVertical(player.getVertical()+1);
			}
			
			if (key == KeyEvent.VK_DOWN) {
				player.setVertical(player.getVertical()-1);
			}
		}
		
	}

}
