package tareas;

public class TablaMultiplicar implements Runnable{
	private int numero;
	public TablaMultiplicar(int numero) {
		this.numero=numero;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(numero+"x"+i+"="+numero*i);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
