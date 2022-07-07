package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		Date fecha=new Date(); //fecha y hora actuales
		System.out.println(fecha);
		//crear fechas a partir de cadena de caracteres
		String f1="11/08/1980";
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fecha2=sdf.parse(f1);
		System.out.println(fecha2);
		//dar formato a fechas
		System.out.println(sdf.format(fecha));
		
		System.out.println(sdf.format(fecha2));
	}

}
