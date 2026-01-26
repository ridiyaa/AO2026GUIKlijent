package ao2026lidija.klijent;
import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ao2026lidija.klijent.AO2026KlijentGUI.Pozicija;
import ao2026lidija.klijent.AO2026KlijentGUI.Smena;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class AO2026KlijentGUI extends JFrame {

	private JPanel contentPane;
	private JPanel loginPanel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtKorisnickoIme;
	private JPasswordField txtLozinka;
	private JButton btnPrijava;
	private JPanel menuPanel;
	private JLabel btnPrijavaSmena;
	private JButton btnNewButton;
	private JButton btnPregled;
	private JButton btnOdjava;
	private JPanel registracijaPanel;
	private JLabel lblNewLabel_3;
	private JButton btnRegistrujPanel;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtEmail;
	private JTextField txtKorisnickoImeReg;
	private JPasswordField txtLozinkaReg;
	private JButton btnNazadNaPrijavu;
	private JButton btnRegistracija;
	private JLabel lblNewLabel_11;
	private JTextField txtJMBG;
	private JPanel prijavaVolPanel;
	private JComboBox<Smena> cbSmena;
	private JComboBox<Pozicija> cbPozicija;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblUlogovanKorisnik;
	private String ulogovaniUsername;
	private JLabel lblNewLabel_13_1;
	private JLabel lblNewLabel_13_1_1;
	private JTextField txtDatumSmene;
	private JButton btnPrijavaSmene;
	private JLabel lblNewLabel_13_1_1_1;
	private JButton btnNazadNaMeni;
	private JPanel pregledPanel;
	private JLabel lblNewLabel_14;
	private JLabel lblNewlbl15;
	private JLabel lblNewLabel_15;
	private JTextField txtJMBGPregled;
	private JButton btnPrikaziPrijaveKorisnika;
	private JTextField txtEmailPregled;
	private JLabel lblNewLabel_15_1;
	private JLabel lblNewLabel_15_1_1;
	private JButton btnOtkazivanje;
	private JPanel brisanjePanel;
	private JLabel lblNewLabel_16;
	private JTextField txtDatumZaOtkazivanje;
	private JLabel lblNewLabel_17;
	private JButton btnPrikaziPrijavuZaBrisanje;
	private JLabel lblPrijavaZaBrisanje;
	private JPasswordField txtpasswordOtkazivanje;
	private JLabel lblNewLabel_19;
	private JButton btnPotvrdiBrisanje;
	public enum Smena { JUTARNJA, POPODEVNA, VECERNJA }
	public enum Pozicija { INFO, REDAR, MEDIJI, VIP }

	//cuvam datum za koji korisnik zeli da obrise prijavu
	private String datumZaBrisanje = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AO2026KlijentGUI frame = new AO2026KlijentGUI();
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
	public AO2026KlijentGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
////////////////////////////////////////
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getLoginPanel(), "PRIJAVA");
		contentPane.add(getMenuPanel(), "MENI");
		contentPane.add(getRegistracijaPanel(), "REGISTRACIJA");
		contentPane.add(getPrijavaVolPanel(), "PRIJAVA ZA SMENU");
		////////////////////////////
		
		// stavljam da se u combo box enum bira
		cbSmena.setModel(new javax.swing.DefaultComboBoxModel<>(Smena.values()));
		cbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(Pozicija.values()));
		contentPane.add(getPregledPanel(), "PREGLED");
		contentPane.add(getBrisanjePanel(), "OTKAZIVANJE");
		lblPrijavaZaBrisanje.setVisible(false);
		txtpasswordOtkazivanje.setVisible(false);
		btnPotvrdiBrisanje.setVisible(false);
		btnPotvrdiBrisanje.setEnabled(false);
		datumZaBrisanje = null;
		lblNewLabel_19.setVisible(false);


	}

	

	private JPanel getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new JPanel();
			loginPanel.setLayout(null);
			loginPanel.add(getLblNewLabel_1());
			loginPanel.add(getLblNewLabel_2());
			loginPanel.add(getTxtKorisnickoIme());
			loginPanel.add(getLblNewLabel());
			loginPanel.add(getTxtLozinka());
			loginPanel.add(getBtnPrijava());
			loginPanel.add(getLblNewLabel_3());
			loginPanel.add(getBtnRegistrujPanel());
		}
		return loginPanel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Prijava");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(50, 6, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Korisnicko ime:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(19, 35, 109, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Lozinka:");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(19, 66, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTxtKorisnickoIme() {
		if (txtKorisnickoIme == null) {
			txtKorisnickoIme = new JTextField();
			txtKorisnickoIme.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtKorisnickoIme.setBounds(140, 30, 130, 26);
			txtKorisnickoIme.setColumns(10);
		}
		return txtKorisnickoIme;
	}
	private JPasswordField getTxtLozinka() {
		if (txtLozinka == null) {
			txtLozinka = new JPasswordField();
			txtLozinka.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtLozinka.setBounds(140, 61, 130, 26);
		}
		return txtLozinka;
	}
//////////////////////////////////////////
	//prijava
	//////////////////////////////////
	/////////////////////////////////
	
	private JButton getBtnPrijava() {
	    if (btnPrijava == null) {
	        btnPrijava = new JButton("Prijavite se");
	        btnPrijava.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // action performed za prijavu!!!!!!!

	                String username = txtKorisnickoIme.getText().trim();
	                String password = new String(txtLozinka.getPassword()).trim();

	                if (username.isEmpty() || password.isEmpty()) {
	                    javax.swing.JOptionPane.showMessageDialog(
	                            null,
	                            "Korisnicko ime i lozinka ne mogu biti prazni");
	                    return;
	                }

	                try {
	                    Socket klijentSoket = new Socket("localhost", 8090);

	                    DataOutputStream izlaz =
	                            new DataOutputStream(klijentSoket.getOutputStream());
	                    BufferedReader ulaz =
	                            new BufferedReader(new InputStreamReader(klijentSoket.getInputStream()));
///////////// LOGIN|username|password\n
	                    String poruka = "LOGIN|" + username + "|" + password + "\n";
	                    izlaz.writeBytes(poruka);

	                    String odgovor = ulaz.readLine();
	                    klijentSoket.close();

	                    if ("OK|LOGIN".equals(odgovor)) {
	                        ((java.awt.CardLayout) contentPane.getLayout()).next(contentPane);
	  ////// kasnije za stranicu za prijavu za smenu da mi se promeni label u trenutnog korisnika                      
	                        ulogovaniUsername = username;
	                        getLblUlogovanKorisnik().setText(ulogovaniUsername);
	                    } else if (odgovor != null && odgovor.startsWith("ERR|")) {
	                        javax.swing.JOptionPane.showMessageDialog(null, odgovor);
	                    } else {
	                        javax.swing.JOptionPane.showMessageDialog(
	                                null, "Nepoznat odgovor servera: " + odgovor);
	                    }

	                } catch (Exception ex) {
	                    javax.swing.JOptionPane.showMessageDialog(
	                            null, "Greška pri povezivanju sa serverom.");
	                }
	            }
	        }); 

	        btnPrijava.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        btnPrijava.setBounds(140, 99, 130, 29);
	    }
	    return btnPrijava;
	}

	private JPanel getMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new JPanel();
			menuPanel.setLayout(null);
			menuPanel.add(getBtnPrijavaSmena());
			menuPanel.add(idiNaPrijavuSmene());
			menuPanel.add(getBtnPregled());
			menuPanel.add(getBtnOdjava());
		}
		return menuPanel;
	}
	private JLabel getBtnPrijavaSmena() {
		if (btnPrijavaSmena == null) {
			btnPrijavaSmena = new JLabel("MENI");
			btnPrijavaSmena.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnPrijavaSmena.setBounds(77, 10, 44, 16);
		}
		return btnPrijavaSmena;
	}
	private JButton idiNaPrijavuSmene() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Prijava za smenu");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "PRIJAVA ZA SMENU");
				}
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton.setBounds(20, 30, 160, 30);
		}
		return btnNewButton;
	}
	private JButton getBtnPregled() {
		if (btnPregled == null) {
			btnPregled = new JButton("Pregled prijava");
			btnPregled.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "PREGLED");
				}
			});
			btnPregled.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnPregled.setBounds(20, 60, 160, 30);
		}
		return btnPregled;
	}
	private JButton getBtnOdjava() {
		if (btnOdjava == null) {
			btnOdjava = new JButton("Odjavi se");
			btnOdjava.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "PRIJAVA");
					ulogovaniUsername = null;

;

				}
			});
			btnOdjava.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnOdjava.setBounds(20, 90, 160, 30);
		}
		return btnOdjava;
	}
	private JPanel getRegistracijaPanel() {
		if (registracijaPanel == null) {
			registracijaPanel = new JPanel();
			registracijaPanel.setBackground(new Color(238, 238, 238));
			registracijaPanel.setLayout(null);
			registracijaPanel.add(getLblNewLabel_4());
			registracijaPanel.add(getLblNewLabel_5());
			registracijaPanel.add(getLblNewLabel_6());
			registracijaPanel.add(getLblNewLabel_7());
			registracijaPanel.add(getLblNewLabel_8());
			registracijaPanel.add(getLblNewLabel_9());
			registracijaPanel.add(getLblNewLabel_10());
			registracijaPanel.add(getTxtIme());
			registracijaPanel.add(getTxtPrezime());
			registracijaPanel.add(getTxtEmail());
			registracijaPanel.add(getTxtKorisnickoImeReg());
			registracijaPanel.add(getTxtLozinkaReg());
			registracijaPanel.add(getBtnNazadNaPrijavu());
			registracijaPanel.add(getBtnRegistracija());
			registracijaPanel.add(getLblNewLabel_11());
			registracijaPanel.add(getTxtJMBG());
		}
		return registracijaPanel;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Nemate nalog?");
			lblNewLabel_3.setFont(new Font("Times New Roman", Font.ITALIC, 15));
			lblNewLabel_3.setBounds(19, 152, 130, 16);
		}
		return lblNewLabel_3;
	}
	private JButton getBtnRegistrujPanel() {
		if (btnRegistrujPanel == null) {
			btnRegistrujPanel = new JButton("Registrujte se!");
			btnRegistrujPanel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "REGISTRACIJA");
;
				}
			});
			btnRegistrujPanel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnRegistrujPanel.setBounds(140, 147, 130, 29);
		}
		return btnRegistrujPanel;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Registracija");
			lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_4.setBounds(50, 6, 108, 16);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Ime:");
			lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_5.setBounds(19, 30, 61, 16);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("Prezime:");
			lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_6.setBounds(19, 62, 61, 16);
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("Email:");
			lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_7.setBounds(19, 90, 61, 16);
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("Korisnicko ime:");
			lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_8.setBounds(20, 152, 108, 16);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("Lozinka:");
			lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_9.setBounds(19, 180, 61, 16);
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("Vec ste registrovani?");
			lblNewLabel_10.setFont(new Font("Times New Roman", Font.ITALIC, 15));
			lblNewLabel_10.setBounds(6, 240, 147, 16);
		}
		return lblNewLabel_10;
	}
	private JTextField getTxtIme() {
		if (txtIme == null) {
			txtIme = new JTextField();
			txtIme.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtIme.setBounds(140, 25, 130, 26);
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JTextField getTxtPrezime() {
		if (txtPrezime == null) {
			txtPrezime = new JTextField();
			txtPrezime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtPrezime.setBounds(140, 55, 130, 26);
			txtPrezime.setColumns(10);
		}
		return txtPrezime;
	}
	private JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtEmail.setBounds(140, 85, 130, 26);
			txtEmail.setColumns(10);
		}
		return txtEmail;
	}
	private JTextField getTxtKorisnickoImeReg() {
		if (txtKorisnickoImeReg == null) {
			txtKorisnickoImeReg = new JTextField();
			txtKorisnickoImeReg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtKorisnickoImeReg.setBounds(140, 145, 130, 26);
			txtKorisnickoImeReg.setColumns(10);
		}
		return txtKorisnickoImeReg;
	}
	private JPasswordField getTxtLozinkaReg() {
		if (txtLozinkaReg == null) {
			txtLozinkaReg = new JPasswordField();
			txtLozinkaReg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtLozinkaReg.setBounds(140, 175, 130, 26);
		}
		return txtLozinkaReg;
	}
	
	private JButton getBtnNazadNaPrijavu() {
		if (btnNazadNaPrijavu == null) {
			btnNazadNaPrijavu = new JButton("Prijava");
			btnNazadNaPrijavu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					///// vrati na prijava panel
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "PRIJAVA");
				}
			});
			btnNazadNaPrijavu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNazadNaPrijavu.setBounds(140, 235, 130, 29);
		}
		return btnNazadNaPrijavu;
	}
