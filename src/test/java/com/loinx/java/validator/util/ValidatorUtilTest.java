package com.loinx.java.validator.util;

import static java.lang.String.format;

import org.junit.Test;

import junit.framework.Assert;

/**
 * The test class for ValidatorUtil
 * 
 * @author LoiNX
 *
 */
public class ValidatorUtilTest {

	@Test
	public void shouldCheckNotNullWithNullObject() {
		String argumentName = "test";
		try {
			ValidatorUtil.checkNotNull(null, argumentName);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertNotNull(e);
			Assert.assertEquals(e.getMessage(), format("The %s must not be null", argumentName));
			return;
		}
	}

	@Test
	public void shouldCheckNotNullWithNonNullObjectSuccessfully() {
		String argumentName = "test";
		String data = "data";
		try {
			ValidatorUtil.checkNotNull(data, argumentName);
		} catch (IllegalArgumentException e) {
			Assert.fail(e.getMessage());
		}
	}
}
