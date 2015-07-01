[Ivy]
[>Created: Wed Jul 01 11:04:06 ICT 2015]
14E479202C9D63E4 3.17 #module
>Proto >Proto Collection #zClass
Br0 BusinessLayer Big #zClass
Br0 B #cInfo
Br0 #process
Br0 @TextInP .resExport .resExport #zField
Br0 @TextInP .type .type #zField
Br0 @TextInP .processKind .processKind #zField
Br0 @AnnotationInP-0n ai ai #zField
Br0 @MessageFlowInP-0n messageIn messageIn #zField
Br0 @MessageFlowOutP-0n messageOut messageOut #zField
Br0 @TextInP .xml .xml #zField
Br0 @TextInP .responsibility .responsibility #zField
Br0 @StartRequest f0 '' #zField
Br0 @EndTask f1 '' #zField
Br0 @PushWFArc f2 '' #zField
>Proto Br0 Br0 BusinessLayer #zField
Br0 f0 outLink start.ivp #txt
Br0 f0 type testingProject.Data #txt
Br0 f0 inParamDecl '<> param;' #txt
Br0 f0 actionDecl 'testingProject.Data out;
' #txt
Br0 f0 guid 14E479202CDCA9FD #txt
Br0 f0 requestEnabled true #txt
Br0 f0 triggerEnabled false #txt
Br0 f0 callSignature start() #txt
Br0 f0 persist false #txt
Br0 f0 taskData '#
#Wed Jul 01 11:03:37 ICT 2015
TaskTriggered.ROL=Everybody
TaskTriggered.EXTYPE=0
TaskTriggered.EXPRI=2
TaskTriggered.TYPE=0
TaskTriggered.PRI=2
TaskTriggered.EXROL=Everybody
' #txt
Br0 f0 caseData '#
#Wed Jul 01 11:03:37 ICT 2015
businessCalendarName=
businessCreator.user=
businessMilestone.timestamp=
businessObject.code=
businessObject.docDb.code=
businessObject.folder.id=
businessObject.name=
businessPriority=
businessStart.timestamp=
case.description=
case.name=
correspondent.id=
mainContact.docDb.code=
mainContact.folder.id=
mainContact.id=
mainContact.name=
mainContact.type=
process.code=
process.name=
processCategory.code=
processCategory.name=
subType.code=
subType.name=
type.code=
type.name=
' #txt
Br0 f0 showInStartList 0 #txt
Br0 f0 taskAndCaseSetupAction 'import ch.ivyteam.ivy.workflow.TaskUpdateDefinition;
ch.ivyteam.ivy.workflow.TaskUpdateDefinition taskUpdDef = new ch.ivyteam.ivy.workflow.TaskUpdateDefinition();
import ch.ivyteam.ivy.request.impl.DefaultCalendarProxy;
DefaultCalendarProxy calendarProxy = ivy.cal as DefaultCalendarProxy;
taskUpdDef.setPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
taskUpdDef.setExpiryActivator("Everybody");
taskUpdDef.setExpiryPriority(ch.ivyteam.ivy.workflow.WorkflowPriority.valueOf(2));
engine.updateCurrentTask(taskUpdDef);
' #txt
Br0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
        <nameStyle>9,5,7
</nameStyle>
    </language>
</elementInfo>
' #txt
Br0 f0 @C|.responsibility Everybody #txt
Br0 f0 81 49 30 30 -21 17 #rect
Br0 f0 @|StartRequestIcon #fIcon
Br0 f1 type testingProject.Data #txt
Br0 f1 337 49 30 30 0 15 #rect
Br0 f1 @|EndIcon #fIcon
Br0 f2 expr out #txt
Br0 f2 111 64 337 64 #arcP
>Proto Br0 .type testingProject.Data #txt
>Proto Br0 .processKind NORMAL #txt
>Proto Br0 0 0 32 24 18 0 #rect
>Proto Br0 @|BIcon #fIcon
Br0 f0 mainOut f2 tail #connect
Br0 f2 head f1 mainIn #connect
