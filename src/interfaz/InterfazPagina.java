package interfaz;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import game.*;


public class InterfazPagina {
	
	private JuegoMain menu;
	private JuegoMatriz matriz = new JuegoMatriz();
	private Cronometro c;
	private JLabel labelTiempo;
	
	//	Objetos de la Interfaz
	private JFrame frmJuegoAritmetico;
	
	private JPanel contentPane;
	private JPanel panelMatriz;
	private JLabel mejorTiempo;
	
	private JButton btnComprobar;
	private JButton btnMenu;
	private JButton btnFinalizar;
	private JButton btnReintentar;
	
	//	Listas para poder acceder a cada elemento sin perder su posicion\
	
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
					InterfazPagina window = new InterfazPagina();
					
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
	public InterfazPagina() {
		initialize();
		c = new Cronometro(labelTiempo);
	}
	
	public void esVisible(boolean b) {
		frmJuegoAritmetico.setVisible(b);
	}
	
	public void cambiarJTextFieldEditable(boolean editable) {
		for(int i = 0; i < 16; i++) {
			dataTextFieldLista.get(i).setEditable(editable);
		}
	}
	
	public void limpiarMatriz() {
		for(int i = 0; i < dataTextFieldLista.size(); i++) {
			dataTextFieldLista.get(i).setText(null);
			dataTextFieldLista.get(i).setBackground(new Color(53, 28, 77));
			dataTextFieldLista.get(i).setForeground(new Color(251, 194, 252));
		}
	}
	
	public void crearPanelArregloHorizontal() {
		JPanel panelArregloHorizontal = new JPanel();
		
		panelArregloHorizontal.setForeground(new Color(251, 194, 252));
		panelArregloHorizontal.setBorder(new LineBorder(new Color(251, 194, 252), 3, true));
		panelArregloHorizontal.setBackground(new Color(251, 194, 252));
		panelArregloHorizontal.setBounds(80, 362, 446, 60);
		contentPane.add(panelArregloHorizontal);
		panelArregloHorizontal.setLayout(new GridLayout(1, 0, 4, 4));
		
		for(int i = 0; i<4; i++) {
			JLabel jLabelHorizontal = new JLabel();
			jLabelHorizontal.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
			jLabelHorizontal.setBackground(new Color(53, 28, 77));
			jLabelHorizontal.setForeground(new Color(251, 194, 252));
			jLabelHorizontal.setHorizontalAlignment(SwingConstants.CENTER);
			panelArregloHorizontal.add(jLabelHorizontal);
			jLabelHorizontal.setOpaque(true);
			jLabelHorizontal.setText(Integer.toString(matriz.getArregloDerecha()[i]));
			arregloSumaColumna.add(jLabelHorizontal);
		}
		
	}
	
	public void crearPanelArregloVertical() {
		JPanel panelArregloVertical = new JPanel();
		panelArregloVertical.setBorder(new LineBorder(new Color(251, 194, 252), 3, true));
		panelArregloVertical.setBackground(new Color(251, 194, 252));
		panelArregloVertical.setBounds(560, 35, 80, 302);
		contentPane.add(panelArregloVertical);
		panelArregloVertical.setLayout(new GridLayout(0, 1, 4, 4));

		for(int i = 0; i< 4; i++) {
			JLabel jLabelVertical= new JLabel();
			jLabelVertical.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
			jLabelVertical.setBackground(new Color(53, 28, 77));
			jLabelVertical.setForeground(new Color(251, 194, 252));
			jLabelVertical.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelVertical.setOpaque(true);
			panelArregloVertical.add(jLabelVertical);
			jLabelVertical.setText(Integer.toString(matriz.getArregloAbajo()[i]));
			arregloSumaFila.add(jLabelVertical);
		}
	}
	
	public void crearPanelMatriz() {
		panelMatriz = new JPanel();
		panelMatriz.setBorder(new LineBorder(new Color(251, 194, 252), 2, true));
		panelMatriz.setForeground(new Color(251, 194, 252));
		panelMatriz.setBackground(new Color(251, 194, 252));
		panelMatriz.setBounds(80, 35, 446, 302);
		contentPane.add(panelMatriz);
		panelMatriz.setLayout(new GridLayout(4, 4, 3, 3));
	}
	
