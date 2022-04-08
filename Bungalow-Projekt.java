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
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VorlageGUI extends JFrame {
	private JTextField textBungalowNr;
	private JTextField textStartWoche;
	private JTextField textEndWoche;
	private JTextField textAnzahlPersonen;
	private JTextField textRueckmeldung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VorlageGUI frame = new VorlageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VorlageGUI() {
		setAutoRequestFocus(false);
		setPreferredSize(new Dimension(800, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		boolean reservierungDurchfuehren = false;
		
		JButton btnReservierungDurchfuehren = new JButton("Reservierung Durchf\u00FChren");
		btnReservierungDurchfuehren.setBounds(27, 250, 200, 60);
		btnReservierungDurchfuehren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[][] reservierung = new int[2][10];
				
				reservierung[0][Integer.parseInt(textBungalowNr.getText())] = Integer.parseInt(textStartWoche.getText());
				reservierung[1][Integer.parseInt(textBungalowNr.getText())] = Integer.parseInt(textEndWoche.getText());
				reservierung[2][Integer.parseInt(textBungalowNr.getText())] = Integer.parseInt(textAnzahlPersonen.getText());
				
				
				
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(btnReservierungDurchfuehren);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setBounds(578, 332, 123, 60);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(btnNewButton_2);
		
		textBungalowNr = new JTextField();
		textBungalowNr.setBounds(159, 21, 164, 40);
		getContentPane().add(textBungalowNr);
		textBungalowNr.setColumns(10);
		
		textStartWoche = new JTextField();
		textStartWoche.setBounds(159, 72, 164, 40);
		textStartWoche.setColumns(10);
		getContentPane().add(textStartWoche);
		
		JLabel lblBungalowNr = new JLabel("Bungalow-Nummer:");
		lblBungalowNr.setBounds(27, 21, 100, 40);
		getContentPane().add(lblBungalowNr);
		
		JLabel lblStartWoche = new JLabel("Start-Woche:");
		lblStartWoche.setBounds(27, 72, 100, 40);
		getContentPane().add(lblStartWoche);
		
		JLabel lblEndWoche = new JLabel("End-Woche:");
		lblEndWoche.setBounds(27, 123, 100, 40);
		getContentPane().add(lblEndWoche);
		
		textEndWoche = new JTextField();
		textEndWoche.setColumns(10);
		textEndWoche.setBounds(159, 123, 164, 40);
		getContentPane().add(textEndWoche);
		
		textAnzahlPersonen = new JTextField();
		textAnzahlPersonen.setColumns(10);
		textAnzahlPersonen.setBounds(159, 173, 164, 40);
		getContentPane().add(textAnzahlPersonen);
		
		JLabel lblAnzahlPersonen = new JLabel("Anzahl Personen:");
		lblAnzahlPersonen.setBounds(27, 174, 100, 40);
		getContentPane().add(lblAnzahlPersonen);
		
		textRueckmeldung = new JTextField();
		textRueckmeldung.setColumns(10);
		textRueckmeldung.setBounds(27, 332, 200, 40);
		getContentPane().add(textRueckmeldung);
		
		JLabel lblAuswahlBungalowAnzeige = new JLabel("Bungalow ausw\u00E4hlen:");
		lblAuswahlBungalowAnzeige.setBounds(425, 21, 120, 40);
		getContentPane().add(lblAuswahlBungalowAnzeige);
		
		JComboBox comboAuswahlBungalow = new JComboBox();
		comboAuswahlBungalow.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboAuswahlBungalow.setMaximumRowCount(10);
		comboAuswahlBungalow.setBounds(580, 26, 45, 30);
		getContentPane().add(comboAuswahlBungalow);
		
		JTextField textBuchungenAnzeigen = new JTextField();
		textBuchungenAnzeigen.setColumns(10);
		textBuchungenAnzeigen.setBounds(425, 72, 200, 200);
		getContentPane().add(textBuchungenAnzeigen);
	}
}
