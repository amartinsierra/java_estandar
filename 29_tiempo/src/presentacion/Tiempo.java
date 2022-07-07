package presentacion;

import java.util.List;

import model.Ciudad;
import service.CiudadesService;

public class Tiempo {

	public static void main(String[] args) {
		CiudadesService service=new CiudadesService();
		List<Ciudad> ciudades=service.todo();
		ciudades.forEach(c->{
			System.out.println("Ciudad: "+c.getCiudad());
			System.out.println("Precipitaci�n: "+c.getPrecipitacion());
			for(int t:c.getHumedad()) {
				System.out.println("Humedad: "+t);
			}
			System.out.println("Temperatura m�xima: "+c.getTemperaturas().getMax());
			System.out.println("Temperatura m�nima: "+c.getTemperaturas().getMin());
			System.out.println("-------------------------------");
		});

	}

}
