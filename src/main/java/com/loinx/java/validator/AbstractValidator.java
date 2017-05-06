package com.loinx.java.validator;

public abstract class AbstractValidator implements Validator, Comparable<Validator> {

	protected Object data;

	protected String name;

	/**
	 * Default Rule constructor
	 */
	public AbstractValidator() {
		this(DEFAULT_NAME);
	}

	/**
	 * Rule Constructor with name
	 * 
	 * @param name
	 */
	public AbstractValidator(final String name) {
		this.name = name;
	}

	public void process() throws Exception {
		initialize();
		validate();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + getPriority();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractValidator)) {
			return false;
		}
		AbstractValidator other = (AbstractValidator) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (getPriority() != other.getPriority()) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(final Validator rule) {
		if (getPriority() < rule.getPriority()) {
			return -1;
		} else if (getPriority() > rule.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

	protected abstract boolean validate() throws Exception;

	protected void initialize() throws Exception {
		// do nothing
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public void setData(Object data) {
		this.data = data;
	}

}
