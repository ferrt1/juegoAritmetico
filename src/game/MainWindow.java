package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainWindow {

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
	private JLabel labelResultados;
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	private void initialize() {
		
		Matriz matriz = new Matriz();
		
		int[][] nuevaMatriz = new int [4][4];
		
		int[] arregloFila = matriz.crearArreglo(4);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 634, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		
		//creo los numeros randoms de cada posicion
		//con este creo el de las filas
		
		
		JLabel lblNewLabel = new JLabel(Integer.toString(arregloFila[0]));
		lblNewLabel.setBounds(546, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(Integer.toString(arregloFila[1]));
		lblNewLabel_1.setBounds(546, 139, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(Integer.toString(arregloFila[2]));
		lblNewLabel_2.setBounds(546, 184, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(Integer.toString(arregloFila[3]));
		lblNewLabel_3.setBounds(546, 235, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		
		//Creo los numeros randoms de cada posicion, con este creo el de las columnas
		int[] arregloColumna = matriz.crearArreglo(4);
		JLabel lblNewLabel_4 = new JLabel(Integer.toString(arregloColumna[0]));
		lblNewLabel_4.setBounds(98, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_5 = new JLabel(Integer.toString(arregloColumna[1]));
		lblNewLabel_5.setBounds(225, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(Integer.toString(arregloColumna[2]));
		lblNewLabel_6.setBounds(328, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(Integer.toString(arregloColumna[3]));
		lblNewLabel_7.setBounds(455, 263, 46, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		textField = new JTextField();
		textField.setBounds(63, 92, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 92, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		
		textField_2 = new JTextField();
		textField_2.setBounds(313, 92, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(432, 92, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(63, 136, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		
		textField_5 = new JTextField();
		textField_5.setBounds(197, 136, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);

		
		textField_6 = new JTextField();
		textField_6.setBounds(313, 136, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);

		
		textField_7 = new JTextField();
		textField_7.setBounds(432, 136, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);

		
		textField_8 = new JTextField();
		textField_8.setBounds(63, 181, 86, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);

		
		textField_9 = new JTextField();
		textField_9.setBounds(197, 181, 86, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);

		
		textField_10 = new JTextField();
		textField_10.setBounds(313, 181, 86, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);

		
		textField_11 = new JTextField();
		textField_11.setBounds(432, 181, 86, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		
		textField_12 = new JTextField();
		textField_12.setBounds(63, 232, 86, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);

		
		textField_13 = new JTextField();
		textField_13.setBounds(197, 232, 86, 20);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);

		
		textField_14 = new JTextField();
		textField_14.setBounds(313, 232, 86, 20);
		frame.getContentPane().add(textField_14);
		textField_14.setColumns(10);

		
		textField_15 = new JTextField();
		textField_15.setBounds(432, 232, 86, 20);
		frame.getContentPane().add(textField_15);
		textField_15.setColumns(10);

		labelResultados = new JLabel("");
		labelResultados.setBounds(73, 330, 471, 42);
		frame.getContentPane().add(labelResultados);
		
		JButton btnNewButton = new JButton("COMPROBAR RESULTADOS");
		btnNewButton.addActionListener(new ActionListener() {
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

				labelResultados.setText("" + matriz.verificarSumaFila(nuevaMatriz, 0, arregloFila[0])+
						" " + matriz.verificarSumaColumna(nuevaMatriz, 0, arregloColumna[0]));

				
			}
		});
		btnNewButton.setBounds(197, 295, 202, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
	
	
}
