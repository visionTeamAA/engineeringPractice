var DEFAULT_SPLIT_MESSAGE = "|";
var DEFAULT_SPLIT_ITEM = "^";
var XRFL_PLACEHOLDER_SUP_CODE = "1";
var XRFL_PLACEHOLDER_SUP_NAME = "sup";
var XRFL_PLACEHOLDER_EMP_CODE = "2";
var XRFL_PLACEHOLDER_EMP_NAME = "emp";
var XRFL_PLACEHOLDER_COMP_NAME = "comp";

var xrflMainPageTab = {
	EMPLOYEE_DETAIL : 0,
	EMPLOYEE_DETAIL_ID: "xrflEmployeeDetailTab",
	DOCUMENT_TYPE: 1,
	DOCUMENT_TYPE_ID:"xrflDocumentTypeTab",
	TASK: 2,
	TASK_ID: "xrflTaskTab",
	FREE_TEXT:3,
	FREE_TEXT_ID: "xrflFreeTextTab",
	COMPETENCE: 4,
	COMPETENCE_ID: "xrflCompetenceTab",
	DOCUMENT_CREATION:5,
	DOCUMENT_CREATION_ID :"xrflDocumentCreationTab"
};


var submitFlag = false;
$().ready(function() {
	xrflInitialize();
	
});
function xrflInitialize(){
	buildMainNavigator();
	xrflAddLoadEvent(xrflOnLoad);
}
function xrflSetSubmitFlagFalse(){
	submitFlag = false;
}

/*
*
*  createCSSClass()
*  http://www.happycode.info/
*
*/
function createCSSClass(selector, style) {
    if (!document.styleSheets) {
        return;
    }
 
    if (document.getElementsByTagName("head").length == 0) {
        return;
    }
    
    var stylesheet;
    var mediaType;
    if (document.styleSheets.length > 0) {
        for (i = 0; i < document.styleSheets.length; i++) {
            if (document.styleSheets[i].disabled) {
                continue;
            }
            var media = document.styleSheets[i].media;
            mediaType = typeof media;
 
            if (mediaType == "string") {
                if (media == "" || (media.indexOf("screen") != -1)) {
                    styleSheet = document.styleSheets[i];
                }
            } else if (mediaType == "object") {
                if (media.mediaText == "" || (media.mediaText.indexOf("screen") != -1)) {
                    styleSheet = document.styleSheets[i];
                }
            }
 
            if (typeof styleSheet != "undefined") {
                break;
            }
        }
    }
 
    if (typeof styleSheet == "undefined") {
        var styleSheetElement = document.createElement("style");
        styleSheetElement.type = "text/css";
 
        document.getElementsByTagName("head")[0].appendChild(styleSheetElement);
 
        for (i = 0; i < document.styleSheets.length; i++) {
            if (document.styleSheets[i].disabled) {
                continue;
            }
            styleSheet = document.styleSheets[i];
        }
 
        var media = styleSheet.media;
        mediaType = typeof media;
    }
 
    if (mediaType == "string") {
        for (i = 0; i < styleSheet.rules.length; i++) {
            if (styleSheet.rules[i].selectorText.toLowerCase() == selector.toLowerCase()) {
                styleSheet.rules[i].style.cssText = style;
                return;
            }
        }
 
        styleSheet.addRule(selector, style);
    } else if (mediaType == "object") {
        for (i = 0; i < styleSheet.cssRules.length; i++) {
            if (styleSheet.cssRules[i].selectorText.toLowerCase() == selector.toLowerCase()) {
                styleSheet.cssRules[i].style.cssText = style;
                return;
            }
        }
 
        styleSheet.insertRule(selector + "{" + style + "}", 0);
    }
}

