[Ivy]
[>Created: Thu Jul 09 13:54:49 ICT 2015]
14E47CF40CA27A1E 3.17 #module
>Proto >Proto Collection #zClass
Rs0 ReferenceLetterRequestProcess Big #zClass
Rs0 RD #cInfo
Rs0 #process
Rs0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
Rs0 @TextInP .rdData2UIAction .rdData2UIAction #zField
Rs0 @TextInP .resExport .resExport #zField
Rs0 @TextInP .type .type #zField
Rs0 @TextInP .processKind .processKind #zField
Rs0 @AnnotationInP-0n ai ai #zField
Rs0 @MessageFlowInP-0n messageIn messageIn #zField
Rs0 @MessageFlowOutP-0n messageOut messageOut #zField
Rs0 @TextInP .xml .xml #zField
Rs0 @TextInP .responsibility .responsibility #zField
Rs0 @RichDialogInitStart f0 '' #zField
Rs0 @RichDialogProcessEnd f1 '' #zField
Rs0 @RichDialogMethodStart f3 '' #zField
Rs0 @RichDialogProcessEnd f4 '' #zField
Rs0 @GridStep f6 '' #zField
Rs0 @PushWFArc f7 '' #zField
Rs0 @PushWFArc f2 '' #zField
Rs0 @GridStep f8 '' #zField
Rs0 @PushWFArc f9 '' #zField
Rs0 @PushWFArc f5 '' #zField
Rs0 @RichDialogProcessStart f10 '' #zField
Rs0 @RichDialogProcessEnd f11 '' #zField
Rs0 @RichDialogProcessStart f13 '' #zField
Rs0 @RichDialogProcessEnd f14 '' #zField
Rs0 @PushWFArc f15 '' #zField
Rs0 @RichDialogProcessStart f16 '' #zField
Rs0 @RichDialogProcessStart f19 '' #zField
Rs0 @RichDialogProcessEnd f20 '' #zField
Rs0 @PushWFArc f21 '' #zField
Rs0 @GridStep f22 '' #zField
Rs0 @PushWFArc f23 '' #zField
Rs0 @GridStep f24 '' #zField
Rs0 @PushWFArc f25 '' #zField
Rs0 @PushWFArc f12 '' #zField
Rs0 @GridStep f26 '' #zField
Rs0 @PushWFArc f27 '' #zField
Rs0 @PushWFArc f18 '' #zField
>Proto Rs0 Rs0 ReferenceLetterRequestProcess #zField
Rs0 f0 guid 14E47CF40FE8C4EA #txt
Rs0 f0 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f0 method start() #txt
Rs0 f0 disableUIEvents true #txt
Rs0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
Rs0 f0 outParameterDecl '<> result;
' #txt
Rs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
Rs0 f0 139 51 26 26 -16 15 #rect
Rs0 f0 @|RichDialogInitStartIcon #fIcon
Rs0 f1 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f1 139 307 26 26 0 12 #rect
Rs0 f1 @|RichDialogProcessEndIcon #fIcon
Rs0 f3 guid 14E47DF7F29A72BC #txt
Rs0 f3 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f3 method onTabChange(org.primefaces.event.TabChangeEvent) #txt
Rs0 f3 disableUIEvents false #txt
Rs0 f3 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<org.primefaces.event.TabChangeEvent event> param = methodEvent.getInputArguments();
' #txt
Rs0 f3 outParameterDecl '<> result;
' #txt
Rs0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>onTabChange(TabChangeEvent)</name>
    </language>
</elementInfo>
' #txt
Rs0 f3 539 75 26 26 16 0 #rect
Rs0 f3 @|RichDialogMethodStartIcon #fIcon
Rs0 f4 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f4 539 299 26 26 16 0 #rect
Rs0 f4 @|RichDialogProcessEndIcon #fIcon
Rs0 f6 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f6 actionTable 'out=in;
' #txt
Rs0 f6 actionCode 'import ch.ivy.sample.navigator.NavigatorManager;
in.activeTabIndex = 0;
in.activeTabIndexTemporary = 0;
in.referenceNavigator = NavigatorManager.createInstance();
' #txt
Rs0 f6 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f6 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>default value</name>
        <nameStyle>13,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f6 96 170 112 44 -34 -8 #rect
Rs0 f6 @|StepIcon #fIcon
Rs0 f7 expr out #txt
Rs0 f7 152 77 152 170 #arcP
Rs0 f2 expr out #txt
Rs0 f2 152 214 152 307 #arcP
Rs0 f8 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f8 actionTable 'out=in;
' #txt
Rs0 f8 actionCode 'import ch.ivy.sample.enums.MainPageTab;
if(in.activeTabIndexTemporary == MainPageTab.EMPLOYEE_DETAIL.index){
	in.activeTabIndexTemporary = MainPageTab.EMPLOYEE_DETAIL.index;

} else {
	in.activeTabIndexTemporary == MainPageTab.DOCUMENT_TYPE.index;
}

	in.activeTabIndex = in.activeTabIndexTemporary;
	
	ivy.log.info(in.activeTabIndexTemporary.toString() +"-"+ in.activeTabIndex);' #txt
Rs0 f8 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f8 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>get active index</name>
        <nameStyle>16,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f8 496 194 112 44 -41 -8 #rect
Rs0 f8 @|StepIcon #fIcon
Rs0 f9 expr out #txt
Rs0 f9 552 101 552 194 #arcP
Rs0 f5 expr out #txt
Rs0 f5 552 238 552 299 #arcP
Rs0 f10 guid 14E5220A88C69699 #txt
Rs0 f10 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f10 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f10 actionTable 'out=in;
' #txt
Rs0 f10 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>onClickNext</name>
    </language>
