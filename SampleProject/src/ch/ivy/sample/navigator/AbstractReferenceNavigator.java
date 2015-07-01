package ch.ivy.sample.navigator;

import java.io.Serializable;

import org.primefaces.context.RequestContext;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.ConstantVariable;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.ResponseData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.EntryType;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivy.sample.util.CommonUtils;
import ch.ivy.sample.util.ReferenceLetterUtil;
import ch.ivyteam.ivy.environment.Ivy;


public abstract class AbstractReferenceNavigator implements Serializable  {
	protected static final int INVALID_INDEX = -1;
	private static final long serialVersionUID = 6281642303861616399L;
	protected MainPageTab stepIndicator;
	protected AbstractReferenceNavigator nextStep;
	protected AbstractReferenceNavigator prevStep;
	protected String caption =  MainPageTab.EMPLOYEE_DETAIL.getCaption();
	protected boolean hasSubMenu;
	protected String description = MainPageTab.EMPLOYEE_DETAIL.getDescription();
	protected int subStepIndex;
	protected int oldSubStepIndex;
	protected ValidationMessages message;

	abstract protected ReferenceLetterRequestBean doLoad(ReferenceLetterRequestBean bean, Action action) throws BusinessException;
	abstract protected void doNext(ReferenceLetterRequestBean bean) throws BusinessException;
	abstract protected void doBack(ReferenceLetterRequestBean bean) throws BusinessException;
	abstract protected void doValidate(ReferenceLetterRequestBean bean, ResponseData response, NavigatorParamVO additionalParam) throws BusinessException;	
	abstract protected void doSaveSwitchTab(ReferenceLetterRequestBean bean)throws BusinessException;
	abstract protected void doSaveAsDraft(ReferenceLetterRequestBean bean) throws BusinessException;
	abstract protected StepStatus getStepStatus(ReferenceLetterRequestBean bean);
	
