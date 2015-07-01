package ch.ivy.sample.enums;

public enum Error {
	NO_ERROR(-1),
	IN_USED(0),
	THE_LAST_LANGUAGE(1),
	THE_LAST_TEMPLATE(2),
	THE_LAST_LANGUAGE_WAS_ASSIGNED(3),
	THE_LAST_LANGUAGE_WAS_ASSIGNED_FOR_ALL_TEMPLATE(4),
	CRITERIA_TEXT_HAS_BEEN_SET(10),
	CANNOT_FOUND_COMPETENCE_CRITERIA(20),
	CANNOT_UPDATE_COMPETENCE_CRITERIA(21),
	CANNOT_ADD_COMPETENCE_CRITERIA(22),
	CANNOT_FOUND_COMPETENCE_GROUP(30),
	CANNOT_ADD_REASON_ORDERING(40),
	CANNOT_UPDATE_REASON_ORDERING(41),
	CANNOT_UPDATE_REFERENCE_LETTER(51),
	NO_COMPETENCE_GROUP(52),
	CANNOT_FOUND_OBJECT(70),
	
	CANNOT_READ_TEMPLATE_FILE(71),
	CANNOT_GENERATE_DOCUMENT(72),
	
	PERSISTENT_EXCEPTION(98),
	OUT_OF_DATE_DATA(99),
	UNKNOWN(999),
	;
	
	private int code;

	private Error(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public static Error getByCode(int code) {
		for (Error er: Error.values()) {
			if (er.getCode() == code) {
				return er;
			}
		}
		return null;
	}
}
