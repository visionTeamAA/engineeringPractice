[Ivy]
[>Created: Wed Jul 01 15:48:53 ICT 2015]
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

	in.activeTabIndex = in.activeTabIndexTemporary;' #txt
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
