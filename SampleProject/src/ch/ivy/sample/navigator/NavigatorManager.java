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
		TransferData transferData = new TransferData();
		navigator.performValidate(param.getCurrentTab(), param, transferData); 
		navigator.performNext(param.getCurrentTab(), param, transferData);
		if(isNewTabIndexValid(transferData) && transferData.getIsDataSaved()){
			param.setAction(Action.NEXT);
			processNewStepData(param , transferData);
		}
		return transferData;
		
	}

	
	
	public TransferData back(NavigatorParamVO param) throws BusinessException{
		TransferData transferData = new TransferData();

		navigator.performValidate(param.getCurrentTab() ,param, transferData); 
		navigator.performBack(param.getCurrentTab() ,param, transferData);
		if(isNewTabIndexValid(transferData) && transferData.getIsDataSaved()){
			param.setAction(Action.BACK);
			processNewStepData(param, transferData);
		}
		
		return transferData;
	}
	
	private void loadAndValidateNewStepIfNeeded(NavigatorParamVO param, TransferData transferData) throws BusinessException {
		if(transferData.isCanChangeTab()){
			navigator.performLoad(param.getNewTab() ,param, transferData);
			param.setForEntry(EntryType.NEW_ENTRY);
			param.setOnLoadMainStep(true);
			param.setCheckSpecialCondition(true);
			param.setOnLoadSubStep(true);
			navigator.performValidate(param.getNewTab() ,param, transferData);
		} 
	}
	private void processNewStepData(NavigatorParamVO param, TransferData transferData) throws BusinessException {
		checkMovingCondition(transferData);
		loadAndValidateNewStepIfNeeded(param, transferData);
	}
	
	public TransferData switchTab(NavigatorParamVO param) throws BusinessException{
		TransferData transferData = new TransferData();
		param.setForEntry(getEntryTypeByTabIndex(param.getCurrentTab(), param.getCurrentTab()));
		navigator.performValidate(param.getCurrentTab(), param, transferData); 
		
		navigator.performSaveSwitchTab(param.getCurrentTab(), param, transferData);
		if(transferData.getIsDataSaved()){
			transferData.setNewTab(param.getNewTab());
			processNewStepDataWhenSwitchTab(param, transferData);
		}
		
		return transferData;
	}
	
	
	
	private EntryType getEntryTypeByTabIndex(MainPageTab oldTab, MainPageTab newTab) {
		EntryType forType = EntryType.NEW_ENTRY;
		if(oldTab.equals(newTab)){
			forType = EntryType.OLD_ENTRY;
		}
		return forType;
	}
	
	public void processNewStepDataWhenSwitchTab(NavigatorParamVO param,
			TransferData transferData) throws BusinessException {
		checkMovingCondition(transferData);
		if(transferData.isCanChangeTab()){
			param.setAction(Action.SWITCH);
			param.setForEntry(EntryType.NEW_ENTRY);
			param.setOnLoadMainStep(true);
			param.setCheckSpecialCondition(true);
			param.setOnLoadSubStep(true);
			
			navigator.performLoad(param.getNewTab(), param, transferData);
			navigator.performValidate(param.getNewTab(), param, transferData);
			
		}
		
	}

	
	public TransferData validate(NavigatorParamVO param, TransferData transferData) throws BusinessException{
		if(transferData == null) {
			transferData = new TransferData();
		}
		transferData = navigator.performValidate(param.getCurrentTab(), param, transferData);
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
	private boolean isNewTabIndexValid(TransferData transferData) {
		return transferData.getNewTab().getIndex() != MainPageTab.UNKNOWN.getIndex();
	}
	
	private TransferData checkMovingCondition(TransferData transferData) throws BusinessException {
		if(transferData == null){
			transferData = new TransferData();
		}
		switch (transferData.getNewTab()) {
			case EMPLOYEE_DETAIL:
			case DOCUMENT_TYPE:
				transferData.setCanChangeTab(true);
				break;
			default:
				break;
		}
		
		return transferData;
	}
}
