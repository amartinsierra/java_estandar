package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import model.Medida;

public class Utilidades {
	public static Medida convertirTextoMedida(String linea) {
		//String[] datos=linea.split("[|]");
		String[] datos=linea.split(",");
		DateTimeFormatter sdf=DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		try {
			//replaceAll para sustituir la coma por el punto
			return new Medida(datos[0],LocalDate.parse(datos[1], sdf),Double.parseDouble(datos[5].replaceAll(",", ".")));
		} catch (NumberFormatException | DateTimeParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
