package vn.axon.vision.test.navigator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.NavigatorParamVO.NavigatorParamBuilder;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.RequestDocumentTypeStep;
import ch.ivy.sample.bean.RequestEmployeeDetailStep;
import ch.ivy.sample.dto.RequestDocumentTypeDTO;
import ch.ivy.sample.enums.EntryType;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivy.sample.navigator.NavigatorManager;
import ch.ivy.sample.service.AvailableLanguageService;

public class NavigatorManagerTest {
	@Test
	public void shouldGetAllValuesInStep3() throws BusinessException{
		NavigatorParamVO navigatorParamVO = buildNavigatorParamOfStep1();
		NavigatorManager referenceNavigator = NavigatorManager.createInstance();
		referenceNavigator.next(navigatorParamVO);
		referenceNavigator.switchTab(changeNavigatorParamOfStep2(navigatorParamVO));
		assertTrue(navigatorParamVO.getXrflBean().getDocumentCreation().getStepStatus() == StepStatus.FINISHED);
//		assertTrue(navigatorParamVO.getXrflBean().getDocumentCreation().getDisplayDocLanguages().equalsIgnoreCase("english"));
	}
	
	private NavigatorParamVO buildNavigatorParamOfStep1(){
		ReferenceLetterRequestBean bean = new ReferenceLetterRequestBean();
		bean.init();
		RequestEmployeeDetailStep requestEmployeeDetailStep = new RequestEmployeeDetailStep();
		requestEmployeeDetailStep.setFirstName("Huong");
		requestEmployeeDetailStep.setLastName("Nguyen");
		requestEmployeeDetailStep.setStepStatus(StepStatus.UNTOUCHED);
		bean.setEmployeeDetailStep(requestEmployeeDetailStep);
		return NavigatorParamBuilder.createBuilder()
				.setForEntry(EntryType.OLD_ENTRY)
				.setOnLoadMainStep(false)
				.setCheckSpecialCondition(false)
				.setOnLoadSubStep(false)
			.setCurrentTab(ch.ivy.sample.enums.MainPageTab.findBy(MainPageTab.EMPLOYEE_DETAIL.getIndex()))
			.setXrflBean(bean)
			.createParam();
	}
	
	private NavigatorParamVO changeNavigatorParamOfStep2(NavigatorParamVO navigatorParamVO){
		ReferenceLetterRequestBean bean = navigatorParamVO.getXrflBean();
		RequestDocumentTypeDTO requestDocumentTypeDTO = new RequestDocumentTypeDTO();
		requestDocumentTypeDTO.setDocLanguage("EN");
		RequestDocumentTypeStep requestDocumentTypeStep = new RequestDocumentTypeStep();
		requestDocumentTypeStep.setRequestDocumentType(requestDocumentTypeDTO);
		
		AvailableLanguageService availableLanguageService = new AvailableLanguageService();
		requestDocumentTypeStep.setAvailableLanguages(availableLanguageService.getAvailableLanguages());
		requestDocumentTypeStep.setStepStatus(StepStatus.UNTOUCHED);
		bean.setDocumentTypeStep(requestDocumentTypeStep);
		
		return NavigatorParamBuilder.createBuilder()
				.setForEntry(EntryType.OLD_ENTRY)
				.setOnLoadMainStep(true)
				.setCheckSpecialCondition(false)
				.setOnLoadSubStep(false)
			.setCurrentTab(ch.ivy.sample.enums.MainPageTab.findBy(MainPageTab.DOCUMENT_TYPE.getIndex()))
			.setXrflBean(bean)
			.createParam();
	}
}
