package com.loinx.java.validator;

/**
 * @author LoiNX
 *
 */
public interface Validator {
	/**
	 * Default rule priority.
	 */
	public static final int DEFAULT_PRIORITY = Integer.MAX_VALUE;
	public static final String DEFAULT_NAME = "Default Validator Name";

	/**
	 * Getter the name of the rule
	 * 
	 * @return the validator name
	 */
	String getName();

	/**
	 * Getter the priority of the validator
	 * 
	 * @return the validator priority
	 */
	int getPriority();

	/**
	 * Getter the result
	 * 
	 * @return result of the after the rule is fired
	 */
	ValidatorResult<Object> getResult();

	/**
	 * Check the rule state which breaks the other rule when it's failed
	 * 
	 * @return the rule state
	 */
	boolean skipOnFailure();

	/**
	 * Execute the rule
	 * 
	 * @return true if all data of the rule is valid, false else
	 */
	void process() throws Exception;

	/**
	 * Set data for the validator
	 * 
	 * @param data
	 */
	void setData(final Object data);
}
