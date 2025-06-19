package Model;

public class CalculatorModel {

	private double a;
	private double b;
	private double value;
	public CalculatorModel() {
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	public void tong() {
		this.value = this.a + this.b;
	}
	
	public void hieu() {
		this.value = this.a - this.b;
	}
	
	public void tich() {
		this.value = this.a * this.b;
	}
	
	public void thuong() {
		this.value = this.a / this.b;
		
	}
}
