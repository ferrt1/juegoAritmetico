package game;

import java.awt.EventQueue;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class MainWindow2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	
	private Matriz matriz;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel resultadoTable;
	private JLabel tiempo_JLabel;
	private JButton button_Comenzar;
	
	  	private Timer tiempo;
	  	private int centesimas_segundos = 0;
	    private int segundos = 0;
	    private int minutos = 0;
	    private int horas = 0;
	    
	    private Cronometro c;
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow2 window = new MainWindow2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the application.
	 */
	public MainWindow2() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		
		Matriz matriz = new Matriz();
		
		int[][] nuevaMatriz = new int [4][4];
		
		int[] arregloFila = matriz.crearArreglo(4);
		
		int[] fila = matriz.arregloArmadoFilas;
		int[] columna = matriz.arregloArmadoColumnas;
		
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 675, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 5, 0, 0));
		
		
		//Creo los numeros randoms de cada posicion, con este creo el de las columnas
		int[] arregloColumna = matriz.crearArreglo(4);
		
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
			
				
				//creo los numeros randoms de cada posicion
				//con este creo el de las filas
				
				
				JLabel lblNewLabel = new JLabel(Integer.toString(fila[0]));
				frame.getContentPane().add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(fila[1]));
		frame.getContentPane().add(lblNewLabel_1);

		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);

		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);

		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(fila[2]));
		frame.getContentPane().add(lblNewLabel_2);

		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);

		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);

		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);

		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(textField_15);
		textField_15.setColumns(10);
		
		
		
		JLabel lblNewLabel_3 = new JLabel(Integer.toString(fila[3]));
		frame.getContentPane().add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel(Integer.toString(columna[0]));
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel(Integer.toString(columna[1]));
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(Integer.toString(columna[2]));
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(Integer.toString(columna[3]));
		frame.getContentPane().add(lblNewLabel_7);
		
		label = new JLabel("");
		frame.getContentPane().add(label);
		
		JButton COMPROBAR = new JButton("COMPROBAR");
		COMPROBAR.setAlignmentX(Component.CENTER_ALIGNMENT);
		COMPROBAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Agrego los text field a la matriz creada arriba 
//				ESTO HAY QUE CAMBIAR ES SOLO PARA HACERLO FUNCIONAR Y PROBAR

				
				nuevaMatriz[0][0] = Integer.parseInt(textField.getText());
				nuevaMatriz[0][1] = Integer.parseInt(textField_1.getText());
				nuevaMatriz[0][2] = Integer.parseInt(textField_2.getText());
				nuevaMatriz[0][3] = Integer.parseInt(textField_3.getText());
				
				nuevaMatriz[1][0] = Integer.parseInt(textField_4.getText());
				nuevaMatriz[1][1] = Integer.parseInt(textField_5.getText());
				nuevaMatriz[1][2] = Integer.parseInt(textField_6.getText());
				nuevaMatriz[1][3] = Integer.parseInt(textField_7.getText());
				
				nuevaMatriz[2][0] = Integer.parseInt(textField_8.getText());
				nuevaMatriz[2][1] = Integer.parseInt(textField_9.getText());
				nuevaMatriz[2][2] = Integer.parseInt(textField_10.getText());
				nuevaMatriz[2][3] = Integer.parseInt(textField_11.getText());
				
				nuevaMatriz[3][0] = Integer.parseInt(textField_12.getText());
				nuevaMatriz[3][1] = Integer.parseInt(textField_13.getText());
				nuevaMatriz[3][2] = Integer.parseInt(textField_14.getText());
				nuevaMatriz[3][3] = Integer.parseInt(textField_15.getText());
				
				
//				Esto lo agregue para comprobar el resultado de sumas y columnas, le paso la nueva matriz y los arreglos
				
				boolean r = matriz.verificarSumaFila(nuevaMatriz, 0, fila[0])&&
						matriz.verificarSumaColumna(nuevaMatriz, 0, columna[0]) &&  
						matriz.verificarSumaFila(nuevaMatriz, 1, fila[1])&&
						matriz.verificarSumaColumna(nuevaMatriz, 1, columna[1]) &&  
						matriz.verificarSumaFila(nuevaMatriz, 2, fila[2])&&
						matriz.verificarSumaColumna(nuevaMatriz, 2, columna[2]) &&  
						matriz.verificarSumaFila(nuevaMatriz, 3, fila[3])&&
						matriz.verificarSumaColumna(nuevaMatriz, 3, columna[3]);
				
				resultadoTable.setText(matriz.esGanador(r));
				
				if(r==true) {
					c.tiempo.stop();
				}
				
			}
		});
		
		
		
		button_Comenzar = new JButton("COMENZAR");
		button_Comenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c = new Cronometro(tiempo_JLabel);
				button_Comenzar.setEnabled(false);
				
			}});
		
		
		frame.getContentPane().add(button_Comenzar);
		frame.getContentPane().add(COMPROBAR);
		
		//Aca se van a mostrar el resultado
		resultadoTable = new JLabel("");
		frame.getContentPane().add(resultadoTable);
				
		tiempo_JLabel = new JLabel();
		frame.getContentPane().add(tiempo_JLabel);
		

		
		
		
	}
	
	
}