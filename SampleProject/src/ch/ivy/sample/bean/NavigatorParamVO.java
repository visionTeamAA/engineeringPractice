package ch.ivy.sample.bean;

import ch.ivy.sample.enums.EntryType;
import ch.ivy.sample.enums.MainPageTab;




public final class NavigatorParamVO {
	
	private boolean isOnLoadMainStep;
	private boolean checkSpecialCondition;
	private EntryType forEntry;
	private boolean isOnLoadSubStep;
	private MainPageTab callerStepIndicator;
	private boolean hasSetStatusOnStep;

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

	public final static class NavigatorParamBuilder {
		private boolean isOnLoadMainStep;
		private boolean checkSpecialCondition;
		private EntryType forEntry;
		private boolean isOnLoadSubStep;
		private MainPageTab callerStepIndicator;
		private boolean hasSetStatusOnStep;

		private NavigatorParamBuilder() {
			this.isOnLoadMainStep = false;
			this.checkSpecialCondition = false;
			this.forEntry = EntryType.UNKNOWN;
			this.callerStepIndicator = MainPageTab.UNKNOWN;
			this.hasSetStatusOnStep = true;
		}

		public static NavigatorParamBuilder createBuilder() {
			return new NavigatorParamBuilder();
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

		public NavigatorParamVO createParam() {
			NavigatorParamVO item = new NavigatorParamVO(this.isOnLoadMainStep,
					this.checkSpecialCondition);
			item.setForEntry(forEntry);
			item.setOnLoadSubStep(this.isOnLoadSubStep);
			item.setCallerStepIndicator(this.callerStepIndicator);
			item.setHasSetStatusOnStep(this.hasSetStatusOnStep);
			return item;
		}

	}
	
}