function buildMainNavigator(){
	var spanList = '';
	$(".xrfl-main-page-panel ul >li >a" ).each(function(index) {
		spanList =  "<span class='xrfl-ui-steps-number'>"+(index +1)+"</span>" +
					"<span class='xrfl-ui-steps-title'>"+$( this).html()+"</span>" ;		
		if($( this).children() != null && $( this).children().length < 1){
			$( this).html("");
			$(this).append(spanList);
		}
		
	});
	
	var arrow = "<div class='xrfl-ui-arrow'></div>";
	if ($(".xrfl-main-page-panel ul").next('div.xrfl-ui-arrow').length  == 0 ){
		$(".xrfl-main-page-panel ul").after(arrow);	
	}
	
	
	// Set dynamic CSS for separator
	var defaultColor = "#EDF1C0";
	var linkColor = "#EDF1C0";
	
	
	createCSSClass('.xrfl-main-page-panel .xrfl-ui-arrow:before', 'border-color: '+defaultColor +' transparent transparent !important;');
	createCSSClass('.xrfl-main-page-panel .xrfl-ui-arrow', 'border-bottom: ' + defaultColor +' 3px solid !important; ' );
	
	 
	createCSSClass('.xrfl-main-page-panel ul', 'background: ' + defaultColor );
	createCSSClass('.xrfl-main-page-panel ul li.ui-tabs-selected span.xrfl-ui-steps-title', 'color: ' + linkColor );
	createCSSClass('.xrfl-main-page-panel ul li.ui-tabs-selected span.xrfl-ui-steps-number', 'color: ' + linkColor );
	
	
	
}

function buildSubNavigator(){
	if(!xrflCheckObjectExists(xrflGetSubMenuWidgetObj())){
		return false;
	}
	// Set dynamic CSS for separator
	var defaultColor = rgb2hex($(".ui-state-default").css('background-color'));
	//var activeColor = rgb2hex($(".ui-state-active").css('background-color'));
	var activeColor = "#cdcdcd";
	var disabledColor = "#cdcdcd";
	createCSSClass('.xrfl-arrow-left', 'border-bottom: 12px solid transparent; width:0; height: 0; border-top: 12px solid transparent; border-right:12px solid '+defaultColor+' !important;' );
	createCSSClass('.xrfl-arrow-left:hover', 'cursor:pointer;border-bottom: 12px solid transparent; width:0; height: 0; border-top: 12px solid transparent; border-right:12px solid '+activeColor+' !important;' );
	createCSSClass('.xrfl-arrow-left.ui-state-disabled', 'cursor:default;border-bottom: 12px solid transparent; width:0; height: 0; border-top: 12px solid transparent; border-right:12px solid '+disabledColor+' !important;' );
	createCSSClass('.xrfl-arrow-right', 'width: 0; height: 0; border-top: 12px solid transparent; border-bottom: 12px solid transparent; border-left: 12px solid '+defaultColor+'!important;' );
	createCSSClass('.xrfl-arrow-right:hover', 'cursor:pointer;width: 0; height: 0; border-top: 12px solid transparent; border-bottom: 12px solid transparent; border-left: 12px solid '+activeColor+'!important;' );
	createCSSClass('.xrfl-arrow-right.ui-state-disabled', 'cursor:default;border-bottom: 12px solid transparent; width:0; height: 0; border-top: 12px solid transparent; border-left:12px solid '+disabledColor+' !important;' );
	
	xrflRegisterSubNavigatorEvent();
}



function xrflRegisterSubNavigatorEvent(){
	$(".xrfl-arrow-left").on("click", function(){
		xrflGetSubMenuWidgetObj().moveBack();
	});
	
	$(".xrfl-arrow-right").on("click", function(){
		xrflGetSubMenuWidgetObj().moveNext();
	});
}


/**
 * add events to document on load
 * @param func
 */
function xrflAddLoadEvent(func) {
	var oldonload = window.onload;
	if (typeof window.onload != 'function') {
		window.onload = func;
	} else {
		window.onload = function() {
			if (oldonload) {
				oldonload();
			}
			func();
		};
	}
}
/**
 * load event when page just opened
 */
function xrflOnLoad(){
	$(document).on("keydown", xrflHandleRefreshAction);
}

/**
 * check object is existed or not
 * @param obj
 * @returns {Boolean}
 */
function xrflCheckObjectExists(obj){
	if(obj == null || typeof(obj) == 'undefined' || obj.length == 0) {
		return false;
	} else {
		return true;
	}
}

/**
 * check object existed or not by ID
 * @param id
 * @returns
 */
