package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Ciudad;

public class CiudadesService {
	String ruta="c:\\temp2\\tiempo.json";
	Ciudad[] ciudades;
	public CiudadesService() {
		Gson gson=new Gson();
		try {
			ciudades=gson.fromJson(new FileReader(ruta), Ciudad[].class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<Ciudad> todo(){
		return Arrays.asList(ciudades);
	}
}
