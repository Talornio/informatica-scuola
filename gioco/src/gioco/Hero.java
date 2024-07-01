package gioco;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

public class Hero extends JLabel{
	private static final long serialVersionUID = 1L;
	
	private int x = 2;
	private int y = 2;
	private ImageIcon pg = new ImageIcon("C:\\Users\\USER\\Downloads\\pg.png");
	
	public Hero() {
		setBackground(Color.BLACK);
		setIcon(pg);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public ImageIcon getPg() {
		return pg;
	}

	public void move(int dx, int dy) {
		x+=dx;
		y+=dy;
	}
	
	public void up() {
		move(0,-1);
	}
	
	public void down() {
		move(0,1);
	}
	
	public void right() {
		move(1,0);
	}
	
	public void left() {
		move(-1,0);
	}

}
