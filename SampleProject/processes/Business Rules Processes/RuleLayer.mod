[Ivy]
[>Created: Wed Jul 01 10:04:16 ICT 2015]
14E4792662EEA4B2 3.17 #module
>Proto >Proto Collection #zClass
Rr0 RuleLayer Big #zClass
Rr0 B #cInfo
Rr0 #process
Rr0 @TextInP .resExport .resExport #zField
Rr0 @TextInP .type .type #zField
Rr0 @TextInP .processKind .processKind #zField
Rr0 @AnnotationInP-0n ai ai #zField
Rr0 @MessageFlowInP-0n messageIn messageIn #zField
Rr0 @MessageFlowOutP-0n messageOut messageOut #zField
Rr0 @TextInP .xml .xml #zField
Rr0 @TextInP .responsibility .responsibility #zField
Rr0 @StartRequest f0 '' #zField
Rr0 @EndTask f1 '' #zField
Rr0 @PushWFArc f2 '' #zField
>Proto Rr0 Rr0 RuleLayer #zField
Rr0 f0 outLink start.ivp #txt
Rr0 f0 type testingProject.Data #txt
Rr0 f0 inParamDecl '<> param;' #txt
Rr0 f0 actionDecl 'testingProject.Data out;
' #txt
Rr0 f0 guid 14E47926632E429E #txt
Rr0 f0 requestEnabled true #txt
Rr0 f0 triggerEnabled false #txt
Rr0 f0 callSignature start() #txt
Rr0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
Rr0 f0 @C|.responsibility Everybody #txt
Rr0 f0 81 49 30 30 -21 17 #rect
Rr0 f0 @|StartRequestIcon #fIcon
Rr0 f1 type testingProject.Data #txt
Rr0 f1 337 49 30 30 0 15 #rect
Rr0 f1 @|EndIcon #fIcon
Rr0 f2 111 64 337 64 #arcP
>Proto Rr0 .type testingProject.Data #txt
>Proto Rr0 .processKind NORMAL #txt
>Proto Rr0 0 0 32 24 18 0 #rect
>Proto Rr0 @|BIcon #fIcon
Rr0 f0 mainOut f2 tail #connect
Rr0 f2 head f1 mainIn #connect