package ch.ivy.sample.enums;

import ch.ivyteam.ivy.environment.Ivy;


public enum MainPageTab {
	UNKNOWN("Unknown", -1, "Unknown", "Unknown"),
	EMPLOYEE_DETAIL("xrflEmployeeDetailTab",0,"/ch/soreco/standard/xrfl/web/mainPage/employeeDetailTab/lblTitleTab","/ch/soreco/standard/xrfl/web/mainPage/generalDescription/lblEmployeeDetail"),
	DOCUMENT_TYPE("xrflDocumentTypeTab",1,"/ch/soreco/standard/xrfl/web/mainPage/documentTypeTab/lblTitleTab","/ch/soreco/standard/xrfl/web/mainPage/generalDescription/lblDocumentType"),
	TASK("xrflTaskTab",2,"/ch/soreco/standard/xrfl/web/mainPage/taskTab/lblTitleTab","/ch/soreco/standard/xrfl/web/mainPage/generalDescription/lblRequestTask"),
	FREE_TEXT("xrflFreeTextTab",3,"/ch/soreco/standard/xrfl/web/mainPage/freeTextTab/lblTitleTab","/ch/soreco/standard/xrfl/web/mainPage/generalDescription/lblFreeText"),
	COMPETENCE("xrflCompetenceTab",4,"/ch/soreco/standard/xrfl/web/mainPage/competenceTab/lblTitleTab","/ch/soreco/standard/xrfl/web/mainPage/generalDescription/lblCompetence"),
	DOCUMENT_CREATION("xrflDocumentCreationTab",5,"/ch/soreco/standard/xrfl/web/mainPage/documentCreationTab/lblTitleTab","/ch/soreco/standard/xrfl/web/mainPage/generalDescription/lblDocumentCreation");
	
	
	private String id;
	private int index;
	private String caption;
	private String description;
	
	private MainPageTab(String id, int index,String caption, String description) {
		this.id = id;
		this.index = index;
		this.caption =caption;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getCaption() { 
		return Ivy.cms().co(this.caption);
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getDescription() {
		return Ivy.cms().co(description);
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static MainPageTab findBy(int id) {
		for (MainPageTab es : MainPageTab.values()) {
			if (es.getIndex() == id) {
				return es;
			}
		}
		return null;
	}
	
}
