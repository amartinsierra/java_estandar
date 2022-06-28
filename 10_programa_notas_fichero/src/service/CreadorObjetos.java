package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class CreadorObjetos {
	static String ruta="c:\\temp\\notas.txt";
	
	public static BufferedReader getReader() {
		try{
			FileReader fr=new FileReader(ruta);
			BufferedReader bf=new BufferedReader(fr);		
			return bf;
			
		}
		catch(IOException ex) {		
			ex.printStackTrace();
			return null;
		}
	}
	
	public static PrintStream getPrintStream(boolean modo) {
		try{
			FileOutputStream fo=new FileOutputStream(ruta, modo);			
			PrintStream out=new PrintStream(fo);
			return out;
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
