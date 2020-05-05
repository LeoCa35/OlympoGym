package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import DADES.*;
import MODEL.Clientes;
import javax.swing.JScrollPane;
public class interficieAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField_DNI;
	private JTextField textField_password;
	private JTextField textField_Nombre;
	private JTextField textField_Apellidos;
	private JTextField textField_Email;
	private JTextField textField_Telefono;
	private JTextField textField_Iban;
	private JLabel lblNombres;
	private JLabel label_1;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblIban;
	JButton btnNewButton;
	JButton btnEditar;
	JButton btnBorrar;
	//JButton btnActualizar;
	JButton btnGuardar;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textField_Buscador;
	private JButton btnNewButton_1;
	private JTextField textField_Direccion;
	String dni,password, nombre, apellidos, direccion, email, telefono, iban, rol;
	String estado;
	SQLClients con = new SQLClients();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textField_rol;
	private JLabel lblRol;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interficieAdmin frame = new interficieAdmin();
					frame.taulas();
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
	public interficieAdmin() {
		JButton btnGuardar = new JButton("ACTUALIZAR");
		btnEditar = new JButton("EDITAR");
		btnNewButton = new JButton("A\u00D1ADIR");
		btnBorrar = new JButton("BORRAR");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 644);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 674, 583);
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 172, 37);
		panel.add(lblNewLabel);
		
		textField_Buscador = new JTextField();
		textField_Buscador.setBounds(117, 22, 453, 20);
		panel.add(textField_Buscador);
		textField_Buscador.setColumns(10);
		/*
		 * BOTON BUSCAR
		 * */
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.setBounds(575, 21, 89, 23);
		panel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 638, 497);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnBuscar.addActionListener(new ActionListener() {					

			public void actionPerformed(ActionEvent e) {
				//---Actualiza valores que se muestran en la tabla
				SQLClients cliente = new SQLClients();
				try {			
							
					model.setRowCount(0);	

					//----RELLENA TABLA
					for (Clientes cli:cliente.BuscarBuscador(new Clientes(textField_Buscador.getText().toString()))) {
						model.addRow(new Object[] {
							cli.getDni(),
							cli.getPassword(),
							cli.getNombre(),
							cli.getApellido(),
							cli.getDireccion(),
							cli.getEmail(),
							cli.getTelefono(),
							cli.getIban(),
							cli.getRol(),
							});	
							}	

						} catch (Exception e1) {

						}
					}
				});
				//btnNewButton.setBounds(661, 63, 117, 25);
				//contentPanel.add(btnNewButton);

			
	
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(694, 11, 480, 411);
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField_DNI = new JTextField();
		textField_DNI.setBounds(10, 11, 332, 30);
		panel_1.add(textField_DNI);
		textField_DNI.setColumns(10);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		textField_Nombre.setBounds(10, 104, 332, 30);
		panel_1.add(textField_Nombre);
		
		textField_Apellidos = new JTextField();
		textField_Apellidos.setColumns(10);
		textField_Apellidos.setBounds(10, 145, 332, 30);
		panel_1.add(textField_Apellidos);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(10, 227, 332, 30);
		panel_1.add(textField_Email);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setColumns(10);
		textField_Telefono.setBounds(10, 268, 332, 30);
		panel_1.add(textField_Telefono);
		
		textField_Iban = new JTextField();
		textField_Iban.setColumns(10);
		textField_Iban.setBounds(10, 309, 332, 30);
		panel_1.add(textField_Iban);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDni.setBounds(352, 15, 118, 22);
		panel_1.add(lblDni);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(352, 60, 118, 22);
		panel_1.add(lblPassword);
		
		lblNombres = new JLabel("Nombre");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombres.setBounds(352, 101, 118, 30);
		panel_1.add(lblNombres);
		
		label_1 = new JLabel("Apellidos");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(352, 145, 118, 30);
		panel_1.add(label_1);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(352, 224, 118, 30);
		panel_1.add(lblEmail);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTelefono.setBounds(352, 266, 118, 29);
		panel_1.add(lblTelefono);
		
		lblIban = new JLabel("IBAN");
		lblIban.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIban.setBounds(352, 306, 118, 30);
		panel_1.add(lblIban);
		
		lblRol = new JLabel("ROL");
		lblRol.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRol.setBounds(352, 347, 118, 30);
		panel_1.add(lblRol);
		
		
		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		textField_Direccion.setBounds(10, 186, 332, 30);
		panel_1.add(textField_Direccion);
		
		textField_password = new JTextField();
		textField_password.setEnabled(false);
		textField_password.setColumns(10);
		textField_password.setBounds(10, 52, 332, 30);
		panel_1.add(textField_password);
		
		textField_rol = new JTextField();
		textField_rol.setEnabled(false);
		textField_rol.setColumns(10);
		textField_rol.setBounds(10, 350, 332, 30);
		panel_1.add(textField_rol);
		
		
		
		JLabel lblNacimiento = new JLabel("Direccion");
		lblNacimiento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNacimiento.setBounds(352, 183, 118, 30);
		panel_1.add(lblNacimiento);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(694, 433, 480, 161);
		panel_2.setBackground(Color.YELLOW);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGuardar.setBounds(244, 119, 226, 31);
		panel_2.add(btnGuardar);
		
		//btnNewButton.setEnabled(false);
		btnBorrar.setEnabled(false);
		//btnGuardar.setEnabled(false);
		btnEditar.setEnabled(false);

		
		
	
		
		textField_DNI.setEnabled(false);
		textField_password.setEnabled(false);
		textField_Nombre.setEnabled(false);
		textField_Apellidos.setEnabled(false);
		textField_Direccion.setEnabled(false);
		textField_Email.setEnabled(false);
		textField_Telefono.setEnabled(false);
		textField_Iban.setEnabled(false);
		textField_rol.setEnabled(false);
		
	
		

		
		/**
		 * BOTON AÑADIR
		 */
		
		//btnNewButton = new JButton("A\u00D1ADIR");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField_DNI.setEnabled(true);
				textField_password.setEnabled(true);
				textField_Nombre.setEnabled(true);
				textField_Apellidos.setEnabled(true);
				textField_Direccion.setEnabled(true);
				textField_Email.setEnabled(true);
				textField_Telefono.setEnabled(true);
				textField_Iban.setEnabled(true);
				textField_rol.setEnabled(true);
				
				textField_DNI.requestFocus();
				
				textField_DNI.setText("");
				textField_password.setText("");
				textField_Nombre.setText("");
				textField_Apellidos.setText("");
				textField_Direccion.setText("");
				textField_Email.setText("");
				textField_Telefono.setText("");
				textField_Iban.setText("");
				textField_rol.setText("");
				
				estado = "new";
				btnNewButton.setEnabled(false);
			}
		});
		//btnNew.setActionCommand("OK");

		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(10, 28, 224, 32);
		panel_2.add(btnNewButton);
		/**
		 * BOTON EDITAR
		 */
		//btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField_DNI.setEnabled(false);
				textField_password.setEnabled(true);
				textField_Nombre.setEnabled(true);
				textField_Apellidos.setEnabled(true);
				textField_Direccion.setEnabled(true);
				textField_Email.setEnabled(true);
				textField_Telefono.setEnabled(true);
				textField_Iban.setEnabled(true);
				textField_rol.setEnabled(true);
				estado = "edit";
	
		btnEditar.setActionCommand("OK");
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEditar.setBounds(10, 71, 224, 32);
		panel_2.add(btnEditar);
		/**
		 * BOTON BORRAR
		 */
		//btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();
				System.out.println(fila);
				dni = (String) model.getValueAt(table.getSelectedRow(), 0);
				//System.out.println(codigo);

				if (fila >= 0) {
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecioname una fila");
				}
				estado = "delete";
				try {
					int dialogbutton = 0;
					int dialogResult = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres borrar este registro? ","Warning",dialogbutton );
					if (dialogResult == JOptionPane.YES_OPTION) {
						con.deleteClients(new Clientes(dni));
					}
				} catch (Exception exception) {
					// TODO: handle exception
				}
				taulas();
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBorrar.setBounds(10, 119, 224, 31);
		panel_2.add(btnBorrar);
		
		/**
		 * BOTON GUARDAR
		 */
		
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String dniUpdate = textField_DNI.getText().toString();
					String passwordUpdate = textField_password.getText().toString();
					String nombreUpdate = textField_Nombre.getText().toString();
					String apellidosUpdate = textField_Apellidos.getText().toString();
					String direccionUpdate = textField_Direccion.getText().toString();
					String emailUpdate = textField_Email.getText().toString();
					String telefonoUpdate = textField_Telefono.getText().toString();
					String ibanUpdate = textField_Iban.getText().toString();
					String rolUpdate = textField_rol.getText().toString();
			

											
					if (estado == "new") {
						con.insertarClientes(new Clientes(dniUpdate,passwordUpdate, nombreUpdate, apellidosUpdate, direccionUpdate,
								emailUpdate, telefonoUpdate, ibanUpdate, rolUpdate));
					} else if (estado == "edit") {
						con.updateClients(new Clientes(dniUpdate,passwordUpdate, nombreUpdate, apellidosUpdate, direccionUpdate,
								emailUpdate, telefonoUpdate, ibanUpdate, rolUpdate));
					}
					taulas();
					btnNewButton.setEnabled(true);
					textField_DNI.setText("");
					textField_password.setText("");
					textField_Nombre.setText("");
					textField_Apellidos.setText("");
					textField_Direccion.setText("");
					textField_Email.setText("");
					textField_Telefono.setText("");
					textField_Iban.setText("");
					textField_rol.setText("");


					textField_DNI.setEnabled(false);
					textField_password.setEnabled(false);
					textField_Nombre.setEnabled(false);
					textField_Apellidos.setEnabled(false);
					textField_Direccion.setEnabled(false);
					textField_Email.setEnabled(false);
					textField_Telefono.setEnabled(false);
					textField_Iban.setEnabled(false);
					textField_rol.setEnabled(false);
					btnEditar.setEnabled(false);
					//btnDelete.setEnabled(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		
	
		
	}
	public void taulas() {
		// TODO Auto-generated method stub
		con = new SQLClients();
		model = new DefaultTableModel();
		/*
		model.addColumn("DNI");
		model.addColumn("Password");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Direccion");
		model.addColumn("Email");
		model.addColumn("Telefono");
		model.addColumn("IBAN");
		model.addColumn("Rol");
	
		table.setModel(model);*/
		
		model.addColumn("DNI");
		model.addColumn("Password");
		model.addColumn("Nombre");
		model.addColumn("Apellidos");
		model.addColumn("Direccion");
		model.addColumn("Email");
		model.addColumn("Telefono");
		model.addColumn("Iban");
		model.addColumn("rol");

		table.setModel(model);

		try {

			for (Clientes cliente : con.guardarObjeto("Clientes")) {
				model.addRow(new Object[] { cliente.getDni(),cliente.getPassword(), cliente.getNombre(), cliente.getApellido(),
						cliente.getDireccion(), cliente.getEmail(), cliente.getTelefono(), cliente.getIban(), cliente.getRol() });

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if (e.getClickCount() == 1) {

					System.out.println("bro aqui llega");
					dni = (String) model.getValueAt(table.getSelectedRow(), 0);
					password = (String) model.getValueAt(table.getSelectedRow(), 1);
					System.out.println(dni);
					nombre = (String) model.getValueAt(table.getSelectedRow(), 2);
					apellidos = (String) model.getValueAt(table.getSelectedRow(), 3);
					direccion = (String) model.getValueAt(table.getSelectedRow(), 4);
					email = (String) model.getValueAt(table.getSelectedRow(), 5);
					telefono = (String) model.getValueAt(table.getSelectedRow(), 6);
					iban = (String) model.getValueAt(table.getSelectedRow(), 7);
					rol = (String) model.getValueAt(table.getSelectedRow(), 8);

					textField_DNI.setText(dni);
					textField_password.setText(password);
					textField_Nombre.setText(nombre);
					textField_Apellidos.setText(apellidos);
					textField_Direccion.setText(direccion);
					textField_Email.setText(email);
					textField_Telefono.setText(telefono);
					textField_Iban.setText(iban);
					textField_rol.setText(rol);

					btnEditar.setEnabled(true);
					btnBorrar.setEnabled(true);
					btnNewButton.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecioname una fila");
				}
			}
		});
		
		

	}
}
