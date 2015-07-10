<%@ page import="ch.ivyteam.ivy.page.engine.jsp.IvyJSP"%><jsp:useBean id="ivy" class="ch.ivyteam.ivy.page.engine.jsp.IvyJSP" scope="session"/>
<%@ page import="org.junit.runner.Result"%>
<%@ page import="org.junit.runner.Description"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<%
Result result = (Result)ivy.session.getAttribute("result") ;
Description testRunStarted = (Description)ivy.session.getAttribute("testRunStarted") ;
Map<String,List>  map = (Map<String,List>)ivy.session.getAttribute("descriptions") ;
%>
<div>
   <div><p><b>--------------------------------------UnitTest-------------------------------------------</b></p></div>
   <div><p><b>Number of testcases to execute : <%=testRunStarted.testCount()%></b></p></div>
   <%for (Map.Entry<String, List> entry : map.entrySet()){
       List<String> descriptions=entry.getValue();%>
	   <div><p><b><font color='blue'><%=entry.getKey()%></font></b></p></div> 
	   <%for(String description:descriptions){%>
		<div style="padding-left:50px;"><p><%=description%></p></div> 
	   
	<%}}%>	   
   <div><p><b>------------------------------------------------------------------------------------------</b></p></div>
   <div><p><b>RESULT :</b></p></div>
   <div><p><b>Number of testcases executed : <%=result.getRunCount()%></b></p></div>
   <div><p><b>Number of testcases ignored : <%=result.getIgnoreCount()%></b></p></div>
   <div><p><b>Number of testcases failed : <%=result.getFailureCount()%></b></p></div>
   
   <div><p><b>All test succeded: <%=result.wasSuccessful()%></b></p></div>
<%
  ivy.session.removeAttribute("result");
  ivy.session.removeAttribute("testRunStarted");
  ivy.session.removeAttribute("descriptions");
%>  
</div>