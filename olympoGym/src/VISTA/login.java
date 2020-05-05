package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MODEL.Clientes;
import DADES.SQLClients;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_usuario;
	private JTextField textField_contraseña;
	SQLClients conexion = new SQLClients();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("ENTRAR");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Clientes cliente = new Clientes(textField_usuario.getText().toString());
				try {
					cliente = conexion.buscarPorDni(cliente);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (cliente.getPassword().equals(textField_contraseña.getText().toString())) {
					if(cliente.getRol().equals("U")) {
						registroHoras pantallaU = new registroHoras(cliente);
						pantallaU.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						pantallaU.actualizacion();
						pantallaU.setVisible(true);
						//dispose();
					}else if (cliente.getRol().equals("A")) {
						interficieAdmin pantallaA = new interficieAdmin();
						pantallaA.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						pantallaA.taulas();
						pantallaA.setVisible(true);
						//dispose();
					}
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(322, 517, 102, 33);
		contentPane.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setForeground(Color.YELLOW);
		panel.setBounds(59, 51, 310, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contrase\u00F1a");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(47, 296, 123, 22);
		panel.add(lblNewLabel);
		
		JLabel lblLogin = new JLabel("Usuario");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(47, 163, 69, 22);
		panel.add(lblLogin);
		
		textField_usuario = new JTextField();
		textField_usuario.setBounds(47, 196, 213, 34);
		panel.add(textField_usuario);
		textField_usuario.setColumns(10);
		
		textField_contraseña = new JTextField();
		textField_contraseña.setBounds(47, 329, 213, 37);
		panel.add(textField_contraseña);
		textField_contraseña.setColumns(10);
		
		JLabel lblOlympogym = new JLabel("OLYMPOGYM");
		lblOlympogym.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblOlympogym.setBackground(Color.ORANGE);
		lblOlympogym.setBounds(76, 54, 150, 34);
		panel.add(lblOlympogym);
	}
}
