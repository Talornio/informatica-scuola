package convertitoreGradi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends JFrame implements ActionListener{
	//per togliere warning
	private static final long serialVersionUID = 1L;
	
	//attributi
	private JPanel p = new JPanel(); //p = pannello principale
	private JPanel a = new JPanel();  //a = pannello alto
	private JPanel b = new JPanel();  //b = pannello basso

	private JLabel la = new JLabel();  //la = etichetta alta
	private JLabel lb = new JLabel();  //lb = etichetta bassa
	
	private JTextField tfa = new JTextField();  //tfa = text field alto
	private JTextField tfb = new JTextField();  //tfb = text field basso
	
	private JButton bp = new JButton(); //bp = bottone principale
	
	//metodi
	public Gui(String title) {
		super(title);
		
		bp.addActionListener(this);
		
		p.setLayout(new GridLayout(3,1));
		a.setLayout(new FlowLayout());
		b.setLayout(new FlowLayout());
		
		a.setBackground(Color.orange);
		b.setBackground(Color.pink);
		
		bp.setText("Converti");
		la.setText("Gradi Centigradi = ");
		lb.setText("Gradi Fahrenheit = ");
		
		tfa.setColumns(5);
		tfb.setColumns(5);
		tfb.setEditable(false);
		
		a.add(la);
		a.add(tfa);
		
		b.add(lb);
		b.add(tfb);
		
		p.add(a);
		p.add(bp);
		p.add(b);
		
		getContentPane().add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		String pulsante = a.getActionCommand();
		if (pulsante.equals("Converti")) {
			try {
				double gc = Double.valueOf(tfa.getText()).doubleValue();
				double f = 32 + (gc / 100) * 180;
				tfb.setText(""+f);
			}catch(Exception e) {
				tfb.setText("Errore");
			}
		}
	}
}	
