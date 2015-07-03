package ch.ivy.sample.dto;

import ch.ivy.sample.bean.ConstantVariable;

public class RequestDocumentTypeDTO {
	
	private Long docReferenceTypeId;
	private Long docProfessionId;
	private Long docReasonForOrderingId;
	private String docLanguage;
	private Long docTemplateId;

	private Long oldReferenceTypeId;
	private Long oldProfessionId;
	private Long oldReasonForOrderingId;
	private String oldDocLanguage;
	private Long oldTemplateId;
	
	public RequestDocumentTypeDTO() {
		super();
		this.docReferenceTypeId = 0L;
		this.docProfessionId = 0L;
		this.docReasonForOrderingId = 0L;
		this.docLanguage = ConstantVariable.EMPTY_STRING;
		this.docTemplateId = 0L;
	}

	public String getDocLanguage() {
		return docLanguage;
	}

	public void setDocLanguage(String docLanguage) {
		this.docLanguage = docLanguage;
	}

	public Long getDocReferenceTypeId() {
		return docReferenceTypeId;
	}

	public void setDocReferenceTypeId(Long docReferenceTypeId) {
		this.docReferenceTypeId = docReferenceTypeId;
	}

	public Long getDocProfessionId() {
		return docProfessionId;
	}

	public void setDocProfessionId(Long docProfessionId) {
		this.docProfessionId = docProfessionId;
	}

	public Long getDocTemplateId() {
		return docTemplateId;
	}

	public void setDocTemplateId(Long docTemplateId) {
		this.docTemplateId = docTemplateId;
	}

	public Long getDocReasonForOrderingId() {
		return docReasonForOrderingId;
	}

	public void setDocReasonForOrderingId(Long docReasonForOrderingId) {
		this.docReasonForOrderingId = docReasonForOrderingId;
	}

	public Long getOldReferenceTypeId() {
		return oldReferenceTypeId;
	}

	public void setOldReferenceTypeId(Long oldReferenceTypeId) {
		this.oldReferenceTypeId = oldReferenceTypeId;
	}

	public Long getOldProfessionId() {
		return oldProfessionId;
	}

	public void setOldProfessionId(Long oldProfessionId) {
		this.oldProfessionId = oldProfessionId;
	}

	public String getOldDocLanguage() {
		return oldDocLanguage;
	}

	public void setOldDocLanguage(String oldDocLanguage) {
		this.oldDocLanguage = oldDocLanguage;
	}

	public Long getOldReasonForOrderingId() {
		return oldReasonForOrderingId;
	}

	public void setOldReasonForOrderingId(Long oldReasonForOrderingId) {
		this.oldReasonForOrderingId = oldReasonForOrderingId;
	}

	public Long getOldTemplateId() {
		return oldTemplateId;
	}

	public void setOldTemplateId(Long oldTemplateId) {
		this.oldTemplateId = oldTemplateId;
	}
	
}
