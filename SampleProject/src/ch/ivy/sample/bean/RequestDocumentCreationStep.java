package ch.ivy.sample.bean;

import java.util.List;
import java.util.Locale;

import ch.ivy.sample.dto.AvailableLanguageDTO;
import ch.ivy.sample.dto.RequestDocumentTypeDTO;
import ch.ivy.sample.enums.StepStatus;


public class RequestDocumentCreationStep extends RequestGeneralStep{

	private String displayDocLanguages;
	private int errorCode;
	
	public RequestDocumentCreationStep() {
		super();
		this.stepStatus = StepStatus.UNTOUCHED;
		
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDisplayDocLanguages() {
		return displayDocLanguages;
	}

	public void setDisplayDocLanguages(String displayDocLanguages) {
		this.displayDocLanguages = displayDocLanguages;
	}
	

}
