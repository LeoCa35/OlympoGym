package DADES;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

import MODEL.Clientes;
public class SQLClients {
	Connection con = null;
	
	Connection c = null;

	Statement sentencia = null;

	String nombreTabla;

	String dni, password, nombre, apellido, direccion, email, telefono, IBAN, rol;
	
	String url;
	public ArrayList<Clientes> insertaClientes = new ArrayList<Clientes>();
	
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
	public void insertarClientes(Clientes cliente) throws SQLException{
		String sqlInsert = "INSERT INTO Clientes (DNI,password,nombre,apellido,direccion,email,telefono,IBAN,ROL) "
            	+ "VALUES ("+"\""+cliente.getDni()+"\""+","
            	+"\""+cliente.getPassword()+"\""+","
            	+"\""+cliente.getNombre()+"\""+","
            	+"\""+cliente.getApellido()+"\""+"," 
            	+"\""+cliente.getDireccion()+"\""+"," 
            	+"\""+cliente.getEmail()+"\""+"," 
            	+"\""+cliente.getTelefono()+"\""+"," 
            	+"\""+cliente.getIban()+"\""+","
				+"\""+cliente.getRol()+"\""+");";

		try {
			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			System.out.println("Datos insertados");
		} catch (Exception e) {
			System.out.println("Error al insertar datos en la tabla");
		}
	}
	public void updateClients(Clientes cliente) throws SQLException {
		String sqlUpdate ="UPDATE Clientes "
                + "SET "
                + "password='" + cliente.getPassword() 
                + "', nombre='" + cliente.getNombre()
                + "', apellido='" + cliente.getApellido()
                + "', direccion='" + cliente.getDireccion()
                + "', email='" + cliente.getEmail()
                + "', telefono='" + cliente.getTelefono()
                + "', IBAN='" +cliente.getIban()
                + "', ROL='" +cliente.getRol()
                + "' WHERE DNI='" + cliente.getDni() + "';";
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
	}
	public void deleteClients(Clientes clientes) throws SQLException {
		String sqlInsert = "DELETE FROM Clientes WHERE DNI ="+"\""+clientes.getDni()+"\"";
		
		try {
			conectar();
			sentencia = c.createStatement();
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			System.out.println("Datos borrados");
		} catch (Exception e) {
			System.out.println("Error al borrar datos en la tabla");
		}
	}
	public ArrayList<Clientes> guardarObjeto(String nombreTabla) throws SQLException {

		conectar();

		sentencia = c.createStatement();

		String consultaSql = "SELECT * FROM " + nombreTabla + ";";

		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
				insertaClientes
						.add(new Clientes(rs.getString("DNI"),rs.getString("password"), rs.getString("nombre"), rs.getString("apellido"),
								rs.getString("direccion"), rs.getString("email"), rs.getString("telefono"),
								rs.getString("IBAN"), rs.getString("ROL")));
			}

			rs.close();
			sentencia.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fallo al recuperar datos");
		}
		return insertaClientes;
	}
	public Clientes buscarPorDni(Clientes cliente) throws SQLException {

		conectar();

		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM Clientes WHERE DNI = '" + cliente.getDni() + "';";
		Clientes client = new Clientes(cliente.getDni(),cliente.getPassword());	
		System.out.println(cliente.getPassword());
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);
			//int i = 0;//-------------CONTADOR PARA LA MATRIZ
			while (rs.next()) {
					
				dni = rs.getString("DNI");
				password = rs.getString("password");
				System.out.println(password);
				rol = rs.getString("ROL");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				direccion = rs.getString("direccion");
				email = rs.getString("email");
				telefono = rs.getString("telefono");
				IBAN = rs.getString("IBAN");
					
				//GUARDA EN ARRAY LIST CLIENT
				 client = new Clientes(
						dni, 
						password, 
						nombre, 
						apellido, 
						direccion, 
						email, 
						telefono, 
						IBAN,
						rol);
				 

				//i++;//---------- AUMENTA CONTADOR
			}

			rs.close();
			sentencia.close();
			c.close();
		} catch (Exception e) {
			System.out.println("impossible");
			

		}
		return client;
	}
	public ArrayList<Clientes> BuscarBuscador(Clientes cliente) throws SQLException {
		conectar();

		sentencia = c.createStatement();
		String consultaSql = "SELECT * FROM Clientes WHERE DNI LIKE '%" + cliente.getDni() + "%';";
		//Client client = new Client(cli.getDni(),cli.getPassword());	
		try {

			ResultSet rs = sentencia.executeQuery(consultaSql);

			while (rs.next()) {
					
				dni = rs.getString("DNI");
				password = rs.getString("password");
				nombre = rs.getString("nombre");
				apellido = rs.getString("apellido");
				direccion = rs.getString("direccion");
				email = rs.getString("email");
				telefono = rs.getString("telefono");
				IBAN = rs.getString("IBAN");
				rol = rs.getString("ROL");	
				//GUARDA EN ARRAY LIST CLIENT
				insertaClientes.add(new Clientes(
						dni, 
						password, 
						nombre, 
						apellido, 
						direccion, 
						email, 
						telefono,
						IBAN,
						rol
						));
				
			}

			rs.close();
			sentencia.close();
			c.close();
			
		} catch (Exception e) {
			System.out.println("fALLO AL BUSCAR ");

		}
		return insertaClientes;
	}

}
