package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Inicial {

	public static void main(String[] args) {
		TareaAscendente ta=new TareaAscendente();
		TareaDescendente td=new TareaDescendente();
		ta.start();		
		td.start();
		
		/*for(int i=1;i<=100;i++) {
			System.out.println("otras cossas del main: "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}

}
