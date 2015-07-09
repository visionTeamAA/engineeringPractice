package ch.ivy.sample.bean;

import ch.ivy.sample.enums.MainPageTab;

public class MainTabInfo {
	private MainPageTab currentTab;
	private MainPageTab newTab;
	private MainPageTab oldTab;
	public MainPageTab getCurrentTab() {
		return currentTab;
	}
	public void setCurrentTab(MainPageTab currentTab) {
		this.currentTab = currentTab;
	}
	public MainPageTab getNewTab() {
		return newTab;
	}
	public void setNewTab(MainPageTab newTab) {
		this.newTab = newTab;
	}
	public MainPageTab getOldTab() {
		return oldTab;
	}
	public void setOldTab(MainPageTab oldTab) {
		this.oldTab = oldTab;
	}
	
	
}
