package calcolatrice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	JPanel ptot = new JPanel(); //pannello principale
	JPanel p9 = new JPanel(); //pannello contenente 9 pulsanti accanto a =
	JPanel p8 = new JPanel(); //pannello contenente 8 pulsanti sopra = e p9
	JPanel p10 = new JPanel(); //pannello raggruppa p9 + =
	
	JTextField tf = new JTextField();
	
	JButton bv = new JButton(",");
	JButton bz = new JButton("0");
	JButton bpm = new JButton("+/-");
	JButton bu = new JButton("1");
	JButton bd = new JButton("2");
	JButton bt = new JButton("3");
	JButton bq = new JButton("4");
	JButton bc = new JButton("5");
	JButton bs = new JButton("6");
	JButton bst = new JButton("7");
	JButton bo = new JButton("8");
	JButton bn = new JButton("9");
	JButton bcanc = new JButton("C");
	JButton bplus = new JButton("+");
	JButton bminus = new JButton("-");
	JButton bper = new JButton("*");
	JButton bdiv = new JButton("/");
	JButton bequals = new JButton("=");
	
	public Gui(String title) {
		super(title);
		
		ptot.setLayout(new BorderLayout());
		p9.setLayout(new GridLayout(3,3));
		p8.setLayout(new GridLayout(2,4));
		p10.setLayout(new BorderLayout());
		
		bplus.setPreferredSize(new Dimension(60, 60));
		bequals.setPreferredSize(new Dimension(60, 180));
		
		ptot.add(tf, BorderLayout.NORTH);
		ptot.add(p8, BorderLayout.CENTER);
		ptot.add(p10, BorderLayout.SOUTH);
		
		p10.add(p9, BorderLayout.CENTER);
		p10.add(bequals, BorderLayout.EAST);
		
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setText("0");
		tf.setEditable(false);
		
		p8.add(bplus);
		p8.add(bminus);
		p8.add(bper);
		p8.add(bdiv);
		p8.add(bst);
		p8.add(bo);
		p8.add(bn);
		p8.add(bcanc);
		
		p9.add(bq);
		p9.add(bc);
		p9.add(bs);
		p9.add(bu);
		p9.add(bd);
		p9.add(bt);
		p9.add(bv);
		p9.add(bz);
		p9.add(bpm);
		
		bu.addActionListener(this);
		bd.addActionListener(this);
		bt.addActionListener(this);
		bq.addActionListener(this);
		bc.addActionListener(this);
		bs.addActionListener(this);
		bst.addActionListener(this);
		bo.addActionListener(this);
		bn.addActionListener(this);
		bz.addActionListener(this);
		
		bplus.addActionListener(this);
		bcanc.addActionListener(this);
		bequals.addActionListener(this);
		bminus.addActionListener(this);
		bper.addActionListener(this);
		bdiv.addActionListener(this);
		
		getContentPane().add(ptot);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private double primoNumero = 0.0;
	private String operatore = "";
	private boolean nuovoInserimento = true;
	@Override
	public void actionPerformed(ActionEvent a) {
		String input = a.getActionCommand();
		selezionaOperazione(input);
	}
	
	private void selezionaOperazione(String input) {
		if(input.equals("C")) {
			tf.setText("0");
			primoNumero = 0.0;
			operatore = "";
			nuovoInserimento = true;
		}
		else if(input.equals("+")) {
			calcolaOperazione();
			operatore = "+";
		}
		else if(input.equals("-")) {
			calcolaOperazione();
			operatore = "-";
		}
		else if(input.equals("*")) {
			calcolaOperazione();
			operatore = "*";
		}
		else if(input.equals("/")) {
			calcolaOperazione();
			operatore = "/";
		}
		else if(input.equals("=")) {
			calcolaOperazione();
			operatore = "";
		} else {
			String app = tf.getText();
			if(nuovoInserimento) {
				app = "";
				nuovoInserimento = false;
			}
			app += input;
			tf.setText(app);
			}
	}
	
	private void calcolaOperazione() {
		if(operatore.equals("")) {
			primoNumero = Double.valueOf(tf.getText()).doubleValue();
		}else {
			double secondoNumero = Double.valueOf(tf.getText()).doubleValue();
			if(operatore.equals("+")) {
				primoNumero += secondoNumero;
			}
			else if(operatore.equals("-")) {
				primoNumero -= secondoNumero;
			}
			else if(operatore.equals("*")) {
				primoNumero *= secondoNumero;
			}
			else if(operatore.equals("/")) {
				primoNumero /= secondoNumero;
			}
			tf.setText(""+primoNumero);
		}
		nuovoInserimento = true;
	}
}