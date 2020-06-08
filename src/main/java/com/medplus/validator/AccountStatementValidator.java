package com.medplus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.medplus.command.AccountStatementCommand;

public class AccountStatementValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(AccountStatementCommand.class);
	}

	@Override
	public void validate(Object command, Errors error) {
		AccountStatementCommand trStatementCommand = (AccountStatementCommand) command;

		if (trStatementCommand.getAccount() == null || trStatementCommand.getAccount().equals("")) {
			error.rejectValue("account", "account.blank");
		}

	}

}
