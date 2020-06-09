
package com.medplus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.medplus.command.AccountStatementCommand;
import com.medplus.dto.AccountStatementDto;

@SuppressWarnings("deprecation")
public class AccountStatementFormController extends SimpleFormController {

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {

		List<AccountStatementDto> statements = null;
		ModelAndView mav = null;
		AccountStatementCommand aCommand = null;

		statements = new ArrayList<>();
		mav = new ModelAndView();
		aCommand = (AccountStatementCommand) command;
		statements.add(new AccountStatementDto(1584, new Date(), "db mall", 500f, 0, 1505));
		statements.add(new AccountStatementDto(1454, new Date(), "pentaloons", 1005f, 0, 900));
		statements.add(new AccountStatementDto(1544, new Date(), "hp oil petrol", 200f, 0, 700));
		statements.add(new AccountStatementDto(1754, new Date(), "paytm", 50f, 0, 650));
		statements.add(new AccountStatementDto(1654, new Date(), "zomato", 250f, 0, 400));
		mav.addObject(aCommand);
		mav.addObject("statements", statements);
		if (aCommand.getStatementType().equals("normal")) {
			mav.setViewName("account-statement");
			return mav;
		}
		if (aCommand.getStatementType().equals("pdf")) {
			mav.setViewName("account-statement-pdf");
			return mav;
		}

		if (aCommand.getStatementType().equals("xls")) {
			mav.setViewName("account-statement-xls");
			return mav;
		}

		return mav;
	}

}
