package ch.ivy.sample.navigator;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO.NavigatorParamBuilder;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.ResponseData;
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
	
	public ResponseData next(MainPageTab tab) throws BusinessException{
		ResponseData response = new ResponseData();
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		navigator.performValidate(tab, bean, response, NavigatorParamBuilder.createBuilder()
																			.setForEntry(EntryType.OLD_ENTRY)
																			.setOnLoadMainStep(false)
																			.setCheckSpecialCondition(false)
																			.setOnLoadSubStep(false)
																			.createParam()); 
		navigator.performNext(tab, bean, response);
		if(isNewTabIndexValid(response) && response.getIsDataSaved()){
			processNewStepData(tab, response, bean, Action.NEXT);
		}
		return response;
		
	}

	
	
	public ResponseData back(MainPageTab tab) throws BusinessException{
		ResponseData response = new ResponseData();
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		response.setOldTabIndicator(tab);
		if(response.isHasException()){
			return response;
		}
		navigator.performValidate(tab, bean, response, NavigatorParamBuilder.createBuilder()
																			.setForEntry(EntryType.OLD_ENTRY)
																			.setOnLoadMainStep(false)
																			.setCheckSpecialCondition(false)
																			.setOnLoadSubStep(false)
																			.createParam()); 
		navigator.performBack(tab, bean, response);
		if(isNewTabIndexValid(response) && response.getIsDataSaved()){
			processNewStepData(tab, response, bean, Action.BACK);
		}
		
		return response;
	}
	
	private void loadAndValidateNewStepIfNeeded(MainPageTab oldTab,
			ResponseData response, ReferenceLetterRequestBean bean,
			Action action) throws BusinessException {
		if(response.isCanChangeTab()){
			navigator.performLoad(response.getNewTabIndicator(), bean , response, action);
			navigator.performValidate(response.getNewTabIndicator(), bean, response,NavigatorParamBuilder.createBuilder()
																										.setForEntry(EntryType.NEW_ENTRY)
																										.setOnLoadMainStep(true)
																										.setCheckSpecialCondition(true)
																										.setOnLoadSubStep(true)
																										.createParam());
		} 
	}
	private void processNewStepData(MainPageTab oldTab, ResponseData response,
			ReferenceLetterRequestBean bean, Action action) throws BusinessException {
		checkMovingCondition(response.getNewTabIndicator(), response);
		loadAndValidateNewStepIfNeeded(oldTab, response, bean, action);
	}
	
	public ResponseData switchTab(MainPageTab oldTab, MainPageTab newTab) throws BusinessException{
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		ResponseData response = new ResponseData();
		navigator.performValidate(oldTab, bean, response, NavigatorParamBuilder.createBuilder()
																				.setForEntry(getEntryTypeByTabIndex(oldTab, newTab))
																				.setOnLoadMainStep(false)
																				.setCheckSpecialCondition(false)
																				.setOnLoadSubStep(false)
																				.createParam()); 
		
		navigator.performSaveSwitchTab(oldTab, bean, response);
		if(response.getIsDataSaved()){
			processNewStepDataWhenSwitchTab(oldTab, newTab, bean, response);
		}
		
		return response;
	}
	
	public ResponseData switchTab(MainPageTab currentTab) throws BusinessException{
		return switchTab(currentTab, currentTab);
	}
	
	private EntryType getEntryTypeByTabIndex(MainPageTab oldTab, MainPageTab newTab) {
		EntryType forType = EntryType.NEW_ENTRY;
		if(oldTab.equals(newTab)){
			forType = EntryType.OLD_ENTRY;
		}
		return forType;
	}
	
	public void processNewStepDataWhenSwitchTab(MainPageTab oldTab,
			MainPageTab newTab, ReferenceLetterRequestBean bean,
			ResponseData response) throws BusinessException {
		checkMovingCondition(newTab, response);
		if(response.isCanChangeTab()){
			navigator.performLoad(newTab, bean, response, Action.SWITCH);
			navigator.performValidate(newTab, bean, response, NavigatorParamBuilder.createBuilder()
																					.setForEntry(EntryType.NEW_ENTRY)
																					.setOnLoadMainStep(true)
																					.setCheckSpecialCondition(true)
																					.setOnLoadSubStep(true)
																					.createParam());
			response.setNewTabIndicator(newTab);
			
		}
		
	}

	
	public ResponseData validate(MainPageTab tab, ResponseData response, boolean checkSpecCond) throws BusinessException{
		if(response == null) {
			response = new ResponseData();
		}
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		response = navigator.performValidate(tab, bean, response,  NavigatorParamBuilder.createBuilder()
																						.setForEntry(EntryType.NEW_ENTRY)
																						.setOnLoadMainStep(false)
																						.setCheckSpecialCondition(checkSpecCond)
																						.setOnLoadSubStep(false)
																						.setStatusOnStep(response.isHasSetStatusOnStep())
																						.createParam());
		return response;
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
	
	
	private boolean isNewTabIndexValid(ResponseData response) {
		return response.getNewTabIndicator().getIndex() != MainPageTab.UNKNOWN.getIndex();
	}
	
	
	private ResponseData checkMovingCondition(MainPageTab newTab, ResponseData response) throws BusinessException {
		if(response == null){
			response = new ResponseData();
		}
		switch (newTab) {
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
