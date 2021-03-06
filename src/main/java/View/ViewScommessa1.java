package View;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import view_event.PiazzaScommessaEvent;
import model.Config;
import model.Scuderia;
import controller.ControllerInterface;
import controller_event.ScommessaEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewScommessa1 extends JPanel {
	private Integer valorePuntato = 0;

	/**
	 * Create the panel.
	 */
	public ViewScommessa1(final ScommessaEvent e, final ControllerInterface controller) {
		
		
		final Image img1 = new ImageIcon(ViewCorsa.class.getResource(e.getGiocatore().getCartaPersonaggio().getImmagine())).getImage(); 
		final JLabel cartaPersonaggio = new JLabel("");
		cartaPersonaggio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cartaPersonaggio.setIcon(new ImageIcon(img1));
				cartaPersonaggio.setBounds(100, 21,  537, 417);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cartaPersonaggio.setIcon(new ImageIcon(img1.getScaledInstance(110, 170,  java.awt.Image.SCALE_SMOOTH)));
				cartaPersonaggio.setBounds(53, 272,  107, 166);
			}
		});
		cartaPersonaggio.setHorizontalAlignment(SwingConstants.CENTER);
		

		cartaPersonaggio.setIcon(new ImageIcon(img1.getScaledInstance(110, 170,  java.awt.Image.SCALE_SMOOTH)));
		cartaPersonaggio.setBounds(43, 272,  107, 166);
		add(cartaPersonaggio);
		
		final Image img2 = new ImageIcon(ViewCorsa.class.getResource(e.getGiocatore().getCartaAzione1().getImmagine())).getImage(); 
		final JLabel cartaAzione1 = new JLabel("");
		cartaAzione1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cartaAzione1.setIcon(new ImageIcon(img2));
				cartaAzione1.setBounds(100, 21,  537, 417);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cartaAzione1.setIcon(new ImageIcon(img2.getScaledInstance(52,80, java.awt.Image.SCALE_SMOOTH)));
				cartaAzione1.setBounds(160, 272, 71, 82);
			}
		});
		cartaAzione1.setHorizontalAlignment(SwingConstants.CENTER);
		cartaAzione1.setIcon(new ImageIcon(img2.getScaledInstance(52,80, java.awt.Image.SCALE_SMOOTH)));
		cartaAzione1.setBounds(160, 272,  71, 82);
		add(cartaAzione1);
		
		final Image img3 = new ImageIcon(ViewCorsa.class.getResource(e.getGiocatore().getCartaAzione2().getImmagine())).getImage(); 
		final JLabel cartaAzione2 = new JLabel("");
		cartaAzione2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cartaAzione2.setIcon(new ImageIcon(img3));
				cartaAzione2.setBounds(100, 21,  537, 417);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				cartaAzione2.setIcon(new ImageIcon(img3.getScaledInstance(52,80, java.awt.Image.SCALE_SMOOTH)));
				cartaAzione2.setBounds(160, 360,  71, 77);
			}
		});
		cartaAzione2.setHorizontalAlignment(SwingConstants.CENTER);
		cartaAzione2.setIcon(new ImageIcon(img3.getScaledInstance(52,80, java.awt.Image.SCALE_SMOOTH)));
		cartaAzione2.setBounds(160, 356,  71, 82);
		add(cartaAzione2);
		
		
		
		final JLabel scelta1 = new JLabel("");
		scelta1.setBounds(514, 160, 61, 16);
		add(scelta1);
		
		final JLabel scelta2 = new JLabel("");
		scelta2.setBounds(514, 190, 61, 16);
		add(scelta2);
		
		final JLabel scelta3 = new JLabel("");
		scelta3.setBounds(514, 218, 61, 16);
		add(scelta3);
		
		setLayout(null);
		//creo la label che dice di chi e il turno
		JLabel lblNewLabel = new JLabel("TURNO DI : "+ e.getGiocatore().getNome().toUpperCase() );
		lblNewLabel.setBounds(431, 26, 156, 16);
		add(lblNewLabel);
		
		
		JLabel lblDenari = new JLabel("Denari");
		lblDenari.setBounds(431, 54, 61, 16);
		add(lblDenari);
		
		
		final JLabel denari = new JLabel("" + e.getGiocatore().getDenari());
		denari.setBounds(514, 54, 61, 16);
		add(denari);
		
		JLabel lblPV = new JLabel("PV");
		lblPV.setBounds(431, 87, 61, 16);
		add(lblPV);
		
		JLabel pv = new JLabel("" + e.getGiocatore().getPv());
		pv.setBounds(514, 87, 61, 16);
		add(pv);
		
		// inizializzo jpanel per scelta banconota
		JPanel sceltaBanconota = new JPanel();
		sceltaBanconota.setBackground(new Color(0,0,0,0));
		sceltaBanconota.setBounds(248, 272, 137, 166);
		sceltaBanconota.setLayout(new FlowLayout());
		for (int valore : Config.tipoDenari) {		
			
			final JLabel btnBanconota = new JLabel("");
			btnBanconota.setToolTipText(Integer.toString(valore));
			btnBanconota.setIcon(new ImageIcon(ViewScommessa1.class.getResource("/Denari/" + valore + ".jpg")));
			btnBanconota.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					valorePuntato += Integer.parseInt(btnBanconota.getToolTipText());
					denari.setText(""+ (e.getGiocatore().getDenari() - valorePuntato));
					scelta2.setText(Integer.toString(valorePuntato));
				}
			});
			
			sceltaBanconota.add(btnBanconota);
		}
		sceltaBanconota.setVisible(true);
		add(sceltaBanconota);
		
		JLabel lblCheTipoDi = new JLabel("CHE TIPO DI SCOMMESSA VUOI FARE?");
		lblCheTipoDi.setBounds(387, 284, 235, 16);
		add(lblCheTipoDi);
		
		//inizializzo jpanel per scelta tipo scommessa
		JPanel sceltaTipo = new JPanel();
		sceltaTipo.setBackground(new Color(0,0,0,0));
		sceltaTipo.setBounds(387, 311, 235, 46);
		sceltaTipo.setLayout(new FlowLayout());
		for (String tipo : Config.tipoScommessa) {
			final JButton btnTipo = new JButton(tipo);
			btnTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					scelta3.setText(btnTipo.getText());
						
				}
			});
			sceltaTipo.add(btnTipo);
		}
		sceltaTipo.setVisible(true);
		add(sceltaTipo);
		
		//label statiche scuderia, valore, tipo
		JLabel lblNewLabel_1 = new JLabel("Scuderia:");
		lblNewLabel_1.setBounds(431, 160, 71, 16);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Valore:");
		lblNewLabel_2.setBounds(431, 190, 61, 16);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo:");
		lblNewLabel_3.setBounds(431, 218, 61, 16);
		add(lblNewLabel_3);
		
		//istanzio il bottone per scommettere con il suo listener
		JButton btnNewButton = new JButton("Scommetti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			
					String scuderia = scelta1.getText();
					String tipo = scelta3.getText();
					if ( (scuderia.equals("")) || (scelta2.getText().equals("")) || (tipo.equals("")) ) {
						JOptionPane.showMessageDialog(null, "Non hai inserito tutti i campi");
					}
					else {
						
						controller.piazzaScommessa1(new PiazzaScommessaEvent(e.getGiocatore(), scuderia, valorePuntato, tipo));
						
					}				

			}
		});
		btnNewButton.setBounds(505, 395, 117, 29);
		add(btnNewButton);
		
		
		
		JPanel quotazione12 = new JPanel();
		quotazione12.setBounds(43,3, 316, 41);
		quotazione12.setBackground(new Color(0,0,0,0));
		add(quotazione12);
		
		JPanel quotazione13 = new JPanel();
		quotazione13.setBounds(43, 43, 316, 41);
		quotazione13.setBackground(new Color(0,0,0,0));
		add(quotazione13);
		
		JPanel quotazione14 = new JPanel();
		quotazione14.setBounds(43, 86, 316, 41);
		quotazione14.setBackground(new Color(0,0,0,0));
		add(quotazione14);
		
		JPanel quotazione15 = new JPanel();
		quotazione15.setBounds(43, 131, 316, 41);
		quotazione15.setBackground(new Color(0,0,0,0));
		add(quotazione15);
		
		JPanel quotazione16 = new JPanel();
		quotazione16.setBounds(43, 174, 316, 41);
		quotazione16.setBackground(new Color(0,0,0,0));
		add(quotazione16);
		
		JPanel quotazione17 = new JPanel();
		quotazione17.setBackground(new Color(0,0,0,0));
		quotazione17.setBounds(43, 220, 316, 41);
		add(quotazione17);
		
		for(final Scuderia s: e.getElencoScuderie()) {
			
			ImageIcon img = new ImageIcon(ViewScommessa1.class.getResource("/SegnaliniQuotazioniScuderie/SegnalinoQuotazioniScuderia" + s.getColore() + ".jpg"));
			JButton segnalino = new JButton(img);
			segnalino.setToolTipText("Segnalini Disponibili: " + s.getNumSegnaliniScommessa());
			if(s.getNumSegnaliniScommessa() == 0) {
				segnalino.setEnabled(false);
			}
			segnalino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scelta1.setText(s.getColore());
				}
			});
			switch (s.getQuotazione()) {
            
            case 2:  quotazione12.add(segnalino);
                     break;
            case 3:  quotazione13.add(segnalino);
                     break;
            case 4:  quotazione14.add(segnalino);
                     break;
            case 5:  quotazione15.add(segnalino);
                     break;
            case 6:  quotazione16.add(segnalino);
                     break;
            case 7:  quotazione17.add(segnalino);
                     break;
			}
		}
		
		
		
		
		JLabel lblDettagliScommessa = new JLabel("DETTAGLI SCOMMESSA");
		lblDettagliScommessa.setBounds(431, 132, 144, 16);
		add(lblDettagliScommessa);
		
		JButton btnAzzera = new JButton("Azzera");
		btnAzzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scelta1.setText("");
				scelta2.setText("");
				scelta3.setText("");
				denari.setText("" + e.getGiocatore().getDenari());
				valorePuntato = 0;
			}
		});
		btnAzzera.setBounds(413, 395, 89, 29);
		add(btnAzzera);
		
		
		
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewChiediNumeroGiocatore.class.getResource("/Altro/Quotazioni.jpg")));
		label.setBounds(0, 0, 634, 451);
		add(label);
		
		

	}
}
