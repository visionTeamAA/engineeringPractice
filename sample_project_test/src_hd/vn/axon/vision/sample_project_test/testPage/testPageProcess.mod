[Ivy]
[>Created: Fri Jul 10 19:42:50 ICT 2015]
14E77FD5CEE14F02 3.17 #module
>Proto >Proto Collection #zClass
ts0 testPageProcess Big #zClass
ts0 RD #cInfo
ts0 #process
ts0 @TextInP .ui2RdDataAction .ui2RdDataAction #zField
ts0 @TextInP .rdData2UIAction .rdData2UIAction #zField
ts0 @TextInP .resExport .resExport #zField
ts0 @TextInP .type .type #zField
ts0 @TextInP .processKind .processKind #zField
ts0 @AnnotationInP-0n ai ai #zField
ts0 @MessageFlowInP-0n messageIn messageIn #zField
ts0 @MessageFlowOutP-0n messageOut messageOut #zField
ts0 @TextInP .xml .xml #zField
ts0 @TextInP .responsibility .responsibility #zField
ts0 @RichDialogInitStart f0 '' #zField
ts0 @RichDialogProcessEnd f1 '' #zField
ts0 @PushWFArc f2 '' #zField
ts0 @RichDialogProcessStart f3 '' #zField
ts0 @RichDialogEnd f4 '' #zField
ts0 @PushWFArc f5 '' #zField
>Proto ts0 ts0 testPageProcess #zField
ts0 f0 guid 14E77FD5D0226A07 #txt
ts0 f0 type vn.axon.vision.sample_project_test.testPage.testPageData #txt
ts0 f0 method start() #txt
ts0 f0 disableUIEvents true #txt
ts0 f0 inParameterDecl 'ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent methodEvent = event as ch.ivyteam.ivy.richdialog.exec.RdMethodCallEvent;
<> param = methodEvent.getInputArguments();
' #txt
ts0 f0 outParameterDecl '<> result;
' #txt
ts0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start()</name>
    </language>
</elementInfo>
' #txt
ts0 f0 83 51 26 26 -16 15 #rect
ts0 f0 @|RichDialogInitStartIcon #fIcon
ts0 f1 type vn.axon.vision.sample_project_test.testPage.testPageData #txt
ts0 f1 211 51 26 26 0 12 #rect
ts0 f1 @|RichDialogProcessEndIcon #fIcon
ts0 f2 expr out #txt
ts0 f2 109 64 211 64 #arcP
ts0 f3 guid 14E77FD5D162FF2D #txt
ts0 f3 type vn.axon.vision.sample_project_test.testPage.testPageData #txt
ts0 f3 actionDecl 'vn.axon.vision.sample_project_test.testPage.testPageData out;
' #txt
ts0 f3 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>close</name>
    </language>
</elementInfo>
' #txt
ts0 f3 83 147 26 26 -15 12 #rect
ts0 f3 @|RichDialogProcessStartIcon #fIcon
ts0 f4 type vn.axon.vision.sample_project_test.testPage.testPageData #txt
ts0 f4 guid 14E77FD5D16F4F94 #txt
ts0 f4 211 147 26 26 0 12 #rect
ts0 f4 @|RichDialogEndIcon #fIcon
ts0 f5 expr out #txt
ts0 f5 109 160 211 160 #arcP
>Proto ts0 .type vn.axon.vision.sample_project_test.testPage.testPageData #txt
>Proto ts0 .processKind HTML_DIALOG #txt
>Proto ts0 -8 -8 16 16 16 26 #rect
>Proto ts0 '' #fIcon
ts0 f0 mainOut f2 tail #connect
ts0 f2 head f1 mainIn #connect
ts0 f3 mainOut f5 tail #connect
ts0 f5 head f4 mainIn #connect
