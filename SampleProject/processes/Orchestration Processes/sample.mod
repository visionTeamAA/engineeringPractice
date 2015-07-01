[Ivy]
[>Created: Wed Jul 01 10:22:07 ICT 2015]
14E47A2C829E8AB8 3.17 #module
>Proto >Proto Collection #zClass
se0 sample Big #zClass
se0 B #cInfo
se0 #process
se0 @TextInP .resExport .resExport #zField
se0 @TextInP .type .type #zField
se0 @TextInP .processKind .processKind #zField
se0 @AnnotationInP-0n ai ai #zField
se0 @MessageFlowInP-0n messageIn messageIn #zField
se0 @MessageFlowOutP-0n messageOut messageOut #zField
se0 @TextInP .xml .xml #zField
se0 @TextInP .responsibility .responsibility #zField
se0 @StartRequest f0 '' #zField
se0 @EndTask f1 '' #zField
se0 @PushWFArc f2 '' #zField
>Proto se0 se0 sample #zField
se0 f0 outLink start.ivp #txt
se0 f0 type testingProject.Data #txt
se0 f0 inParamDecl '<> param;' #txt
se0 f0 actionDecl 'testingProject.Data out;
' #txt
se0 f0 guid 14E47A2C82EBCD63 #txt
se0 f0 requestEnabled true #txt
se0 f0 triggerEnabled false #txt
se0 f0 callSignature start() #txt
se0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
se0 f0 @C|.responsibility Everybody #txt
se0 f0 81 49 30 30 -21 17 #rect
se0 f0 @|StartRequestIcon #fIcon
se0 f1 type testingProject.Data #txt
se0 f1 337 49 30 30 0 15 #rect
se0 f1 @|EndIcon #fIcon
se0 f2 111 64 337 64 #arcP
>Proto se0 .type testingProject.Data #txt
>Proto se0 .processKind NORMAL #txt
>Proto se0 0 0 32 24 18 0 #rect
>Proto se0 @|BIcon #fIcon
se0 f0 mainOut f2 tail #connect
se0 f2 head f1 mainIn #connect
