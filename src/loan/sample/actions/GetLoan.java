package loan.sample.actions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import loan.sample.model.LoanOption;

public class GetLoan {

	private final int _connectTimeOut = 5000;
	private final int _readTimeout = 10000;
	private final static String service_url = "https://www.snpv.co.il/api/v2/calc/process/format/json";

	private LoanOption loanOption = null;
	public GetLoan(LoanOption option) {
		// need to add checks
		this.loanOption = option;
	}
	public void setLoanOption(LoanOption option) {
		this.loanOption = option;
	}

	public String send() throws Exception {
		URL url = new URL(service_url);
		HttpURLConnection post = (HttpURLConnection) url.openConnection();
		post.setRequestMethod("POST");
		post.setDoInput(true);
		post.setDoOutput(true);
		post.setConnectTimeout(_connectTimeOut);
		post.setReadTimeout(_readTimeout);
		post.setRequestProperty("User-Agent", "myLoanApi");
		post.setRequestProperty("Content-Type", "application/json;utf-8");
		OutputStreamWriter osw = new OutputStreamWriter(post.getOutputStream(), "UTF-8");
		osw.write(this.loanOption.toJson());
		osw.flush();
		StringBuilder jsonResponse = new StringBuilder();
		if (post.getResponseCode() == HttpURLConnection.HTTP_OK) {
			InputStreamReader streamReader = new InputStreamReader(post.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(streamReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				jsonResponse.append(line);
			}
			bufferedReader.close();

		} else {
			// handle error
		}
		return jsonResponse.toString();

	}
}