/////// REGISTER|ime|prezime|email|jmbg|username|password\n
	private JButton getBtnRegistracija() {
	    if (btnRegistracija == null) {
	        btnRegistracija = new JButton("Registrujte se");
	        btnRegistracija.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	                String username = txtKorisnickoImeReg.getText().trim();
	                String password = new String(txtLozinkaReg.getPassword()).trim();
	                String ime = txtIme.getText().trim();
	                String prezime = txtPrezime.getText().trim();
	                String email = txtEmail.getText().trim();
	                
	                String jmbg = txtJMBG.getText().trim();
	                
	                if (username.isEmpty() || password.isEmpty() || ime.isEmpty() || prezime.isEmpty() || email.isEmpty() 
	                		|| jmbg.isEmpty() ) {
	                    javax.swing.JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena");
	                    return;
	                }
	                
	                // jmbg mora imati 13 cifara
	                
	                if(jmbg.length()!=13) {
	                	javax.swing.JOptionPane.showMessageDialog(null, "JMBG mora imati tacno 13 cifara");
	                	return;
	                }else {
	                	for(int i =0;i<jmbg.length();i++) {
	                		if(!Character.isDigit(jmbg.charAt(i))) {
	                			javax.swing.JOptionPane.showMessageDialog(null, "JMBG polje moze sadrzati samo cifre");
	    	                	return;
	                		}
	                	}
	                }

	                if (!email.contains("@") || !email.contains(".")) {
	                    javax.swing.JOptionPane.showMessageDialog(null, "Neispravan email");
	                    return;
	                }

	                try {
	                    Socket klijentSoket = new Socket("localhost", 8090);

	                    DataOutputStream izlaz = new DataOutputStream(klijentSoket.getOutputStream());
	                    BufferedReader ulaz = new BufferedReader(new InputStreamReader(klijentSoket.getInputStream()));

	                    String poruka = "REGISTER|" + ime + "|" + prezime + "|" + email + "|" + jmbg + "|" + username + "|" + password + "\n";
	                    izlaz.writeBytes(poruka);

	                    String odgovor = ulaz.readLine();
	                    klijentSoket.close();

	                    // OBRADA ODGOVORA
	                    if ("OK|REGISTER".equals(odgovor)) {
	                    	JOptionPane.showMessageDialog(null, "Uspešno ste se registrovali!");
	                    	((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "PRIJAVA");
	                    } else if (odgovor != null && odgovor.startsWith("ERR|")) {
	                        javax.swing.JOptionPane.showMessageDialog(null, odgovor);
	                    } else {
	                        javax.swing.JOptionPane.showMessageDialog(
	                                null, "Nepoznat odgovor servera: " + odgovor);
	                    }

	                } catch (Exception ex) {
	                    javax.swing.JOptionPane.showMessageDialog(null, "Greška pri povezivanju sa serverom.");
	                }
	            }
	        });

	        btnRegistracija.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        btnRegistracija.setBounds(140, 200, 130, 29);
	    }
	    return btnRegistracija;
	}

	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("JMBG:");
			lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_11.setBounds(19, 124, 61, 16);
		}
		return lblNewLabel_11;
	}
	// 
	private JTextField getTxtJMBG() {
		if (txtJMBG == null) {
			txtJMBG = new JTextField();
			txtJMBG.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtJMBG.setBounds(140, 115, 130, 30);
			txtJMBG.setColumns(10);
		}
		return txtJMBG;
	}
	private JPanel getPrijavaVolPanel() {
		if (prijavaVolPanel == null) {
			prijavaVolPanel = new JPanel();
			prijavaVolPanel.setLayout(null);
			prijavaVolPanel.add(getCbSmena());
			prijavaVolPanel.add(getCbPozicija());
			prijavaVolPanel.add(getLblNewLabel_12());
			prijavaVolPanel.add(getLblNewLabel_13());
			prijavaVolPanel.add(getLblUlogovanKorisnik());
			prijavaVolPanel.add(getLblNewLabel_13_1());
			prijavaVolPanel.add(getLblNewLabel_13_1_1());
			prijavaVolPanel.add(getTxtDatumSmene());
			prijavaVolPanel.add(getBtnPrijavaSmene());
			prijavaVolPanel.add(getLblNewLabel_13_1_1_1());
			prijavaVolPanel.add(getBtnNazadNaMeni());
			prijavaVolPanel.add(getLblNewLabel_14());
		}
		return prijavaVolPanel;
	}
	private JComboBox<Smena> getCbSmena() {
	    if (cbSmena == null) {
	        cbSmena = new JComboBox();
	        cbSmena.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	        cbSmena.setBounds(91, 58, 127, 27);

	        cbSmena.setModel(
	            new DefaultComboBoxModel<>(AO2026KlijentGUI.Smena.values())
	        );
	    }
	    return cbSmena;
	}



	private JComboBox<Pozicija> getCbPozicija() {
	    if (cbPozicija == null) {
	        cbPozicija = new JComboBox();
	        cbPozicija.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	        cbPozicija.setBounds(91, 85, 127, 27);

	        cbPozicija.setModel(new javax.swing.DefaultComboBoxModel<>(Pozicija.values()));
	    }
	    return cbPozicija;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("Prijava za smenu");
			lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_12.setBounds(33, 6, 136, 16);
		}
		return lblNewLabel_12;
	}
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("Korisnik:");
			lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_13.setBounds(6, 34, 61, 16);
		}
		return lblNewLabel_13;
	}
	private JLabel getLblUlogovanKorisnik() {
		if (lblUlogovanKorisnik == null) {
			lblUlogovanKorisnik = new JLabel("New label");
			lblUlogovanKorisnik.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblUlogovanKorisnik.setBounds(108, 34, 107, 16);

		}
		return lblUlogovanKorisnik;
	}
	private JLabel getLblNewLabel_13_1() {
		if (lblNewLabel_13_1 == null) {
			lblNewLabel_13_1 = new JLabel("Smena:");
			lblNewLabel_13_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_13_1.setBounds(6, 62, 61, 16);
		}
		return lblNewLabel_13_1;
	}
	private JLabel getLblNewLabel_13_1_1() {
		if (lblNewLabel_13_1_1 == null) {
			lblNewLabel_13_1_1 = new JLabel("Pozicija");
			lblNewLabel_13_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_13_1_1.setBounds(6, 89, 61, 16);
		}
		return lblNewLabel_13_1_1;
	}
	private JTextField getTxtDatumSmene() {
		if (txtDatumSmene == null) {
			txtDatumSmene = new JTextField();
			txtDatumSmene.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtDatumSmene.setBounds(91, 112, 127, 26);
			txtDatumSmene.setColumns(10);
		}
		return txtDatumSmene;
	}
	private JButton getBtnPrijavaSmene() {
		if (btnPrijavaSmene == null) {
			btnPrijavaSmene = new JButton("Prijava");
			btnPrijavaSmene.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					////////// PRIJAVA NA SMENUUUUU
					if (ulogovaniUsername==null || ulogovaniUsername.equals("")) {
						 javax.swing.JOptionPane.showMessageDialog(null, "Morate biti ulogovani!");
						 return;
					}

	                String datum = txtDatumSmene.getText().trim();
	                Smena smena = Smena.valueOf(cbSmena.getSelectedItem().toString());
	                Pozicija pozicija = Pozicija.valueOf(cbPozicija.getSelectedItem().toString());

	                
	                // provera formata datuma
	                DateTimeFormatter formatter =
	                        DateTimeFormatter.ofPattern("dd-MM-yyyy");

	                LocalDate datumVolontiranja;

	                try {
	                    datumVolontiranja = LocalDate.parse(datum, formatter);
	                } catch (DateTimeParseException ex) {
	                    JOptionPane.showMessageDialog(null, "Datum mora biti u formatu dd-MM-yyyy (npr. 25-01-2026)");
	                    return;
	                }
	                

	                try {
	                    Socket klijentSoket = new Socket("localhost", 8090);

	                    DataOutputStream izlaz = new DataOutputStream(klijentSoket.getOutputStream());
	                    BufferedReader ulaz = new BufferedReader(new InputStreamReader(klijentSoket.getInputStream()));
// PRIJAVA|username|smena|pozicija|datum
	                    String poruka = "PRIJAVA|" + ulogovaniUsername + "|" + smena.name() + "|" + pozicija.name() + "|" + datum +"\n";
	                    izlaz.writeBytes(poruka);

	                    String odgovor = ulaz.readLine();
	                    klijentSoket.close();

	                    // OBRADA ODGOVORA
	                    if ("OK|PRIJAVA".equals(odgovor)) {
	                    	JOptionPane.showMessageDialog(null, "Uspesno ste se prijavili!");
	                    	((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "MENI");
	                    } else if (odgovor != null && odgovor.startsWith("ERR|")) {
	                        javax.swing.JOptionPane.showMessageDialog(null, odgovor);
	                    } else {
	                        javax.swing.JOptionPane.showMessageDialog(
	                                null, "Nepoznat odgovor servera: " + odgovor);
	                    }

	                } catch (Exception ex) {
	                    javax.swing.JOptionPane.showMessageDialog(null, "Greška pri povezivanju sa serverom.");
	                }
	            
					
				}
			});
			btnPrijavaSmene.setFont(new Font("Times New Roman", Font.BOLD, 15));
			btnPrijavaSmene.setBounds(91, 150, 127, 29);
		}
		return btnPrijavaSmene;
	}
	private JLabel getLblNewLabel_13_1_1_1() {
		if (lblNewLabel_13_1_1_1 == null) {
			lblNewLabel_13_1_1_1 = new JLabel("Datum:");
			lblNewLabel_13_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_13_1_1_1.setBounds(6, 117, 61, 16);
		}
		return lblNewLabel_13_1_1_1;
	}
	private JButton getBtnNazadNaMeni() {
		if (btnNazadNaMeni == null) {
			btnNazadNaMeni = new JButton("Nazad na meni");
			btnNazadNaMeni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "MENI");
				}
			});
			btnNazadNaMeni.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNazadNaMeni.setBounds(91, 179, 127, 29);
		}
		return btnNazadNaMeni;
	}
	private JPanel getPregledPanel() {
		if (pregledPanel == null) {
			pregledPanel = new JPanel();
			pregledPanel.setLayout(null);
			pregledPanel.add(getLblNewlbl15());
			pregledPanel.add(getLblNewLabel_15());
			pregledPanel.add(getTxtJMBGPregled());
			pregledPanel.add(getBtnPrikaziPrijaveKorisnika());
			pregledPanel.add(getTxtEmailPregled());
			pregledPanel.add(getLblNewLabel_15_1());
			pregledPanel.add(getLblNewLabel_15_1_1());
			pregledPanel.add(getBtnOtkazivanje());
		}
		return pregledPanel;
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("(dd-MM-gggg)");
			lblNewLabel_14.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			lblNewLabel_14.setBounds(222, 117, 82, 16);
		}
		return lblNewLabel_14;
	}
	private JLabel getLblNewlbl15() {
		if (lblNewlbl15 == null) {
			lblNewlbl15 = new JLabel("Pregled svih prijava");
			lblNewlbl15.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewlbl15.setBounds(50, 6, 132, 16);
		}
		return lblNewlbl15;
	}
	private JLabel getLblNewLabel_15() {
		if (lblNewLabel_15 == null) {
			lblNewLabel_15 = new JLabel("Unesite svoj JMBG:");
			lblNewLabel_15.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_15.setBounds(21, 44, 125, 16);
		}
		return lblNewLabel_15;
	}
	private JTextField getTxtJMBGPregled() {
		if (txtJMBGPregled == null) {
			txtJMBGPregled = new JTextField();
			txtJMBGPregled.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtJMBGPregled.setBounds(158, 39, 146, 26);
			txtJMBGPregled.setColumns(10);
		}
		return txtJMBGPregled;
	}
	private JButton getBtnPrikaziPrijaveKorisnika() {
		if (btnPrikaziPrijaveKorisnika == null) {
			btnPrikaziPrijaveKorisnika = new JButton("Prikazi");
			btnPrikaziPrijaveKorisnika.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// PREGLED|email|jmbg\n


	                String email = txtEmailPregled.getText().trim();
	                String jmbg = txtJMBGPregled.getText().trim();

	                if (jmbg.isEmpty()) {
	                    javax.swing.JOptionPane.showMessageDialog(
	                            null,
	                            "JMBG je obavezno polje");
	                    return;
	                }
	                if (email==null || email.isEmpty()) {
	                    javax.swing.JOptionPane.showMessageDialog(
	                            null,
	                            "Email je obavezno polje");
	                    return;
	                }
	                if(!email.contains("@")||!email.contains(".")) {
	                	JOptionPane.showMessageDialog(null, "Email nije u dobrom formatu");
	                    return;
	                }
	                // jmbg moze imati samo 13 cifara
	                if (jmbg.length() != 13) {
	                    JOptionPane.showMessageDialog(null, "JMBG mora imati tacno 13 cifara");
	                    return;
	                }
	                for (int i = 0; i < jmbg.length(); i++) {
	                    if (!Character.isDigit(jmbg.charAt(i))) {
	                        JOptionPane.showMessageDialog(null, "JMBG sme sadrzati samo cifre");
	                        return;
	                    }
	                }

	                try {
	                    Socket klijentSoket = new Socket("localhost", 8090);

	                    DataOutputStream izlaz =
	                            new DataOutputStream(klijentSoket.getOutputStream());
	                    BufferedReader ulaz =
	                            new BufferedReader(new InputStreamReader(klijentSoket.getInputStream()));
///////////// PREGLED|email|jmbg\n
	                    String poruka = "PREGLED|" + email + "|" + jmbg + "\n";
	                    izlaz.writeBytes(poruka);

	                    String odgovor = ulaz.readLine();
	                    klijentSoket.close();

	                    if (odgovor != null && odgovor.startsWith("OK|PREGLED|")) {
	                        // obradi i ispiši
	                    	
	                    	// OK|PREGLED|ime|prezime|username|jmbg|email|count|payload
	                    	String[] delovi = odgovor.split("\\|", 9);

	                    	String ime = delovi[2];
	                    	String prezime = delovi[3];
	                    	String username = delovi[4];
	                    	String jmbgSrv = delovi[5];
	                    	String emailSrv = delovi[6];
	                    	int n = Integer.parseInt(delovi[7]);
	                    	String payload = (delovi.length == 9) ? delovi[8] : "";
	                    	
	                    	if(!username.equals(ulogovaniUsername)) {
	                    		JOptionPane.showMessageDialog(null, "Pogresan JMBG i email");
	                    		return;
	                    	}

	                    	StringBuilder prikaz = new StringBuilder();
	                    	prikaz.append("Ime: ").append(ime).append("\n");
	                    	prikaz.append("Prezime: ").append(prezime).append("\n");
	                    	prikaz.append("Username: ").append(username).append("\n");
	                    	prikaz.append("JMBG: ").append(jmbgSrv).append("\n");
	                    	prikaz.append("Email: ").append(emailSrv).append("\n");
	                    	prikaz.append("----------------------------------------\n");
	                    	prikaz.append("Broj prijava: ").append(n).append("\n\n");

	                        if (n == 0 || payload.trim().isEmpty()) {
	                            prikaz.append("Nemate nijednu prijavu.\n");
	                        } else {
	                            String[] items = payload.split(";");
	                            for (String it : items) {
	                                String[] f = it.split(",", -1);
	                                String datum = (f.length > 0) ? f[0] : "";
	                                String smena = (f.length > 1) ? f[1] : "";
	                                String pozicija = (f.length > 2) ? f[2] : "";
	                                String datumPrijave = (f.length > 3) ? f[3] : "";
	                                String status = (f.length > 4) ? f[4] : "";


	                                prikaz.append("Datum: ").append(datum)
	                                      .append(" | Smena: ").append(smena)
	                                      .append(" | Pozicija: ").append(pozicija)
	                                      .append("\nPrijavljeno: ").append(datumPrijave)
	                                      .append("\nStatus: ").append(status)
	                                      .append("\n\n");
	                            }
	                        }
	                        JOptionPane.showMessageDialog(null, prikaz.toString());
	                    	
	                    } else if (odgovor != null && odgovor.startsWith("ERR|")) {
	                        javax.swing.JOptionPane.showMessageDialog(null, odgovor);
	                    } else {
	                        javax.swing.JOptionPane.showMessageDialog(
	                                null, "Nepoznat odgovor servera: " + odgovor);
	                    }

	                } catch (Exception ex) {
	                    javax.swing.JOptionPane.showMessageDialog(
	                            null, "Greška pri povezivanju sa serverom.");
	                }
	            
				}
			});
			btnPrikaziPrijaveKorisnika.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnPrikaziPrijaveKorisnika.setBounds(180, 110, 108, 29);
		}
		return btnPrikaziPrijaveKorisnika;
	}
	private JTextField getTxtEmailPregled() {
		if (txtEmailPregled == null) {
			txtEmailPregled = new JTextField();
			txtEmailPregled.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtEmailPregled.setColumns(10);
			txtEmailPregled.setBounds(158, 72, 146, 26);
		}
		return txtEmailPregled;
	}
	private JLabel getLblNewLabel_15_1() {
		if (lblNewLabel_15_1 == null) {
			lblNewLabel_15_1 = new JLabel("Unesite svoj email:");
			lblNewLabel_15_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_15_1.setBounds(21, 77, 125, 16);
		}
		return lblNewLabel_15_1;
	}
	private JLabel getLblNewLabel_15_1_1() {
		if (lblNewLabel_15_1_1 == null) {
			lblNewLabel_15_1_1 = new JLabel("Da li zelite da otkazete neku prijavu?");
			lblNewLabel_15_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_15_1_1.setBounds(21, 167, 267, 16);
		}
		return lblNewLabel_15_1_1;
	}
	private JButton getBtnOtkazivanje() {
		if (btnOtkazivanje == null) {
			btnOtkazivanje = new JButton("Otkazivanje");
			btnOtkazivanje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "OTKAZIVANJE");
					
				}
			});
			btnOtkazivanje.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnOtkazivanje.setBounds(180, 187, 108, 29);
		}
		return btnOtkazivanje;
	}
	private JPanel getBrisanjePanel() {
		if (brisanjePanel == null) {
			brisanjePanel = new JPanel();
			brisanjePanel.setLayout(null);
			brisanjePanel.add(getLblNewLabel_16());
			brisanjePanel.add(getTxtDatumZaOtkazivanje());
			brisanjePanel.add(getLblNewLabel_17());
			brisanjePanel.add(getBtnPrikaziPrijavuZaBrisanje());
			brisanjePanel.add(getLblPrijavaZaBrisanje());
			brisanjePanel.add(getTxtpasswordOtkazivanje());
			brisanjePanel.add(getLblNewLabel_19());
			brisanjePanel.add(getBtnPotvrdiBrisanje());
		}
		return brisanjePanel;
	}
	private JLabel getLblNewLabel_16() {
		if (lblNewLabel_16 == null) {
			lblNewLabel_16 = new JLabel("Brisanje prijave za dan:");
			lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_16.setBounds(28, 17, 158, 16);
		}
		return lblNewLabel_16;
	}
	private JTextField getTxtDatumZaOtkazivanje() {
		if (txtDatumZaOtkazivanje == null) {
			txtDatumZaOtkazivanje = new JTextField();
			txtDatumZaOtkazivanje.setBounds(38, 40, 130, 26);
			txtDatumZaOtkazivanje.setColumns(10);
		}
		return txtDatumZaOtkazivanje;
	}
	private JLabel getLblNewLabel_17() {
		if (lblNewLabel_17 == null) {
			lblNewLabel_17 = new JLabel("(dd-MM-gggg)");
			lblNewLabel_17.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_17.setBounds(181, 45, 94, 16);
		}
		return lblNewLabel_17;
	}
	private JButton getBtnPrikaziPrijavuZaBrisanje() {
		if (btnPrikaziPrijavuZaBrisanje == null) {
			btnPrikaziPrijavuZaBrisanje = new JButton("Obrisi");
			btnPrikaziPrijavuZaBrisanje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// poziv za prikazivanje prijave koju korisnik zeli da obrise
					String username = ulogovaniUsername;
					String datum = txtDatumZaOtkazivanje.getText().trim();

					if (username == null || username.isEmpty()) {
					    JOptionPane.showMessageDialog(null, "Niste ulogovani!");
					    return;
					}

					try {
					    // validacija datuma (da ne saljes glupost)
					    java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
					    java.time.LocalDate.parse(datum, fmt);
					} catch (Exception ex) {
					    JOptionPane.showMessageDialog(null, "Datum mora biti u formatu dd-MM-yyyy");
					    return;
					}

					try (Socket s = new Socket("localhost", 8090)) {
					    DataOutputStream out = new DataOutputStream(s.getOutputStream());
					    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

					    out.writeBytes("OTKAZI_PREGLED|" + username + "|" + datum + "\n");

					    String odgovor = in.readLine();

					    if (odgovor != null && odgovor.startsWith("OK|OTKAZI_PREGLED|")) {

					        // OK|OTKAZI_PREGLED|datum|SMENA|POZICIJA|datumPrijave|STATUS
					        String[] d = odgovor.split("\\|", 7);
					        String datumSrv = d[2];
					        String smena = d[3];
					        String pozicija = d[4];
					        String datumPrijave = d[5];
					        String status = d[6];

					        // prikaz detalja
					        lblPrijavaZaBrisanje.setText(
					            "<html><b>Pronađena prijava</b><br>" +
					            "Datum: " + datumSrv + "<br>" +
					            "Smena: " + smena + "<br>" +
					            "Pozicija: " + pozicija + "<br>" +
					            "Datum prijave: " + datumPrijave + "<br>" +
					            "Status: " + status + "</html>"
					        );
					        lblPrijavaZaBrisanje.setVisible(true);

					        // zapamti datum koji je potvrđen/prikazan
					        datumZaBrisanje = datumSrv;

					        // otvori opciju za potvrdu lozinkom
					        txtpasswordOtkazivanje.setText("");
					        txtpasswordOtkazivanje.setVisible(true);
					        
					        btnPotvrdiBrisanje.setVisible(true);

					        // ako je zakljucana ili zavrsena - ne daj brisanje
					        if ("ZAKLJUCANA".equals(status) || "ZAVRSENA".equals(status)) {
					            btnPotvrdiBrisanje.setEnabled(false);
					            JOptionPane.showMessageDialog(null, "Prijava je " + status + " i ne može se otkazati.");
					        } else {
					            btnPotvrdiBrisanje.setEnabled(true);
					        }

					    } else if (odgovor != null && odgovor.startsWith("ERR|")) {
					        // resetuj UI stanje
					        datumZaBrisanje = null;
					        lblPrijavaZaBrisanje.setVisible(false);
					        txtpasswordOtkazivanje.setVisible(false);
					        btnPotvrdiBrisanje.setEnabled(false);
					        lblNewLabel_19.setVisible(true);

					        JOptionPane.showMessageDialog(null, odgovor);
					    } else {
					        JOptionPane.showMessageDialog(null, "Nepoznat odgovor servera: " + odgovor);
					    }

					} catch (Exception ex) {
					    JOptionPane.showMessageDialog(null, "Greška pri povezivanju sa serverom.");
					}

					
					
				}
			});
			btnPrikaziPrijavuZaBrisanje.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnPrikaziPrijavuZaBrisanje.setBounds(48, 64, 117, 29);
		}
		return btnPrikaziPrijavuZaBrisanje;
	}
	private JLabel getLblPrijavaZaBrisanje() {
		if (lblPrijavaZaBrisanje == null) {
			lblPrijavaZaBrisanje = new JLabel("");
			lblPrijavaZaBrisanje.setBackground(new Color(254, 231, 253));
			lblPrijavaZaBrisanje.setBounds(19, 91, 404, 98);
		}
		return lblPrijavaZaBrisanje;
	}
	private JPasswordField getTxtpasswordOtkazivanje() {
		if (txtpasswordOtkazivanje == null) {
			txtpasswordOtkazivanje = new JPasswordField();
			txtpasswordOtkazivanje.setBounds(38, 191, 130, 26);
		}
		return txtpasswordOtkazivanje;
	}
	private JLabel getLblNewLabel_19() {
		if (lblNewLabel_19 == null) {
			lblNewLabel_19 = new JLabel("Unesite loziku");
			lblNewLabel_19.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_19.setBounds(181, 196, 94, 16);
		}
		return lblNewLabel_19;
	}
	private JButton getBtnPotvrdiBrisanje() {
		if (btnPotvrdiBrisanje == null) {
			btnPotvrdiBrisanje = new JButton("Potvrdi");
			btnPotvrdiBrisanje.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = ulogovaniUsername;

					if (datumZaBrisanje == null) {
					    JOptionPane.showMessageDialog(null, "Prvo pronađite prijavu (Prikaži).");
					    return;
					}

					String password = new String(txtpasswordOtkazivanje.getPassword()).trim();
					if (password.isEmpty()) {
					    JOptionPane.showMessageDialog(null, "Unesite lozinku kao potvrdu.");
					    return;
					}

					// confirm dialog 
					int ok = JOptionPane.showConfirmDialog(
					    null,
					    "Da li ste sigurni da želite da otkažete prijavu za datum: " + datumZaBrisanje + "?",
					    "Potvrda",
					    JOptionPane.YES_NO_OPTION
					);
					if (ok != JOptionPane.YES_OPTION) return;

					try (Socket s = new Socket("localhost", 8090)) {
					    DataOutputStream out = new DataOutputStream(s.getOutputStream());
					    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

					    out.writeBytes("OTKAZI|" + username + "|" + datumZaBrisanje + "|" + password + "\n");

					    String odgovor = in.readLine();

					    if ("OK|OTKAZI".equals(odgovor)) {
					        JOptionPane.showMessageDialog(null, "Prijava je uspešno otkazana!");
					        // vrati na predgled prijava
					        
					        ((java.awt.CardLayout) contentPane.getLayout()).show(contentPane, "PREGLED");
					        
					        // reset UI
					        datumZaBrisanje = null;
					        txtDatumZaOtkazivanje.setText("");
					        lblPrijavaZaBrisanje.setVisible(false);
					        txtpasswordOtkazivanje.setText("");
					        lblNewLabel_19.setVisible(false);
					        txtpasswordOtkazivanje.setVisible(false);
					        btnPotvrdiBrisanje.setVisible(false);
					        btnPotvrdiBrisanje.setEnabled(false);

					    } else if (odgovor != null && odgovor.startsWith("ERR|")) {
					        JOptionPane.showMessageDialog(null, odgovor);
					    } else {
					        JOptionPane.showMessageDialog(null, "Nepoznat odgovor servera: " + odgovor);
					    }

					} catch (Exception ex) {
					    JOptionPane.showMessageDialog(null, "Greška pri povezivanju sa serverom.");
					}

				}
			});
			btnPotvrdiBrisanje.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnPotvrdiBrisanje.setBounds(48, 217, 117, 29);
		}
		return btnPotvrdiBrisanje;
	}
}
