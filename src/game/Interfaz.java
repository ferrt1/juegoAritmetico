package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Interfaz {

	private JFrame frmJuegoAritmetico;
	private int[][] matrizRecibida;
	private Matriz matriz = new Matriz();
	private Niveles nivelClase = new Niveles();
	private static int nivel = 1;
	
	//	Listas para poder acceder a cada elemento sin perder su posicion
	private LinkedList<JTextField> dataTextFieldLista = new LinkedList<JTextField>();
	private LinkedList<JLabel> arregloSumaFila = new LinkedList<JLabel>();
	private LinkedList<JLabel> arregloSumaColumna = new LinkedList<JLabel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmJuegoAritmetico.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}
	
	
	
	private void createPanelHorizontal(int nivelActual) {
		JPanel panelArregloHorizontal = new JPanel();
		
		panelArregloHorizontal.setForeground(new Color(251, 194, 252));
		panelArregloHorizontal.setBorder(new LineBorder(new Color(251, 194, 252), 3, true));
		panelArregloHorizontal.setBackground(new Color(251, 194, 252));
		panelArregloHorizontal.setBounds(80, 362, 446, 60);
		frmJuegoAritmetico.getContentPane().add(panelArregloHorizontal);
		panelArregloHorizontal.setLayout(new GridLayout(1, 0, 4, 4));
		
		for(int i = 0; i<4; i++) {
			JLabel jLabelHorizontal = new JLabel();
			jLabelHorizontal.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
			jLabelHorizontal.setBackground(new Color(53, 28, 77));
			jLabelHorizontal.setForeground(new Color(251, 194, 252));
			jLabelHorizontal.setHorizontalAlignment(SwingConstants.CENTER);
			panelArregloHorizontal.add(jLabelHorizontal);
			jLabelHorizontal.setOpaque(true);
			jLabelHorizontal.setText(Integer.toString(nivelClase.cambiarNivelColumna(nivelActual)[i]));
			arregloSumaColumna.add(jLabelHorizontal);
		}
		
	}
	
	private void createPanelVertical(int nivelActual) {
		JPanel panelArregloVertical = new JPanel();
		panelArregloVertical.setBorder(new LineBorder(new Color(251, 194, 252), 3, true));
		panelArregloVertical.setBackground(new Color(251, 194, 252));
		panelArregloVertical.setBounds(560, 35, 80, 302);
		frmJuegoAritmetico.getContentPane().add(panelArregloVertical);
		panelArregloVertical.setLayout(new GridLayout(0, 1, 4, 4));

		for(int i = 0; i< 4; i++) {
			JLabel jLabelVertical= new JLabel();
			jLabelVertical.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
			jLabelVertical.setBackground(new Color(53, 28, 77));
			jLabelVertical.setForeground(new Color(251, 194, 252));
			jLabelVertical.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelVertical.setOpaque(true);
			panelArregloVertical.add(jLabelVertical);
			jLabelVertical.setText(Integer.toString(nivelClase.cambiarNivelFila(nivel)[i]));
			arregloSumaFila.add(jLabelVertical);
		}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		matrizRecibida = new int[4][4];

		frmJuegoAritmetico = new JFrame();
		frmJuegoAritmetico.getContentPane().setForeground(new Color(251, 194, 252));
		frmJuegoAritmetico.setTitle("Juego Aritmetico");
		frmJuegoAritmetico.getContentPane().setBackground(new Color(43, 22, 63));
		frmJuegoAritmetico.setBackground(new Color(0, 0, 0));
		frmJuegoAritmetico.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		frmJuegoAritmetico.setForeground(SystemColor.activeCaptionText);
		frmJuegoAritmetico.setBounds(100, 100, 765, 561);
		frmJuegoAritmetico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuegoAritmetico.getContentPane().setLayout(null);

		//		Panel de la matriz del juego

		JPanel panelMatriz = new JPanel();
		panelMatriz.setBorder(new LineBorder(new Color(251, 194, 252), 2, true));
		panelMatriz.setForeground(new Color(251, 194, 252));
		panelMatriz.setBackground(new Color(251, 194, 252));
		panelMatriz.setBounds(80, 35, 446, 302);
		frmJuegoAritmetico.getContentPane().add(panelMatriz);
		panelMatriz.setLayout(new GridLayout(4, 4, 3, 3));

		for(int i = 0; i<16; i++) {
			JTextField textField = new JTextField();
			panelMatriz.add(textField);
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
			textField.setForeground(new Color(251, 194, 252));
			textField.setBackground(new Color(53, 28, 77));
			textField.setBorder(null);
			dataTextFieldLista.add(textField);
		}


		//		Agrego el arreglo donde se encuentra el resultado que debo sumar verticalmente
		//		Agrego el arreglo donde se encuentra el resultado que debo sumar horizontalmente

		createPanelHorizontal(nivel);
		createPanelVertical(nivel);


		//		Creacion de boton para Comprobar el estado

		JButton btnComprobar = new JButton("COMPROBAR");
		btnComprobar.setForeground(new Color(255, 255, 255));
		btnComprobar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnComprobar.setBackground(new Color(118, 82, 133));
		btnComprobar.setBounds(202, 433, 201, 70);
		btnComprobar.setOpaque(true);
		btnComprobar.setContentAreaFilled(true);
		btnComprobar.setBorderPainted(false);
		btnComprobar.setFocusPainted(false);
		frmJuegoAritmetico.getContentPane().add(btnComprobar);

		JButton btnReintentar = new JButton("REINTENTAR");
		btnReintentar.setOpaque(true);
		btnReintentar.setForeground(Color.WHITE);
		btnReintentar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnReintentar.setFocusPainted(false);
		btnReintentar.setContentAreaFilled(true);
		btnReintentar.setBorderPainted(false);
		btnReintentar.setBackground(new Color(118, 82, 133));
		btnReintentar.setBounds(202, 433, 201, 70);
		frmJuegoAritmetico.getContentPane().add(btnReintentar);

		JButton btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setOpaque(true);
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnFinalizar.setFocusPainted(false);
		btnFinalizar.setContentAreaFilled(true);
		btnFinalizar.setBorderPainted(false);
		btnFinalizar.setBackground(new Color(118, 82, 133));
		btnFinalizar.setBounds(202, 433, 201, 70);
		frmJuegoAritmetico.getContentPane().add(btnFinalizar);
		
		JButton btnSiguiente = new JButton("SIGUIENTE");
		btnSiguiente.setOpaque(true);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnSiguiente.setFocusPainted(false);
		btnSiguiente.setContentAreaFilled(true);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setBackground(new Color(118, 82, 133));
		btnSiguiente.setBounds(202, 433, 201, 70);
		frmJuegoAritmetico.getContentPane().add(btnSiguiente);

		btnComprobar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean comprobar = true;
				try {
					matriz.agregarNumerosDeListaAMatriz(matrizRecibida, dataTextFieldLista);

					//Oculto el boton cuando comprueba los resultados
					btnComprobar.setVisible(false);
					for(int i = 0; i < 16; i++) {
						dataTextFieldLista.get(i).setEditable(false);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), 
							"La matriz no puede tener espacios vacios, letras o ceros");
					for(int i = 0; i < 16; i++) {
						dataTextFieldLista.get(i).setEditable(false);
					}
					btnComprobar.setVisible(false);
				}

				//Asumimos que la matriz siempre sera de 4x4
				//Chequeo la suma de las filas
				for(int i = 0; i < 4; i++) {
					if(matriz.verificarSumaFila(matrizRecibida, 0, nivelClase.cambiarNivelFila(nivel)[0])) {
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}
				}
				for(int i = 4; i < 8; i++) {
					if(matriz.verificarSumaFila(matrizRecibida, 1, nivelClase.cambiarNivelFila(nivel)[1])){
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}
				}
				for(int i = 8; i < 12; i++) {
					if(matriz.verificarSumaFila(matrizRecibida, 2, nivelClase.cambiarNivelFila(nivel)[2])) {
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}

				}
				for(int i = 12; i < 16; i++) {
					if(matriz.verificarSumaFila(matrizRecibida, 3, nivelClase.cambiarNivelFila(nivel)[3])) {
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}
				}

				//Chequeo suma columnas

				for(int i = 0; i < 16; i+=4) {
					if(!matriz.verificarSumaColumna(matrizRecibida, 0, nivelClase.cambiarNivelColumna(nivel)[0])) {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}
				}
				for(int i = 1; i < 16; i+=4) {
					if(!matriz.verificarSumaColumna(matrizRecibida, 1, nivelClase.cambiarNivelColumna(nivel)[1])){
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
				}
				}
				for(int i = 2; i < 16; i+=4) {
					if(!matriz.verificarSumaColumna(matrizRecibida, 2, nivelClase.cambiarNivelColumna(nivel)[2])) {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}

				}
				for(int i = 3; i < 16; i+=4) {
					if(!matriz.verificarSumaColumna(matrizRecibida, 3, nivelClase.cambiarNivelColumna(nivel)[3])) {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
						comprobar = false;
					}
				}

				if(!comprobar) {
					btnReintentar.setVisible(true);
				}
				if(nivel !=6 && comprobar) {
					nivel+=1;
					btnSiguiente.setVisible(true);
					btnReintentar.setVisible(false);
					btnFinalizar.setVisible(false);
				}
				if(nivel == 6 && comprobar) {
					btnFinalizar.setVisible(true);
					btnReintentar.setVisible(false);
				}
				System.out.println(nivel);
			}
		});




		btnReintentar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < dataTextFieldLista.size(); i++) {
					dataTextFieldLista.get(i).setText(null);
					dataTextFieldLista.get(i).setBackground(new Color(53, 28, 77));
					dataTextFieldLista.get(i).setForeground(new Color(251, 194, 252));
				}

				btnComprobar.setVisible(true);
				for(int i = 0; i < 16; i++) {
					dataTextFieldLista.get(i).setEditable(true);
				}
				btnReintentar.setVisible(false);
			}
		});
		
		//Acciones del BOTTON SIGUIENTE

		btnSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < dataTextFieldLista.size(); i++) {
					dataTextFieldLista.get(i).setText(null);
					dataTextFieldLista.get(i).setBackground(new Color(53, 28, 77));
					dataTextFieldLista.get(i).setForeground(new Color(251, 194, 252));
				}
				for(int i = 0; i < 16; i++) {
					dataTextFieldLista.get(i).setEditable(true);
				}
				for(int i = 0; i < 4; i++) {
					arregloSumaFila.get(i).setText(Integer.toString(nivelClase.cambiarNivelFila(nivel)[i]));
					arregloSumaColumna.get(i).setText(Integer.toString(nivelClase.cambiarNivelColumna(nivel)[i]));
				}
				
				btnComprobar.setVisible(true);
				btnSiguiente.setVisible(false);
			}
		});
		
		//Acciones del BOTTON FINALIZAR

		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					frmJuegoAritmetico.dispose();
			}
			
		});
	}
}
