package com.auth.exception;

public class DuplicateUserFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateUserFoundException(String msg) {
		super(msg);
	}
	
}
