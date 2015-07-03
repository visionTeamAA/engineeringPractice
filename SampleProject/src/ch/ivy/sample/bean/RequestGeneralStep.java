package ch.ivy.sample.bean;

import java.util.Observable;

import ch.ivy.sample.enums.StepStatus;


public abstract class RequestGeneralStep extends Observable {
	
	protected StepStatus stepStatus = StepStatus.UNTOUCHED;
	
	public StepStatus getStepStatus() {
		return stepStatus;
	}

	public void setStepStatus(StepStatus stepStatus) {
		this.stepStatus = stepStatus;
	}
}
