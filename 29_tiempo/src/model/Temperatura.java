package model;

public class Temperatura {
	private double max;
	private double min;
	public Temperatura(double max, double min) {
		super();
		this.max = max;
		this.min = min;
	}
	
	public Temperatura() {
		super();
	}

	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	
}
