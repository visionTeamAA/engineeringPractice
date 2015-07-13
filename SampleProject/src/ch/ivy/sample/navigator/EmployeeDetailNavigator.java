package ch.ivy.sample.navigator;

import org.apache.commons.lang3.StringUtils;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.ConstantVariable;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.RequestEmployeeDetailStep;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivy.sample.util.CommonUtils;
import ch.ivyteam.ivy.environment.Ivy;

public class EmployeeDetailNavigator extends AbstractReferenceNavigator {
	
	private static final long serialVersionUID = -3470260586500850291L;

	public EmployeeDetailNavigator(MainPageTab step){
		this.stepIndicator = step;
		this.subStepIndex = -1;
		this.message = new ValidationMessages();
	}

	@Override
	protected void doLoad(NavigatorParamVO param)
			throws BusinessException {
		Ivy.log().info("DoLoad:" + this.getClass().getName());
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
		
		RequestEmployeeDetailStep employeeDetailStep = param.getXrflBean().getEmployeeDetailStep();
		if(StringUtils.isEmpty(employeeDetailStep.getFirstName())) {
			transferData.getEmpDetailValidationResult().addMessage(CommonUtils.getFullId(param.getFacesContext(), ConstantVariable.FIRSTNAME_INPUT), message.getMessage(ConstantVariable.MSG_REQUIRE_MESSAGE));
		}
		
		if(StringUtils.isEmpty(employeeDetailStep.getLastName())) {
			transferData.getEmpDetailValidationResult().addMessage(CommonUtils.getFullId(param.getFacesContext(), ConstantVariable.LASTNAME_INPUT), message.getMessage(ConstantVariable.MSG_REQUIRE_MESSAGE));
		}
		if(!transferData.getEmpDetailValidationResult().isValidForm()){
			param.getXrflBean().getEmployeeDetailStep().setStepStatus(StepStatus.WARNING);
		} else{
			param.getXrflBean().getEmployeeDetailStep().setStepStatus(StepStatus.FINISHED);
		}
		updateStatusStep3(param);
		
		transferData.sendValidationResults(param.getRequestContext(), MainPageTab.findBy(MainPageTab.EMPLOYEE_DETAIL.getIndex()), false);
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
