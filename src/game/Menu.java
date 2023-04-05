package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;
	private InterfazPagina interfaz;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void crearBoton(JButton button) {
		button.setOpaque(true);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		button.setFocusPainted(false);
		button.setContentAreaFilled(true);
		button.setBorderPainted(false);
		button.setBackground(new Color(118, 82, 133));
		contentPane.add(button);
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setBackground(new Color(42, 22, 63));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(42, 22, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("JUEGO ARITMETICO");
		lblNewLabel.setForeground(new Color(251, 194, 252));
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 26));
		lblNewLabel.setBounds(215, 93, 282, 134);
		contentPane.add(lblNewLabel);
		
		JButton btnComenzar = new JButton("COMENZAR");
		crearBoton(btnComenzar);
		btnComenzar.setBounds(253, 252, 201, 70);
		
		JButton btnPuntajes = new JButton("PUNTAJES");
		crearBoton(btnPuntajes);
		btnPuntajes.setBounds(253, 362, 201, 70);
		
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz = new InterfazPagina();
				interfaz.esVisible(true);
				setVisible(false);
				dispose();
			}
		});
		
		btnPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
}