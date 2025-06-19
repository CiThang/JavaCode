package Project_Calculator;

public class ModelCalculator {

	private int a;
	private int b;
	public ModelCalculator(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public ModelCalculator() {
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "ModelCalculator [a=" + a + ", b=" + b + "]";
	}
	
	public int tong(int a, int b) {
		return a+b;
	}
	
	public int hieu(int a, int b) {
		return a-b;
	}
	
	public int tich(int a, int b) {
		return a*b;
	}
	
	public double thuong(int a, int b) {
		return 1.0*a/b;
	}
	
	
	
}
