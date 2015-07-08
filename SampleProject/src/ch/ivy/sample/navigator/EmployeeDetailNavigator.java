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
	protected ReferenceLetterRequestBean doLoad(
			ReferenceLetterRequestBean bean, Action action)
			throws BusinessException {
		Ivy.log().info("DoLoad:" + this.getClass().getName());
		return null;
	}

	@Override
	protected void doNext(ReferenceLetterRequestBean bean)
			throws BusinessException {
		Ivy.log().info("DoNext:" + this.getClass().getName());
		
	}

	@Override
	protected void doBack(ReferenceLetterRequestBean bean)
			throws BusinessException {
		Ivy.log().info("DoBack:" + this.getClass().getName());
		
	}

	@Override
	protected void doValidate(ReferenceLetterRequestBean bean,
			TransferData response, NavigatorParamVO additionalParam)
			throws BusinessException {
		Ivy.log().info("DoValidate:" + this.getClass().getName());
		
	}

	@Override
	protected void doSaveSwitchTab(ReferenceLetterRequestBean bean)
			throws BusinessException {
		Ivy.log().info("DoSwitchTab:" + this.getClass().getName());
		
	}

	@Override
	protected StepStatus getStepStatus(ReferenceLetterRequestBean bean) {
		
		return null;
	}

	
	
	
}
