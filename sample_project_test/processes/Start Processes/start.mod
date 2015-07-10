[Ivy]
[>Created: Fri Jul 10 19:39:32 ICT 2015]
14E77E8F2942191C 3.17 #module
>Proto >Proto Collection #zClass
st0 start Big #zClass
st0 B #cInfo
st0 #process
st0 @TextInP .resExport .resExport #zField
st0 @TextInP .type .type #zField
st0 @TextInP .processKind .processKind #zField
st0 @AnnotationInP-0n ai ai #zField
st0 @MessageFlowInP-0n messageIn messageIn #zField
st0 @MessageFlowOutP-0n messageOut messageOut #zField
st0 @TextInP .xml .xml #zField
st0 @TextInP .responsibility .responsibility #zField
st0 @StartRequest f0 '' #zField
st0 @EndTask f1 '' #zField
st0 @ProgramInterface f3 '' #zField
st0 @PushWFArc f4 '' #zField
st0 @ProcessException f5 '' #zField
st0 @PushWFArc f6 '' #zField
st0 @Page f7 '' #zField
st0 @PushWFArc f8 '' #zField
>Proto st0 st0 start #zField
st0 f0 outLink start.ivp #txt
st0 f0 type vn.axon.vision.sample_project_test.Data #txt
st0 f0 inParamDecl '<> param;' #txt
st0 f0 actionDecl 'vn.axon.vision.sample_project_test.Data out;
' #txt
st0 f0 guid 14E77E8F2AAD9E5A #txt
st0 f0 requestEnabled true #txt
st0 f0 triggerEnabled false #txt
st0 f0 callSignature start() #txt
st0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
st0 f0 @C|.responsibility Everybody #txt
st0 f0 81 49 30 30 -21 17 #rect
st0 f0 @|StartRequestIcon #fIcon
st0 f1 type vn.axon.vision.sample_project_test.Data #txt
st0 f1 297 145 30 30 0 15 #rect
st0 f1 @|EndIcon #fIcon
st0 f3 type vn.axon.vision.sample_project_test.Data #txt
st0 f3 outerBean "vn.axon.vision.test.helper.UnitTestRunner" #txt
st0 f3 timeout 1000 #txt
st0 f3 beanConfig "" #txt
st0 f3 168 42 112 44 0 -8 #rect
st0 f3 @|ProgramInterfaceIcon #fIcon
st0 f4 expr out #txt
st0 f4 111 64 168 64 #arcP
st0 f5 .resExport export #txt
st0 f5 actionDecl 'vn.axon.vision.sample_project_test.Data out;
' #txt
st0 f5 actionTable 'out=in;
' #txt
st0 f5 actionCode ivy.log.error(exception); #txt
st0 f5 type vn.axon.vision.sample_project_test.Data #txt
st0 f5 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>Exception</name>
        <nameStyle>9,7
</nameStyle>
    </language>
</elementInfo>
' #txt
st0 f5 81 145 30 30 -26 17 #rect
st0 f5 @|ExceptionIcon #fIcon
st0 f6 expr out #txt
st0 f6 111 160 297 160 #arcP
st0 f6 0 0.5496622641394271 0 0 #arcLabel
st0 f7 outTypes "vn.axon.vision.sample_project_test.Data" #txt
st0 f7 template "/ProcessPages/UnitTest/TestResultPage.ivc" #txt
st0 f7 type vn.axon.vision.sample_project_test.Data #txt
st0 f7 skipLink skip.ivp #txt
st0 f7 sortLink sort.ivp #txt
st0 f7 templateWizard '#
#Fri Jul 10 19:39:28 ICT 2015
' #txt
st0 f7 pageArchivingActivated false #txt
st0 f7 @C|.responsibility Everybody #txt
st0 f7 350 42 68 44 0 -8 #rect
st0 f7 @|PageIcon #fIcon
st0 f8 expr out #txt
st0 f8 280 64 350 64 #arcP
>Proto st0 .type vn.axon.vision.sample_project_test.Data #txt
>Proto st0 .processKind NORMAL #txt
>Proto st0 0 0 32 24 18 0 #rect
>Proto st0 @|BIcon #fIcon
st0 f0 mainOut f4 tail #connect
st0 f4 head f3 mainIn #connect
st0 f5 mainOut f6 tail #connect
st0 f6 head f1 mainIn #connect
st0 f3 mainOut f8 tail #connect
st0 f8 head f7 mainIn #connect
