package model;

import java.util.Date;

public class Ciudad {
	private String nombre;
	private double temperatura;
	private Date fecha;
	public Ciudad(String nombre, double temperatura, Date fecha) {
		super();
		this.nombre = nombre;
		this.temperatura = temperatura;
		this.fecha = fecha;
	}
	public Ciudad() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
