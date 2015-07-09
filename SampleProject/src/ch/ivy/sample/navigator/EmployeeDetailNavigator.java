package ch.ivy.sample.navigator;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivyteam.ivy.environment.Ivy;

public class EmployeeDetailNavigator extends AbstractReferenceNavigator {
	
	private static final long serialVersionUID = -3470260586500850291L;

	public EmployeeDetailNavigator(MainPageTab step){
		this.stepIndicator = step;
		this.subStepIndex = -1;
		this.message = new ValidationMessages();
	}

	@Override
	protected ReferenceLetterRequestBean doLoad(NavigatorParamVO param)
			throws BusinessException {
		Ivy.log().info("DoLoad:" + this.getClass().getName());
		return null;
	}

	@Override
	protected void doNext(NavigatorParamVO param) throws BusinessException {
		Ivy.log().info("doNext:" + this.getClass().getName());
		
	}

	@Override
	protected void doBack(NavigatorParamVO param) throws BusinessException {
		Ivy.log().info("doBack:" + this.getClass().getName());
		
	}

	@Override
	protected void doValidate(NavigatorParamVO param, TransferData transferData)
			throws BusinessException {
		Ivy.log().info("doValidate:" + this.getClass().getName());
		
	}

	@Override
	protected void doSaveSwitchTab(NavigatorParamVO param)
			throws BusinessException {
		Ivy.log().info("doSaveSwitchTab:" + this.getClass().getName());
		
	}

	@Override
	protected StepStatus getStepStatus(NavigatorParamVO param) {
		Ivy.log().info("getStepStatus:" + this.getClass().getName());
		return null;
	}

	
	
	
	
}