	public ResponseData performNext(MainPageTab currentStep, ReferenceLetterRequestBean bean, ResponseData response) throws BusinessException{
		if(this.stepIndicator.getIndex() == currentStep.getIndex()){	
			response = getResponseData(response);
			try{
				doNext(bean);
				MainPageTab nextStep = currentStep;
				int newSubStepIdx = INVALID_INDEX;
				if(this.hasSubMenu){
					newSubStepIdx = getNextSubStepIndex(bean);
				}
				if(newSubStepIdx != INVALID_INDEX){
					this.oldSubStepIndex = newSubStepIdx;
					this.subStepIndex = newSubStepIdx;
				} else{
					nextStep = getNextStepIndicator();
					preDestroy(bean);
				}
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
	
	public ResponseData performSaveAsDraft(MainPageTab currentStep, ReferenceLetterRequestBean bean, ResponseData response) throws BusinessException{
		if(this.stepIndicator.getIndex() == currentStep.getIndex()){
			try {
				doSaveAsDraft(bean);
			} catch (Exception ex) {
				response.setIsDataSaved(false);
				response.setNewTabIndicator(currentStep);
				handleException(response, ex);
			}
			return response;
		}		
		if(nextStep != null){
			response = nextStep.performSaveAsDraft(currentStep, bean, response);
		}
		return response;
	}
	
	public ResponseData performLoad(MainPageTab tab, ReferenceLetterRequestBean bean, ResponseData response, Action action) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){	
			response = getResponseData(response);
			try{
				
				if(!this.hasSubMenu ||!isValidSubIndex(bean, this.subStepIndex)){
					doLoad(bean, action);	
					updateUI();
					if(this.hasSubMenu){ 
						initSubNavigator(bean, action);
					}
				} else{
					doLoadSubStep(bean, subStepIndex);
					updateSubMenuUI();
				}
				
			} catch(Exception ex){
				response.setIsDataLoaded(false);
				handleException(response, ex);
				updateUI();
			}
			this.caption = tab.getCaption();
			return response;
		}
		if(nextStep != null){
			response = nextStep.performLoad(tab, bean, response, action);
		}
		return response;
	}
	
	public ResponseData performBack(MainPageTab currentStep, ReferenceLetterRequestBean bean, ResponseData response) throws BusinessException{
		if(this.stepIndicator.getIndex() == currentStep.getIndex()){
			response = getResponseData(response);
			try{
				
				doBack(bean);
				int newSubStepIdx = INVALID_INDEX;
				MainPageTab nextStep = currentStep;
				if(this.hasSubMenu){
					newSubStepIdx = getPrevSubStepIndex(bean);
				}
				if(newSubStepIdx != INVALID_INDEX){
					this.oldSubStepIndex = newSubStepIdx;
					this.subStepIndex = newSubStepIdx;
				} else{
					nextStep = getPrevStepIndicator();
					preDestroy(bean);
				}
				response.setNewTabIndicator(nextStep);
			} catch(Exception ex){
				response.setIsDataSaved(false);
				response.setNewTabIndicator(currentStep);
				handleException(response, ex);
				updateUI();
			}
			this.caption = response.getNewTabIndicator().getCaption();
			return response;	
		}		
		if(nextStep != null){
			response = nextStep.performBack(currentStep, bean, response);
		}
		return response;
	}
	private ResponseData getResponseData(ResponseData response) {
		if(response == null){
			response = new ResponseData();
		}
		return response;
	}
	
	/**
	 * This method will be called when main menu is changing
	 * @param level
	 * @param bean
	 * @throws BusinessException
	 */
	public void performPreDestroy(MainPageTab level, ReferenceLetterRequestBean bean) throws BusinessException{
		if(this.stepIndicator.getIndex() == level.getIndex()){
			preDestroy(bean);
		}		
		if(nextStep != null){
			nextStep.performPreDestroy(level, bean);
		}
	}
	
	public void performPreSynchronize(MainPageTab level, ReferenceLetterRequestBean bean) throws BusinessException{
		if(this.stepIndicator.getIndex() == level.getIndex()){
			preSynchronize(bean);
		}		
		if(nextStep != null){
			nextStep.performPreSynchronize(level, bean);
		}
	}
	
	
	public void updateUI(){
		RequestContext.getCurrentInstance().update(CommonUtils.getFullId(ConstantVariable.XRFL_REFERENCE_REQUEST_MAIN_TAB));
	}
	
	public ResponseData performSaveSwitchTab(MainPageTab oldStep, ReferenceLetterRequestBean bean, ResponseData response) throws BusinessException{
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
	
	public ResponseData performValidate(MainPageTab level, ReferenceLetterRequestBean bean, ResponseData response, NavigatorParamVO param) throws BusinessException{
		if(this.stepIndicator.getIndex() == level.getIndex()){
			response = getResponseData(response);
			try{
				if(!this.hasSubMenu ||!isValidSubIndex(bean, this.subStepIndex)){
					doValidate(bean, response, param);
					response.setNeedToValidate(this.getStepStatus(bean) != StepStatus.UNTOUCHED);
				} else{
					doValidateSubStep(bean, getValidateIndex(param.getForEntry()), response, param);
					response.setNeedToValidate(this.getSubStepStatus(bean) != StepStatus.UNTOUCHED);
				}
				
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
	
	
	
	public void performRestoreSubStepIndex(ReferenceLetterRequestBean bean){
		if(this.hasSubMenu){
			this.subStepIndex = this.oldSubStepIndex;
			restoreSubStepIndex(bean);
		}
		if(nextStep != null){
			nextStep.performRestoreSubStepIndex(bean);
		}
	}
	
	public void performUpdateStepStatus(MainPageTab currentStep, ReferenceLetterRequestBean bean, StepStatus status){
		 if(this.stepIndicator.getIndex() == currentStep.getIndex()){
			updateStepStatus(bean, status);
		}
		if(nextStep != null){
			nextStep.performUpdateStepStatus(currentStep, bean, status);
		}
	}
	
	
	
	private int getValidateIndex(EntryType forEntry){
		int index = INVALID_INDEX;
		if(EntryType.OLD_ENTRY == forEntry){
			index = this.oldSubStepIndex;
		} else{
			index = this.subStepIndex;
		}
		return index;
	}
	
	public ResponseData performValidateAll(ReferenceLetterRequestBean bean, ResponseData response, NavigatorParamVO navigatorParamVO) throws BusinessException{ 
    	response = getResponseData(response);
		try{
			if(!this.hasSubMenu){
				doValidate(bean, response, navigatorParamVO);
			} else{
		    	doValidateAll(bean, response, navigatorParamVO);
			}
			
		}catch(Exception ex){
			response.setIsDataSaved(false);
			handleException(response, ex);
		}
    	  
	      if(nextStep !=null){
	    	  response = nextStep.performValidateAll(bean, response,navigatorParamVO);
	      } else{
	    	  return response;
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
	

	protected void initSubNavigator(ReferenceLetterRequestBean bean, Action action){
		this.subStepIndex = INVALID_INDEX;
	}
	
	protected void preDestroy(ReferenceLetterRequestBean bean) throws BusinessException{
		
	}
	
	protected void preSynchronize(ReferenceLetterRequestBean bean) throws BusinessException{
		
	}
	
	protected int getNextSubStepIndex(ReferenceLetterRequestBean bean){
		return INVALID_INDEX;
	}
	
	protected int getPrevSubStepIndex(ReferenceLetterRequestBean bean){
		return INVALID_INDEX;
	}
	
	protected ReferenceLetterRequestBean doLoadSubStep(ReferenceLetterRequestBean bean, int subStepIndex) throws BusinessException{
		return null;
	}
	
	protected void updateSubMenuUI(){
	}
	
	protected void updateStepStatus(ReferenceLetterRequestBean bean, StepStatus status){
	}
	
	
	
	protected StepStatus getSubStepStatus(ReferenceLetterRequestBean bean){
		return StepStatus.UNTOUCHED;
	}
	
	
	protected void doValidateSubStep(ReferenceLetterRequestBean bean, int subStepIndex, ResponseData response, NavigatorParamVO additionalParam) throws BusinessException{
	}
	
	protected void doValidateAll(ReferenceLetterRequestBean bean, ResponseData response, NavigatorParamVO additionalParam) throws BusinessException{
		
	}
	protected boolean isValidSubIndex(ReferenceLetterRequestBean bean, int stepIndex){
		return false;
	}
	protected void restoreSubStepIndex(ReferenceLetterRequestBean bean){
		
	}
	
	protected ResponseData doSynchronization(ReferenceLetterRequestBean bean, ResponseData response, NavigatorParamVO param) throws BusinessException{
		return response;
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
	
	private void handleException(ResponseData response, Exception ex) {
		response.setHasException(true);
		if(ex instanceof BusinessException){
			response.setException((BusinessException)ex);
		} else{
			Ivy.log().error(ex.getMessage(), ex);
			response.setException(new BusinessException(ch.ivy.sample.enums.Error.UNKNOWN.getCode()));
		}
		response.setNeedRefresh(ReferenceLetterUtil.checkRefreshConditionByErrorCode(response.getException().getErrorCode()));
	}
	
	protected ResponseData performSynchronization(ReferenceLetterRequestBean bean, ResponseData response, NavigatorParamVO param) throws BusinessException {
		if(!response.isStopSynchronization()) {
			try{
				doSynchronization(bean, response, param);
			} catch(Exception ex){
				response.setStopSynchronization(true);
				handleException(response, ex);
			}
		
			if(nextStep != null){
				response = nextStep.performSynchronization(bean, response, param);
			}
		}
		return response;
	}
	
	protected void postSync(ReferenceLetterRequestBean bean) throws BusinessException{
		
	}
	
}
