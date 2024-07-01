package gui1;

import java.awt.*;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Scelta Menù");
		JPanel p = new JPanel(new BorderLayout());   //p = principale
		JPanel c = new JPanel(new GridLayout(2, 2)); //c = centrale
		JPanel c1 = new JPanel(new BorderLayout());  //c1 = centrale destra alto
		JPanel c2 = new JPanel(new BorderLayout()); //c2 = centrale destra basso
		JPanel b = new JPanel(new FlowLayout());  //b = basso
		
		JLabel l = new JLabel("Scegli il tuo pranzo", JLabel.CENTER); //l = etichetta principale
		JLabel ls1 = new JLabel("N. Porzioni: ");  //ls1 = etichetta per porzioni primo
		JLabel ls2 = new JLabel("N. Porzioni: ");  //ls2 = etichetta per porzioni secondo
		
		JTextField t1 = new JTextField(5);  //t1 = text box porzioni primo
		JTextField t2 = new JTextField(5); //t2 = text box porzioni secondo
		
		JCheckBox cb1 = new JCheckBox("Primo");  //cb1 = check box per il primo
		JCheckBox cb2 = new JCheckBox("Secondo"); //cb2 = check box per il secondo
		
		JButton b1 = new JButton("Ok");   //b1 = bottone basso per ok
		JButton b2 = new JButton("Annulla");  //b2 = bottone basso per annulla
		
		c1.add(ls1, BorderLayout.CENTER);
		c2.add(ls2, BorderLayout.CENTER);
		c1.add(t1, BorderLayout.EAST);
		c2.add(t2, BorderLayout.EAST);
		c1.setBackground(Color.lightGray);
		c2.setBackground(Color.lightGray);
		
		c.add(cb1);
		c.add(c1);
		c.add(cb2);
		c.add(c2);
		c.setBackground(Color.lightGray);
		cb1.setBackground(Color.lightGray);
		cb2.setBackground(Color.lightGray);
		
		b.add(b1);
		b.add(b2);
		b.setBackground(Color.lightGray);
		
		p.add(l, BorderLayout.NORTH);
		p.add(c, BorderLayout.CENTER);
		p.add(b, BorderLayout.SOUTH);
		p.setBackground(Color.lightGray);
		
		f.getContentPane().add(p, "North");
		f.pack();
		//f.setSize(400, 225);
		f.setVisible(true);
	}

}