function xrflCheckObjectExistsById(id){
	var obj = $("[id$='"+ id +"']");
	return xrflCheckObjectExists(obj);
}

//hide confirm dialog
function xrflHideCommonDialog() {
	PF('cdCommonDialogVar').hide();
}
function xrflMarkAsError(id){
	var obj = $("[id$='"+ id +"']");
	if(xrflCheckObjectExists(obj)) {
		obj.addClass("ui-state-error");
	}
}
function xrflRemoveErrorStateById(id){
	var obj = $("[id$='"+ id +"']");
	xrflRemoveErrorState(obj);
}
function xrflRemoveErrorState(obj){
	if(xrflCheckObjectHasErrorState(obj)){
		obj.removeClass("ui-state-error");
	}
}

function selectRowTable(tableObject, rowkey) {
	var id = tableObject.id;
	var trs = $("[id='"+ id + "']").find("table").find("tbody").find("tr");
	for(var i = 0;i < trs.length; i++) {
		if(parseInt(trs[i].getAttribute("data-rk")) == rowkey) {
			tableObject.unselectAllRows();
			tableObject.selectRow(i);
			break;
		}
	}
}

function handleSaveCompleteValuation(xhr, status, args){
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			args.errorMessage = args.errorMessage.replace(/%s/g,'/&#92;:*?&quot;<>|');
			xrflDisplayError(args);
			$("[id$='_error']").addClass("ui-message-error");
		}else{
			PF('xrflTranslationDlgVar').hide();
			//PF('xrflValuationTableVar').filter();
		} 
	}
}

function handleDeleteCompleteValuation(xhr, status, args){
	if(args.isValid){
		PF('xrflDeleteValuationDlgVar').hide();
		PF('xrflValuationTableVar').filter();
	}
}

function onShow_ValuationTranslationDlg(){
	 $("[id$='_error']").removeClass("ui-message-error");
	
}
function xrflClearValidation(){
	$(".xrfl-ui-message").each(function(){
		 if($(this).first(".ui-message-error-detail").text() != "") {
			 $(this).hide();
		 	} else{
		 		$(this).show();
		 	}
	 });
}

function onShow_PlaceHolderDlg(){
	 xrflResetForm("xrflPlaceHolderDlgFrm");
	 xrflMaskPlaceHolder();
}

function onShow_ProfessionGroupDlg(){
	 xrflResetForm("xrflProfessionDlgFrm");
	 xrflMaskPlaceHolder();
}

function onShow_ReferenceTypeDlg(){
	xrflClearValidation();
	xrflResetForm("xrflReferenceTypeDlgFrm");
}

function onShow_CompetenceGroupDlg(){
	xrflClearValidation();
	xrflResetForm("xrflCompetenceGroupDlgFrm");
	xrflCompetenceGroupMaskPlaceHolder();
}

function xrflMaskPlaceHolder(){
	var prefixHidden = $("[id$='xrflCategortyRadioGroupHidden']");

	if(xrflCheckObjectExists(prefixHidden)){
		var placeHolderInput = $("[id$='xrflPlaceholderName']");
		if(xrflCheckObjectExists(placeHolderInput)){
			var prefix = prefixHidden.val();
			if(XRFL_PLACEHOLDER_SUP_CODE == prefix){
				prefix = XRFL_PLACEHOLDER_SUP_NAME;
				placeHolderInput.changeInputPrefix(XRFL_PLACEHOLDER_EMP_NAME, XRFL_PLACEHOLDER_SUP_NAME);
			}
			else if(XRFL_PLACEHOLDER_EMP_CODE == prefix){
				prefix = XRFL_PLACEHOLDER_EMP_NAME;
				placeHolderInput.changeInputPrefix(XRFL_PLACEHOLDER_SUP_NAME, XRFL_PLACEHOLDER_EMP_NAME);
			}
			placeHolderInput.maskXRFLInput(prefix, 255);
		}
	}
}

function xrflCompetenceGroupMaskPlaceHolder() {
	var placeHolderInput = $(".xrfl-competence-group-pattern-name");
	if(xrflCheckObjectExists(placeHolderInput)){
		placeHolderInput.maskXRFLInput(XRFL_PLACEHOLDER_COMP_NAME, 255);
	}
}

