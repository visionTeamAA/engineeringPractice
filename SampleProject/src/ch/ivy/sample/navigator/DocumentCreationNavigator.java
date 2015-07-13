package ch.ivy.sample.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.TransferData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.dto.AvailableLanguageDTO;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivyteam.ivy.environment.Ivy;

public class DocumentCreationNavigator extends AbstractReferenceNavigator {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DocumentCreationNavigator(MainPageTab step){
		this.stepIndicator = step;
		this.subStepIndex = -1;
		this.message = new ValidationMessages();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doLoad(NavigatorParamVO param)
			throws BusinessException {
		Ivy.log().info("DoLoad:" + this.getClass().getName());
		final String doclang = param.getXrflBean().getDocumentTypeStep().getRequestDocumentType().getDocLanguage(); 
		Collection<AvailableLanguageDTO> selectedLang= CollectionUtils.select(param.getXrflBean().getDocumentTypeStep().getAvailableLanguages(), new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				AvailableLanguageDTO obj = (AvailableLanguageDTO) arg0;
				return obj.getCode().equalsIgnoreCase(doclang);
			}
		});
		List<AvailableLanguageDTO> result = new ArrayList<AvailableLanguageDTO>(selectedLang);
		if(CollectionUtils.isNotEmpty(result)){
			param.getXrflBean().getDocumentCreation().setDisplayDocLanguages(result.get(0).getDescription());
		}
	}

	@Override
	protected void doNext(NavigatorParamVO param) throws BusinessException {
		Ivy.log().info("doNext:" + this.getClass().getName());
		
	}

	@Override
	protected void doBack(NavigatorParamVO param) throws BusinessException {
		Ivy.log().info("doBack" + this.getClass().getName());
		
	}

	@Override
	protected void doValidate(NavigatorParamVO param, TransferData transferData)
			throws BusinessException {
		Ivy.log().info("doValidate:" + this.getClass().getName());
		if(param.getXrflBean().getEmployeeDetailStep().getStepStatus().equals(StepStatus.FINISHED) 
				&& param.getXrflBean().getDocumentTypeStep().getStepStatus().equals(StepStatus.FINISHED)){
			param.getXrflBean().getDocumentCreation().setStepStatus(StepStatus.FINISHED);
		} else{
			param.getXrflBean().getDocumentCreation().setStepStatus(StepStatus.WARNING);
		}
		updateStatusStep3(param);
	}

	@Override
	protected void doSaveSwitchTab(NavigatorParamVO param)
			throws BusinessException {
		Ivy.log().info("doSaveSwitchTab:" + this.getClass().getName());
		
	}

	@Override
	protected StepStatus getStepStatus(NavigatorParamVO param) {
		Ivy.log().info("getStepStatus:" + this.getClass().getName());
		return null;
	}

	
	
	
}
