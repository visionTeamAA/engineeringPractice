[Ivy]
[>Created: Wed Jul 01 10:04:01 ICT 2015]
14E47922AE787FF1 3.17 #module
>Proto >Proto Collection #zClass
UO0 UserDAO Big #zClass
UO0 B #cInfo
UO0 #process
UO0 @TextInP .resExport .resExport #zField
UO0 @TextInP .type .type #zField
UO0 @TextInP .processKind .processKind #zField
UO0 @AnnotationInP-0n ai ai #zField
UO0 @MessageFlowInP-0n messageIn messageIn #zField
UO0 @MessageFlowOutP-0n messageOut messageOut #zField
UO0 @TextInP .xml .xml #zField
UO0 @TextInP .responsibility .responsibility #zField
UO0 @StartRequest f0 '' #zField
UO0 @EndTask f1 '' #zField
UO0 @PushWFArc f2 '' #zField
>Proto UO0 UO0 UserDAO #zField
UO0 f0 outLink start.ivp #txt
UO0 f0 type testingProject.Data #txt
UO0 f0 inParamDecl '<> param;' #txt
UO0 f0 actionDecl 'testingProject.Data out;
' #txt
UO0 f0 guid 14E47922AEA71E12 #txt
UO0 f0 requestEnabled true #txt
UO0 f0 triggerEnabled false #txt
UO0 f0 callSignature start() #txt
UO0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
UO0 f0 @C|.responsibility Everybody #txt
UO0 f0 81 49 30 30 -21 17 #rect
UO0 f0 @|StartRequestIcon #fIcon
UO0 f1 type testingProject.Data #txt
UO0 f1 337 49 30 30 0 15 #rect
UO0 f1 @|EndIcon #fIcon
UO0 f2 111 64 337 64 #arcP
>Proto UO0 .type testingProject.Data #txt
>Proto UO0 .processKind NORMAL #txt
>Proto UO0 0 0 32 24 18 0 #rect
>Proto UO0 @|BIcon #fIcon
UO0 f0 mainOut f2 tail #connect
UO0 f2 head f1 mainIn #connect
