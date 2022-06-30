package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Ciudad;

public class Utilidades {
	public static Ciudad convertirTextoCiudad(String linea) {
		//String[] datos=linea.split("[|]");
		String[] datos=linea.split(",");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			return new Ciudad(datos[0],Double.parseDouble(datos[1]),sdf.parse(datos[2]));
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