function xrflResetForm(formId) {
	var idElement = formId;
	if (formId.charAt(0) == "#") {
		idElement = id.substring(1, formId.length);
	}
	
	if ($("[id*='"+idElement+"']").length > 0) {
		$("[id$='"+idElement+"']").children().each(function(){
			resetOneElement(this);
		});
		

	}
}

function resetDocumentTypeStep (){
	resetOneElement($("[id$='xrflReferenceTypeCbo']"));
	resetOneElement($("[id$='xrflProfessionGroupCbo']"));
	resetOneElement($("[id$='xrflReasonOrderingCbo']"));
}

function resetLanguageDocumentTypeStep (){
	resetOneElement($("[id$='xrflAvailableLanguageCbo']"));
	resetOneElement($("[id$='xrflTemplateCbo']"));
}

function resetReferenceTypeDocFields(){
	resetOneElement($("[id$='xrflAvailableLanguage']"));
	resetOneElement($("[id$='xrflReferenceTypeCaptionField']"));
	resetOneElement($("[id$='xrflReferenceTypeIntroductionField']"));
}

function resetOneElement(object){
	var $object = $(object);
	if(!xrflCheckObjectExists(object)){return;}
	if ($object.hasClass("ui-autocomplete-multiple")) {
		$object.find("ul").first().removeClass("ui-state-error");
	} else if ($object.hasClass("ui-autocomplete")) {
		$object.find("input").first().removeClass("ui-state-error");

	} else if ($object.hasClass("ui-selectonemenu")) {
		$object.removeClass("ui-state-error");
		$object.find("div").each(function() {
			if ($(this).hasClass("ui-selectonemenu-trigger")) {
				$(this).removeClass("ui-state-error");
			}
		});
		
		if ($object.find("label.ui-state-error").length > 0 ){
			$object.find("label.ui-state-error").removeClass("ui-state-error");
		}		
		
		// remove class in panel 
		var id = $object.attr("id");
		id = id+"_panel";
		var panel = $("[id$='"+id+"']");		
		if(xrflCheckObjectExists(panel)){
			if (panel.hasClass("ui-state-error")) {
				panel.removeClass("ui-state-error");
			}
		}
		
	} else if ($object.hasClass("ui-selectoneradio")) {
		$object.find("div").each(function() {
			if ($(this).hasClass("ui-radiobutton-box")) {
				$(this).removeClass("ui-state-error");
			}
		});
	} else if($object.hasClass("ui-scrollpanel")){
		$object.removeClass("ui-state-error");
	} else if($object.hasClass("ui-chkbox")){
		$object.find(".ui-chkbox-box").removeClass("ui-state-error");
	} else {
		if ($object.find("input").first().length > 0) {			
			$object.find("input").first()
					.removeClass("ui-state-error");
		} else {				
			$object.removeClass("ui-state-error");
			
		}
	}
	
	// set error message
	if ($object.find(".ui-message-error").length > 0) {
		// //alert(id_error);
		$object.find(".ui-message-error").each(function(){
			$(this).removeClass();
			$(this).html("");
		});
	}else if ($object.siblings('.ui-message-error').length > 0){
		$object.siblings(".ui-message-error").each(function(){
			$(this).removeClass();
			$(this).html("");
		});
	}
		
	
}

function onComplete_ReasonForOrdering(xhr, status, args) {
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			xrflDisplayError(args);
		} 
	}
}

function onCompleteValidation(xhr, status, args) {
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			xrflDisplayError(args);
		} 
	}
}

function onComplete_TranslateText(xhr, status, args) {
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			xrflDisplayError(args);
		} 
	}
	
	xrflMaskPlaceHolder();
	xrflCompetenceGroupMaskPlaceHolder();
}

function onComplete_CompetenceCriteriaSubmit(xhr, status, args) {
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			xrflDisplayError(args);
		} 
	}
	
	xrflMaskPlaceHolder();
	xrflCompetenceGroupMaskPlaceHolder();
	calculateFixedPlaceHolderLayoutWhenScrollingCriteria();
}

