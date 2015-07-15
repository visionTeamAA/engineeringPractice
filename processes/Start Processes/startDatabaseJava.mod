[Ivy]
[>Created: Wed Jul 01 18:18:47 ICT 2015]
14E495730A0D522C 3.17 #module
>Proto >Proto Collection #zClass
sa0 startDatabaseJava Big #zClass
sa0 B #cInfo
sa0 #process
sa0 @TextInP .resExport .resExport #zField
sa0 @TextInP .type .type #zField
sa0 @TextInP .processKind .processKind #zField
sa0 @AnnotationInP-0n ai ai #zField
sa0 @MessageFlowInP-0n messageIn messageIn #zField
sa0 @MessageFlowOutP-0n messageOut messageOut #zField
sa0 @TextInP .xml .xml #zField
sa0 @TextInP .responsibility .responsibility #zField
sa0 @StartRequest f0 '' #zField
sa0 @EndTask f1 '' #zField
sa0 @PushWFArc f2 '' #zField
>Proto sa0 sa0 startDatabaseJava #zField
sa0 f0 outLink start.ivp #txt
sa0 f0 type company.team.vision.databaseJava.Data #txt
sa0 f0 inParamDecl '<> param;' #txt
sa0 f0 actionDecl 'company.team.vision.databaseJava.Data out;
' #txt
sa0 f0 guid 14E495730AE1C89D #txt
sa0 f0 requestEnabled true #txt
sa0 f0 triggerEnabled false #txt
sa0 f0 callSignature start() #txt
sa0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
sa0 f0 @C|.responsibility Everybody #txt
sa0 f0 81 49 30 30 -21 17 #rect
sa0 f0 @|StartRequestIcon #fIcon
sa0 f1 type company.team.vision.databaseJava.Data #txt
sa0 f1 337 49 30 30 0 15 #rect
sa0 f1 @|EndIcon #fIcon
sa0 f2 111 64 337 64 #arcP
>Proto sa0 .type company.team.vision.databaseJava.Data #txt
>Proto sa0 .processKind NORMAL #txt
>Proto sa0 0 0 32 24 18 0 #rect
>Proto sa0 @|BIcon #fIcon
sa0 f0 mainOut f2 tail #connect
sa0 f2 head f1 mainIn #connect
