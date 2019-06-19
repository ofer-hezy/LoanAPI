package loan.sample.actions;

import java.net.HttpURLConnection;
import java.net.URL;

import loan.sample.model.LoanMix;
import loan.sample.model.LoanOption;

public class GetLoan {
	
	private final int _connectTimeOut = 5;
	private final int _readTimeout = 10;
	private final static String  service_url = "https://www.snpv.co.il/api/v2/calc/process/format/json";
	
	private LoanOption loanOption = null;
	private String api_key = null;
	
	public GetLoan(String api_key) throws Exception{
		if (api_key == null || api_key.trim().length() == 0)
			throw new Exception ("api key must not be null");
		this.api_key = api_key;	
	}
	public void setLoanOption(LoanOption option) {
		
		loanOption = option;
	}
	public String send() throws Exception{
		URL url = new URL(service_url);
		HttpURLConnection post  = (HttpURLConnection)url.openConnection();
		post.setRequestMethod("POST");
		post.setDoInput(true);
		post.setDoOutput(true);
		post.setConnectTimeout(_connectTimeOut);
		post.setReadTimeout(_readTimeout);
		post.setRequestProperty("User-Agent", "myLoanApi");
        post.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		// params from laonOption;
		String postParams = "";
		postParams +="api_key="+this.api_key;
		postParams +="&auto_interest="+this.loanOption.isAutoInterest();
		postParams +="&user_settings="+this.loanOption.isUserSetting();
		
	    for (LoanMix mix: this.loanOption.getMixs()) {
	    	postParams +="&loan_board="+mix.getLoanBoard();
	    	postParams +="&loan_type="+mix.getLoanType();
	    	postParams +="&loan_value="+mix.getLoanValue();
	    	postParams +="&loan_years="+mix.getLoanYears();
	    	postParams +="&loan_interest="+mix.getLoanInterest();
	    	postParams +="&loan_grace_parts="+mix.getLoanGracepart();
	    }
	    
	    return postParams;
		
	}
}
