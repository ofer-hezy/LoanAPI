package loan.sample.debug;

import loan.sample.actions.GetLoan;
import loan.sample.model.LoanMix;
import loan.sample.model.LoanOption;

public class TestLoan {

	public static void main(String[] args) {
		try {
			GetLoan gl = new GetLoan("my-api-key");
			LoanOption lo = new LoanOption();
			lo.setAutoInterest(true);
			lo.setUserSetting(true);
			//int autoInterest,String loanType,int loanYears,int loanValue,float loanInterest,int loanGracepart
			LoanMix mix = new LoanMix(1,"1|0",10,100000,2.1f ,1);
			lo.addMix(mix);
			mix.setLoanInterest(3.0f);
			mix.setLoanYears(15);
			lo.addMix(mix);
			gl.setLoanOption(lo);
			
			System.out.println(gl.send());
			
			
			
		}catch(Exception e) {e.printStackTrace();}
		
	}

}
