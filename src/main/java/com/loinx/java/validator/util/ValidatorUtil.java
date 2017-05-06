package com.loinx.java.validator.util;

import static java.lang.String.format;

import java.util.Objects;

/**
 * @author LoiNX
 *
 */
public final class ValidatorUtil {

	private ValidatorUtil() {

	}

	/**
	 * Check the object must not be null
	 * 
	 * @param argument
	 * @param argumentName
	 * 
	 * @throws IllegalArgumentException
	 *             if the argument is null
	 */
	public static void checkNotNull(final Object argument, final String argumentName) {
		if (Objects.isNull(argument)) {
			throw new IllegalArgumentException(format("The %s must not be null", argumentName));
		}
	}
}
