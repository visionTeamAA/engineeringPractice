package ch.ivy.sample.util;

import ch.ivy.sample.bean.ConstantVariable;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.navigator.AbstractReferenceNavigator;
import ch.ivy.sample.navigator.DocumentCreationNavigator;
import ch.ivy.sample.navigator.DocumentTypeNavigator;
import ch.ivy.sample.navigator.EmployeeDetailNavigator;



public class ReferenceLetterUtil {

	public static boolean checkRefreshConditionByErrorCode(int errorCode){
		if(errorCode == ch.ivy.sample.enums.Error.OUT_OF_DATE_DATA.getCode()){
			return true;
		} 
		return false;
	}
	public static AbstractReferenceNavigator getChainOfNavigator(){
		EmployeeDetailNavigator emp = new EmployeeDetailNavigator(MainPageTab.EMPLOYEE_DETAIL);
		DocumentTypeNavigator documentType = new DocumentTypeNavigator(MainPageTab.DOCUMENT_TYPE);
		DocumentCreationNavigator documentCreation = new DocumentCreationNavigator(MainPageTab.DOCUMENT_CREATION);
		
		emp.setNextStep(documentType);
		emp.setPrevStep(null);
		documentType.setNextStep(documentCreation);
		documentType.setPrevStep(emp);
		documentCreation.setNextStep(null);
		documentCreation.setPrevStep(documentType);
		
		return emp;
	}
	public static ReferenceLetterRequestBean getReferenceLetterRequestBean(){
		return FacesUtils.findBean(ConstantVariable.XRFL_REQUEST_BEAN);
	}
	
	
}
