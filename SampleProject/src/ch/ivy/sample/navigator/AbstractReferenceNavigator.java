package ch.ivy.sample.navigator;

import java.io.Serializable;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivy.sample.util.ReferenceLetterUtil;
import ch.ivyteam.ivy.environment.Ivy;


public abstract class AbstractReferenceNavigator implements Serializable  {
	protected static final int INVALID_INDEX = -1;
	private static final long serialVersionUID = 6281642303861616399L;
	protected MainPageTab stepIndicator;
	protected AbstractReferenceNavigator nextStep;
	protected AbstractReferenceNavigator prevStep;
	protected String caption =  MainPageTab.EMPLOYEE_DETAIL.getCaption();
	protected String description = MainPageTab.EMPLOYEE_DETAIL.getDescription();
	protected int subStepIndex;
	protected int oldSubStepIndex;
	protected ValidationMessages message;

	abstract protected ReferenceLetterRequestBean doLoad(ReferenceLetterRequestBean bean, Action action) throws BusinessException;
	abstract protected void doNext(ReferenceLetterRequestBean bean) throws BusinessException;
	abstract protected void doBack(ReferenceLetterRequestBean bean) throws BusinessException;
	abstract protected void doValidate(ReferenceLetterRequestBean bean, TransferData response, NavigatorParamVO additionalParam) throws BusinessException;	
	abstract protected void doSaveSwitchTab(ReferenceLetterRequestBean bean)throws BusinessException;
	abstract protected StepStatus getStepStatus(ReferenceLetterRequestBean bean);
	
	public TransferData performNext(MainPageTab currentStep, ReferenceLetterRequestBean bean, TransferData response) throws BusinessException{
		if(this.stepIndicator.getIndex() == currentStep.getIndex()){	
			response = getResponseData(response);
			try{
				doNext(bean);
				MainPageTab nextStep = getNextStepIndicator();
				response.setNewTabIndicator(nextStep);
			} catch(Exception ex){
				response.setIsDataSaved(false);
				response.setNewTabIndicator(currentStep);
				handleException(response, ex);
			}
			return response;	
		}		
		if(nextStep != null){
			response = nextStep.performNext(currentStep, bean, response);
		}
		return response;
	}
	
	
	
	public TransferData performLoad(MainPageTab tab, ReferenceLetterRequestBean bean, TransferData response, Action action) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){	
			response = getResponseData(response);
			try{
				doLoad(bean, action);	
			} catch(Exception ex){
				response.setIsDataLoaded(false);
				handleException(response, ex);
			}
			return response;
		}
		if(nextStep != null){
			response = nextStep.performLoad(tab, bean, response, action);
		}
		return response;
	}
	
	public TransferData performBack(MainPageTab currentStep, ReferenceLetterRequestBean bean, TransferData response) throws BusinessException{
		if(this.stepIndicator.getIndex() == currentStep.getIndex()){
			response = getResponseData(response);
			try{
				
				doBack(bean);
				MainPageTab nextStep = getPrevStepIndicator();
				response.setNewTabIndicator(nextStep);
			} catch(Exception ex){
				response.setIsDataSaved(false);
				response.setNewTabIndicator(currentStep);
				handleException(response, ex);
			}
			return response;	
		}		
		if(nextStep != null){
			response = nextStep.performBack(currentStep, bean, response);
		}
		return response;
	}
	private TransferData getResponseData(TransferData response) {
		if(response == null){
			response = new TransferData();
		}
		return response;
	}
	
	public TransferData performSaveSwitchTab(MainPageTab oldStep, ReferenceLetterRequestBean bean, TransferData response) throws BusinessException{
		if(this.stepIndicator.getIndex() == oldStep.getIndex()){
			response = getResponseData(response);
			try{
				doSaveSwitchTab(bean);
			}catch(Exception ex){
				response.setIsDataSaved(false);
				response.setNewTabIndicator(oldStep);
				handleException(response, ex);
			}
			return response;
		}
		if(nextStep != null){
			response = nextStep.performSaveSwitchTab(oldStep, bean, response);
		}
		return response;
	}
	
	public TransferData performValidate(MainPageTab level, ReferenceLetterRequestBean bean, TransferData response, NavigatorParamVO param) throws BusinessException{
		if(this.stepIndicator.getIndex() == level.getIndex()){
			response = getResponseData(response);
			try{
				doValidate(bean, response, param);
			}catch(Exception ex){
				response.setIsDataSaved(false);
				handleException(response, ex);
			}
			return response;
		}
		
		if(nextStep != null){
			response = nextStep.performValidate(level, bean, response, param);
		}
		return response;
	}
	
	private MainPageTab getNextStepIndicator(){
		if(this.nextStep != null){
			return this.nextStep.stepIndicator;
		}
		return MainPageTab.UNKNOWN;
	}
	
	private MainPageTab getPrevStepIndicator(){
		if(this.prevStep != null){
			return this.prevStep.stepIndicator;
		}
		return MainPageTab.UNKNOWN;
	}
	
	public MainPageTab getNextTabOf(MainPageTab currentTab){
		MainPageTab result = MainPageTab.UNKNOWN;
		if(this.stepIndicator.getIndex() == currentTab.getIndex()){
			result = this.getNextStepIndicator();
			return result;
		}
		if(nextStep != null){
			result= nextStep.getNextTabOf(currentTab);
		}
		return result;
	}
	
	public MainPageTab getPrevTabOf(MainPageTab currentTab){
		MainPageTab result = MainPageTab.UNKNOWN;
		if(this.stepIndicator.getIndex() == currentTab.getIndex()){
			result = this.getPrevStepIndicator();
			return result;
		}
		if(nextStep != null){
			result= nextStep.getPrevTabOf(currentTab);
		}
		return result;
	}
	
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public void setNextStep(AbstractReferenceNavigator nextStep){
	      this.nextStep = nextStep;
	}

	public void setPrevStep(AbstractReferenceNavigator prevStep) {
		this.prevStep = prevStep;
	}
	public void setCaption(MainPageTab level){
		this.caption = level.getCaption();
		this.description = level.getDescription();
	}
	
	private void handleException(TransferData response, Exception ex) {
		response.setHasException(true);
		if(ex instanceof BusinessException){
			response.setException((BusinessException)ex);
		} else{
			Ivy.log().error(ex.getMessage(), ex);
			response.setException(new BusinessException(ch.ivy.sample.enums.Error.UNKNOWN.getCode()));
		}
		response.setNeedRefresh(ReferenceLetterUtil.checkRefreshConditionByErrorCode(response.getException().getErrorCode()));
	}
}
