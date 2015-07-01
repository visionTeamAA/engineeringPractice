package ch.ivy.sample.navigator;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.bean.NavigatorParamVO;
import ch.ivy.sample.bean.ReferenceLetterRequestBean;
import ch.ivy.sample.bean.ResponseData;
import ch.ivy.sample.bean.ValidationMessages;
import ch.ivy.sample.enums.Action;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.enums.StepStatus;
import ch.ivyteam.ivy.environment.EnvironmentNotAvailableException;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.persistence.PersistencyException;

public class DocumentTypeNavigator extends AbstractReferenceNavigator {
	private static final String XRFL_TEMPLATE_CBO = "xrflTemplateCbo";
	private static final String XRFL_AVAILABLE_LANGUAGE_CBO = "xrflAvailableLanguageCbo";
	private static final String XRFL_REASON_ORDERING_CBO = "xrflReasonOrderingCbo";
	private static final String XRFL_PROFESSION_GROUP_CBO = "xrflProfessionGroupCbo";
	private static final String XRFL_REFERENCE_TYPE_CBO = "xrflReferenceTypeCbo";
	private static final long serialVersionUID = 3308872462947776468L;
	private static final String COMBOBOX_SMALL_ERROR = "combobox_small_error";
	
	private Long oldReferenceTypeId;
	private Long oldProfessionId;
	private String oldDocLanguage;
	
	public DocumentTypeNavigator(MainPageTab step){
		this.stepIndicator = step;
		this.subStepIndex = -1;
		this.hasSubMenu = false;
		this.message = new ValidationMessages();
	}

	@Override
	protected ReferenceLetterRequestBean doLoad(
			ReferenceLetterRequestBean bean, Action action)
			throws BusinessException {
		return null;
	}

	@Override
	protected void doNext(ReferenceLetterRequestBean bean)
			throws BusinessException {
		
	}

	@Override
	protected void doBack(ReferenceLetterRequestBean bean)
			throws BusinessException {
		
	}

	@Override
	protected void doValidate(ReferenceLetterRequestBean bean,
			ResponseData response, NavigatorParamVO additionalParam)
			throws BusinessException {
		
	}

	@Override
	protected void doSaveSwitchTab(ReferenceLetterRequestBean bean)
			throws BusinessException {
		
	}

	@Override
	protected void doSaveAsDraft(ReferenceLetterRequestBean bean)
			throws BusinessException {
		
	}

	@Override
	protected StepStatus getStepStatus(ReferenceLetterRequestBean bean) {
		return null;
	}
	
	
}
