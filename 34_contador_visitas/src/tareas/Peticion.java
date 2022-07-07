package tareas;

import recursos.Contador;

public class Peticion implements Runnable{
	Contador contador;
	

	public Peticion(Contador contador) {
		super();
		this.contador = contador;
	}


	@Override
	public void run() {
		//muchas instrucciones
		synchronized (contador) {
			contador.incrementar();
			System.out.println("Valor despues de incrementar: "+contador.getValor());
		}
		
		//muchas instrucciones
		
	}
	
}
