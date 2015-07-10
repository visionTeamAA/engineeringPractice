[Ivy]
[>Created: Fri Jul 10 19:41:45 ICT 2015]
14E77FC2FC6ACA85 3.17 #module
>Proto >Proto Collection #zClass
os0 orches Big #zClass
os0 B #cInfo
os0 #process
os0 @TextInP .resExport .resExport #zField
os0 @TextInP .type .type #zField
os0 @TextInP .processKind .processKind #zField
os0 @AnnotationInP-0n ai ai #zField
os0 @MessageFlowInP-0n messageIn messageIn #zField
os0 @MessageFlowOutP-0n messageOut messageOut #zField
os0 @TextInP .xml .xml #zField
os0 @TextInP .responsibility .responsibility #zField
os0 @StartRequest f0 '' #zField
os0 @EndTask f1 '' #zField
os0 @PushWFArc f2 '' #zField
>Proto os0 os0 orches #zField
os0 f0 outLink start.ivp #txt
os0 f0 type vn.axon.vision.sample_project_test.Data #txt
os0 f0 inParamDecl '<> param;' #txt
os0 f0 actionDecl 'vn.axon.vision.sample_project_test.Data out;
' #txt
os0 f0 guid 14E77FC2FEE164A6 #txt
os0 f0 requestEnabled true #txt
os0 f0 triggerEnabled false #txt
os0 f0 callSignature start() #txt
os0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
os0 f0 @C|.responsibility Everybody #txt
os0 f0 81 49 30 30 -21 17 #rect
os0 f0 @|StartRequestIcon #fIcon
os0 f1 type vn.axon.vision.sample_project_test.Data #txt
os0 f1 337 49 30 30 0 15 #rect
os0 f1 @|EndIcon #fIcon
os0 f2 111 64 337 64 #arcP
>Proto os0 .type vn.axon.vision.sample_project_test.Data #txt
>Proto os0 .processKind NORMAL #txt
>Proto os0 0 0 32 24 18 0 #rect
>Proto os0 @|BIcon #fIcon
os0 f0 mainOut f2 tail #connect
os0 f2 head f1 mainIn #connect
