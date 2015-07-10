package vn.axon.vision.test.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import ch.ivyteam.ivy.environment.Ivy;

public class ExecutionListener extends RunListener
{
	 
	
	private Map<String,List<String>> map=new HashMap<String,List<String>>();
	
	/**
	 * Called before any tests have been run.
	 * */
	public void testRunStarted(Description description)	throws java.lang.Exception
	{
		Ivy.log().info("Number of testcases to execute : " + description.testCount());
		Ivy.session().setAttribute("testRunStarted", description);
	
	}

	/**
	 *  Called when all tests have finished
	 * */
	public void testRunFinished(Result result) throws java.lang.Exception
	{
		Ivy.log().info("---------------------------------------------------");
		Ivy.log().info("Number of testcases executed : " + result.getRunCount());		
		Ivy.log().info("Number of testcases ignored : " + result.getIgnoreCount());
		List<Failure> failureList= result.getFailures();
		
		for (Failure failure : failureList) {
			Ivy.log().error("Failure message: " + failure.getMessage(), failure.getException());
		}
		Ivy.session().setAttribute("descriptions", map);
	}

	/**
	 *  Called when an atomic test is about to be started.
	 * */
	public void testStarted(Description description) throws java.lang.Exception
	{
		Ivy.log().info("*Starting test case : "+ description.getMethodName());
		List<String> temp= (List<String>)map.get(description.getClassName());
		if(temp!=null){			
			temp.add("*Starting test case : "+description.getMethodName());
		}else{			
			List<String> list=new ArrayList<String>();
			list.add("*Starting test case : "+description.getMethodName());
			map.put(description.getClassName(),list);
		}		
	}

	/**
	 *  Called when an atomic test has finished, whether the test succeeds or fails.
	 * */
	public void testFinished(Description description) throws java.lang.Exception
	{
		Ivy.log().info("*Finished test case : "+ description.getMethodName());		
		map.get(description.getClassName()).add("*Finished test case : "+description.getMethodName());		
	}

	/**
	 *  Called when an atomic test fails.
	 * */
	public void testFailure(Failure failure) throws java.lang.Exception
	{
		Ivy.log().info("Execution of test case failed : "+ failure.getTrace());		
		map.get(failure.getDescription().getClassName()).add("<font color='red'>Execution of test case failed  : "+failure.getTrace()+"</font>");
		
	}

	/**
	 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
	 * */
	public void testIgnored(Description description) throws java.lang.Exception
	{
		Ivy.log().info("Execution of test case ignored : "+ description.getMethodName());		
		map.get(description.getClassName()).add("Execution of test case ignored : "+description.getMethodName());
	}
}
