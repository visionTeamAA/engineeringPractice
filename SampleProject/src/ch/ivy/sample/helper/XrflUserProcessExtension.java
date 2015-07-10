package ch.ivy.sample.helper;

import ch.ivy.sample.bean.BusinessException;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.engine.IRequestId;
import ch.ivyteam.ivy.process.extension.impl.AbstractUserProcessExtension;
import ch.ivyteam.ivy.scripting.exceptions.invocation.IvyScriptMethodInvocationException;
import ch.ivyteam.ivy.scripting.language.IIvyScriptContext;
import ch.ivyteam.ivy.scripting.objects.CompositeObject;
import ch.ivyteam.util.IvyRuntimeException;

public abstract class XrflUserProcessExtension extends AbstractUserProcessExtension {
	public abstract void run(IRequestId requestId, CompositeObject in, IIvyScriptContext context) throws BusinessException;
	
	/**
	 * Runs the provided ivy script from the editor tab.
	 */
	@Override
	public CompositeObject perform(IRequestId requestId, CompositeObject in, IIvyScriptContext context)
			throws Exception {
		try {
			run(requestId, in, context);
		} catch (Throwable e) {
			e = findRootCauseIfItsAnIvyScriptError(e);
			Ivy.log().error("An error occured while executing the script.");
			ExceptionInformationWrapperException exceptionInformationException = new ExceptionInformationWrapperException(
					e);
			throw exceptionInformationException;
		}
		return in;
	}
	
	/**
	 * If the exception occurred in the code that was called by the given ivy script, the exception is wrapped into an
	 * {@link IvyScriptMethodInvocationException} that is wrapped into another exception and so on. This method extracts
	 * the real cause from the given {@link Throwable} and returns it. <br/>
	 * <i>Note: Without this method, the error in the UI would always be an {@link IvyRuntimeException} that tells you
	 * that line xy of block yz had an error, but you have no clue what the problem actually could have been at that
	 * point.</i>
	 */
	private Throwable findRootCauseIfItsAnIvyScriptError(Throwable throwable) {
		Throwable cause = throwable.getCause();
		if (cause == null) {
			return throwable;
		}

		boolean thereIsADeeperCause = true;
		while (thereIsADeeperCause) {
			if (IvyScriptMethodInvocationException.class.isAssignableFrom(cause.getClass())) {
				IvyScriptMethodInvocationException ivyScriptMethodInvocationException = (IvyScriptMethodInvocationException) cause;
				Throwable ivyScriptMethodInvocationExceptionCause = ivyScriptMethodInvocationException.getCause();
				if (ivyScriptMethodInvocationExceptionCause != null) {
					throwable = ivyScriptMethodInvocationExceptionCause;
				}
				break;
			}
			cause = cause.getCause();
			thereIsADeeperCause = cause != null && cause.getCause() != cause;
		}

		return throwable;
	}
}
