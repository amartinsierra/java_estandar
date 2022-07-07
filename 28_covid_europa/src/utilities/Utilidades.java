package utilities;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Utilidades {
	public static LocalDate convertirTextAFecha(String fecha) {
		//definimos el formato con el que viene la fecha en el documento
		/*DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-ww");
		//aplicamos formato para convertir la cadena en un LocalDate
		return LocalDate.parse(fecha, dtf);*/
		/*DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-DDD");
		NumberFormat formatDay=NumberFormat.getIntegerInstance();
		formatDay.setMinimumIntegerDigits(3); //para que los días aparezcan al menos con tres dígitos
		int year=Integer.parseInt(fecha.split("-")[0]);
		int dayYear=Integer.parseInt(fecha.split("-")[1])*7-6; //obtengo el primer día de cada semana
		fecha=year+"-"+formatDay.format(dayYear); //forzamos a que el número tenga tres dígitos
		return LocalDate.parse(fecha, format);*/
		
		DateTimeFormatter format = new DateTimeFormatterBuilder()
				.appendPattern("YYYY-ww")
				.parseDefaulting(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue())
				.toFormatter();
		return LocalDate.parse(fecha, format);

		
	}
}