	public void crearPanelDeContenido() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmJuegoAritmetico.setContentPane(contentPane);	
		contentPane.setForeground(new Color(251, 194, 252));
		contentPane.setName("Juego Aritmetico");
		contentPane.setBackground(new Color(43, 22, 63));
		contentPane.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		contentPane.setForeground(SystemColor.activeCaptionText);
		contentPane.setBounds(100, 100, 765, 561);
		contentPane.setLayout(null);
	}
	
	public void crearBoton(JButton button) {
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		button.setFocusPainted(false);
		button.setContentAreaFilled(true);
		button.setBorderPainted(false);
		button.setBackground(new Color(118, 82, 133));
		button.setBounds(202, 433, 201, 70);
		contentPane.add(button);
	}
	
	public void crearLabelTiempo() {
		labelTiempo = new JLabel("00:00:00:00");
		labelTiempo.setForeground(new Color(255, 255, 255));
		labelTiempo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		labelTiempo.setBackground(new Color(118, 82, 133));
		labelTiempo.setBounds(325, 433, 201, 70);
		labelTiempo.setBackground(Color.MAGENTA);
		labelTiempo.setBounds(560, 433, 167, 70);
		contentPane.add(labelTiempo);
	}
	
	public void crearLabelMejorTiempo() {
		mejorTiempo = new JLabel();
		File archivo = new File ("test.txt");
		try {
			LeerArchivo j = new LeerArchivo(archivo);
			FileInputStream fis =new FileInputStream(archivo);
			Scanner scanner = new Scanner(fis);
			String linea = scanner.nextLine();
			mejorTiempo.setText(linea);
		}
			
		 catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		mejorTiempo.setForeground(Color.WHITE);
		mejorTiempo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		mejorTiempo.setBackground(new Color(118, 82, 133));
		mejorTiempo.setBounds(560, 352, 167, 70);
		contentPane.add(mejorTiempo);
	}
	
	  public void crearYAgregarMatriz() {
	        try {
	            // Crear una lista de enteros a partir de los JTextFields
	            List<Integer> numeros = new ArrayList<>();
	            for (JTextField field : dataTextFieldLista) {
	                numeros.add(Integer.parseInt(field.getText()));
	            }

	            matriz.agregarNumerosDeListaAMatriz(numeros);
	            //Oculto el boton cuando comprueba los resultados
	            btnComprobar.setVisible(false);
	            cambiarJTextFieldEditable(false);
	            
	        } catch (Exception e2) {
	            JOptionPane.showMessageDialog(new JFrame(), 
	                    "La matriz no puede tener espacios vacios, letras o ceros");
	            cambiarJTextFieldEditable(false);
	            btnComprobar.setVisible(false);
	        }
	    }
	
	public void cambiarColorVerdeTextField(JTextField textField) {
		textField.setBackground(new Color(198, 222, 111));
		textField.setForeground(new Color(0, 0, 0));
	}
	
	public void cambiarColorRojoTextField(JTextField textField) {
		textField.setBackground(new Color(227, 0, 82));
		textField.setForeground(new Color(0, 0, 0));
	}
	
	
	public void cambiarColorSiSumaBienOMalFilas() {
		for(int i = 0; i < 4; i++) {
			if(matriz.verificarSumaFila(0,  matriz.getArregloAbajo()[0])) {
				cambiarColorVerdeTextField(dataTextFieldLista.get(i));
			}
			else {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}
		}
		for(int i = 4; i < 8; i++) {
			if(matriz.verificarSumaFila(1,  matriz.getArregloAbajo()[1])){
				cambiarColorVerdeTextField(dataTextFieldLista.get(i));
			}
			else {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}
		}
		for(int i = 8; i < 12; i++) {
			if(matriz.verificarSumaFila(2,  matriz.getArregloAbajo()[2])) {
				cambiarColorVerdeTextField(dataTextFieldLista.get(i));
			}
			else {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}

		}
		for(int i = 12; i < 16; i++) {
			if(matriz.verificarSumaFila(3,  matriz.getArregloAbajo()[3])) {
				cambiarColorVerdeTextField(dataTextFieldLista.get(i));
			}
			else {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}
		}
	}
	
