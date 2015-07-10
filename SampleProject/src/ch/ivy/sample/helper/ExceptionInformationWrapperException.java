package ch.ivy.sample.helper;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * This exception is a wrapper that can encode the type, the detailed message and the stacktrace within a {@link String}
 * so that it can be transported to the exception start.
 */
public class ExceptionInformationWrapperException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private static final String ENCODED_MESSAGE_DELIMITER = ":::";
	private static final String DEFAULT_MESSAGE = "n/a";

	private Class<? extends Throwable> causingThrowableType;
	private String causingMessage;
	private String stackTraceAsString;

	/**
	 * Creates an exception wrapper that contains all data from a given {@link String}. This constructor is used on the
	 * exception event start to create an instance.
	 * 
	 * The form of the String must be:<br />
	 * java.lang.RuntimeException:::DetailedMessage:::Stacktrace
	 * 
	 * @param encodedExceptionInformation
	 *            The encoded exception string.
	 */
	public ExceptionInformationWrapperException(String encodedExceptionInformation) {
		super(encodedExceptionInformation);

		String[] parts = encodedExceptionInformation.split(ENCODED_MESSAGE_DELIMITER);
		if (parts.length >= 3) {
			determineCausingThrowableType(parts);
			determineCausingMessage(parts);
			determineStacktraceAsString(parts);
		} else {
			causingThrowableType = null;
			causingMessage = DEFAULT_MESSAGE;
			stackTraceAsString = null;
		}
	}

	/**
	 * Creates an exception wrapper that contains all data from a given {@link Throwable}. This constructor is used on
	 * the site where the exception happens to encode the information.
	 * 
	 * @param cause
	 *            The exception that shall be encoded.
	 */
	public ExceptionInformationWrapperException(Throwable cause) {
		super(createEncodedMessage(cause));
		causingMessage = cause.getMessage();
		causingThrowableType = cause.getClass();

	}

	/**
	 * Creates an empty exception information message. This constructor can be used by subclasses to provide a
	 * meaningful functionality for an empty constructor.
	 */
	public ExceptionInformationWrapperException() {
		causingThrowableType = null;
		causingMessage = DEFAULT_MESSAGE;
		stackTraceAsString = null;
	}

	public Class<? extends Throwable> getCausingThrowableType() {
		return causingThrowableType;
	}

	public String getCausingMessage() {
		return causingMessage;
	}

	public String getStackTraceAsString() {
		return stackTraceAsString;
	}

	private void determineCausingMessage(String[] parts) {
		causingMessage = parts[1];
	}

	private void determineCausingThrowableType(String[] parts) {
		try {
			Class<?> type = Class.forName(parts[0]);
			if (Throwable.class.isAssignableFrom(type)) {
				@SuppressWarnings("unchecked")
				Class<? extends Throwable> throwableType = (Class<? extends Throwable>) type;
				causingThrowableType = throwableType;
				return;
			}
		} catch (ClassNotFoundException e) { // No exception handling required because in case the type cannot be
												// found null is simply returned.
			causingThrowableType = null;
		}
	}

	private void determineStacktraceAsString(String[] parts) {
		stackTraceAsString = parts[2];
	}

	private static String createEncodedMessage(Throwable cause) {
		String stackTraceAsString = ExceptionUtils.getStackTrace(cause);
		String encodedMessage = String.format("%s%s%s%s%s", cause.getClass().getName(), ENCODED_MESSAGE_DELIMITER,
				cause.getMessage(), ENCODED_MESSAGE_DELIMITER, stackTraceAsString);
		return encodedMessage;
	}
}
