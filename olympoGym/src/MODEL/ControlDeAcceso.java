package MODEL;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

public class ControlDeAcceso {

	//ATRIBUTOS
	
	int movimiento;
	String fecha;
	String tipo;
	//String DNI;
	String gimnasio;
	String cliente;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public ControlDeAcceso() {
		// TODO Auto-generated constructor stub
	}
	
	public ControlDeAcceso(ControlDeAcceso eS) {
		this.movimiento = eS.getMovimiento();
		this.fecha = eS.getFecha();
		this.tipo = eS.getTipo();
		this.gimnasio = eS.getgimnasio();
		this.cliente = eS.getCliente();

	}
	public ControlDeAcceso(String cliente) {
		this.cliente = cliente;
	}
	public ControlDeAcceso(String tipo , String gimnasio, String cliente) {
		this.cliente = cliente;
		this.gimnasio = gimnasio;
		this.tipo = tipo;
		this.fecha = sdf.format(new Date());
	}
	
	public ControlDeAcceso(int movimiento, String fecha, String tipo, String gimnasio, String cliente) {
		this.movimiento = movimiento;
		this.fecha = fecha;
		this.tipo = tipo;
		this.cliente = cliente;
		this.gimnasio = gimnasio;
	}
	public int getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/*public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}*/
	public String getgimnasio() {
		return gimnasio;
	}
	public void setgimnasio(String gimnasio) {
		this.gimnasio = gimnasio;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(String gimnasio) {
		this.gimnasio = gimnasio;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	//GETTERS Y SETTERS
	
	
	
}
