package model;

public class Pais {
	private String name;
	private String capital;
	private String region;
	private long population;
	public Pais(String name, String capital, String region, long population) {
		super();
		this.name = name;
		this.capital = capital;
		this.region = region;
		this.population = population;
	}
	public Pais() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	
}
