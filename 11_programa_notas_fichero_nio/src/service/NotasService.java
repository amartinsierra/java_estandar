package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class NotasService {
	String ruta="c:\\temp\\notas.txt";
	Path path;
	public NotasService() {
		path=Path.of(ruta);
	}
	
	//métodos de la clase
	public void guardarNota(double nota) {					
		try {
			Files.writeString(path, String.valueOf(nota), StandardOpenOption.APPEND);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	
	public OptionalDouble media() {
		try {
			return Files.lines(path)
			.mapToDouble(n->Double.parseDouble(n))
			.average();
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return OptionalDouble.empty();
		}
	}
	//***
	public int aprobados() {
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){		
			//con programación funcional
			return (int) bf.lines()
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
		/*double[] valores=new double[notas.size()];
		for(int i=0;i<notas.size();i++) {
			valores[i]=notas.get(i);
		}*/
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){		
			//con programación funcional
			/*return bf.lines()
			.mapToDouble(n->Double.parseDouble(n)) //DoubleStream
			.toArray(); //double[]*/
			
			return bf.lines() //Stream<String>
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
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){		
			//con programación funcional
			return new ArrayList<Double>(bf.lines()
					.map(n->Double.parseDouble(n)) //Stream<Double>
					.collect(Collectors.toList()));		
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public void guardarNotas(ArrayList<Double> notas) {
		try (PrintStream out=new PrintStream(ruta);){			
			notas.forEach(n->out.println(n));
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
	//***
	public OptionalDouble notaMayor() {
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){		
			//con programación funcional
			return bf.lines()
			.mapToDouble(n->Double.parseDouble(n))
			.max();
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return OptionalDouble.empty();
		}
	}
	//***
	public OptionalDouble notaMenor() {
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){		
			//con programación funcional
			return bf.lines()
			.mapToDouble(n->Double.parseDouble(n))
			.min();
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return OptionalDouble.empty();
		}
	}
}
