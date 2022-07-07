package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class NotasService {
	String ruta="c:\\temp\\notas.txt";
	Path path;
	public NotasService() {
		path=Path.of(ruta);
		try {
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	//métodos de la clase
	public void guardarNota(double nota) {					
		try {
			Files.writeString(path, String.valueOf(nota)+"\n",StandardOpenOption.APPEND);
		}
		catch(IOException ex) {
			
			ex.printStackTrace();
		}	
	}	
	public double media() {
		try {
			return Files.lines(path) //Stream<String>
			.collect(Collectors.averagingDouble(s->Double.parseDouble(s)));
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return 0;
		}
	}
	//***
	public int aprobados() {
		try{		
			//con programación funcional
			return (int) Files.lines(path)
			.mapToDouble(n->Double.parseDouble(n))
			.filter(n->n>=5)
			.count();
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return 0;
		}
	}
	
	public Double[] devolverNotas() {
		try{		
			return Files.lines(path) //Stream<String>
					.map(n->Double.parseDouble(n)) //Stream<Double>
					.toArray(n->new Double[n]);
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return new Double[0];
		}
	}
	
	public void subirNotas(double incremento) {	
		ArrayList<Double> notas=obtenerNotas();
		notas.replaceAll(n->n+incremento);
		guardarNotas(notas);
	}
	public void eliminarSuspensos() {
		ArrayList<Double> notas=obtenerNotas();
		notas.removeIf(n->n<5);
		guardarNotas(notas);
	}
	public void ordenarNotas() {
		ArrayList<Double> notas=obtenerNotas();
		//usando el método sort de las listas, NO el de Collections
		//notas.sort((a,b)->a>b?1:-1);
		notas.sort((a,b)->a.compareTo(b));
		guardarNotas(notas);
	}
	
	public ArrayList<Double> obtenerNotas(){
		try{		
			//con programación funcional
			return new ArrayList<Double>(Files.lines(path)
					.map(n->Double.parseDouble(n)) //Stream<Double>
					.collect(Collectors.toList()));		
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public void guardarNotas(ArrayList<Double> notas) {
		try {			
			Files.write(path, notas.stream()
					.map(n->String.valueOf(n))
					.collect(Collectors.toList()));
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//***
	public Optional<String> notaMayor() {
		try{		
			//con programación funcional
			return Files.lines(path) //Stream<String>
			.collect(Collectors.maxBy((a,b)->Double.parseDouble(a)>Double.parseDouble(b)?1:-1));
			
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return Optional.empty();
		}
	}
	//***
	public Optional<String> notaMenor() {
		try{		
			//con programación funcional
			return Files.lines(path)
				.collect(Collectors.minBy((a,b)->Double.parseDouble(a)>Double.parseDouble(b)?1:-1));
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return Optional.empty();
		}
	}
}
