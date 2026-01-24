package ao2026lidija.klijent;
import java.io.*;
import java.net.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
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

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getLoginPanel(), "name_62140405943864");
		contentPane.add(getMenuPanel(), "name_63004403213294");
	}

	private JPanel getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new JPanel();
			loginPanel.setLayout(null);
			loginPanel.add(getLblNewLabel());
			loginPanel.add(getLblNewLabel_1());
			loginPanel.add(getLblNewLabel_2());
			loginPanel.add(getTxtKorisnickoIme());
			loginPanel.add(getTxtLozinka());
			loginPanel.add(getBtnPrijava());
		}
		return loginPanel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Prijava");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(5, 6, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Korisnicko ime:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(5, 35, 109, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Lozinka:");
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(5, 66, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getTxtKorisnickoIme() {
		if (txtKorisnickoIme == null) {
			txtKorisnickoIme = new JTextField();
			txtKorisnickoIme.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtKorisnickoIme.setBounds(113, 30, 130, 26);
			txtKorisnickoIme.setColumns(10);
		}
		return txtKorisnickoIme;
	}
	private JPasswordField getTxtLozinka() {
		if (txtLozinka == null) {
			txtLozinka = new JPasswordField();
			txtLozinka.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			txtLozinka.setBounds(113, 61, 130, 26);
		}
		return txtLozinka;
	}
	
	private JButton getBtnPrijava() {
	    if (btnPrijava == null) {
	        btnPrijava = new JButton("Prijavi se");
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

	        btnPrijava.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	        btnPrijava.setBounds(113, 99, 130, 29);
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
					((java.awt.CardLayout) contentPane.getLayout()).previous(contentPane);

				}
			});
			btnOdjava.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			btnOdjava.setBounds(20, 90, 160, 30);
		}
		return btnOdjava;
	}
}