//	Al asumir que la matriz es de 4x4 puedo recorrer hasta 16 veces el arreglo dataTextField y saber cada posicion
	
	public void cambiarColorSiSumaBienOMalColumnas() {
		for(int i = 0; i < 16; i+=4) {
			if(!matriz.verificarSumaColumna(0, matriz.getArregloDerecha()[0])) {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}
		}
		for(int i = 1; i < 16; i+=4) {
			if(!matriz.verificarSumaColumna(1, matriz.getArregloDerecha()[1])){
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
		}
		}
		for(int i = 2; i < 16; i+=4) {
			if(!matriz.verificarSumaColumna(2, matriz.getArregloDerecha()[2])) {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}
		}
		for(int i = 3; i < 16; i+=4) {
			if(!matriz.verificarSumaColumna(3, matriz.getArregloDerecha()[3])) {
				cambiarColorRojoTextField(dataTextFieldLista.get(i));
			}
		}
	}
	
	public void cambiarBotones(boolean comprobar) {
		if(!comprobar) {
			btnReintentar.setVisible(true);
		}
		if(comprobar) {
			btnReintentar.setVisible(false);
			btnFinalizar.setVisible(true);
		}
	}

	
	public void manejarGuardadoTiempo() {
		c.tiempo.stop();
		
		String mTiempo = mejorTiempo.getText();
		String tiempoCorriendo = labelTiempo.getText();
		
		char letraAEliminar = ':';
		String textoSinLetra1 = mTiempo.replace(Character.toString(letraAEliminar), "");
		String textoSinLetra2 = tiempoCorriendo.replace(Character.toString(letraAEliminar), "");
		
		int mejorTiempo2 = Integer.parseInt(textoSinLetra1);
		int labelTiempo2 = Integer.parseInt(textoSinLetra2);
		
		if(labelTiempo2<mejorTiempo2) {
			try {
				GuardarArchivoTxt g2 = new GuardarArchivoTxt(labelTiempo.getText());
				File archivo = new File ("test.txt");
				LeerArchivo j = new LeerArchivo(archivo);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private void crearYAgregarTextFields() {
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
	}
	
	private void crearYConfigurarBotones() {
	    btnComprobar = new JButton("COMPROBAR");
	    crearBoton(btnComprobar);
	    btnReintentar = new JButton("REINTENTAR");
	    crearBoton(btnReintentar);
	    btnFinalizar = new JButton("MENU");
	    crearBoton(btnFinalizar);
	    btnMenu = new JButton("MENU");
	    crearBoton(btnMenu);
	}
	
	private void asignarAccionesBotones() {
	    btnComprobar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            crearYAgregarMatriz();
	            cambiarColorSiSumaBienOMalFilas();
	            cambiarColorSiSumaBienOMalColumnas();

	            boolean comprobar = matriz.comprobarTodoJuego();
	            if (comprobar) {
	                manejarGuardadoTiempo();
	            }
	            cambiarBotones(comprobar);
	        }
	    });

	    btnReintentar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            limpiarMatriz();
	            btnComprobar.setVisible(true);
	            cambiarJTextFieldEditable(true);
	            btnReintentar.setVisible(false);
	        }
	    });

	    btnMenu.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Acciones del botón Menú
	        }
	    });

	    btnFinalizar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            menu = new JuegoMain();
	            menu.setVisible(true);
	            frmJuegoAritmetico.dispose();
	        }
	    });
	}
	
	private void inicializarJFrame() {
	    frmJuegoAritmetico = new JFrame();
	    frmJuegoAritmetico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frmJuegoAritmetico.setBounds(100, 100, 765, 561);
	}
	
	/**
	 * Create the frame.
	 */
	
	
	private void initialize() {
	    inicializarJFrame();
	    crearPanelDeContenido();
	    crearPanelMatriz();
	    crearYAgregarTextFields();
	    crearPanelArregloHorizontal();
	    crearPanelArregloVertical();
	    crearLabelMejorTiempo();
	    crearLabelTiempo();
	    crearYConfigurarBotones();
	    asignarAccionesBotones();
	}
}
