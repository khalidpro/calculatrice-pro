import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame {

	private String mem = "";
	private String operation = "";
	private boolean vider_txt = false;
	private boolean B2NDF = false;

	JPanel pan = new JPanel();
	JPanel pan_st = new JPanel(); // pour la partie Standard
	JPanel pan_sc = new JPanel(); // pour la partie Scientifique

	JMenuBar menu = new JMenuBar();
	JMenu affichage = new JMenu("Affichage");
	JMenuItem standard = new JMenuItem("Standard");
	JMenuItem scientifique = new JMenuItem("Scientifique");

	JTextField txt = new JTextField();

	JButton B0 = new JButton("0");
	JButton B1 = new JButton("1");
	JButton B2 = new JButton("2");
	JButton B3 = new JButton("3");
	JButton B4 = new JButton("4");
	JButton B5 = new JButton("5");
	JButton B6 = new JButton("6");
	JButton B7 = new JButton("7");
	JButton B8 = new JButton("8");
	JButton B9 = new JButton("9");
	JButton BDot = new JButton(".");
	JButton BAdd = new JButton("+");
	JButton BSub = new JButton("-");
	JButton BPro = new JButton("*");
	JButton BDiv = new JButton("/");
	JButton BEgal = new JButton("=");
	JButton BBack = new JButton("←");
	JButton BRacine = new JButton("√");
	JButton B100 = new JButton("%");
	JButton BCE = new JButton("CE");
	JButton BSin = new JButton("sin");
	JButton BCos = new JButton("cos");
	JButton BTan = new JButton("tan");
	JButton BX2 = new JButton("x²");
	JButton BLog = new JButton("Log");
	JButton BLn = new JButton("ln");
	JButton BFact = new JButton("x!");
	JButton BAbs = new JButton("|x|");
	JButton B1x = new JButton("1/x");
	JButton B2ndf = new JButton("2ndf");

	public Calc() {

		init();

		this.setVisible(true);
	}

	public void init() {

		// Fenetre
		// *************************************************************************************
		this.setTitle("Calculatrice");
		this.setSize(350, 230);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setIconImage(getToolkit().getImage("resource/icon.png")); // changer
																		// l'icon
																		// par
																		// defaut
																		// de
																		// JFram
		this.getContentPane().setLayout(new BorderLayout());

		// Menu
		// *************************************************************************************
		this.menu.add(affichage);
		this.affichage.add(standard);
		this.affichage.add(scientifique);
		standard.setEnabled(false);
		this.setJMenuBar(menu);

		standard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(350, 230);
				scientifique.setEnabled(true);
				standard.setEnabled(false);
				pan_sc.setVisible(false);
			}
		});

		scientifique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(350, 325);
				scientifique.setEnabled(false);
				standard.setEnabled(true);
				pan_sc.setVisible(true);
			}
		});
		// TextField
		// *************************************************************************************
		txt.setPreferredSize(new Dimension(340, 40));
		txt.setHorizontalAlignment(JTextField.RIGHT);

		this.getContentPane().add(txt, BorderLayout.NORTH);

		Font f = null;
		try {
			File fis = new File("resource/lcd.ttf");
			f = Font.createFont(Font.TRUETYPE_FONT, fis);
			f = f.deriveFont((float) 44.0);
			txt.setFont(f);
		} catch (Exception e) {
			txt.setFont(new Font("Arial", Font.PLAIN, 30));
		}

		// Buttons Scientifique
		// *************************************************************************************
		GridLayout gl_sc = new GridLayout(2, 5);
		gl_sc.setHgap(3);
		gl_sc.setVgap(3);
		pan_sc.setLayout(gl_sc);

		pan_sc.add(BSin);
		pan_sc.add(BCos);
		pan_sc.add(BTan);
		pan_sc.add(BX2);
		pan_sc.add(BFact);
		pan_sc.add(BLn);
		pan_sc.add(BLog);
		pan_sc.add(BAbs);
		pan_sc.add(B1x);
		pan_sc.add(B2ndf);

		for (Component b : pan_sc.getComponents()) {
			b.setPreferredSize(new Dimension(65, 30));
			b.setForeground(Color.RED);
		}

		pan_sc.setBorder(BorderFactory.createTitledBorder("Scientifique :"));
		pan.add(pan_sc, BorderLayout.NORTH);
		pan_sc.setVisible(false);

		// Buttons Standard
		// *************************************************************************************
		GridLayout gl_st = new GridLayout(4, 5);
		gl_st.setHgap(3);
		gl_st.setVgap(3);
		pan_st.setLayout(gl_st);

		BDiv.setForeground(Color.red);
		BPro.setForeground(Color.red);
		BSub.setForeground(Color.red);
		BAdd.setForeground(Color.red);
		BEgal.setForeground(Color.BLUE);

		pan_st.add(B7);
		pan_st.add(B8);
		pan_st.add(B9);
		pan_st.add(BDiv);
		pan_st.add(BCE);
		pan_st.add(B4);
		pan_st.add(B5);
		pan_st.add(B6);
		pan_st.add(BPro);
		pan_st.add(BBack);
		pan_st.add(B3);
		pan_st.add(B1);
		pan_st.add(B2);
		pan_st.add(B3);
		pan_st.add(BAdd);
		pan_st.add(B100);
		pan_st.add(BDot);
		pan_st.add(B0);
		pan_st.add(BEgal);
		pan_st.add(BSub);
		pan_st.add(BRacine);

		for (Component b : pan_st.getComponents()) {
			b.setPreferredSize(new Dimension(65, 30));
		}

		pan.add(pan_st, BorderLayout.CENTER);
		this.getContentPane().add(pan, BorderLayout.CENTER);

		// Evenements des Buttons
		// *************************************************************************************

		B0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("0");
			}
		});
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("1");
			}
		});
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("2");
			}
		});
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("3");
			}
		});
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("4");
			}
		});
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("5");
			}
		});
		B6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("6");
			}
		});
		B7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("7");
			}
		});
		B8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("8");
			}
		});
		B9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				affichageNum("9");
			}
		});
		BDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation("/");
			}
		});
		BPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation("*");
			}
		});
		BAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation("+");
			}
		});
		BSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation("-");
			}
		});
		BEgal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mem != "") {
					double a = Double.valueOf(mem);
					double b = getValeur();
					double resultat = 0;

					if (operation == "+") {
						resultat = a + b;
					} else if (operation == "-") {
						resultat = a - b;
					} else if (operation == "/") {
						resultat = a / b;
					} else if (operation == "*") {
						resultat = a * b;
					} else if (operation == "^") {
						resultat = Math.pow(a, b);
					}

					affichageResultat(resultat);
				}
				operation = "";
				mem = "";
			}
		});
		BDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txt.getText().indexOf(".") < 0) {
					txt.setText(txt.getText() + ".");
				}
			}
		});
		BCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setText("");
				operation = "";
				mem = "";
			}
		});
		B100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mem != "") {
					double a = Double.valueOf(mem);
					double b = (getValeur() * a) / 100;
					double resultat = 0;

					if (operation == "+") {
						resultat = a + b;
					} else if (operation == "-") {
						resultat = a - b;
					} else if (operation == "/") {
						resultat = a / b;
					} else if (operation == "*") {
						resultat = a * b;
					}

					affichageResultat(resultat);
				}
				operation = "";
				mem = "";
			}
		});

		BRacine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = getValeur();
				txt.setText(String.valueOf(Math.sqrt(x)));
			}
		});
		BBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int l = txt.getText().length();
				if (l > 0) {
					txt.setText(txt.getText().substring(0, l - 1));
				}
			}
		});
		B2ndf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				B2NDF = !B2NDF;
				if (B2NDF) {
					for (Component b : pan_sc.getComponents()) {
						b.setForeground(Color.blue);
					}
					BSin.setText("Asin");
					BCos.setText("Acos");
					BTan.setText("Atan");
					BAbs.setText("+/-");
					BLn.setText("e^x");
					BLog.setText("Π");
					BX2.setText("x^3");
					BFact.setText("10^x");
					B1x.setText("y^x");

				} else {
					for (Component b : pan_sc.getComponents()) {
						b.setForeground(Color.red);
					}
					BSin.setText("sin");
					BCos.setText("cos");
					BTan.setText("tan");
					BAbs.setText("|x|");
					BLn.setText("ln");
					BLog.setText("Log");
					BX2.setText("x²");
					BFact.setText("x!");
					B1x.setText("1/x");

				}

			}
		});

		BSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = 0;
				if (B2NDF) {
					resultat = Math.asin(getValeur());
				} else {
					resultat = Math.sin(getValeur());
				}
				affichageResultat(resultat);
			}
		});
		BCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = 0;
				if (B2NDF) {
					resultat = Math.acos(getValeur());
				} else {
					resultat = Math.cos(getValeur());
				}
				affichageResultat(resultat);
			}
		});
		BTan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = 0;
				if (B2NDF) {
					resultat = Math.tan(getValeur());
				} else {
					resultat = Math.atan(getValeur());
				}
				affichageResultat(resultat);
			}
		});
		BX2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = 0;
				if (B2NDF) {
					resultat = Math.pow(getValeur(), 2);
				} else {
					resultat = Math.pow(getValeur(), 2);
				}
				affichageResultat(resultat);
			}
		});
		BLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = 0;
				if (B2NDF) {
					resultat = Math.exp(getValeur());
				} else {
					resultat = Math.log(getValeur());
				}
				affichageResultat(resultat);
			}
		});

		BLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = 0;
				if (B2NDF) {
					resultat = Math.PI;
				} else {
					resultat = Math.log10(getValeur());
				}
				affichageResultat(resultat);
			}
		});
		BAbs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = getValeur();
				if (B2NDF) {
					resultat = resultat * -1;

				} else {
					if (resultat < 0)
						resultat = resultat * -1;
				}
				affichageResultat(resultat);
			}
		});
		B1x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = getValeur();
				if (B2NDF) {
					operation("^");
				} else {
					resultat = 1 / getValeur();
				}
				affichageResultat(resultat);
			}
		});
		BFact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double resultat = getValeur();
				if (B2NDF) {
					resultat = Math.pow(10, getValeur());
				} else {
					double x=getValeur();
					while (--x > 0) {
						resultat=resultat*x;
					}
				}
				affichageResultat(resultat);
			}
		});
	}

	// Procedure d'affichage des numéros dans le TextField
	// *************************************************************************************
	public void affichageNum(String num) {
		if (vider_txt) {
			txt.setText("");
		}
		txt.setText(txt.getText() + num);
		vider_txt = false;
	}

	// Procedure d'affichage des resultat de calcule dans le TextField
	// *************************************************************************************
	public void affichageResultat(double resultat) {
		String str = String.valueOf(resultat);
		if (str.length() > 15) // afficher seulement 15 numéros
		{
			str = str.substring(0, 15);
		}

		if (str.indexOf(".0") == str.length() - 2) // enlever le .0 dans la fin
													// du numéros
		{
			str = str.substring(0, str.length() - 2);
		}

		txt.setText(str);
	}

	// Fonction pour la récuperation de la valeur du Textfield
	// *************************************************************************************
	public double getValeur() {
		if (txt.getText() != "") {
			return Double.valueOf(txt.getText());
		}
		return 0;
	}

	// Procedure initialisation des operation arithmetiuqe
	// *************************************************************************************
	public void operation(String op) {
		operation = op;
		mem = txt.getText();
		vider_txt = true;

	}

}
