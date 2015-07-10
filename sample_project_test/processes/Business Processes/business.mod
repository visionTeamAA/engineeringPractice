[Ivy]
[>Created: Fri Jul 10 19:40:38 ICT 2015]
14E77FB5BEF2CDF6 3.17 #module
>Proto >Proto Collection #zClass
bs0 business Big #zClass
bs0 B #cInfo
bs0 #process
bs0 @TextInP .resExport .resExport #zField
bs0 @TextInP .type .type #zField
bs0 @TextInP .processKind .processKind #zField
bs0 @AnnotationInP-0n ai ai #zField
bs0 @MessageFlowInP-0n messageIn messageIn #zField
bs0 @MessageFlowOutP-0n messageOut messageOut #zField
bs0 @TextInP .xml .xml #zField
bs0 @TextInP .responsibility .responsibility #zField
bs0 @StartRequest f0 '' #zField
bs0 @EndTask f1 '' #zField
bs0 @PushWFArc f2 '' #zField
>Proto bs0 bs0 business #zField
bs0 f0 outLink start.ivp #txt
bs0 f0 type vn.axon.vision.sample_project_test.Data #txt
bs0 f0 inParamDecl '<> param;' #txt
bs0 f0 actionDecl 'vn.axon.vision.sample_project_test.Data out;
' #txt
bs0 f0 guid 14E77FB5C035BC3B #txt
bs0 f0 requestEnabled true #txt
bs0 f0 triggerEnabled false #txt
bs0 f0 callSignature start() #txt
bs0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
bs0 f0 @C|.responsibility Everybody #txt
bs0 f0 81 49 30 30 -21 17 #rect
bs0 f0 @|StartRequestIcon #fIcon
bs0 f1 type vn.axon.vision.sample_project_test.Data #txt
bs0 f1 337 49 30 30 0 15 #rect
bs0 f1 @|EndIcon #fIcon
bs0 f2 111 64 337 64 #arcP
>Proto bs0 .type vn.axon.vision.sample_project_test.Data #txt
>Proto bs0 .processKind NORMAL #txt
>Proto bs0 0 0 32 24 18 0 #rect
>Proto bs0 @|BIcon #fIcon
bs0 f0 mainOut f2 tail #connect
bs0 f2 head f1 mainIn #connect