function onComplete_ReferenceTypeSubmit(xhr, status, args) {
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			xrflDisplayError(args);
		} 
	}
}

function onComplete_CompetenceGroupSubmit(xhr, status, args){
	if(xrflCheckObjectExists(args)) {
		if (xrflCheckObjectExists(args.isValid) && !args.isValid) {
			xrflDisplayError(args);
		}else{
			PF('xrflCompetenceGroupDlgVar').hide();
		} 
	}
	
	xrflCompetenceGroupMaskPlaceHolder();
}

function xrflDisplayError(args) {
	if (args.isValid == false) {
		var messages = null;
		var splitterItem = DEFAULT_SPLIT_ITEM;
		if(args.isJSON) {
			messages = $.parseJSON(args.errorMessage);
		} else{
			var splitterMessage = args.splitterMessage;
			if (splitterMessage == "") {
				splitterMessage = DEFAULT_SPLIT_MESSAGE;
			}
			splitterItem = args.splitterItem;
			if (splitterItem == "") {
				splitterItem = DEFAULT_SPLIT_ITEM;
			}
			messages = args.errorMessage.split(splitterMessage);
		}
		// <![CDATA[
		var n = messages.length;
		var controlId = "";
		var errorContent = "";
		var customCss = "";
		for ( var i = 0; i < n; i++) {
			if(args.isJSON) {
				controlId = messages[i].controlId;
				errorContent = messages[i].errorContent;
				customCss = messages[i].customCss;
			} else {
				var message = messages[i].split(splitterItem);
				controlId = message[0];
				errorContent = message[1];
				customCss = message[2];
			}
			
			var idElement = "[id*='"+controlId+"']";
			//check object exist
			if(!xrflCheckObjectExistsById(controlId)){
				//change to use class
				idElement = "."+controlId;
			}
			
			if ($(idElement).length == 0) {
				continue;
			}
			
			xrflChangeStateForMainElement(idElement);
			xrflAddErrorMessage(controlId, errorContent, customCss);
		}
		// ]]>
	}
}

function xrflAddErrorMessage(controlId, errorContent, customCss){
	var id_error;
	var id_lbl;
	id_lbl = "[id*='"+controlId+ "_lbl"+"']"; 
	id_error = "[id*='"+controlId+ "_error"+"']"; 
	//check object exist
	if(!xrflCheckObjectExistsById(controlId+"_lbl")){
		//change to use class
		id_lbl = "."+controlId + "_lbl";
	}
	if(!xrflCheckObjectExistsById(controlId + "_error")){
		//change to use class
		id_error = "."+controlId + "_error";
	}
	
	// set error state for label
	if ($(id_lbl).length > 0) {
		$(id_lbl).addClass("ui-state-error");
	}

	// set error message
	if ($(id_error).length > 0) {
		$(id_error)
				.addClass("ui-message-error ui-widget ui-corner-all").removeClass("ui-state-error");
		$(id_error).html(
				"<span class='ui-message-error-detail'>" + errorContent
						+ "</span>");
		// add custom css
		if (customCss != null && customCss != 'undefined') {
			$(id_error).addClass(customCss);
		}
		$(id_error).show();
	}
}

function xrflChangeStateForMainElement(idElement){
	if ($(idElement).hasClass("ui-autocomplete-multiple")) {
		$(idElement).find("ul").first().addClass("ui-state-error");
	} else if($(idElement).hasClass("ui-autocomplete")){
		$(idElement).find("input").first().addClass("ui-state-error");
		
	} else if($(idElement).hasClass("ui-selectonemenu")){
		$(idElement).addClass("ui-state-error");
		$(idElement).find("div").each(function(){
			if($(this).hasClass("ui-selectonemenu-trigger")) {
				$(this).addClass("ui-state-error");
			}
		});
	} else if($(idElement).hasClass("ui-selectoneradio")){
		$(idElement).find("div").each(function(){
			if($(this).hasClass("ui-radiobutton-box")) {
				$(this).addClass("ui-state-error");
			}
		});
	} else if($(idElement).hasClass("ui-scrollpanel")){
		$(idElement).addClass("ui-state-error");
	} else if($(idElement).hasClass("ui-inputtextarea")) {
		$(idElement).addClass("ui-state-error");
	} else if($(idElement).hasClass("ui-chkbox")){
		$(idElement).find(".ui-chkbox-box").addClass("ui-state-error");
	}else {
		if($(idElement).find("input").first().length > 0) {
			$(idElement).find("input").first().addClass("ui-state-error");
			if($(idElement).hasClass("xrfl-combine-inputField")){
				$(idElement).addClass("ui-state-error");
			}
		} else {
			$(idElement).addClass("ui-state-error");
		}
	}
}

