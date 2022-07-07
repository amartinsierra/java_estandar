package model;

import java.time.LocalDate;
import java.util.Date;

public class Medida {
	private String nombre;
	private LocalDate fechaMuestra;
	private double incidencia;
	public Medida(String nombre, LocalDate fechaMuestra, double incidencia) {
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
	public LocalDate getFechaMuestra() {
		return fechaMuestra;
	}
	public void setFechaMuestra(LocalDate fechaMuestra) {
		this.fechaMuestra = fechaMuestra;
	}
	public double getIncidencia() {
		return incidencia;
	}
	public void setIncidencia(double incidencia) {
		this.incidencia = incidencia;
	}
	
}
