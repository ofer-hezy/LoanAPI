package loan.sample.debug;

import loan.sample.actions.GetLoan;
import loan.sample.model.LoanMix;
import loan.sample.model.LoanOption;

public class TestLoan {

	public static void main(String[] args) {
		try {
			
			
			LoanOption lo = new LoanOption();
			lo.setAutoInterest(true);
			lo.setUserSetting(true);
			lo.setApiKey("2F8TBX0VCUAMKNDMSZLLOW9OV5KP7X1WDIQIJHUQ");
			LoanMix mix = null;
			mix = new LoanMix(1, "1|0", 10, 100000, 2.1f, 1);
			lo.addMix(mix);
			mix = new LoanMix(1, "1|0", 10, 200000, 3.1f, 1);
			lo.addMix(mix);
			
			GetLoan gl = new GetLoan(lo);
			String jsonResponse = gl.send();
			System.out.println(jsonResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
