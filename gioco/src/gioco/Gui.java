package gioco;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	
	final int MAX = 15;
	
	private JPanel frame = new JPanel(new BorderLayout());
	private JPanel menuLayout = new JPanel(new FlowLayout());
	private JTextField input = new JTextField(1);
	private JLabel cxy = new JLabel();
	private JPanel penter = new JPanel(new FlowLayout());
	private JPanel map = new JPanel(new GridLayout(MAX,MAX));
	private JLabel element[][] = new JLabel[MAX][MAX];
	private JMenuBar mb = new JMenuBar();
	//private int xPoint = 0;
	//private int yPoint = 0;
	private Hero hero = new Hero();
	
	LevelOne l1 = new LevelOne();
	
	public Gui(String title) {
		super(title);
		
		for(int y = 0; y < MAX; y++) {
			for(int x = 0; x < MAX; x++) {
				element[x][y] = new JLabel();
				map.add(element[x][y]);
			}
		}
		
		screenRefresh();
		
		//penter.add(input);
		frame.add(map, BorderLayout.CENTER);
		frame.add(penter, BorderLayout.SOUTH);
		mb.add(menuLayout);
		menuLayout.add(cxy);
		menuLayout.add(input);
		
		input.addKeyListener(this);
		setJMenuBar(mb);
		getContentPane().add(frame);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void screenRefresh() { 
		cxy.setText("Y: "+hero.getY()+"  X: "+hero.getX()+"  /  "+l1.getMapPoint(hero.getX(), hero.getY()));
		for(int y = 0; y < MAX; y++) {
			for(int x = 0; x < MAX; x++) {
				//mapPoint[x][y] = 0;
				if(hero.getX() == x && hero.getY() == y) l1.setMapPoint(x, y, 1);
				if(l1.getMapPoint(x, y) == 0) element[x][y].setIcon(l1.getBlank());
				if(l1.getMapPoint(x, y) == 1) element[x][y].setIcon(hero.getPg());
				if(l1.getMapPoint(x, y) == 2) element[x][y].setIcon(l1.getWall());
				if(l1.getMapPoint(x, y) == 3) element[x][y].setIcon(l1.getArrive());
				//if(mapPoint[x][y] == 1) element[x][y].setText("1");
				//if(mapPoint[x][y] == 0) element[x][y].setText("0");
				//if(mapPoint[x][y] == 2) element[x][y].setText("2");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W) {
			l1.setMapPoint(hero.getX(), hero.getY(), 0);
			if(l1.getMapPoint(hero.getX(), hero.getY()-1) != 2) hero.up();
			screenRefresh();
			input.setText("");
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			l1.setMapPoint(hero.getX(), hero.getY(), 0);
			if(l1.getMapPoint(hero.getX(), hero.getY()+1) != 2) hero.down();
			screenRefresh();
			input.setText("");
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			l1.setMapPoint(hero.getX(), hero.getY(), 0);
			if(l1.getMapPoint(hero.getX()-1, hero.getY()) != 2) hero.left();
			screenRefresh();
			input.setText("");
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			l1.setMapPoint(hero.getX(), hero.getY(), 0);
			if(l1.getMapPoint(hero.getX()+1, hero.getY()) != 2) hero.right();
			screenRefresh();
			input.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
