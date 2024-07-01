package menu;

import java.awt.*;
import javax.swing.*;

public class Main 
{

	public static void main(String[] args) 
	{
		JFrame f = new JFrame("scelta menù");
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new GridLayout(2,2));
		JPanel p3 = new JPanel(new BorderLayout());
		JPanel p4 = new JPanel(new BorderLayout());
		JPanel p5 = new JPanel(new FlowLayout());
		
		JLabel l1 = new JLabel("scegli il tuo pranzo", JLabel.CENTER);
		JLabel l2 = new JLabel("n porzioni ");
		JLabel l3 = new JLabel("n porzioni ");
		
		JTextField t1 = new JTextField(4);
		JTextField t2 = new JTextField(4);
		
		JCheckBox c1 = new JCheckBox("primo");
		JCheckBox c2 = new JCheckBox("secondo");
		
		JButton b1 = new JButton("ok");
		JButton b2 = new JButton("annulla");
		
		p3.add(l2, BorderLayout.CENTER);
		p3.add(t1, BorderLayout.EAST);
		p4.add(l3, BorderLayout.CENTER);
		p4.add(t2, BorderLayout.EAST);
		
		p2.add(c1);
		p2.add(p3);
		p2.add(c2);
		p2.add(p4);
		
		p5.add(b1);
		p5.add(b2);
		
		p1.add(l1, BorderLayout.NORTH);
		p1.add(p2, BorderLayout.CENTER);
		p1.add(p5, BorderLayout.SOUTH);
		
		f.getContentPane().add(p1);
		//f.setSize(400,225);
		f.pack();
		f.setVisible(true);
	}

}
