package recursos;

public class Contador {
	private int valor;
	public void incrementar() {
		int aux=valor;
		aux=aux+1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valor=aux;
	}
	
	public int getValor() {
		return valor;
	}
}
