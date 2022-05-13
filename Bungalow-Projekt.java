/**
 *  VORLAGE GUI 
 *  ---------------------------------------------------------------------- 
 *  Autor: Peter Braunschï¿½del
 *  Erstellungs-Datum: 28.03.2022
 *  Version 1.1
 *  Datum der letzten ï¿½nderung: 31.03.2022
 *  ï¿½nderung: Kommentar hinzugefï¿½gt
 *  ----------------------------------------------------------------------
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.attribute.AclEntry;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class Main extends JFrame {
	private JTextField textBungalowNr;
	private JTextField textStartWoche;
	private JTextField textEndWoche;
	private JTextField textAnzahlPersonen;
	private JTextField textRueckmeldung;
	private JTextField textEingabeBungalow;
	private JTextArea textAusgabe;
	
	int Bungalownr = 0;
	int StartWoche = 0;
	int EndWoche = 0;
	int Personen = 0;
	boolean ReservierungFunktioniert = true;
	
	
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.pack();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setAutoRequestFocus(false);
		setPreferredSize(new Dimension(800, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Reservierungen speichern
		
		int[][] reservierung = new int[3][10];
		
		JButton btnReservierungDurchfuehren = new JButton("Reservierung Durchf\u00FChren");
		btnReservierungDurchfuehren.setForeground(Color.BLUE);
		btnReservierungDurchfuehren.setBounds(27, 250, 296, 60);
		btnReservierungDurchfuehren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				 Bungalownr = Integer.parseInt(textBungalowNr.getText());
				 if (Bungalownr < 1 || Bungalownr >10) {
					throw new IllegalArgumentException();
				}
				 StartWoche =  Integer.parseInt(textStartWoche.getText());
				 if (StartWoche <1 || StartWoche > 52 ) {
					 throw new IllegalArgumentException();
				}
				 EndWoche = 	Integer.parseInt(textEndWoche.getText());
				 if (EndWoche <1 || EndWoche > 52 ) {
					 throw new IllegalArgumentException();
				 }
				 
				 
				 if( EndWoche < StartWoche) {
					 throw new IllegalAccessException();
					
					}
					 
				 Personen = Integer.parseInt(textAnzahlPersonen.getText());

				}catch (IllegalArgumentException a) {
					textRueckmeldung.setText("Bitte gültige Zahlen eingeben bzw. Zahlen prüfen!");
					ReservierungFunktioniert = false;
				} catch (IllegalAccessException e1) {
					textRueckmeldung.setText("Die Startwoche muss vor der Endwoche liegen!");
					ReservierungFunktioniert = false;
					e1.printStackTrace();
				}
				
				
				
				
				
				
				reservierung[0][Bungalownr] = StartWoche;
				reservierung[1][Bungalownr] = EndWoche;
				reservierung[2][Bungalownr] = Personen;
				
				if (ReservierungFunktioniert = true) {
					textRueckmeldung.setText("Reservierung erfolgreich!");
				}
				
					
				
					
				
				
				
				
				
				
				
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(btnReservierungDurchfuehren);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(652, 441, 123, 60);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(btnNewButton_2);
		
		// Eingabe der Daten
		
		
		textBungalowNr = new JTextField();
		textBungalowNr.setForeground(new Color(204, 153, 204));
		textBungalowNr.setBounds(159, 21, 164, 40);
		getContentPane().add(textBungalowNr);
		textBungalowNr.setColumns(10);
		
		textStartWoche = new JTextField();
		textStartWoche.setForeground(new Color(204, 153, 204));
		textStartWoche.setBounds(159, 72, 164, 40);
		textStartWoche.setColumns(10);
		getContentPane().add(textStartWoche);
		
		textEndWoche = new JTextField();
		textEndWoche.setForeground(new Color(204, 153, 204));
		textEndWoche.setColumns(10);
		textEndWoche.setBounds(159, 123, 164, 40);
		getContentPane().add(textEndWoche);
		
		textAnzahlPersonen = new JTextField();
		textAnzahlPersonen.setForeground(new Color(204, 153, 204));
		textAnzahlPersonen.setColumns(10);
		textAnzahlPersonen.setBounds(159, 173, 164, 40);
		
		//Feste JLabels
		
		getContentPane().add(textAnzahlPersonen);
		JLabel lblBungalowNr = new JLabel("Bungalow-Nummer:");
		lblBungalowNr.setForeground(Color.GRAY);
		lblBungalowNr.setBounds(27, 21, 100, 40);
		getContentPane().add(lblBungalowNr);
		
		JLabel lblStartWoche = new JLabel("Start-Woche:");
		lblStartWoche.setForeground(Color.GRAY);
		lblStartWoche.setBounds(27, 72, 100, 40);
		getContentPane().add(lblStartWoche);
		
		JLabel lblEndWoche = new JLabel("End-Woche:");
		lblEndWoche.setForeground(Color.GRAY);
		lblEndWoche.setBounds(27, 123, 100, 40);
		getContentPane().add(lblEndWoche);
		
		JLabel lblAnzahlPersonen = new JLabel("Anzahl Personen:");
		lblAnzahlPersonen.setForeground(Color.GRAY);
		lblAnzahlPersonen.setBounds(27, 174, 100, 40);
		getContentPane().add(lblAnzahlPersonen);
		
		JLabel lblAuswahlBungalowAnzeige = new JLabel("Bungalow ausw\u00E4hlen:");
		lblAuswahlBungalowAnzeige.setForeground(Color.GRAY);
		lblAuswahlBungalowAnzeige.setBounds(425, 21, 145, 40);
		getContentPane().add(lblAuswahlBungalowAnzeige);
		
		
		
		textRueckmeldung = new JTextField();
		textRueckmeldung.setColumns(10);
		textRueckmeldung.setBounds(27, 332, 296, 40);
		getContentPane().add(textRueckmeldung);
		
		textEingabeBungalow = new JTextField();
		textEingabeBungalow.setBounds(580, 26, 44, 30);
		getContentPane().add(textEingabeBungalow);
		textEingabeBungalow.setColumns(10);
		
		textAusgabe = new JTextArea();
		textAusgabe.setBounds(425, 82, 199, 136);
		getContentPane().add(textAusgabe);
		textAusgabe.setColumns(10);
		 
		
		
		
		JButton btnNewButton = new JButton("Pr\u00FCfen");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAusgabe.setText(
						
						"Start Woche: " + reservierung[0][Integer.parseInt(textEingabeBungalow.getText())] +"\n"+
						"End Woche: " + reservierung[1][Integer.parseInt(textEingabeBungalow.getText())] +"\n"+
						"Personen: " + reservierung[2][Integer.parseInt(textEingabeBungalow.getText())] +"\n"
									);
				
			}
		});
		btnNewButton.setBounds(425, 250, 200, 60);
		getContentPane().add(btnNewButton);
		 
	}
}
