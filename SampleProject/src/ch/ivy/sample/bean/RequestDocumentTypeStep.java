package ch.ivy.sample.bean;

import java.util.List;
import java.util.Locale;

import ch.ivy.sample.dto.AvailableLanguageDTO;
import ch.ivy.sample.dto.RequestDocumentTypeDTO;
import ch.ivy.sample.enums.StepStatus;


public class RequestDocumentTypeStep extends RequestGeneralStep{

	RequestDocumentTypeDTO requestDocumentType;
	private List<AvailableLanguageDTO> availableLanguages;
	Locale locale;
	private int errorCode;
	
	public RequestDocumentTypeStep() {
		super();
		this.requestDocumentType = new RequestDocumentTypeDTO();
		this.stepStatus = StepStatus.UNTOUCHED;
		
	}

	public RequestDocumentTypeDTO getRequestDocumentType() {
		return requestDocumentType;
	}

	public void setRequestDocumentType(
			RequestDocumentTypeDTO requestDocumentType) {
		this.requestDocumentType = requestDocumentType;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public List<AvailableLanguageDTO> getAvailableLanguages() {
		return availableLanguages;
	}

	public void setAvailableLanguages(List<AvailableLanguageDTO> availableLanguages) {
		this.availableLanguages = availableLanguages;
	}
	
}
