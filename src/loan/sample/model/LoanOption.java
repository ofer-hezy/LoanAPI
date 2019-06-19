package loan.sample.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoanOption {

	private boolean autoInterest = true;
	private boolean userSetting = true;
	private String apiKey = null;
	private ArrayList<LoanMix> mixs = new ArrayList<LoanMix>();

	public ArrayList<LoanMix> getMixs() {
		return mixs;
	}

	public void setMixs(ArrayList<LoanMix> mixs) {
		this.mixs = mixs;
	}

	public void addMix(LoanMix mix) {
		this.mixs.add(mix);
	}

	public boolean isAutoInterest() {
		return autoInterest;
	}

	public void setAutoInterest(boolean autoInterest) {
		this.autoInterest = autoInterest;
	}

	public boolean isUserSetting() {
		return userSetting;
	}

	public void setUserSetting(boolean userSetting) {
		this.userSetting = userSetting;
	}

	public String toJson() {
		JSONObject json = new JSONObject();
		json.put("api_key", this.apiKey);
		JSONObject request = new JSONObject();
		request.put("auto-interest", this.isAutoInterest());
		request.put("user-setting", this.userSetting);
		JSONArray mixarr = new JSONArray();
		for (LoanMix lm:getMixs()) {
			JSONObject mixo = new JSONObject();
			mixo.put("loan_board", lm.getLoanBoard());
			mixo.put("loan_type", lm.getLoanType());
			mixo.put("loan_value",lm.getLoanValue());
			mixo.put("loan_years", lm.getLoanYears());
			mixo.put("loan_interest", lm.getLoanInterest());
			mixo.put("loan_grace_parts", lm.getLoanGracepart());
			mixarr.put(mixo);
		}
		request.put("mix", mixarr);
		json.put("request", request); 
		return json.toString();

	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}
