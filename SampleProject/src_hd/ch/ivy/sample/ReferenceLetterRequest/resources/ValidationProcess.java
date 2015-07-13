package ch.ivy.sample.ReferenceLetterRequest.resources;

import ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData;
import ch.ivy.sample.bean.BusinessException;
import ch.ivy.sample.enums.MainPageTab;
import ch.ivy.sample.helper.XrflUserProcessExtension;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.engine.IRequestId;
import ch.ivyteam.ivy.scripting.language.IIvyScriptContext;
import ch.ivyteam.ivy.scripting.objects.CompositeObject;

public class ValidationProcess extends XrflUserProcessExtension {

	@Override
	public void run(IRequestId requestId, CompositeObject in, IIvyScriptContext context) throws BusinessException {
		ReferenceLetterRequestData data = (ReferenceLetterRequestData) in;
		
		Ivy.log().info("onClickValidation.");
		Ivy.log().info("Request bean: " + data.getNavigatorParam().getXrflBean());
		Ivy.log().info("Employee detail: " + data.getNavigatorParam().getXrflBean().getEmployeeDetailStep());
		Ivy.log().info("Name: " + data.getNavigatorParam().getXrflBean().getEmployeeDetailStep().getFirstName());
		Ivy.log().info("Family name: " + data.getNavigatorParam().getXrflBean().getEmployeeDetailStep().getLastName());
		
		data.getReferenceNavigator().validate(data.getNavigatorParam(), data.getTransferData());
		//data.getTransferData().sendValidationResults(data.getNavigatorParam().getRequestContext(), MainPageTab.findBy(data.getActiveTabIndex()), true);
		data.getTransferData().setNeedToValidate(true);
	}

}
