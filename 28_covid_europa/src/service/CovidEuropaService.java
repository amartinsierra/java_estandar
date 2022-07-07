package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import model.Item;
import utilities.Utilidades;

public class CovidEuropaService {
	String ruta="https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";
	Item[] items;
	public CovidEuropaService() {
		Gson gson=new Gson();
		//crear HttpRequest
		HttpRequest request=HttpRequest.newBuilder() //Builder
							.uri(URI.create(ruta)) //Builder
							.GET() //Builder
							.build(); //HttpRequest
		//crear HttpClient
		HttpClient client=HttpClient.newBuilder() //Builder
						.version(Version.HTTP_1_1)
						.build();
		//lanzar petición y objeto HttpResponse

		try {
			HttpResponse response=client.send(request, BodyHandlers.ofString());
			items=gson.fromJson(response.body().toString(), Item[].class);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<String> listaPaises(){
		return Arrays.stream(items) //Stream<Item>
				.map(p->p.getNombrePais()) //Stream<String>
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public double incidenciaPais(String pais) {
		return Arrays.stream(items) //Stream<Item>
				.filter(it->it.getIndicador().equals("cases")&&it.getNombrePais().equals(pais))  //Stream<Item> -solo con los casos-
				.max((it1,it2)->Utilidades.convertirTextAFecha(it1.getFecha()).compareTo(Utilidades.convertirTextAFecha(it2.getFecha())))   //Optional<Item>
				.orElseGet(()->new Item()) //Item
				.getIncidencia();
	}
	
	public int acumulados(String pais) {
		return Arrays.stream(items) //Stream<Item>
				.parallel()
				.filter(it->it.getIndicador().equals("cases")&&it.getNombrePais().equals(pais))  //Stream<Item> -solo con los casos-
				.max((it1,it2)->Utilidades.convertirTextAFecha(it1.getFecha()).compareTo(Utilidades.convertirTextAFecha(it2.getFecha())))   //Optional<Item>
				.orElseGet(()->new Item()) //Item
				.getAcumulados();
	}
	
	
	public List<Item> itemsPosteriorFecha(LocalDate fecha){
		return Arrays.stream(items)
				.filter(it->Utilidades.convertirTextAFecha(it.getFecha()).isAfter(fecha)&&it.getIndicador().equals("cases"))
				.collect(Collectors.toList());
	}
}
