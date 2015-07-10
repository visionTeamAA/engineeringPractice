[Ivy]
[>Created: Fri Jul 10 19:41:45 ICT 2015]
14E77FBECAFCA884 3.17 #module
>Proto >Proto Collection #zClass
fl0 functional Big #zClass
fl0 B #cInfo
fl0 #process
fl0 @TextInP .resExport .resExport #zField
fl0 @TextInP .type .type #zField
fl0 @TextInP .processKind .processKind #zField
fl0 @AnnotationInP-0n ai ai #zField
fl0 @MessageFlowInP-0n messageIn messageIn #zField
fl0 @MessageFlowOutP-0n messageOut messageOut #zField
fl0 @TextInP .xml .xml #zField
fl0 @TextInP .responsibility .responsibility #zField
fl0 @StartRequest f0 '' #zField
fl0 @EndTask f1 '' #zField
fl0 @PushWFArc f2 '' #zField
>Proto fl0 fl0 functional #zField
fl0 f0 outLink start.ivp #txt
fl0 f0 type vn.axon.vision.sample_project_test.Data #txt
fl0 f0 inParamDecl '<> param;' #txt
fl0 f0 actionDecl 'vn.axon.vision.sample_project_test.Data out;
' #txt
fl0 f0 guid 14E77FBECAFC3301 #txt
fl0 f0 requestEnabled true #txt
fl0 f0 triggerEnabled false #txt
fl0 f0 callSignature start() #txt
fl0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
fl0 f0 @C|.responsibility Everybody #txt
fl0 f0 81 49 30 30 -21 17 #rect
fl0 f0 @|StartRequestIcon #fIcon
fl0 f1 type vn.axon.vision.sample_project_test.Data #txt
fl0 f1 337 49 30 30 0 15 #rect
fl0 f1 @|EndIcon #fIcon
fl0 f2 111 64 337 64 #arcP
>Proto fl0 .type vn.axon.vision.sample_project_test.Data #txt
>Proto fl0 .processKind NORMAL #txt
>Proto fl0 0 0 32 24 18 0 #rect
>Proto fl0 @|BIcon #fIcon
fl0 f0 mainOut f2 tail #connect
fl0 f2 head f1 mainIn #connect
