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
	private Matriz matriz;
	private int[][] matrizRecibida;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frmJuegoAritmetico.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Matriz matriz = new Matriz();

		LinkedList<JTextField> dataTextFieldLista = new LinkedList<JTextField>();
		LinkedList<JLabel> arrayLabelHorizontal = new LinkedList<JLabel>();
		LinkedList<JLabel> arrayLabelVertical = new LinkedList<JLabel>();

		
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
			jLabelVertical.setText(Integer.toString(matriz.arregloArmadoFilas[i]));
		}


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
			
			jLabelHorizontal.setText(Integer.toString(matriz.arregloArmadoColumnas[i]));
		}


		JButton btnComprobar = new JButton("COMPROBAR");
		btnComprobar.setForeground(new Color(255, 255, 255));
		btnComprobar.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnComprobar.setBackground(new Color(118, 82, 133));
		btnComprobar.setBounds(202, 433, 201, 70);
		btnComprobar.setOpaque(true);
		btnComprobar.setContentAreaFilled(true);
		btnComprobar.setBorderPainted(false);
		btnComprobar.setFocusPainted(false);

		btnComprobar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				matrizRecibida = new int[4][4];
				try {
					matriz.agregarNumerosDeListaAMatriz(matrizRecibida, dataTextFieldLista);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), 
							"La matriz no puede tener espacios vacios o letras");
				}
				
				for(int i = 0; i < dataTextFieldLista.size(); i++) {
					if(i < 4 && matriz.verificarSumaFila(matrizRecibida, 0, matriz.arregloArmadoFilas[0])) {
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else if(i < 8 && matriz.verificarSumaFila(matrizRecibida, 1, matriz.arregloArmadoFilas[1])){
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else if(i < 12 && matriz.verificarSumaFila(matrizRecibida, 2, matriz.arregloArmadoFilas[2])){
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else if(i < 16 && matriz.verificarSumaFila(matrizRecibida, 3, matriz.arregloArmadoFilas[3])){
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else {
						dataTextFieldLista.get(i).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
				}
//			Intento de mostrar en rojo si las columnas dan bien pero tira error
				for(int i = 0; i < 4; i++) {
					for(int j = 0; j < dataTextFieldLista.size(); j+=4) {
					if(!(i == 0 && matriz.verificarSumaColumna(matrizRecibida, 0, matriz.arregloArmadoColumnas[0]))) {
						dataTextFieldLista.get(j).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					
					else if(!(i == 1 && matriz.verificarSumaColumna(matrizRecibida, 1, matriz.arregloArmadoColumnas[1]))){
						dataTextFieldLista.get(j+1).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					
					else if(!(i == 2 && matriz.verificarSumaColumna(matrizRecibida, 2, matriz.arregloArmadoColumnas[2]))){
						dataTextFieldLista.get(j+2).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					
					else if(!(i == 3 && matriz.verificarSumaColumna(matrizRecibida, 3, matriz.arregloArmadoColumnas[3]))){
						dataTextFieldLista.get(j+3).setBackground(new Color(227, 0, 82));
						dataTextFieldLista.get(i).setForeground(new Color(0, 0, 0));
					}
					else {
						dataTextFieldLista.get(i).setBackground(new Color(198, 222, 111));
					}
				}
				}
				
		}
				
				
			
			
		});

		frmJuegoAritmetico.getContentPane().add(btnComprobar);


	}
}
