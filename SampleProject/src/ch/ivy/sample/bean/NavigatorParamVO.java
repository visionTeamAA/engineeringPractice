package ch.ivy.sample.bean;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.EntryType;
import ch.ivy.sample.enums.MainPageTab;




public final class NavigatorParamVO {
	
	private boolean isOnLoadMainStep;
	private boolean checkSpecialCondition;
	private EntryType forEntry;
	private boolean isOnLoadSubStep;
	private MainPageTab callerStepIndicator;
	private boolean hasSetStatusOnStep;
	private MainPageTab currentTab;
	private MainPageTab newTab;
	private ReferenceLetterRequestBean xrflBean;
	private RequestContext requestContext;
	private FacesContext facesContext;
	private Action action;
	private NavigatorParamVO(boolean isOnLoadMainStep,
			boolean checkSpecialCondition) {
		this.isOnLoadMainStep = isOnLoadMainStep;
		this.checkSpecialCondition = checkSpecialCondition;
	}

	public boolean isOnLoadMainStep() {
		return isOnLoadMainStep;
	}

	public void setOnLoadMainStep(boolean isOnLoadMainStep) {
		this.isOnLoadMainStep = isOnLoadMainStep;
	}

	public boolean isCheckSpecialCondition() {
		return checkSpecialCondition;
	}

	public void setCheckSpecialCondition(boolean checkSpecialCondition) {
		this.checkSpecialCondition = checkSpecialCondition;
	}

	public EntryType getForEntry() {
		return forEntry;
	}

	public void setForEntry(EntryType forEntry) {
		this.forEntry = forEntry;
	}

	public boolean isOnLoadSubStep() {
		return isOnLoadSubStep;
	}

	public void setOnLoadSubStep(boolean isOnLoadSubStep) {
		this.isOnLoadSubStep = isOnLoadSubStep;
	}

	public MainPageTab getCallerStepIndicator() {
		return callerStepIndicator;
	}

	public void setCallerStepIndicator(MainPageTab currentIndicator) {
		this.callerStepIndicator = currentIndicator;
	}

	public boolean isHasSetStatusOnStep() {
		return hasSetStatusOnStep;
	}

	public void setHasSetStatusOnStep(boolean hasSetStatusOnStep) {
		this.hasSetStatusOnStep = hasSetStatusOnStep;
	}
	public MainPageTab getNewTab() {
		return newTab;
	}

	public void setNewTab(MainPageTab newTab) {
		this.newTab = newTab;
	}

	public MainPageTab getCurrentTab() {
		return currentTab;
	}

	public void setCurrentTab(MainPageTab currentTab) {
		this.currentTab = currentTab;
	}

	public ReferenceLetterRequestBean getXrflBean() {
		return xrflBean;
	}

	public void setXrflBean(ReferenceLetterRequestBean xrflBean) {
		this.xrflBean = xrflBean;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}


	public final static class NavigatorParamBuilder {
		private boolean isOnLoadMainStep;
		private boolean checkSpecialCondition;
		private EntryType forEntry;
		private boolean isOnLoadSubStep;
		private MainPageTab callerStepIndicator;
		private boolean hasSetStatusOnStep;
		private MainPageTab currentTab;
		private MainPageTab newTab;
		private ReferenceLetterRequestBean xrflBean;
		private RequestContext requestContext;
		private FacesContext facesContext;
		private Action action;
		
		private NavigatorParamBuilder() {
			this.isOnLoadMainStep = false;
			this.checkSpecialCondition = false;
			this.forEntry = EntryType.UNKNOWN;
			this.callerStepIndicator = MainPageTab.UNKNOWN;
			this.hasSetStatusOnStep = true;
			this.newTab = MainPageTab.UNKNOWN;
			this.currentTab = MainPageTab.UNKNOWN;
		}

		public static NavigatorParamBuilder createBuilder() {
			return new NavigatorParamBuilder();
		}
		
		public NavigatorParamBuilder setHasSetStatusOnStep(boolean hasSetStatusOnStep) {
			this.hasSetStatusOnStep = hasSetStatusOnStep;
			return this;
		}

		public NavigatorParamBuilder setTabInfo(MainPageTab tabInfo) {
			this.currentTab = tabInfo;
			return this;
		}

		public NavigatorParamBuilder setXrflBean(ReferenceLetterRequestBean xrflBean) {
			this.xrflBean = xrflBean;
			return this;
		}

		public NavigatorParamBuilder setRequestContext(RequestContext requestContext) {
			this.requestContext = requestContext;
			return this;
		}

		public NavigatorParamBuilder setAction(Action action) {
			this.action = action;
			return this;
		}

		public NavigatorParamBuilder setStatusOnStep(boolean hasSetStatusOnStep) {
			this.hasSetStatusOnStep = hasSetStatusOnStep;
			return this;
		}

		public NavigatorParamBuilder setOnLoadMainStep(boolean isOnLoadMainStep) {
			this.isOnLoadMainStep = isOnLoadMainStep;
			return this;
		}

		public NavigatorParamBuilder setCheckSpecialCondition(
				boolean checkSpecialCondition) {
			this.checkSpecialCondition = checkSpecialCondition;
			return this;
		}

		public NavigatorParamBuilder setOnLoadSubStep(boolean isOnLoadSubStep) {
			this.isOnLoadSubStep = isOnLoadSubStep;
			return this;
		}

		public NavigatorParamBuilder setForEntry(EntryType forEntry) {
			this.forEntry = forEntry;
			return this;
		}

		public NavigatorParamBuilder setCallerStepIndicator(
				MainPageTab indicator) {
			this.callerStepIndicator = indicator;
			return this;
		}
		
		public NavigatorParamBuilder setCurrentTab(
				MainPageTab indicator) {
			this.currentTab = indicator;
			return this;
		}
		
		public NavigatorParamBuilder setNewTab(
				MainPageTab indicator) {
			this.newTab = indicator;
			return this;
		}
		
		public void setFacesContext(FacesContext facesContext) {
			this.facesContext = facesContext;
		}


		public NavigatorParamVO createParam() {
			NavigatorParamVO item = new NavigatorParamVO(this.isOnLoadMainStep,
					this.checkSpecialCondition);
			item.setForEntry(forEntry);
			item.setOnLoadSubStep(this.isOnLoadSubStep);
			item.setCallerStepIndicator(this.callerStepIndicator);
			item.setHasSetStatusOnStep(this.hasSetStatusOnStep);
			item.setAction(this.action);
			item.setRequestContext(this.requestContext);
			item.setCurrentTab(this.currentTab);
			item.setNewTab(this.newTab);
			item.setXrflBean(this.xrflBean);
			item.setFacesContext(this.facesContext);
			return item;
		}

	}


	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}
	
}
