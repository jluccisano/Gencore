package com.gencore.backend.java.exception;

public class FlexServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public FlexServiceException (String string) {
		super(string);
	}
	
	public FlexServiceException () {
		super();
	}

}
