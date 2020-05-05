package VISTA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DADES.EntradaSortida;
import DADES.SQLClients;
import MODEL.Clientes;
import MODEL.ControlDeAcceso;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;

public class registroHoras extends JDialog{

	static JPanel contentPane;
	static JTable table;
	static Clientes cliente;
	static EntradaSortida conES = new EntradaSortida();
	static SQLClients clientesSQL = new SQLClients();
	static DefaultTableModel model;
	 //Clientes cliente = new Clientes();
	/**
	 * Launch the application.
	 */
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registroHoras frame = new registroHoras();
					frame.setVisible(true);
					updateTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @param cliente 
	 */
	public registroHoras(Clientes cliente) {
		
		this.cliente = cliente;
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1100, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		panel.setBounds(10, 11, 760, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 78, 740, 440);
		panel.add(table);
		
		model = new DefaultTableModel();
		model.addColumn("Fecha");
		model.addColumn("Gimnasio");
		model.addColumn("E/S");
		
		table.setModel(model);
		actualizacion();
		
		
		
		JLabel lblHistorial = new JLabel("HISTORIAL");
		lblHistorial.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblHistorial.setBounds(10, 31, 119, 22);
		panel.add(lblHistorial);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		panel_1.setBounds(780, 11, 294, 529);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnFichar = new JButton("FICHAR");
		btnFichar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFichar.setBounds(10, 354, 274, 42);
		panel_1.add(btnFichar);
		
		JLabel lblOlympogym = new JLabel("OLYMPOGYM");
		lblOlympogym.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblOlympogym.setBounds(10, 0, 214, 42);
		panel_1.add(lblOlympogym);
		
		JLabel lblGym = new JLabel("GYM's");
		lblGym.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblGym.setBounds(20, 409, 60, 22);
		panel_1.add(lblGym);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String [] {"OlympoGym Terrassa","OlympoGym Sanvi","OlympoGym Manresa"}));
		comboBox.setBounds(10, 442, 214, 22);
		panel_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\lambo\\eclipse-workspace\\olympoGym\\imagenes\\OlympoSida.PNG"));
		lblNewLabel.setBounds(-71, 41, 365, 302);
		panel_1.add(lblNewLabel);
		
		/*btnActualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				actualizacion();
			}
		});*/
		
	
		
		btnFichar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControlDeAcceso eS = new ControlDeAcceso(cliente.getDni());
				try {
					
					ControlDeAcceso aux = conES.consultaUltimoMovimentoCliente(cliente);
					if(aux.getTipo().equals("S")) {
						eS = new ControlDeAcceso("E",comboBox.getSelectedItem().toString(),cliente.getDni());
						
					} else if(aux.getTipo().equals("E")) {
					
						eS = new ControlDeAcceso("S",comboBox.getSelectedItem().toString(),cliente.getDni());
					
					} 
					
					conES.introducirMovimiento(eS);
					actualizacion();
				
				} catch (Exception e) {
								
					try {
					
						System.out.println("No existe");
						eS = new ControlDeAcceso("E",comboBox.getSelectedItem().toString(),cliente.getDni());
					
						conES.introducirMovimiento(eS);
						actualizacion();
					
				} catch (SQLException e1) {
					
						System.out.println("Error al fichar ");
						e1.printStackTrace();
					
				}				
			}
		
				//btnFichar.setBounds(402, 78, 131, 25);
				//contentPane.add(btnFichar);

			}
		});
	}
	public static void actualizacion() {

        // DATA BASE

        EntradaSortida datos = new EntradaSortida();
        datos.conectar();

        DefaultTableModel model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("Fecha");
        model.addColumn("Tipo");
        model.addColumn("Gimnasio");
        model.setRowCount(0);

        table.setModel(model);
        model.setRowCount(0);

        try {
			for (ControlDeAcceso eS : datos.consultaMovimentoCliente(cliente)) {

			    model.addRow(new Object[] {  eS.getFecha(), eS.getTipo(),
			            eS.getGimnasio() });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }
}
