package ch.ivy.sample.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import ch.ivy.sample.bean.ConstantVariable;
import ch.ivy.sample.bean.ValidationItem;
import ch.ivy.sample.bean.ValidationItem.ValidationItemBuilder;


public class ValidationUtils {
	private static final String IS_JSON = "isJSON";
	private static final String CUSTOM_CSS = "customCss";
	private static final String ERROR_CONTENT = "errorContent";
	private static final String CONTROL_ID = "controlId";
	private static final String ERROR_MESSAGE = "errorMessage";
	private static final String IS_VALID = "isValid";
	private static final String DEFAULT_SPLIT_ITEM = "^";
	private static final String DEFAULT_SPLIT_MESSAGE = "|";
	private static final String DIGIT_PATTERN = ".*\\D.*";
	private String errorString;
	private String splitterBetweenMessage;
	private String splitterBetweenItem;
	private List<ValidationItem> validationItems;

	public ValidationUtils() {
		this.errorString = ConstantVariable.EMPTY_STRING;
		this.splitterBetweenMessage = DEFAULT_SPLIT_MESSAGE;
		this.splitterBetweenItem = DEFAULT_SPLIT_ITEM;
		this.validationItems = new ArrayList<ValidationItem>();
	}

	public ValidationUtils(String splitterBetweenMessage,
			String splitterBetweenItem) {
		this.errorString = ConstantVariable.EMPTY_STRING;
		this.splitterBetweenMessage = splitterBetweenMessage;
		this.splitterBetweenItem = splitterBetweenItem;
	}

	public void addMessage(String controlId, String errorContent) {
		if (controlId.isEmpty() || errorContent.isEmpty()) {
			return;
		}
		if (!this.errorString.isEmpty()) {
			this.errorString += splitterBetweenMessage;
		}
		controlId = controlId.replace(ConstantVariable.COLON, ConstantVariable.COLON_QUOTE);
		this.errorString += controlId;
		this.errorString += splitterBetweenItem;
		this.errorString += errorContent;
		
		ValidationItemBuilder itemBuilder = new ValidationItemBuilder(controlId, errorContent);
		this.validationItems.add(itemBuilder.createValidationItem());
	}

	public void setSplitter(String splitterBetweenMessage,
			String splitterBetweenItem) {
		this.splitterBetweenMessage = splitterBetweenMessage;
		this.splitterBetweenItem = splitterBetweenItem;
	}

	public void addMessage(String controlId, String errorContent,
			String customCss) {
		if (controlId.isEmpty() || errorContent.isEmpty()) {
			return;
		}
		if (!this.errorString.isEmpty()) {
			this.errorString += splitterBetweenMessage;
		}

		controlId = controlId.replace(ConstantVariable.COLON, ConstantVariable.COLON_QUOTE);

		this.errorString += controlId;
		this.errorString += splitterBetweenItem;
		this.errorString += errorContent;
		ValidationItemBuilder itemBuilder = new ValidationItemBuilder(controlId, errorContent);
	
		if (!customCss.isEmpty()) {
			this.errorString += splitterBetweenItem;
			this.errorString += customCss;
			itemBuilder.setCustomCss(customCss);
		}
		
		this.validationItems.add(itemBuilder.createValidationItem());

	}
	public void removeValidationItem(String controlId){
		Iterator<ValidationItem> itemsIterator = this.validationItems.iterator();
		while(itemsIterator.hasNext()){
			ValidationItem item = itemsIterator.next();
			if(item.getControlId().contains(controlId)){
				itemsIterator.remove();
			}
		}
	}
	
	public String generateErrorStringAsJSONSupport(){
		if(CollectionUtils.isEmpty(validationItems)){
			return ConstantVariable.EMPTY_STRING;
		}
		JSONObject errorObject = null;
		JSONArray errorArray = new JSONArray();
		try{
			for(ValidationItem item : this.validationItems){
				errorObject = new JSONObject();
				errorObject.put(CONTROL_ID, item.getControlId());
				errorObject.put(ERROR_CONTENT, item.getErrorContent());
				errorObject.put(CUSTOM_CSS, item.getCssClass());
				errorArray.put(errorObject);
			}
		}catch (JSONException je) {
			return ConstantVariable.EMPTY_STRING;
		}
		return errorArray.toString();
	}
	public String getErrorString() {
		return errorString;
	}

	public boolean isValidForm() {
		return this.errorString.isEmpty();
	}
	public void clear(){
		this.errorString = ConstantVariable.EMPTY_STRING;
	}
	
	public void sendErrorWithJSONSupport(RequestContext context, boolean isClearErrorAfterSending) {
		if (this.errorString.isEmpty() || CollectionUtils.isEmpty(validationItems)) {
			context.addCallbackParam(IS_VALID, true);
		} else {
			String jsonError = generateErrorStringAsJSONSupport();
			if(!jsonError.isEmpty()){
				context.addCallbackParam(IS_VALID, false);
				context.addCallbackParam(ERROR_MESSAGE, jsonError);
				context.addCallbackParam(IS_JSON, true);
			} else{
				context.addCallbackParam(IS_VALID, true);
			}
			
			if (isClearErrorAfterSending){
				this.errorString = ConstantVariable.EMPTY_STRING;
				this.validationItems.clear();
			}
		}
	}
	
	public static Boolean isNotNumber(String number){
		Pattern digitattern = Pattern.compile(ValidationUtils.DIGIT_PATTERN);
		Matcher digitMatcher = digitattern.matcher(number);
		return digitMatcher.matches();
	}
}
