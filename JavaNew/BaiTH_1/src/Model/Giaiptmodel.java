package Model;

public class Giaiptmodel {

	private double a ;
	private double b;
	private double kq;
	public Giaiptmodel() {

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
	public double getKq() {
		return kq;
	}
	public void setKq(double kq) {
		this.kq = kq;
	}
	
	public void giaipt() {
		this.kq = -(this.b / this.a);
	}
}
