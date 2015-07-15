[Ivy]
[>Created: Wed Jul 01 18:19:31 ICT 2015]
14E4957DBCD5E8A4 3.17 #module
>Proto >Proto Collection #zClass
ps0 page2Process Big #zClass
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
>Proto ps0 ps0 page2Process #zField
ps0 f0 guid 14E4957DBD9D4DD7 #txt
ps0 f0 type company.team.vision.databaseJava.page2.page2Data #txt
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
ps0 f1 type company.team.vision.databaseJava.page2.page2Data #txt
ps0 f1 211 51 26 26 0 12 #rect
ps0 f1 @|RichDialogProcessEndIcon #fIcon
ps0 f2 expr out #txt
ps0 f2 109 64 211 64 #arcP
>Proto ps0 .type company.team.vision.databaseJava.page2.page2Data #txt
>Proto ps0 .processKind RICH_DIALOG #txt
>Proto ps0 -8 -8 16 16 16 26 #rect
>Proto ps0 '' #fIcon
ps0 f0 mainOut f2 tail #connect
ps0 f2 head f1 mainIn #connect
