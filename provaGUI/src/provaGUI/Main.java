package provaGUI;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Titolo");
		JPanel p = new JPanel();
		JLabel l = new JLabel("Etichetta");
		JButton b = new JButton("Bottone");
		
		p.add(l);
		p.add(b);
		
		Container c = f.getContentPane();
		
		c.add(p);
		
		f.setSize(800, 450);
		f.setVisible(true);
		

	}

}