function onShow_CompetenceCriteriaDlg(){
	xrflClearValidation();
	xrflResetForm("xrflCompetenceCriteriaDlgFrm");
	calculateFixedPlaceHolderLayoutWhenScrollingCriteria();
}

function calculateFixedPlaceHolderLayoutWhenScrollingCriteria(){
	$("[id$='xrflCompetenceCriteriaDlgScroll']").bind('scroll', function() {
		   var scrollerHeight = $("[id$='xrflCompetenceCriteriaDlgScroll']").outerHeight(true);
	       var scrollVal = $("[id$='xrflCompetenceCriteriaDlgScroll']").scrollTop();
	       var top = 0;
	        if ( scrollVal > (scrollerHeight - 50)) {//50: height of the elments above
	        	top = scrollVal - (scrollerHeight - 50);
	            $('.xrfl-criteria-placeholder').css({'position':'absolute','right':'2em','top' :top+'px'});
	        } else {
	            $('.xrfl-criteria-placeholder').css({'position':'static','top':'0px'});
	        }
	});
}

function onShow_ReasonForOrderingDlg(){
	xrflClearValidation();
	xrflResetForm("xrflReasonForOrderingDlgFrm");
} 


function addClassIfNotExist(obj, className){
	if(!$(obj).hasClass(className)){
		$(obj).addClass(className);
	}
}

function ignoreTrackingDataChangeForDocumentCreation(){
	var hiddenCarousel = $(".xrfl-competence-group-carousel input");
	var ignoreCheckClass = "ignoreCheck";
	if(xrflCheckObjectExists(hiddenCarousel)){
		addClassIfNotExist(hiddenCarousel, ignoreCheckClass);
	}
}

function prepareRequestData(tabIndex){
	if(tabIndex == 0){
		$("[id$='empFunctionFreeTextInput']").val($("[id$='empFunctionInput_input']").val());
		$("[id$='supFunctionFreeTextInput']").val($("[id$='supFunctionInput_input']").val());
	}
}

function xrflPopulateFunctionForEmployeeDetail(){
	if($("[id$='supFunctionInput_input']").val().length == 0){
		$("[id$='supFunctionInput_input']").val($("[id$='supFunctionFreeTextInput']").val());
	}
}

function updateEmployeeDetailStep(){
	var validateBtn =$("[id$='xrflValidateBtn']");
	if(xrflCheckObjectExists(validateBtn)){
		validateBtn.click();
	}	
}

function openRequestTaskDescriptionEditor(requestTaskId) {
	var $editButton = $('.xrfl-edit-id-' + requestTaskId + ' .ui-row-editor .ui-icon-pencil');
	var $text = $('.xrfl-text-id-' + requestTaskId + ' .ui-cell-editor textarea');
	$editButton.click();
	$text.val('');
	setTimeout(function () {$text.focus();}, 500);
}

