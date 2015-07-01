package ch.ivy.sample.bean;

import java.io.Serializable;

public class ValidationItem implements Serializable {

	private static final long serialVersionUID = -5415106513422854822L;
	
	private String controlId;
	private String errorContent;
	private String cssClass;
	
	public String getControlId() {
		return controlId;
	}
	public void setControlId(String controlId) {
		this.controlId = controlId;
	}
	public String getErrorContent() {
		return errorContent;
	}
	public void setErrorContent(String errorContent) {
		this.errorContent = errorContent;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	public static class ValidationItemBuilder {
		private String controlId;
		private String errorContent;
		private String cssClass;
		
		public ValidationItemBuilder(String controlId, String errorContent){
			this.controlId = controlId;
			this.errorContent = errorContent;
		}
		
		public ValidationItemBuilder setCustomCss(String customCss){
			this.cssClass = customCss;
			return this;
		}
		
		public ValidationItem createValidationItem(){
			ValidationItem item = new ValidationItem();
			item.setControlId(this.controlId);
			item.setCssClass(this.cssClass);
			item.setErrorContent(this.errorContent);
			return item;
		}
		
	}
}
