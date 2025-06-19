package Model;

public class MiniCalculatorModel {

	private double firsValue;
	private double secondValue;
	private double answer;
	public MiniCalculatorModel() {	
	}
	public double getFirsValue() {
		return firsValue;
	}
	public void setFirsValue(double firsValue) {
		this.firsValue = firsValue;
	}
	public double getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(double secondValue) {
		this.secondValue = secondValue;
	}
	public double getAnswer() {
		return answer;
	}
	public void setAnswer(double answer) {
		this.answer = answer;
	}

	public void plus() {
		this.answer = this.firsValue + this.secondValue;
	} 
	public void minus() {
		this.answer = this.firsValue - this.secondValue;
	} 
	public void multiply() {
		this.answer = this.firsValue * this.secondValue;
	} 
	public void divide() {
		this.answer = this.firsValue / this.secondValue;
	} 
	public void pow() {
		this.answer =Math.pow(this.firsValue, this.secondValue);
	} 
	public void mod() {
		this.answer = this.firsValue % this.secondValue;
	} 
	
}
