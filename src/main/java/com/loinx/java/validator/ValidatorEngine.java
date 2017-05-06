package com.loinx.java.validator;

import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author LoiNX
 *
 */
public interface ValidatorEngine {

	/**
	 * The name of the rule engine
	 * 
	 * @return the engine name
	 */
	String getName();

	ValidatorEngine registerRule(Validator rule);

	ValidatorEngine registerRule(List<Validator> rule);

	ValidatorEngine unregisterRule(Validator rule);

	Set<Validator> getValidators();

	void fireValidators();

	void clearValidators();

	List<Object> getResults();

	boolean hasExecuted();

}
