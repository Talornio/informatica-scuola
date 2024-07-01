package gioco;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class LevelOne{
	private final int MAX = 15;
	
	private ImageIcon blank = new ImageIcon("C:\\Users\\USER\\Downloads\\blank.png");
	private ImageIcon wall = new ImageIcon("C:\\Users\\USER\\Downloads\\wall.png");
	private ImageIcon arrive = new ImageIcon("C:\\Users\\USER\\Downloads\\arrive.png");
	private int mapPoint[][] = new int[MAX][MAX];
	private JTextField input = new JTextField(1);
	
	public LevelOne() {
		drawMap();
	}

	public ImageIcon getBlank() {
		return blank;
	}

	public ImageIcon getWall() {
		return wall;
	}

	public ImageIcon getArrive() {
		return arrive;
	}

	public int getMapPoint(int x, int y) {
		return mapPoint[x][y];
	}
	
	public void setMapPoint(int x, int y, int n) {
		 mapPoint[x][y] = n;
	}
	
	public JTextField getInput() {
		return input;
	}
	
	private void drawMap() {
		for(int y = 0; y < MAX; y++) {
			for(int x = 0; x < MAX; x++) {
				mapPoint[x][y] = 0;
				if(y == 0 || y == MAX-1 || x == 0 || x == MAX-1) mapPoint[x][y] = 2;
				if(y == 3 && x < 12) mapPoint[x][y] = 2;
				if(y == 6 && x > 2) mapPoint[x][y] = 2;
				if(y > 6 && y < 12 && x == 3) mapPoint[x][y] = 2;
				if(y > 6 && y < 12 && x == 9) mapPoint[x][y] = 2;
				if(y > 8 && x == 6) mapPoint[x][y] = 2;
				if(x == 12 && y == 8) mapPoint[x][y] = 3;
			}
		}
	}

}
