package ch.ivy.sample.bean;

import org.apache.http.protocol.RequestContent;

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
	private MainTabInfo tabInfo;
	private ReferenceLetterRequestBean xrflBean;
	private RequestContent requestContext;
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

	public MainTabInfo getTabInfo() {
		return tabInfo;
	}

	public void setTabInfo(MainTabInfo tabInfo) {
		this.tabInfo = tabInfo;
	}
	public ReferenceLetterRequestBean getXrflBean() {
		return xrflBean;
	}

	public void setXrflBean(ReferenceLetterRequestBean xrflBean) {
		this.xrflBean = xrflBean;
	}

	public RequestContent getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(RequestContent requestContext) {
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
		private MainTabInfo tabInfo;
		private ReferenceLetterRequestBean xrflBean;
		private RequestContent requestContext;
		private Action action;
		
		private NavigatorParamBuilder() {
			this.isOnLoadMainStep = false;
			this.checkSpecialCondition = false;
			this.forEntry = EntryType.UNKNOWN;
			this.callerStepIndicator = MainPageTab.UNKNOWN;
			this.hasSetStatusOnStep = true;
			this.tabInfo = new MainTabInfo();
		}

		public static NavigatorParamBuilder createBuilder() {
			return new NavigatorParamBuilder();
		}
		
		public NavigatorParamBuilder setHasSetStatusOnStep(boolean hasSetStatusOnStep) {
			this.hasSetStatusOnStep = hasSetStatusOnStep;
			return this;
		}

		public NavigatorParamBuilder setTabInfo(MainTabInfo tabInfo) {
			this.tabInfo = tabInfo;
			return this;
		}

		public NavigatorParamBuilder setXrflBean(ReferenceLetterRequestBean xrflBean) {
			this.xrflBean = xrflBean;
			return this;
		}

		public NavigatorParamBuilder setRequestContext(RequestContent requestContext) {
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
		
		public NavigatorParamBuilder setCurrentTabIndicator(
				MainPageTab indicator) {
			this.tabInfo.setCurrentTab(indicator);
			return this;
		}
		
		public NavigatorParamBuilder setOldTabIndicator(
				MainPageTab indicator) {
			this.tabInfo.setOldTab(indicator);
			return this;
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
			item.setTabInfo(this.tabInfo);
			item.setXrflBean(this.xrflBean);
			return item;
		}

	}
	
}
