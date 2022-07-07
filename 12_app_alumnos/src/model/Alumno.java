package model;

public class Alumno {
	private String nombre;
	private String dni;
	private String curso;
	private double nota;
	public Alumno(String nombre, String dni, String curso, double nota) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.curso = curso;
		this.nota = nota;
	}
	public Alumno() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	
}
