package codiceFiscale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Gui extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private JPanel ptot = new JPanel(); //pannello principale
	private JPanel pn = new JPanel();   //pannello contenente nomi dei dati da inserire 
	private JPanel pin = new JPanel();  //pannello contenente componenti per inserimento dati
	private JPanel pcd = new JPanel();  //pannello contenente i componenti per la scelta della data di nascita
	private JPanel rbin = new JPanel(); //pannello contenente i radio button per la scelta del sesso
	private JPanel din = new JPanel();  //pannello contenente bottone converti e text field con risultato
	
	private JLabel dati[] = new JLabel[5];  //vettore contenente etichette 
	private String ndati[] = {"Cognome", "Nome", "Sesso", "Data di nascita", "Comune"}; //nomi delle etichette
	
	private JTextField caselleInput[] = new JTextField[5];  //vettore contenente le caselle di testo per l'input
	
	private JRadioButton m = new JRadioButton();  //due radio button per l'inserimento del sesso
	private JRadioButton f = new JRadioButton();
	
	private JComboBox<String> mese = new JComboBox<String>();  //combo box per scelta del mese
	private String nmese[] = {"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};	//nomi mesi
	private ButtonGroup bg = new ButtonGroup();
	
	private JButton bcd = new JButton();  //bottone converti
	private JTextField tcd = new JTextField();  //casella di testo per risultato
	
	public Gui(String title) {
		super(title);
		
		ptot.setLayout(new BorderLayout());
		pn.setLayout(new GridLayout(5,1));
		pin.setLayout(new GridLayout(5,1));
		din.setLayout(new GridLayout(2,1));
		rbin.setLayout(new GridLayout(1,2));
		pcd.setLayout(new BorderLayout());
		
		mese.setMaximumRowCount(12);
		
		for(int i = 0; i < 5; i++) {
			dati[i] = new JLabel(ndati[i]);
			caselleInput[i] = new JTextField();
			pn.add(dati[i]);
			if(i != 2) {
				if(i == 3) {
					pin.add(pcd);
				}else {
					pin.add(caselleInput[i]);
				}
			}else {
				pin.add(rbin);
			}
		}
		for(int i = 0; i < 12; i++) {
			mese.addItem(nmese[i]);
		}
		
		caselleInput[2].setColumns(5);
		caselleInput[3].setColumns(5);
		pcd.add(caselleInput[2], BorderLayout.WEST);
		pcd.add(mese, BorderLayout.CENTER);
		pcd.add(caselleInput[3], BorderLayout.EAST);
		
		m.setText("Maschio");
		f.setText("Femmina");
		bg.add(m);
		bg.add(f);
		rbin.add(m);
		rbin.add(f);
		m.setSelected(true);
		
		din.add(bcd);
		din.add(tcd);
		tcd.setEditable(false);
		bcd.setText("Calcola");
		
		ptot.add(pn, BorderLayout.WEST);
		ptot.add(pin, BorderLayout.CENTER);
		ptot.add(din, BorderLayout.SOUTH);
		
		getContentPane().add(ptot);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
