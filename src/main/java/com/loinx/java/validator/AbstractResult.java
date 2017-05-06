package com.loinx.java.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * The abstract result of the Rule
 * 
 * @author LoiNX
 *
 */
public abstract class AbstractResult<T> implements ValidatorResult<T> {

	protected boolean isSuccess;

	protected List<T> errors = new ArrayList<>();

	@Override
	public boolean isSuccess() {
		return isSuccess;
	}

	/**
	 * @return the errors
	 */
	@Override
	public List<T> getErrors() {
		return errors;
	}
}
