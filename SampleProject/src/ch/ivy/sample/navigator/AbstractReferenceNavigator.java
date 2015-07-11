package ch.ivy.sample.navigator;

import java.io.Serializable;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.bean.ValidationMessages;
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

	abstract protected ReferenceLetterRequestBean doLoad(NavigatorParamVO param) throws BusinessException;
	abstract protected void doNext(NavigatorParamVO param) throws BusinessException;
	abstract protected void doBack(NavigatorParamVO param) throws BusinessException;
	abstract protected void doValidate(NavigatorParamVO param, TransferData transferData) throws BusinessException;	
	abstract protected void doSaveSwitchTab(NavigatorParamVO param)throws BusinessException;
	abstract protected StepStatus getStepStatus(NavigatorParamVO param);
	
	public TransferData performNext(MainPageTab tab, NavigatorParamVO param, TransferData transferData) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){	
			transferData = getResponseData(transferData);
			try{
				doNext(param);
				MainPageTab nextStep = getNextStepIndicator();
				transferData.setNewTab(nextStep);
			} catch(Exception ex){
				transferData.setIsDataSaved(false);
				transferData.setNewTab(tab);
				handleException(transferData, ex);
			}
			return transferData;	
		}		
		if(nextStep != null){
			transferData = nextStep.performNext(tab, param, transferData);
		}
		return transferData;
	}
	
	
	
	public TransferData performLoad(MainPageTab tab, NavigatorParamVO param, TransferData transferData) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){	
			transferData = getResponseData(transferData);
			try{
				doLoad(param);	
			} catch(Exception ex){
				transferData.setIsDataLoaded(false);
				handleException(transferData, ex);
			}
			return transferData;
		}
		if(nextStep != null){
			transferData = nextStep.performLoad(tab, param, transferData );
		}
		return transferData;
	}
	
	public TransferData performBack(MainPageTab tab, NavigatorParamVO param, TransferData transferData) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){
			transferData = getResponseData(transferData);
			try{
				
				doBack(param);
				MainPageTab nextStep = getPrevStepIndicator();
				transferData.setNewTab(nextStep);
			} catch(Exception ex){
				transferData.setIsDataSaved(false);
				transferData.setNewTab(tab);
				handleException(transferData, ex);
			}
			return transferData;	
		}		
		if(nextStep != null){
			transferData = nextStep.performBack(tab, param, transferData);
		}
		return transferData;
	}
	private TransferData getResponseData(TransferData transferData) {
		if(transferData == null){
			transferData = new TransferData();
		}
		return transferData;
	}
	
	public TransferData performSaveSwitchTab(MainPageTab tab, NavigatorParamVO param,  TransferData transferData) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){
			transferData = getResponseData(transferData);
			try{
				doSaveSwitchTab(param);
			}catch(Exception ex){
				transferData.setIsDataSaved(false);
				transferData.setNewTab(tab);
				handleException(transferData, ex);
			}
			return transferData;
		}
		if(nextStep != null){
			transferData = nextStep.performSaveSwitchTab(tab, param, transferData);
		}
		return transferData;
	}
	
	public TransferData performValidate(MainPageTab tab, NavigatorParamVO param, TransferData transferData) throws BusinessException{
		if(this.stepIndicator.getIndex() == tab.getIndex()){
			transferData = getResponseData(transferData);
			try{
				doValidate(param, transferData);
			}catch(Exception ex){
				transferData.setIsDataSaved(false);
				handleException(transferData, ex);
			}
			return transferData;
		}
		
		if(nextStep != null){
			transferData = nextStep.performValidate(tab, param, transferData);
		}
		return transferData;
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
	
	private void handleException(TransferData transferData, Exception ex) {
		transferData.setHasException(true);
		if(ex instanceof BusinessException){
			transferData.setException((BusinessException)ex);
		} else{
			Ivy.log().error(ex.getMessage(), ex);
			transferData.setException(new BusinessException(ch.ivy.sample.enums.Error.UNKNOWN.getCode()));
		}
		transferData.setNeedRefresh(ReferenceLetterUtil.checkRefreshConditionByErrorCode(transferData.getException().getErrorCode()));
	}
}
