package vn.axon.vision.test.helper;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import vn.axon.vision.test.navigator.NavigatorManagerTest;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.engine.IRequestId;
import ch.ivyteam.ivy.process.extension.impl.AbstractUserProcessExtension;
import ch.ivyteam.ivy.scripting.language.IIvyScriptContext;
import ch.ivyteam.ivy.scripting.objects.CompositeObject;

public class UnitTestRunner extends AbstractUserProcessExtension {
	
	@Override
	public CompositeObject perform(IRequestId requestId, CompositeObject in,
			IIvyScriptContext context) throws Exception {

		JUnitCore junit = new JUnitCore();
		junit.addListener(new ExecutionListener());
		Ivy.log().info("--- UnitTest ---");
		
		// Add your test classes or test suites here.
		Result result = junit.run(
				NavigatorManagerTest.class
			);
		
		Ivy.log().info("All test succeded: " + result.wasSuccessful());		
		Ivy.session().setAttribute("result", result);
		return in;
	}
}
