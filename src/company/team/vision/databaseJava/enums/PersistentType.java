package company.team.vision.databaseJava.enums;

public enum PersistentType {
	PERSISTENT_UNIT_TEST("xrfl_unit_test"), 
	PERSISTENT_INTEGRATION_TEST("xrfl_integration_test"),
	PERSISTENT_XPERTLINE_TEST("xpertLine");
	
	private String persistentName;

	private PersistentType(String persistentName) {
		this.persistentName = persistentName;
	}

	public String getPersistentName() {
		return persistentName;
	}

	public void setPersistentName(String persistentName) {
		this.persistentName = persistentName;
	}

}
