package loan.sample.model;

public class LoanMix {

	private int autoInterest = 1;
	private int loanBoard = 1;
	public int getLoanBoard() {
		return loanBoard;
	}
	public void setLoanBoard(int loanBoard) {
		this.loanBoard = loanBoard;
	}
	private String loanType = "1|0";
	private int loanValue = 0;
	private int loanYears = 0;
	private float loanInterest = 0;
	private int loanGracepart = 0;
 public LoanMix(int autoInterest,String loanType,int loanYears,int loanValue,float loanInterest,int loanGracepart) {
	 this.autoInterest = autoInterest;
	 this.loanType = loanType;
	 this.loanValue = loanValue;
	 this.loanYears = loanYears;
	 this.loanInterest = loanInterest;
	 this.loanGracepart = loanGracepart;	 
 }
public int getAutoInterest() {
	return autoInterest;
}
public void setAutoInterest(int autoInterest) {
	this.autoInterest = autoInterest;
}
public String getLoanType() {
	return loanType;
}
public void setLoanType(String loanType) {
	this.loanType = loanType;
}
public int getLoanValue() {
	return loanValue;
}
public void setLoanValue(int loanValue) {
	this.loanValue = loanValue;
}
public int getLoanYears() {
	return loanYears;
}
public void setLoanYears(int loanYears) {
	this.loanYears = loanYears;
}
public float getLoanInterest() {
	return loanInterest;
}
public void setLoanInterest(float loanInterest) {
	this.loanInterest = loanInterest;
}
public int getLoanGracepart() {
	return loanGracepart;
}
public void setLoanGracepart(int loanGracepart) {
	this.loanGracepart = loanGracepart;
}
}
 
