package com.objis.cmr.sge;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnAuthorizedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4325764797468289823L;
	protected static MessageSourceAccessor message = SpringSecurityMessageSource.getAccessor();
	
	public UnAuthorizedException() {
		super(message.getMessage("AbstractAccessDecisionManager.accessDenied", "Access is denied !!!"));
	}
	
	public UnAuthorizedException(String message)
	{
		super(message);
	}

}
