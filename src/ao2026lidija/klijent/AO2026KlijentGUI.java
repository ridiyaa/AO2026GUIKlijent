package ao2026lidija.klijent;
import java.io.*;
import java.net.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		////////////////////////////
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
			menuPanel.add(getBtnNewButton());
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Prijava za smenu");
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnNewButton.setBounds(20, 30, 160, 30);
		}
		return btnNewButton;
	}
	private JButton getBtnPregled() {
		if (btnPregled == null) {
			btnPregled = new JButton("Pregled prijava");
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
			lblNewLabel_5.setBounds(19, 34, 61, 16);
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
			lblNewLabel_8.setBounds(20, 118, 108, 16);
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("Lozinka:");
			lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_9.setBounds(19, 146, 61, 16);
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
			txtIme.setBounds(140, 34, 130, 26);
			txtIme.setColumns(10);
		}
		return txtIme;
	}
	private JTextField getTxtPrezime() {
		if (txtPrezime == null) {
			txtPrezime = new JTextField();
			txtPrezime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtPrezime.setBounds(140, 57, 130, 26);
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
			txtKorisnickoImeReg.setBounds(140, 113, 130, 26);
			txtKorisnickoImeReg.setColumns(10);
		}
		return txtKorisnickoImeReg;
	}
	private JPasswordField getTxtLozinkaReg() {
		if (txtLozinkaReg == null) {
			txtLozinkaReg = new JPasswordField();
			txtLozinkaReg.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtLozinkaReg.setBounds(140, 141, 130, 26);
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
/////// REGISTER|ime|prezime|username|email|password\n
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

	                if (username.isEmpty() || password.isEmpty() || ime.isEmpty() || prezime.isEmpty() || email.isEmpty()) {
	                    javax.swing.JOptionPane.showMessageDialog(null, "Sva polja moraju biti popunjena");
	                    return;
	                }

	                if (!email.contains("@") || !email.contains(".")) {
	                    javax.swing.JOptionPane.showMessageDialog(null, "Neispravan email");
	                    return;
	                }

	                try {
	                    Socket klijentSoket = new Socket("localhost", 8090);

	                    DataOutputStream izlaz = new DataOutputStream(klijentSoket.getOutputStream());
	                    BufferedReader ulaz = new BufferedReader(new InputStreamReader(klijentSoket.getInputStream()));

	                    String poruka = "REGISTER|" + ime + "|" + prezime + "|" + username + "|" + email + "|" + password + "\n";
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
	        btnRegistracija.setBounds(140, 179, 130, 29);
	    }
	    return btnRegistracija;
	}

}
