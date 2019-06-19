package loan.sample.model;

import java.util.ArrayList;

public class LoanOption {
 
 
 private boolean autoInterest = true;
 private boolean userSetting = true;
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

}
