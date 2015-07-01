package ch.ivy.sample.navigator;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.ResponseData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;

public class EmployeeDetailNavigator extends AbstractReferenceNavigator {
	
	private static final String EMP_LEAVE_DATE_INPUT = "empLeaveDateInput";
	private static final String EMP_ENTRY_DATE_INPUT = "empEntryDateInput";
	private static final String EMP_BIRTHDATE_INPUT = "empBirthdateInput";
	private static final String EMP_SALUTAION_INPUT = "empSalutaionInput";
	private static final String EMP_LASTNAME_INPUT = "empLastnameInput";
	private static final String EMP_FIRSTNAME_INPUT = "empFirstnameInput";
	private static final String EMP_NATIVE_PLACE_INPUT = "empNativePlaceInput";
	
	private static final String TEXTINPUT_SMALL_S2_ERROR = "textinput_small_s2_error";
	private static final String SUP_SALUTATION_INPUT = "supSalutationInput";
	private static final String SUP_LASTNAME_INPUT = "supLastnameInput";
	private static final String TEXTINPUT_MEDIUM_S3_ERROR = "textinput_medium_s3_error";
	private static final String SUP_FIRSTNAME_INPUT = "supFirstnameInput";
	private static final long serialVersionUID = -3470260586500850291L;

	public EmployeeDetailNavigator(MainPageTab step){
		this.stepIndicator = step;
		this.subStepIndex = -1;
		this.hasSubMenu = false;
		this.message = new ValidationMessages();
	}

	@Override
	protected ReferenceLetterRequestBean doLoad(
			ReferenceLetterRequestBean bean, Action action)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void doNext(ReferenceLetterRequestBean bean)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doBack(ReferenceLetterRequestBean bean)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doValidate(ReferenceLetterRequestBean bean,
			ResponseData response, NavigatorParamVO additionalParam)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doSaveSwitchTab(ReferenceLetterRequestBean bean)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doSaveAsDraft(ReferenceLetterRequestBean bean)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected StepStatus getStepStatus(ReferenceLetterRequestBean bean) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
