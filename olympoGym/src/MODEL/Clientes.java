package MODEL;

public class Clientes {
	//ATRIBUTOS
	String dni;
	String nombre;
	String apellido;
	String direccion;
	String email;
	String password;
	String telefono;
	String iban;
	String rol;
	
	public Clientes(String dni,String password,	String nombre,	String apellido,String direccion,	String email,String telefono,String iban, String rol) {
		this.dni = dni;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.iban = iban;
		this.rol = rol;
	}
	public Clientes(String dni) {
		this.dni = dni;
	}
	public Clientes(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}
	
	//MAS FUNCIONES
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public void cambiarMetodoDePago(String iban) {
		
	}
	public void cambioDireccionVivienda(String direccion) {
		
	}
	
	
	
}
