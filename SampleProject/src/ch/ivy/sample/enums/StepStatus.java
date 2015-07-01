package ch.ivy.sample.enums;


public enum StepStatus {
	UNDEFINED(-1, "xrfl-start-undefined"),
	START(1, "xrfl-start-status"),
	WARNING (2,"xrfl-warning-status"),
	FINISHED(3,"xrfl-finish-status"), 
	UNTOUCHED(4,"xrfl-untouched-status"),
	;
	private String cssClass;
	private int id;
	private StepStatus(int id, String cssClass) {
		this.id = id;
		this.cssClass = cssClass;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public static StepStatus getById(int id) {
		for (StepStatus status: StepStatus.values()) {
			if (status.getId() == id) {
				return status;
			}
		}
		return null;
	}
}
