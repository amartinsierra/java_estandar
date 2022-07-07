package principal;

import tareas.TablaMultiplicar;

public class Main {

	public static void main(String[] args) {
		new Thread(new TablaMultiplicar(4)).start();
		new Thread(new TablaMultiplicar(8)).start();
		new Thread(new TablaMultiplicar(3)).start();
		new Thread(new TablaMultiplicar(7)).start();
	}

}
