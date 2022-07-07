package model;

public class Ciudad {
	private String ciudad;
	private String precipitacion;
	private Temperatura temperaturas;
	private int[] humedad;
	public Ciudad(String ciudad, String precipitacion, Temperatura temperaturas, int[] humedad) {
		super();
		this.ciudad = ciudad;
		this.precipitacion = precipitacion;
		this.temperaturas = temperaturas;
		this.humedad = humedad;
	}
	
	public Ciudad() {
		super();
	}

	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPrecipitacion() {
		return precipitacion;
	}
	public void setPrecipitacion(String precipitacion) {
		this.precipitacion = precipitacion;
	}
	public Temperatura getTemperaturas() {
		return temperaturas;
	}
	public void setTemperaturas(Temperatura temperaturas) {
		this.temperaturas = temperaturas;
	}
	public int[] getHumedad() {
		return humedad;
	}
	public void setHumedad(int[] humedad) {
		this.humedad = humedad;
	}
	
	
}
