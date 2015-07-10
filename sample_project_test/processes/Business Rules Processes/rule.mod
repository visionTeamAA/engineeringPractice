[Ivy]
[>Created: Fri Jul 10 19:41:45 ICT 2015]
14E77FB77AF68189 3.17 #module
>Proto >Proto Collection #zClass
re0 rule Big #zClass
re0 B #cInfo
re0 #process
re0 @TextInP .resExport .resExport #zField
re0 @TextInP .type .type #zField
re0 @TextInP .processKind .processKind #zField
re0 @AnnotationInP-0n ai ai #zField
re0 @MessageFlowInP-0n messageIn messageIn #zField
re0 @MessageFlowOutP-0n messageOut messageOut #zField
re0 @TextInP .xml .xml #zField
re0 @TextInP .responsibility .responsibility #zField
re0 @StartRequest f0 '' #zField
re0 @EndTask f1 '' #zField
re0 @PushWFArc f2 '' #zField
>Proto re0 re0 rule #zField
re0 f0 outLink start.ivp #txt
re0 f0 type vn.axon.vision.sample_project_test.Data #txt
re0 f0 inParamDecl '<> param;' #txt
re0 f0 actionDecl 'vn.axon.vision.sample_project_test.Data out;
' #txt
re0 f0 guid 14E77FB77B9D0FE0 #txt
re0 f0 requestEnabled true #txt
re0 f0 triggerEnabled false #txt
re0 f0 callSignature start() #txt
re0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
re0 f0 @C|.responsibility Everybody #txt
re0 f0 81 49 30 30 -21 17 #rect
re0 f0 @|StartRequestIcon #fIcon
re0 f1 type vn.axon.vision.sample_project_test.Data #txt
re0 f1 337 49 30 30 0 15 #rect
re0 f1 @|EndIcon #fIcon
re0 f2 111 64 337 64 #arcP
>Proto re0 .type vn.axon.vision.sample_project_test.Data #txt
>Proto re0 .processKind NORMAL #txt
>Proto re0 0 0 32 24 18 0 #rect
>Proto re0 @|BIcon #fIcon
re0 f0 mainOut f2 tail #connect
re0 f2 head f1 mainIn #connect
