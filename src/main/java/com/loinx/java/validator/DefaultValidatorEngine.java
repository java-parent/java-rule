package com.loinx.java.validator;

import static com.loinx.java.validator.util.ValidatorUtil.checkNotNull;
import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author LoiNX
 *
 */
class DefaultValidatorEngine implements ValidatorEngine {

	private static final Logger logger = LoggerFactory.getLogger(DefaultValidatorEngine.class);

	private String name;

	private List<Object> results = new ArrayList<>();

	private boolean isExecuted;

	private Set<Validator> validators = new TreeSet<>();

	public DefaultValidatorEngine(String name) {
		super();
		this.name = StringUtils.isEmpty(name) ? this.getClass().getSimpleName() : name;
	}

	@Override
	public ValidatorEngine registerRule(Validator validator) {
		checkNotNull(validator, Validator.class.getName());
		validators.add(validator);
		return this;
	}

	@Override
	public ValidatorEngine unregisterRule(Validator validator) {
		checkNotNull(validator, Validator.class.getSimpleName());
		validators.remove(validator);
		return this;
	}

	@Override
	public Set<Validator> getValidators() {
		return validators;
	}

	@Override
	public void fireValidators() {
		if (validators.isEmpty()) {
			logger.info(format("The validators in %s are empty.", this.getName()));
			return;
		}
		if (hasExecuted()) {
			logger.info(format("The %s is executed.", this.getName()));
			return;
		}
		sortValidators();
		execute();
	}

	@Override
	public void clearValidators() {
		validators.clear();
	}

	private void sortValidators() {
		validators = new TreeSet<>(validators);
	}

	private void execute() {
		this.isExecuted = true;
		try {
			for (Validator validator : validators) {
				validator.process();
				if (!validator.getResult().isSuccess()) {
					results.addAll(validator.getResult().getErrors());
					if (validator.skipOnFailure()) {
						break;
					}
				}
			}

		} catch (Exception e) {
			logger.error("An exception occurs during executing the rule ", e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public List<Object> getResults() {
		return this.results;
	}

	@Override
	public ValidatorEngine registerRule(List<Validator> validators) {
		validators.forEach(validator -> this.registerRule(validator));
		return this;
	}

	@Override
	public boolean hasExecuted() {
		return this.isExecuted;
	}

}
