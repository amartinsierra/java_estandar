package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFechaIgualdad {

	public static void main(String[] args) throws ParseException {
		String f1="02/12/2000 10:25:39";
		String f2="2000-12-02 10:25:30";

		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date fecha1=sdf1.parse(f1);
		Date fecha2=sdf2.parse(f2);
		
		//¿son iguales?
		System.out.println(fecha1.equals(fecha2));
		
		//¿cual es mayor?
		if(fecha1.after(fecha2)) {
			System.out.println(sdf1.format(fecha1));
		}else {
			System.out.println(sdf1.format(fecha2));
		}
	}

}
