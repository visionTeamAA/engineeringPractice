package ch.ivy.sample.bean;

import java.util.ArrayList;
import java.util.List;

import ch.ivyteam.ivy.environment.Ivy;

public class ValidationMessages {

	public String getMessage(String uri) {
		return Ivy.cms().co(uri);
	}

	public String getMessage(String uri, String param) {
		List<Object> params = new ArrayList<Object>();
		params.add(param);
		return Ivy.cms().co(uri, params );
	}
	
	public static String getMessageCMS(String uri) {
		return Ivy.cms().co(uri);
	}
}
