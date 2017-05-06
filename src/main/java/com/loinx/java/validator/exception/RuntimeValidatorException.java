/**
 * 
 */
package com.loinx.java.validator.exception;

/**
 * </p>
 * A RuntimeException is thrown when executing the Rule.
 * </p>
 * 
 * @author LoiNX
 *
 */
public class RuntimeValidatorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RuntimeValidatorException() {
		super();
	}

	public RuntimeValidatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RuntimeValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeValidatorException(String message) {
		super(message);
	}

	public RuntimeValidatorException(Throwable cause) {
		super(cause);
	}

}