</elementInfo>
' #txt
Rs0 f10 755 83 26 26 -32 12 #rect
Rs0 f10 @|RichDialogProcessStartIcon #fIcon
Rs0 f11 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f11 755 515 26 26 0 12 #rect
Rs0 f11 @|RichDialogProcessEndIcon #fIcon
Rs0 f13 guid 14E5220B34C6DF6E #txt
Rs0 f13 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f13 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f13 actionTable 'out=in;
' #txt
Rs0 f13 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>onValidate</name>
    </language>
</elementInfo>
' #txt
Rs0 f13 1187 99 26 26 -29 12 #rect
Rs0 f13 @|RichDialogProcessStartIcon #fIcon
Rs0 f14 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f14 1187 227 26 26 0 12 #rect
Rs0 f14 @|RichDialogProcessEndIcon #fIcon
Rs0 f15 1200 125 1200 227 #arcP
Rs0 f16 guid 14E5220BF803CD49 #txt
Rs0 f16 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f16 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f16 actionTable 'out=in;
' #txt
Rs0 f16 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>onClickBack</name>
    </language>
</elementInfo>
' #txt
Rs0 f16 915 83 26 26 -34 12 #rect
Rs0 f16 @|RichDialogProcessStartIcon #fIcon
Rs0 f19 guid 14E52B828DCB54FB #txt
Rs0 f19 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f19 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f19 actionTable 'out=in;
' #txt
Rs0 f19 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>onSelectLanguage</name>
    </language>
</elementInfo>
' #txt
Rs0 f19 1371 83 26 26 -52 12 #rect
Rs0 f19 @|RichDialogProcessStartIcon #fIcon
Rs0 f20 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f20 1371 211 26 26 0 12 #rect
Rs0 f20 @|RichDialogProcessEndIcon #fIcon
Rs0 f21 1384 109 1384 211 #arcP
Rs0 f22 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f22 actionTable 'out=in;
' #txt
Rs0 f22 actionCode 'in.transferData = in.referenceNavigator.next(ch.ivy.sample.enums.MainPageTab.findBy(in.activeTabIndex));' #txt
Rs0 f22 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f22 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>doNext</name>
        <nameStyle>6,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f22 712 186 112 44 -19 -8 #rect
Rs0 f22 @|StepIcon #fIcon
Rs0 f23 expr out #txt
Rs0 f23 768 109 768 186 #arcP
Rs0 f24 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f24 actionTable 'out=in;
' #txt
Rs0 f24 actionCode 'in.activeTabIndex = in.transferData.getTabInfo().getNewTab().index;
in.activeTabIndexTemporary = in.activeTabIndex;' #txt
Rs0 f24 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f24 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>get next index</name>
        <nameStyle>14,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f24 712 346 112 44 -37 -8 #rect
Rs0 f24 @|StepIcon #fIcon
Rs0 f25 expr out #txt
Rs0 f25 768 230 768 346 #arcP
Rs0 f12 expr out #txt
Rs0 f12 768 390 768 515 #arcP
Rs0 f26 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f26 actionTable 'out=in;
' #txt
Rs0 f26 actionCode 'in.transferData = in.referenceNavigator.back(ch.ivy.sample.enums.MainPageTab.findBy(in.activeTabIndex));' #txt
Rs0 f26 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f26 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>doBack</name>
        <nameStyle>6,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Rs0 f26 872 186 112 44 -20 -8 #rect
Rs0 f26 @|StepIcon #fIcon
Rs0 f27 expr out #txt
Rs0 f27 928 109 928 186 #arcP
Rs0 f18 expr out #txt
Rs0 f18 928 230 824 368 #arcP
Rs0 f18 1 928 368 #addKink
Rs0 f18 1 0.07276975031671618 0 0 #arcLabel
>Proto Rs0 .type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
>Proto Rs0 .processKind HTML_DIALOG #txt
>Proto Rs0 .xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <swimlaneLabel>START</swimlaneLabel>
        <swimlaneLabel>EVENTS</swimlaneLabel>
    </language>
    <swimlaneOrientation>true</swimlaneOrientation>
    <swimlaneSize>424</swimlaneSize>
    <swimlaneSize>1088</swimlaneSize>
    <swimlaneColor gradient="false">-16711936</swimlaneColor>
    <swimlaneColor gradient="false">-256</swimlaneColor>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneType>LANE</swimlaneType>
    <swimlaneSpaceBefore>0</swimlaneSpaceBefore>
    <swimlaneSpaceBefore>0</swimlaneSpaceBefore>
</elementInfo>
' #txt
>Proto Rs0 -8 -8 16 16 16 26 #rect
>Proto Rs0 '' #fIcon
Rs0 f0 mainOut f7 tail #connect
Rs0 f7 head f6 mainIn #connect
Rs0 f6 mainOut f2 tail #connect
Rs0 f2 head f1 mainIn #connect
Rs0 f3 mainOut f9 tail #connect
Rs0 f9 head f8 mainIn #connect
Rs0 f8 mainOut f5 tail #connect
Rs0 f5 head f4 mainIn #connect
Rs0 f13 mainOut f15 tail #connect
Rs0 f15 head f14 mainIn #connect
Rs0 f19 mainOut f21 tail #connect
Rs0 f21 head f20 mainIn #connect
Rs0 f10 mainOut f23 tail #connect
Rs0 f23 head f22 mainIn #connect
Rs0 f22 mainOut f25 tail #connect
Rs0 f25 head f24 mainIn #connect
Rs0 f24 mainOut f12 tail #connect
Rs0 f12 head f11 mainIn #connect
Rs0 f16 mainOut f27 tail #connect
Rs0 f27 head f26 mainIn #connect
Rs0 f26 mainOut f18 tail #connect
Rs0 f18 head f24 mainIn #connect
