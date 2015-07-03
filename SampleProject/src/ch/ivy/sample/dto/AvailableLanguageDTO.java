package ch.ivy.sample.dto;

import ch.ivy.sample.base.interfaces.IBaseDTO;



public class AvailableLanguageDTO  implements IBaseDTO {

	private java.lang.Long id;
	private java.lang.String description;
	private java.lang.String code;
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	public java.lang.String getDescription() {
		return description;
	}
	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public java.lang.String getCode() {
		return code;
	}
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	
}
