package com.loinx.java.rule;

import org.junit.Assert;
import org.junit.Test;

import com.loinx.java.validator.AbstractValidator;
import com.loinx.java.validator.ValidatorResult;

public class AbstractValidatorTest {

	@Test
	public void shouldImplRuleSuccessfully() {
		ValidatorImpl impl = new ValidatorImpl();
		Assert.assertNotNull(impl);
	}

	class ValidatorImpl extends AbstractValidator {

		public ValidatorImpl() {
			super(ValidatorImpl.class.getSimpleName());
		}

		@Override
		public int getPriority() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ValidatorResult<Object> getResult() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean skipOnFailure() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		protected boolean validate() throws Exception {
			// TODO Auto-generated method stub
			return false;
		}

	}
}
