package DADES;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import MODEL.ControlDeAcceso;
import MODEL.Clientes;
public class EntradaSortida {
	Connection con = null;
	
	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String dni,clientes, password, nombre, apellido, direccion, email, telefono, IBAN, rol, fecha, tipo, gimnasio;
	int  movimiento;
	String url;
	//ArrayList<Cin> moviments = new ArrayList<E_S>();
	ArrayList<ControlDeAcceso> insertaMovimiento = new ArrayList<ControlDeAcceso>();
	
	public Connection conectar() {

		url = "C:\\Users\\lambo\\eclipse-workspace\\olympoGym\\gym.db";
		
		try {

			Class.forName("org.sqlite.JDBC");

			c = DriverManager.getConnection("jdbc:sqlite:" + url);

			System.out.println("Exito al conectar con base de datos\n");

		} catch (Exception e) {

			System.out.println("Error al conectar con base de datos\n");
			e.printStackTrace();

		}
		return c;

	}
	public void introducirMovimiento(ControlDeAcceso eS) throws SQLException {

		
		try {
			conectar();

			String sqlInsert = "INSERT INTO ControlDeAcceso (fecha, tipo, gimnasio, cliente) "

		            	 + "VALUES (" 
		            	 + "'" + eS.getFecha() + "'" + ","
		            	 + "'" + eS.getTipo() + "'" + ","
		            	 + "'" + eS.getgimnasio() + "'" + ","
		            	 + "'" + eS.getCliente() + "'" + ");";
			
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();

			System.out.println("Datos insertados");

		} catch (Exception e) {

			System.out.println("Error al insertertar datos en la tabla ControlDeAcceso");

		}
	}
	/*public void updateMovimiento(ControlDeAcceso eS) throws SQLException {
		String sqlUpdate ="UPDATE ControlDeAcceso "
                + "SET "
                + "movimiento='" + eS.getMovimiento() 
                + "', fecha='" + eS.getFecha()
                + "', tipo='" + eS.getTipo()
                + "', gimnasio='" +eS.getgimnasio()
                + "' WHERE movimiento='" + eS.getMovimiento() + "';";
		try {
			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlUpdate);
			//System.out.println(sqlUpdate);
			sentencia.close();
			c.close();
			System.out.println("Datos modificados");
		} catch (Exception e) {
			System.out.println("Error al modificar datos en la tabla");
		}
	}*/
	public ArrayList<ControlDeAcceso> consultaMoviment() throws SQLException {

		conectar();

		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM ControlDeAcceso ORDER BY fecha desc;";
		
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			while (rs.next()) {
					
				movimiento = rs.getInt("movimiento");
				fecha = rs.getString("fecha");
				tipo = rs.getString("tipo");
				gimnasio = rs.getString("gimnasio");
				clientes = rs.getString("cliente");
						
				//GUARDA EN ARRAY LIST CLIENT
				insertaMovimiento.add(new ControlDeAcceso(
						movimiento, 
						fecha, 
						tipo,
						gimnasio,
						clientes
						));
			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (Exception e) {

			System.out.println("Error al ver la tabla");

		}
		return insertaMovimiento;
	}
	public ArrayList<ControlDeAcceso> consultaMovimentoCliente(Clientes cliente) throws SQLException {

		conectar();

		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM ControlDeAcceso WHERE cliente = '" + cliente.getDni() + "' ORDER BY fecha desc;";
		System.out.println("Aqui llega 1");
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			System.out.println("Aqui llega 2");
			while (rs.next()) {
					
				movimiento = rs.getInt("movimiento");
				gimnasio = rs.getString("gimnasio");
				fecha = rs.getString("fecha");
				tipo = rs.getString("tipo");
				clientes = rs.getString("cliente");
						
				//GUARDA EN ARRAY LIST CLIENT
				insertaMovimiento.add(new ControlDeAcceso(
						movimiento, 
						fecha, 
						tipo,
						gimnasio,
						clientes
						));
			}
			System.out.println("Aqui llega 3");
			rs.close();
			sentencia.close();
			c.close();

		} catch (Exception e) {

			System.out.println("Error al ver los datos del Cliente");

		}
		return insertaMovimiento;
	}
	public ControlDeAcceso consultaUltimoMovimentoCliente(Clientes cliente) throws SQLException {

		conectar();
		ControlDeAcceso movimientos = null;
		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM ControlDeAcceso WHERE cliente = '" + cliente.getDni() + "' ORDER BY movimiento desc LIMIT 1;";
		System.out.println(consultaSql);
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
		
				
				
				//cliente = rs.getString("Client");
				movimiento = rs.getInt("movimiento");
				fecha = rs.getString("fecha");
				tipo = rs.getString("tipo");
				gimnasio = rs.getString("gimnasio");
				clientes = rs.getString("cliente");
						
				//GUARDA EN ARRAY LIST CLIENT
				movimientos = new ControlDeAcceso(
						movimiento, 
						fecha, 
						tipo,
						gimnasio,
						clientes
						);
			

			rs.close();
			sentencia.close();
			c.close();

		} catch (Exception e) {

			System.out.println("Error al ver los datos del Cliente del ultimo movimiento");

		}
		return movimientos;
	}
	
}