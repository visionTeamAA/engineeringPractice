package ch.ivy.sample.navigator;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.EntryType;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.util.ReferenceLetterUtil;


public class NavigatorManager {
	private AbstractReferenceNavigator navigator;
	private NavigatorManager(){
		navigator = ReferenceLetterUtil.getChainOfNavigator();

	}
	
	public static NavigatorManager createInstance(){
		return new NavigatorManager();
	}
	
	public TransferData next(NavigatorParamVO param) throws BusinessException{
		TransferData response = new TransferData();
		navigator.performValidate(param, response); 
		navigator.performNext(param, response);
		if(isNewTabIndexValid(response) && response.getIsDataSaved()){
			param.setAction(Action.NEXT);
			processNewStepData(param , response);
		}
		return response;
		
	}

	
	
	public TransferData back(NavigatorParamVO param) throws BusinessException{
		TransferData response = new TransferData();

		navigator.performValidate(param, response); 
		navigator.performBack(param, response);
		if(isNewTabIndexValid(response) && response.getIsDataSaved()){
			param.setAction(Action.BACK);
			processNewStepData(param, response);
		}
		
		return response;
	}
	
	private void loadAndValidateNewStepIfNeeded(NavigatorParamVO param, TransferData response) throws BusinessException {
		if(response.isCanChangeTab()){
			navigator.performLoad(param, response);
			param.setForEntry(EntryType.NEW_ENTRY);
			param.setOnLoadMainStep(true);
			param.setCheckSpecialCondition(true);
			param.setOnLoadSubStep(true);
			navigator.performValidate(param, response);
		} 
	}
	private void processNewStepData(NavigatorParamVO param, TransferData response) throws BusinessException {
		checkMovingCondition(response);
		loadAndValidateNewStepIfNeeded(param, response);
	}
	
	public TransferData switchTab(NavigatorParamVO param) throws BusinessException{
		TransferData response = new TransferData();
		param.setForEntry(getEntryTypeByTabIndex(param.getOldTab(), param.getCurrentTab()));
		navigator.performValidate(param, response); 
		
		navigator.performSaveSwitchTab(param, response);
		if(response.getIsDataSaved()){
			processNewStepDataWhenSwitchTab(param, response);
		}
		
		return response;
	}
	
	
	
	private EntryType getEntryTypeByTabIndex(MainPageTab oldTab, MainPageTab newTab) {
		EntryType forType = EntryType.NEW_ENTRY;
		if(oldTab.equals(newTab)){
			forType = EntryType.OLD_ENTRY;
		}
		return forType;
	}
	
	public void processNewStepDataWhenSwitchTab(NavigatorParamVO param,
			TransferData response) throws BusinessException {
		checkMovingCondition(response);
		if(response.isCanChangeTab()){
			param.setAction(Action.SWITCH);
			param.setForEntry(EntryType.NEW_ENTRY);
			param.setOnLoadMainStep(true);
			param.setCheckSpecialCondition(true);
			param.setOnLoadSubStep(true);
			
			navigator.performLoad(param, response);
			navigator.performValidate(param, response);
			response.setNewTab(param.getCurrentTab());
			
		}
		
	}

	
	public TransferData validate(NavigatorParamVO param, TransferData transferData) throws BusinessException{
		if(transferData == null) {
			transferData = new TransferData();
		}
		transferData = navigator.performValidate(param, transferData);
		return transferData;
	}
	
	public void setCaption(MainPageTab tab){
		this.navigator.setCaption(tab);
	}
	public String getCaption(){
		return this.navigator.getCaption();
	}
	public String getDescription(){
		return this.navigator.getDescription();
	}
	private boolean isNewTabIndexValid(TransferData response) {
		return response.getNewTab().getIndex() != MainPageTab.UNKNOWN.getIndex();
	}
	
	private TransferData checkMovingCondition(TransferData response) throws BusinessException {
		if(response == null){
			response = new TransferData();
		}
		switch (response.getNewTab()) {
			case EMPLOYEE_DETAIL:
			case DOCUMENT_TYPE:
				response.setCanChangeTab(true);
				break;
			default:
				break;
		}
		
		return response;
	}
}
