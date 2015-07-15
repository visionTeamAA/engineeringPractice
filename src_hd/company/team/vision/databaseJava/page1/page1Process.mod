[Ivy]
[>Created: Wed Jul 01 18:19:18 ICT 2015]
14E4957A9239F448 3.17 #module
>Proto >Proto Collection #zClass
ps0 page1Process Big #zClass
ps0 RD #cInfo
ps0 #process
ps0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
ps0 @TextInP .rdData2UIAction .rdData2UIAction #zField
ps0 @TextInP .resExport .resExport #zField
ps0 @TextInP .type .type #zField
ps0 @TextInP .processKind .processKind #zField
ps0 @AnnotationInP-0n ai ai #zField
ps0 @MessageFlowInP-0n messageIn messageIn #zField
ps0 @MessageFlowOutP-0n messageOut messageOut #zField
ps0 @TextInP .xml .xml #zField
ps0 @TextInP .responsibility .responsibility #zField
ps0 @RichDialogInitStart f0 '' #zField
ps0 @RichDialogProcessEnd f1 '' #zField
ps0 @PushWFArc f2 '' #zField
ps0 @RichDialogProcessStart f3 '' #zField
ps0 @RichDialogEnd f4 '' #zField
ps0 @PushWFArc f5 '' #zField
>Proto ps0 ps0 page1Process #zField
ps0 f0 guid 14E4957A93790468 #txt
ps0 f0 type company.team.vision.databaseJava.page1.page1Data #txt
ps0 f0 method start() #txt
ps0 f0 disableUIEvents true #txt
ps0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
ps0 f0 outParameterDecl '<> result;
' #txt
ps0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
ps0 f0 83 51 26 26 -16 15 #rect
ps0 f0 @|RichDialogInitStartIcon #fIcon
ps0 f1 type company.team.vision.databaseJava.page1.page1Data #txt
ps0 f1 211 51 26 26 0 12 #rect
ps0 f1 @|RichDialogProcessEndIcon #fIcon
ps0 f2 expr out #txt
ps0 f2 109 64 211 64 #arcP
ps0 f3 guid 14E4957A946A0AC4 #txt
ps0 f3 type company.team.vision.databaseJava.page1.page1Data #txt
ps0 f3 actionDecl 'company.team.vision.databaseJava.page1.page1Data out;
' #txt
ps0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
ps0 f3 83 147 26 26 -15 12 #rect
ps0 f3 @|RichDialogProcessStartIcon #fIcon
ps0 f4 type company.team.vision.databaseJava.page1.page1Data #txt
ps0 f4 guid 14E4957A946EFCE0 #txt
ps0 f4 211 147 26 26 0 12 #rect
ps0 f4 @|RichDialogEndIcon #fIcon
ps0 f5 expr out #txt
ps0 f5 109 160 211 160 #arcP
>Proto ps0 .type company.team.vision.databaseJava.page1.page1Data #txt
>Proto ps0 .processKind HTML_DIALOG #txt
>Proto ps0 -8 -8 16 16 16 26 #rect
>Proto ps0 '' #fIcon
ps0 f0 mainOut f2 tail #connect
ps0 f2 head f1 mainIn #connect
ps0 f3 mainOut f5 tail #connect
ps0 f5 head f4 mainIn #connect
