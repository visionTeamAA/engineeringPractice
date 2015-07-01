package ch.ivy.sample.util;

public class ReferenceLetterUtil {
	private static final String ROLE_EMPLOYEE = "employee";
	private static final String ROLE_EVERYBODY = "everybody";
	private static final String INIT_PHASE_LISTENERS = "initPhaseListeners";

	public static boolean checkRefreshConditionByErrorCode(int errorCode){
		if(errorCode == ch.ivy.sample.enums.Error.OUT_OF_DATE_DATA.getCode()){
			return true;
		} 
		return false;
	}
	
}
