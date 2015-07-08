package ch.ivy.sample.navigator;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivyteam.ivy.environment.EnvironmentNotAvailableException;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.persistence.PersistencyException;

public class DocumentTypeNavigator extends AbstractReferenceNavigator {
	
	public DocumentTypeNavigator(MainPageTab step){
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
		Ivy.log().info("DoSaveSwitchTab:" + this.getClass().getName());
		
	}

	@Override
	protected StepStatus getStepStatus(ReferenceLetterRequestBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
