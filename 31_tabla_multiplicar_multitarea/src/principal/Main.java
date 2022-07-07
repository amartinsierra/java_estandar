package principal;

import tareas.TablaMultiplicar;

public class Main {

	public static void main(String[] args) {
		new TablaMultiplicar(4).start();
		new TablaMultiplicar(8).start();
		new TablaMultiplicar(3).start();
		new TablaMultiplicar(7).start();
	}

}
