package vn.axon.vision.test.helper;

public enum PropertyName {
	SELENIUM_WEBDRIVER_IE_PATH("selenium.webdriver.ie.driver"),
	SELENIUM_WEBDRIVER_SELECTED("selenium.webdriver.selected"),
	SELENIUM_BASEURL("selenium.baseurl"),
	;
	
	public final String id;
	
	private PropertyName(String id) {
		this.id = id;
	}
}
