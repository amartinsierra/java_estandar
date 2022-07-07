package principal;

import recursos.Contador;
import tareas.Peticion;

public class Lanzador {

	public static void main(String[] args) {
		Contador contador=new Contador();
		
		new Thread(new Peticion(contador)).start();
		new Thread(new Peticion(contador)).start();
		new Thread(new Peticion(contador)).start();
	}

}
