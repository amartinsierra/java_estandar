package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import utilities.Utilidades;

public class Test {

	public static void main(String[] args) {
		//Nombre de la ciudad correspondiente a la última medida de temperatura tomada
		String dir="c:\\tempo\\ciudades.txt";
		Path path=Path.of(dir);
		try {
			Files.lines(path) //Stream<String>
				.map(s->Utilidades.convertirTextoCiudad(s)) //Stream<Ciudad>
				.max((c1,c2)->c1.getFecha().compareTo(c2.getFecha())) //Optional<Ciudad>
				/*.get()  //Ciudad
				.getNombre()); //String*/
				.ifPresentOrElse(c->System.out.println(c.getNombre()), ()->System.out.println("No hay ciudad"));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
