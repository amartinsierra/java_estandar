package principal;

import java.util.List;
import java.util.Map;

import model.Alumno;
import service.AlumnosService;

public class Prueba {

	public static void main(String[] args) {
		AlumnosService service=new AlumnosService();
		Map<String,List<Alumno>> alumnos=service.alumnosAgrupadosCurso();
		//mostrar para cada curso, el nombre de los alumnos
		alumnos.forEach((k,v)->{
			System.out.println("-----Curso: "+k);
			v.forEach(a->System.out.println("Nombre alumno: "+a.getNombre()));
		});
	}

}
