package ch.ivy.sample.bean;

import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.util.ValidationUtils;


public class TransferData {
	private MainTabInfo tabInfo;
	private ValidationUtils empDetailValidationResult;
	private ValidationUtils docTypeValidationResult;
	private ValidationUtils taskValidationResult;
	private ValidationUtils competenceValidationResult;
	private boolean isDataLoaded;
	private boolean isDataSaved;
	private BusinessException exception;
	private boolean canChangeTab;
	private boolean hasException;
	private String message;
	private boolean hasNoTemplate;
	private boolean isAllStepsFinished;
	private boolean isCheckedStepUntouched;
	private boolean needRefresh;
	private boolean showTryAgainLink;
	private boolean canSaveAsDraft;
	private boolean needToValidate;
	private boolean needToSynchronize;
	private boolean isSynchronized;
	private boolean isStopSynchronization;
	private boolean hasSetStatusOnStep;


	public TransferData() {
		isDataSaved = true;
		isDataLoaded = true;
		canChangeTab = true;
		hasException = false;
		hasNoTemplate = false;
		canSaveAsDraft = false;
		this.empDetailValidationResult = new ValidationUtils();
		this.docTypeValidationResult = new ValidationUtils();
		this.taskValidationResult = new ValidationUtils();
		this.competenceValidationResult = new ValidationUtils();
		this.exception = null;
		this.tabInfo = new MainTabInfo();
		this.tabInfo.setNewTab(MainPageTab.UNKNOWN);
		this.needRefresh = false;
		this.needToValidate = false;
		isStopSynchronization = false;
		needToSynchronize = false;
		hasSetStatusOnStep = true;
	}

	public Boolean getIsDataLoaded() {
		return isDataLoaded;
	}

	public void setIsDataLoaded(Boolean isDataLoaded) {
		this.isDataLoaded = isDataLoaded;
	}

	public Boolean getIsDataSaved() {
		return isDataSaved;
	}

	public void setIsDataSaved(Boolean isDataSaved) {
		this.isDataSaved = isDataSaved;
	}

	public BusinessException getException() {
		return exception;
	}

	public void setException(BusinessException exception) {
		this.exception = exception;
	}

	public boolean isCanChangeTab() {
		return canChangeTab;
	}

	public void setCanChangeTab(boolean canChangeTab) {
		this.canChangeTab = canChangeTab;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isHasException() {
		return hasException;
	}

	public void setHasException(boolean hasException) {
		this.hasException = hasException;
	}

	public boolean isHasNoTemplate() {
		return hasNoTemplate;
	}

	public void setHasNoTemplate(boolean hasNoTemplate) {
		this.hasNoTemplate = hasNoTemplate;
	}

	public ValidationUtils getEmpDetailValidationResult() {
		return empDetailValidationResult;
	}

	public void setEmpDetailValidationResult(
			ValidationUtils empDetailValidationResult) {
		this.empDetailValidationResult = empDetailValidationResult;
	}

	public ValidationUtils getDocTypeValidationResult() {
		return docTypeValidationResult;
	}

	public void setDocTypeValidationResult(
			ValidationUtils docTypeValidationResult) {
		this.docTypeValidationResult = docTypeValidationResult;
	}

	public ValidationUtils getTaskValidationResult() {
		return taskValidationResult;
	}

	public void setTaskValidationResult(ValidationUtils taskValidationResult) {
		this.taskValidationResult = taskValidationResult;
	}

	public void setDataLoaded(boolean isDataLoaded) {
		this.isDataLoaded = isDataLoaded;
	}

	public void setDataSaved(boolean isDataSaved) {
		this.isDataSaved = isDataSaved;
	}

	public void sendValidationResults(MainPageTab activeTab,
			boolean isClearError) {
		switch (activeTab) {
		case EMPLOYEE_DETAIL:
			this.empDetailValidationResult
					.sendErrorWithJSONSupport(isClearError);
			break;
		case DOCUMENT_TYPE:
			this.docTypeValidationResult.sendErrorWithJSONSupport(isClearError);
			break;
		case TASK:
			this.taskValidationResult.sendErrorWithJSONSupport(isClearError);
			break;
		case COMPETENCE:
			this.competenceValidationResult
					.sendErrorWithJSONSupport(isClearError);
		default:
			break;
		}

	}

	public boolean isNeedRefresh() {
		return needRefresh;
	}

	public void setNeedRefresh(boolean needRefresh) {
		this.needRefresh = needRefresh;
	}

	public boolean isShowTryAgainLink() {
		return showTryAgainLink;
	}

	public void setShowTryAgainLink(boolean showTryAgainLink) {
		this.showTryAgainLink = showTryAgainLink;
	}

	public ValidationUtils getCompetenceValidationResult() {
		return competenceValidationResult;
	}

	public void setCompetenceValidationResult(
			ValidationUtils competenceValidationResult) {
		this.competenceValidationResult = competenceValidationResult;
	}

	public boolean isCanSaveAsDraft() {
		return canSaveAsDraft;
	}

	public void setCanSaveAsDraft(boolean canSaveAsDraft) {
		this.canSaveAsDraft = canSaveAsDraft;
	}

	public boolean isNeedToValidate() {
		return needToValidate;
	}

	public void setNeedToValidate(boolean needToValidate) {
		this.needToValidate = needToValidate;
	}

	public boolean isSynchronized() {
		return isSynchronized;
	}

	public void setSynchronized(boolean isSynchronized) {
		this.isSynchronized = isSynchronized;
	}

	public boolean isStopSynchronization() {
		return isStopSynchronization;
	}

	public void setStopSynchronization(boolean isStopSynchronization) {
		this.isStopSynchronization = isStopSynchronization;
	}

	public boolean isNeedToSynchronize() {
		return needToSynchronize;
	}

	public void setNeedToSynchronize(boolean needToSynchronize) {
		this.needToSynchronize = needToSynchronize;
	}

	public boolean isAllStepsFinished() {
		return isAllStepsFinished;
	}

	public void setAllStepsFinished(boolean isAllStepsFinished) {
		this.isAllStepsFinished = isAllStepsFinished;
	}

	public boolean isCheckedStepUntouched() {
		return isCheckedStepUntouched;
	}

	public void setCheckedStepUntouched(boolean isCheckedStepUntouched) {
		this.isCheckedStepUntouched = isCheckedStepUntouched;
	}

	public boolean isHasSetStatusOnStep() {
		return hasSetStatusOnStep;
	}

	public void setHasSetStatusOnStep(boolean hasSetStatusOnStep) {
		this.hasSetStatusOnStep = hasSetStatusOnStep;
	}

	public MainTabInfo getTabInfo() {
		return tabInfo;
	}

	public void setTabInfo(MainTabInfo tabInfo) {
		this.tabInfo = tabInfo;
	}
	
	
}
