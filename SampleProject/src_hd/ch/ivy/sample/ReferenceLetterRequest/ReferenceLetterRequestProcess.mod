[Ivy]
[>Created: Fri Jul 03 14:01:17 ICT 2015]
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
Rs0 @PushWFArc f12 '' #zField
Rs0 @RichDialogProcessStart f13 '' #zField
Rs0 @RichDialogProcessEnd f14 '' #zField
Rs0 @PushWFArc f15 '' #zField
Rs0 @RichDialogProcessStart f16 '' #zField
Rs0 @RichDialogProcessEnd f17 '' #zField
Rs0 @PushWFArc f18 '' #zField
Rs0 @RichDialogProcessStart f19 '' #zField
Rs0 @RichDialogProcessEnd f20 '' #zField
Rs0 @PushWFArc f21 '' #zField
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
Rs0 f3 499 51 26 26 16 0 #rect
Rs0 f3 @|RichDialogMethodStartIcon #fIcon
Rs0 f4 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f4 499 275 26 26 16 0 #rect
Rs0 f4 @|RichDialogProcessEndIcon #fIcon
Rs0 f6 actionDecl 'ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData out;
' #txt
Rs0 f6 actionTable 'out=in;
' #txt
Rs0 f6 actionCode 'in.activeTabIndex = 0;
in.activeTabIndexTemporary = 0;
ivy.log.info("Huong test commit SVN");' #txt
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
Rs0 f8 456 170 112 44 -41 -8 #rect
Rs0 f8 @|StepIcon #fIcon
Rs0 f9 expr out #txt
Rs0 f9 512 77 512 170 #arcP
Rs0 f5 expr out #txt
Rs0 f5 512 214 512 275 #arcP
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
Rs0 f11 755 211 26 26 0 12 #rect
Rs0 f11 @|RichDialogProcessEndIcon #fIcon
Rs0 f12 768 109 768 211 #arcP
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
Rs0 f13 851 83 26 26 -29 12 #rect
Rs0 f13 @|RichDialogProcessStartIcon #fIcon
Rs0 f14 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f14 851 211 26 26 0 12 #rect
Rs0 f14 @|RichDialogProcessEndIcon #fIcon
Rs0 f15 864 109 864 211 #arcP
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
Rs0 f16 947 83 26 26 -34 12 #rect
Rs0 f16 @|RichDialogProcessStartIcon #fIcon
Rs0 f17 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f17 947 211 26 26 0 12 #rect
Rs0 f17 @|RichDialogProcessEndIcon #fIcon
Rs0 f18 960 109 960 211 #arcP
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
Rs0 f19 1043 83 26 26 -52 12 #rect
Rs0 f19 @|RichDialogProcessStartIcon #fIcon
Rs0 f20 type ch.ivy.sample.ReferenceLetterRequest.ReferenceLetterRequestData #txt
Rs0 f20 1043 211 26 26 0 12 #rect
Rs0 f20 @|RichDialogProcessEndIcon #fIcon
Rs0 f21 1056 109 1056 211 #arcP
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
    <swimlaneSize>456</swimlaneSize>
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
Rs0 f10 mainOut f12 tail #connect
Rs0 f12 head f11 mainIn #connect
Rs0 f13 mainOut f15 tail #connect
Rs0 f15 head f14 mainIn #connect
Rs0 f16 mainOut f18 tail #connect
Rs0 f18 head f17 mainIn #connect
Rs0 f19 mainOut f21 tail #connect
Rs0 f21 head f20 mainIn #connect
