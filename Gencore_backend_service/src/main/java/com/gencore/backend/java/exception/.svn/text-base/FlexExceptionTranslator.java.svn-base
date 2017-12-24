package com.gencore.backend.java.exception;

import org.springframework.flex.core.ExceptionTranslator;

import flex.messaging.MessageException;

public class FlexExceptionTranslator implements ExceptionTranslator {

	public boolean handles(Class<?> arg0) {
		return true;
	}

	public MessageException translate(Throwable t) {
	    MessageException ex = new MessageException();
//	    StackTraceElement[] stackTrackElements = t.getStackTrace();
//	    
//	    String className = stackTrackElements[0].getClassName();
//	    String methodName = stackTrackElements[0].getMethodName();
//	    String string = stackTrackElements[0].toString();
//	    String fileName = stackTrackElements[0].getFileName();
//	    	    
	    ex.setCode(t.getLocalizedMessage());
//	    ex.setMessage(t.getLocalizedMessage());
//	    ex.setRootCause(t);
	    return ex;
	}
}
