package presentacion;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import service.CovidEuropaService;

public class InformeConvid {

	public static void main(String[] args) {
		/*LocalDate fecha=LocalDate.now();
		double num=473984.34;
		//formateado
		DateTimeFormatter formater=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(1); //solo un decimal
		System.out.println(fecha.format(formater));
		System.out.println(nf.format(num));*/
		NumberFormat nf=NumberFormat.getNumberInstance();
		
		CovidEuropaService service=new CovidEuropaService();
		service.listaPaises()
		.forEach(s->System.out.println("pais: "+s+"  Incidencia:"+nf.format(service.incidenciaPais(s))+"  Acumulados:"+nf.format(service.acumulados(s))));
		 
		
		
	}

}