function handleEditingRequestTask(datatableWidgetVar, errorMessage) {
	setTimeout(function () {
		var requestTaskId = datatableWidgetVar.selection[0];
		var $text = $('.xrfl-text-id-' + requestTaskId + ' textarea');
		var $okBtn = $('.xrfl-edit-id-' + requestTaskId + ' .ui-icon-check');
		var $message = $('.xrfl-text-id-' + requestTaskId + ' .ui-message');
		// do validate before submit
		$okBtn.on('click', function (ev) {
			if ($.trim($text.val()) == '') {
				$text.addClass('ui-state-error');
				$message.addClass('ui-message-error ui-widget ui-corner-all');
				$message.text(errorMessage);
				ev.preventDefault();
				return false;
			}
			else {
				$text.removeClass('ui-state-error');
				$message.removeClass('ui-message-error ui-widget ui-corner-all');
				$message.text("");
			}
		});
		// submit when Enter
		$text.on('keydown', function (ev) {
			if (ev.keyCode == 13) {
				ev.preventDefault();
				$okBtn.click();
				return false;
			}
		});
		// off other edit buttons
		$('[class*="xrfl-edit-id"] .ui-row-editor .ui-icon-pencil').on('click', function (ev) {return false;});
		// off drag and drop
		datatableWidgetVar.tbody.sortable('disable');
	}, 500);
}

function xrflMakeEffectOnLoad(){
	var requestEmpDetail = $("[id$='xrflRequestEmpDetail']");
	if(xrflCheckObjectExists(requestEmpDetail)){
		if(requestEmpDetail.html() != ""){
			requestEmpDetail.fadeIn( "slow", function() {});
		}
	}
}

function xrflHandleRefreshAction(e){
	/*if ((e.which || e.keyCode) == 116 ||  (e.keyCode == 82 && e.ctrlKey)){
		var mainTabPanel = $("[id$='xrflMainTabPanel']");
		if(xrflCheckObjectExists(mainTabPanel)){
			reloadCurrentStep();
			e.preventDefault();
		}
	}*/
}

function xrflGetStepId(code){
	switch(code){
	case xrflMainPageTab.EMPLOYEE_DETAIL:
		return xrflMainPageTab.EMPLOYEE_DETAIL_ID;
	case xrflMainPageTab.DOCUMENT_TYPE:
		return xrflMainPageTab.DOCUMENT_TYPE_ID;
	case xrflMainPageTab.TASK:
		return xrflMainPageTab.TASK_ID;
	case xrflMainPageTab.FREE_TEXT:
		return xrflMainPageTab.FREE_TEXT_ID;
	case xrflMainPageTab.COMPETENCE:
		return xrflMainPageTab.COMPETENCE_ID;
	case xrflMainPageTab.DOCUMENT_CREATION:
		return xrflMainPageTab.DOCUMENT_CREATION_ID;
	default:
	}
}
function xrflUpdateMainStatus(stepIdx, statusCode){
	var stepObjId = xrflGetStepId(parseInt(stepIdx));
	var stepObj = $("[href$='"+stepObjId+"']");
	if(xrflCheckObjectExists(stepObj)){
		var parentOfStep = $(stepObj).parent();
		xrflRemoveClass(parentOfStep, xrflStepStatus.FINISH_CLASS);
		xrflRemoveClass(parentOfStep, xrflStepStatus.UNTOUCHED_CLASS);
		xrflRemoveClass(parentOfStep, xrflStepStatus.START_CLASS);
		xrflRemoveClass(parentOfStep, xrflStepStatus.WARNING_CLASS);
		var code = parseInt(statusCode);
		var statusClass = xrflGetStatusClass(code);
		parentOfStep.addClass(statusClass);
	}
}

function clickDownloadButton(){
	$('.xrfl-download-document-btn').click();
}

function xrflMarkErrorSelectOneMenu(elementId) {
	var $element = $("[id$='" + elementId + "']");
	$element.addClass("ui-state-error");
	$element.find(".ui-state-default").addClass("ui-state-error");
}

function xrflSetErrorMessage(elementId, text) {
	var $element = $("[id$='" + elementId + "_error']");
	$element.addClass("ui-message-error");
	$element.text(text);
}

function xrflHandleGeneralSettingValidation(result) {
	$.each(result, function(index, value) {
		xrflMarkErrorSelectOneMenu(value.elementId);
		xrflSetErrorMessage(value.elementId, value.message);
	});
}

function xrflKeepWaterMarkAutoComplete(){
	var obj = $("[id$='xrflEmployeeSearchInput_input']");
	if(xrflCheckObjectExists(obj)) {
		var msg = $("[id$='xrflEmployeeSearchWaterMark']");		
		obj.watermark(msg.text(), {className: 'xrft-watermark'});
	}
}