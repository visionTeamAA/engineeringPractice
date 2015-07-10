package ch.ivy.sample.util;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;


public final class CommonUtils {
	private static final String ERROR = "Error";
	public static final String SESSION_XPORTAL_USER_DATA = "user";
	public static final String DEFAULT_CATEGORY_CODE = "XEXPDEFCAT";

	public static void reset(String componentId) {
		RequestContext context = RequestContext.getCurrentInstance();
		context.reset(componentId);
	}

	public static void addCallbackParam(String name, Object value) {

		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam(name, value);
	}

	public static String getFullId(FacesContext context, String componentId) {
		UIViewRoot root = context.getViewRoot();
		UIComponent c = findComponent(root, componentId);
		return c.getClientId(context);
	}

	private static UIComponent findComponent(UIComponent c, String id) {
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

	public static void sendErrorMessage(FacesContext context, String idComponent, String message) {
		context.addMessage(CommonUtils.getFullId(context, idComponent), new FacesMessage(FacesMessage.SEVERITY_ERROR, ERROR, message));
	}

}
