package com.itwill.service;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class UserService {
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void create() throws UserExistedException {
		/*
		 * user.existed.exception = {0} 는 존재하는 아이디 입니다. 
		 * user.existed.exception = {0} User ID already exist.
		 */
		// Locale locale=Locale.getDefault();
		Locale locale = LocaleContextHolder.getLocale();

		String msg = messageSource.getMessage("user.existed.exception", new Object[] { "xxx" }, locale);
		System.out.println("### UserService msg:" + msg);
		throw new UserExistedException(msg);

	}

}
