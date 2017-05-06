package com.loinx.java.validator;

import java.util.List;

/**
 * @author loinx
 *
 */
public interface ValidatorResult<T> {
	/**
	 * @return the isSuccess
	 */
	boolean isSuccess();

	List<T> getErrors();
}
