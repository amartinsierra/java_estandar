package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import model.Alumno;
import utilities.Utilidades;

public class AlumnosService {
	String ruta="c:\\tempo\\alumnos.csv";
	Path path;
	public AlumnosService() {
		path=Path.of(ruta);
	}
	
	
	//alta alumno
	
	public boolean altaAlumno(String nombre, String dni,String curso, double nota) {
		if(existeDni(dni)) {
			return false;
		}
		try{
			Files.writeString(path, nombre+","+dni+","+curso+","+nota+"\n", StandardOpenOption.APPEND);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//comprobar si existe dni
	private boolean existeDni(String dni) {
		try {
			return Files.lines(path)
			.anyMatch(l->l.contains(dni));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//lista de alumnos por curso
	public List<Alumno> alumnosCurso(String curso){
		try {
			return Files.lines(path)  //Stream<String>
					.map(l->Utilidades.convertirTextoAlumno(l))  //Stream<Alumno>
					.filter(a->a.getCurso().equals(curso)) //Stream<Alumno>
					.collect(Collectors.toList()); //List<Alumno>
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//alumno a partir de dni
	public Alumno alumnoDni(String dni){
		try {
			return Files.lines(path)  //Stream<String>
					.map(l->Utilidades.convertirTextoAlumno(l))  //Stream<Alumno>
					.filter(a->a.getDni().equals(dni)) //Stream<Alumno>
					.findFirst()  //Optional<Alumno>
					.orElse(null); //Alumno
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//nota media por curso
	public double mediaCurso(String curso) {
		try {
			return Files.lines(path)  //Stream<String>
					.map(l->Utilidades.convertirTextoAlumno(l))  //Stream<Alumno>
					.filter(a->a.getCurso().equals(curso)) //Stream<Alumno>
					.collect(Collectors.averagingDouble(a->a.getNota()));
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return 0;
		}
	}
	//alumno con mayor nota
	public Alumno alumnoDestacado(){
		try {
			return Files.lines(path)  //Stream<String>
					.map(l->Utilidades.convertirTextoAlumno(l))  //Stream<Alumno>
					.max((a1,a2)->a1.getNota()>a2.getNota()?1:-1) //Optional<Alumno>
					.orElse(null);
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//alumnos agrupados por curso:
	
	public Map<String,List<Alumno>> alumnosAgrupadosCurso(){
		try {
			return Files.lines(path)
			.map(l->Utilidades.convertirTextoAlumno(l))  //Stream<Alumno>
			.collect(Collectors.groupingBy(a->a.getCurso()));
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
