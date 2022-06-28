package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class NotasServiceObjetos {
	
	//métodos de la clase
	public void guardarNota(double nota) {			
		try (PrintStream out=CreadorObjetos.getPrintStream(true);){
			out.println(nota);			
		}
		
	}
	
	
	public OptionalDouble media() {
		try(BufferedReader bf=CreadorObjetos.getReader()){		
			//con programación funcional
			return bf.lines()
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
		try(BufferedReader bf=CreadorObjetos.getReader()){				
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
		try(BufferedReader bf=CreadorObjetos.getReader()){				
			//con programación funcional
			/*return bf.lines()
			.mapToDouble(n->Double.parseDouble(n)) //DoubleStream
			.toArray(); //double[]*/
			
			return bf.lines() //Stream<String>
					.map(n->Double.parseDouble(n)) //Stream<Double>
					.toArray(n->new Double[0]);
			
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
	/*public void eliminarSuspensos() {
		notas.removeIf(n->n<5);
	}
	public void ordenarNotas() {
		//usando el método sort de las listas, NO el de Collections
		//notas.sort((a,b)->a>b?1:-1);
		notas.sort((a,b)->a.compareTo(b));
	}*/
	
	public ArrayList<Double> obtenerNotas(){
		try(BufferedReader bf=CreadorObjetos.getReader()){				
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
		try (PrintStream out=CreadorObjetos.getPrintStream(true);){			
			notas.forEach(n->out.println(n));
		}
		
	}
	
	//***
	public OptionalDouble notaMayor() {
		try(BufferedReader bf=CreadorObjetos.getReader()){				
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
		try(BufferedReader bf=CreadorObjetos.getReader()){				
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
