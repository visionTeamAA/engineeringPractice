package ch.ivy.sample.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "xrflRequestBean")
@SessionScoped
public class ReferenceLetterRequestBean implements Serializable {

	private static final long serialVersionUID = -5730460710754409952L;
	private RequestEmployeeDetailStep employeeDetailStep;
	private RequestDocumentTypeStep documentTypeStep;
	public RequestEmployeeDetailStep getEmployeeDetailStep() {
		return employeeDetailStep;
	}

	public void setEmployeeDetailStep(RequestEmployeeDetailStep employeeDetailStep) {
		this.employeeDetailStep = employeeDetailStep;
	}

	public RequestDocumentTypeStep getDocumentTypeStep() {
		return documentTypeStep;
	}

	public void setDocumentTypeStep(RequestDocumentTypeStep documentTypeStep) {
		this.documentTypeStep = documentTypeStep;
	}
}
