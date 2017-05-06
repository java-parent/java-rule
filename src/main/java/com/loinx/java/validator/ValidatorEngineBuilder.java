package com.loinx.java.validator;

/**
 * @author LoiNX
 *
 */
public class ValidatorEngineBuilder {

	public static ValidatorEngineBuilder newRuleEngineBuilder() {
		return new ValidatorEngineBuilder();
	}

	public ValidatorEngine build(final String name) {
		return new DefaultValidatorEngine(name);
	}
}
