package model;

import java.util.Date;

public class Medida {
	private String nombre;
	private Date fechaMuestra;
	private double incidencia;
	public Medida(String nombre, Date fechaMuestra, double incidencia) {
		super();
		this.nombre = nombre;
		this.fechaMuestra = fechaMuestra;
		this.incidencia = incidencia;
	}
	public Medida() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaMuestra() {
		return fechaMuestra;
	}
	public void setFechaMuestra(Date fechaMuestra) {
		this.fechaMuestra = fechaMuestra;
	}
	public double getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}
	
}
