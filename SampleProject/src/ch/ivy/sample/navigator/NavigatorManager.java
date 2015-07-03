package ch.ivy.sample.navigator;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.ConstantVariable;
import ch.ivy.sample.bean.NavigatorParamVO.NavigatorParamBuilder;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.ResponseData;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.EntryType;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivy.sample.util.ReferenceLetterUtil;
import ch.ivyteam.ivy.environment.Ivy;


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
		response.setOldTabIndicator(tab);
		synchronizeIfRequired(response, bean);
		if(response.isHasException()){
			return response;
		}
		navigator.performValidate(tab, bean, response, NavigatorParamBuilder.createBuilder()
																			.setForEntry(EntryType.OLD_ENTRY)
																			.setOnLoadMainStep(false)
																			.setCheckSpecialCondition(false)
																			.setOnLoadSubStep(false)
																			.createParam()); 
		//build step status to save to DB
		ReferenceLetterUtil.buildStatusForBeanDTO(bean);

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
		synchronizeIfRequired(response, bean);
		if(response.isHasException()){
			return response;
		}
		navigator.performValidate(tab, bean, response, NavigatorParamBuilder.createBuilder()
																			.setForEntry(EntryType.OLD_ENTRY)
																			.setOnLoadMainStep(false)
																			.setCheckSpecialCondition(false)
																			.setOnLoadSubStep(false)
																			.createParam()); 
		//build step status to save to DB
		ReferenceLetterUtil.buildStatusForBeanDTO(bean);
		
		navigator.performBack(tab, bean, response);
		if(isNewTabIndexValid(response) && response.getIsDataSaved()){
			processNewStepData(tab, response, bean, Action.BACK);
		}
		
		return response;
	}
	
	public ResponseData refresh(MainPageTab tab) throws BusinessException{
		ResponseData response = new ResponseData();
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		if(tab.getIndex() != MainPageTab.UNKNOWN.getIndex()){
			navigator.performPreDestroy(tab, bean);
			response.setNewTabIndicator(tab);
			processCurrentStepData(response, bean, Action.REFRESH);
		}
		return response;
		
	}
	
	private void preDestroyIfNeeded(MainPageTab oldTab, MainPageTab newTab, ReferenceLetterRequestBean bean) throws BusinessException{
		if(!oldTab.equals(newTab)){
			navigator.performPreDestroy(oldTab, bean);
		}
	}
	
	public void updateStatus(MainPageTab tab, StepStatus status) throws BusinessException{
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		navigator.performUpdateStepStatus(tab, bean, status);
		
	}
	
	private void processCurrentStepData(ResponseData response,
			ReferenceLetterRequestBean bean, Action action) throws BusinessException{
		if(response.getNewTabIndicator().getIndex() != MainPageTab.DOCUMENT_CREATION.getIndex()){
			checkMovingCondition(response.getNewTabIndicator(), response);
		} else{
			response.setCanChangeTab(true);
		}
		loadAndValidateNewStepIfNeeded(response.getNewTabIndicator(), response, bean, action);
		
	}

	private void loadAndValidateNewStepIfNeeded(MainPageTab oldTab,
			ResponseData response, ReferenceLetterRequestBean bean,
			Action action) throws BusinessException {
		if(response.isCanChangeTab()){
			preDestroyIfNeeded(oldTab, response.getNewTabIndicator(), bean);
			navigator.performLoad(response.getNewTabIndicator(), bean , response, action);
			navigator.performValidate(response.getNewTabIndicator(), bean, response,NavigatorParamBuilder.createBuilder()
																										.setForEntry(EntryType.NEW_ENTRY)
																										.setOnLoadMainStep(true)
																										.setCheckSpecialCondition(true)
																										.setOnLoadSubStep(true)
																										.createParam());
		} else{
			navigator.performRestoreSubStepIndex(bean);
		}
	}
	private void processNewStepData(MainPageTab oldTab, ResponseData response,
			ReferenceLetterRequestBean bean, Action action) throws BusinessException {
		checkSynchronizationCondition(response.getNewTabIndicator(), response, EntryType.NEW_ENTRY);
		if(response.isNeedToSynchronize()){
			processSynchronization(oldTab, response.getNewTabIndicator(), bean, response);
			if(response.isHasException()){
				return;
			}
		}
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
		ReferenceLetterUtil.buildStatusForBeanDTO(bean);
		
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
		checkSynchronizationCondition(newTab, response, EntryType.NEW_ENTRY);
		if(response.isNeedToSynchronize()){
			processSynchronization(oldTab, newTab, bean, response);
			if(response.isHasException()){
				return;
			}
		}
		
		checkMovingCondition(newTab, response);
		if(response.isCanChangeTab()){
			preDestroyIfNeeded(oldTab, newTab, bean);
			navigator.performLoad(newTab, bean, response, Action.SWITCH);
			navigator.performValidate(newTab, bean, response, NavigatorParamBuilder.createBuilder()
																					.setForEntry(EntryType.NEW_ENTRY)
																					.setOnLoadMainStep(true)
																					.setCheckSpecialCondition(true)
																					.setOnLoadSubStep(true)
																					.createParam());
			response.setNewTabIndicator(newTab);
			
		}else{
			navigator.performRestoreSubStepIndex(bean);
		}
		
	}

	private void processSynchronization(MainPageTab oldTab, MainPageTab newTab,
			ReferenceLetterRequestBean bean, ResponseData response)
			throws BusinessException {
		navigator.performPreSynchronize(oldTab, bean);
		navigator.performSynchronization(bean, response, NavigatorParamBuilder.createBuilder()
																				.setCallerStepIndicator(newTab)
																				.createParam());
		validateAll(response);
		navigator.postSync(bean);
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
	public ResponseData validateAll (ResponseData response) throws BusinessException {
		ReferenceLetterRequestBean bean =  ReferenceLetterUtil.getReferenceLetterRequestBean();
		response = navigator.performValidateAll(bean, response, NavigatorParamBuilder.createBuilder()
				.setForEntry(EntryType.NEW_ENTRY)
				.setOnLoadMainStep(true)
				.setCheckSpecialCondition(false)
				.setOnLoadSubStep(true)
				.createParam());
		return response;
	}
	
	private ResponseData synchronizeIfRequired(ResponseData response, ReferenceLetterRequestBean bean) throws BusinessException{
		checkSynchronizationCondition(response.getOldTabIndicator(), response, EntryType.OLD_ENTRY);
		if(response.isNeedToSynchronize()){
			processSynchronization(response.getOldTabIndicator(), response.getNewTabIndicator(), bean, response);
		}
		return response;
	}
	
	private boolean isNewTabIndexValid(ResponseData response) {
		return response.getNewTabIndicator().getIndex() != MainPageTab.UNKNOWN.getIndex();
	}
	
	private ResponseData checkSynchronizationCondition(MainPageTab newTab, ResponseData response, EntryType forEntry) throws BusinessException {
		if(response == null){
			response = new ResponseData();
		}
		switch (newTab) {
		case EMPLOYEE_DETAIL:
			break;
		case DOCUMENT_TYPE:
			if(forEntry.equals(EntryType.NEW_ENTRY)){
				response.setNeedToSynchronize(true);
			} else{
				response.setNeedToSynchronize(false);
			}
			break;
		case TASK:
		case FREE_TEXT:
		case COMPETENCE:
			response.setNeedToSynchronize(false);
			break;
		case DOCUMENT_CREATION:
			if(forEntry.equals(EntryType.NEW_ENTRY)){
				response.setNeedToSynchronize(true);
			} else{
				response.setNeedToSynchronize(false);
			}
			break;
		default:
			break;
		}
		return response;
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
			case TASK:
			case FREE_TEXT:
			case COMPETENCE:
			{
				response.getDocTypeValidationResult().clear();
				validate(MainPageTab.DOCUMENT_TYPE, response, true);
				if(response.isHasNoTemplate()){
					response.setMessage(Ivy.cms().co(ConstantVariable.MSG_MANDATORY_TEMPLATE));
				}else if(!response.getDocTypeValidationResult().isValidForm() || response.isCheckedStepUntouched()){
					response.setMessage(Ivy.cms().co(ConstantVariable.MSG_CANNOT_MOVE_TO_OTHER_STEP_BECAUSE_OF_DOCUMENT_TYPE_STEP));
				}		
				response.setCanChangeTab(response.getDocTypeValidationResult().isValidForm() && !response.isHasNoTemplate() && !response.isCheckedStepUntouched());
				break;
			}
				
			case DOCUMENT_CREATION:
				validate(MainPageTab.DOCUMENT_CREATION, response, true);
				if(!response.isAllStepsFinished()){
					response.setMessage(Ivy.cms().co(ConstantVariable.MSG_CANNOT_MOVE_TO_DOCUMENT_CREATION_STEP));
				}
				response.setCanChangeTab(response.isAllStepsFinished());
				break;
			default:
				break;
		}
		
		return response;
	}
}
