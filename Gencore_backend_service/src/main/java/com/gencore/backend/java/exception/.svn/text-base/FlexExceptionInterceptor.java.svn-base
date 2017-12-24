package com.gencore.backend.java.exception;

import org.springframework.flex.core.MessageInterceptor;
import org.springframework.flex.core.MessageProcessingContext;

import flex.messaging.messages.Message;

public class FlexExceptionInterceptor implements MessageInterceptor {

	@Override
	public Message postProcess(MessageProcessingContext context, Message inputMessage, Message outputMessage) {
        Object result =  outputMessage.getBody();
        
        //...Do some sort of processing on result...
        
        outputMessage.setBody(result);
        
        return outputMessage;
	}

	@Override
	public Message preProcess(MessageProcessingContext context, Message inputMessage) {
        //Don't need to process the incoming message, so just return it
        return inputMessage;
	}

	// public Object invoke(MethodInvocation invocation) throws Throwable {
	//
	// Object returnObject = null;
	// String className = null;
	// String methodName = null;
	//
	// try {
	// className = invocation.getThis().getClass().getSimpleName();
	// methodName = invocation.getMethod().getName();
	// returnObject = invocation.proceed();
	// } catch (Throwable ex) {
	//
	// throw new FlexServiceException(className + '.' + methodName);
	// }
	// return null;
	// }

}
