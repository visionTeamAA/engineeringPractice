package ch.ivy.sample.util;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;


/**
 * FacesUtils
 * 
 * Copyright(c)2010 by Soreco AG, CH-8603 Schwerzenbach. http://www.soreco.ch
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of 
 * Soreco AG. You shall not disclose such confidential information and 
 * shall use it only in accordance with the terms of the license 
 * agreement you entered into with Soreco.
 */


public final class FacesUtils {
	/**
	 * private method
	 */
	private FacesUtils(){
		
	}
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    if(context != null){
	    	return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	    }else {
	    	return null;
	    }
	}
	
	   /**
	   * Returns the clientId for a component with id="shortClientID"
	   */
	  public static String getFullClientID(String shortClientID) {
	    FacesContext context = FacesContext.getCurrentInstance();
	    UIViewRoot root = context.getViewRoot();
	    UIComponent c = findComponent(root, shortClientID);
	    return c.getClientId(context);
	  }
	  
	  public static String getCurrentPageName(){
		  String pageName = "";
		  FacesContext context = FacesContext.getCurrentInstance();
		  String viewId = context.getViewRoot().getViewId();
		  Pattern pattern = Pattern.compile(".+/(.+/(.+\\.xhtml))");
		  Matcher matcher = pattern.matcher(viewId);
		  if(matcher.matches()){
			  pageName = matcher.group(1);
		  }
		  return pageName;
	  }

	  /**
	   * Finds component with the given id
	   */
	  public static UIComponent findComponent(UIComponent c, String id) {
	    if (id.equals(c.getId())) {
	      return c;
	    }
	    Iterator<UIComponent> kids = c.getFacetsAndChildren();
	    while (kids.hasNext()) {
	      UIComponent found = findComponent(kids.next(), id);
	      if (found != null) {
	        return found;
	      }
	    }
	    return null;
	  }
}
