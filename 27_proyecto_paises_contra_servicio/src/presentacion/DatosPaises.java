package presentacion;

import model.Pais;
import service.PaisesService;

public class DatosPaises {

	public static void main(String[] args) {
		PaisesService service=new PaisesService();
		System.out.println("-------Poblaci�n de todos los continentes:-------");
		service.nombresContinentes()
		.forEach(c->System.out.println(c+":"+service.poblacionTotal(c)));
		System.out.println("-------Datos del pais m�s poblado:-------");
		Pais pais=service.paisMasPoblado();
		System.out.println("Nombre: "+pais.getName());
		System.out.println("Capital: "+pais.getCapital());
		System.out.println("Poblaci�n: "+pais.getPopulation());
	}

}
