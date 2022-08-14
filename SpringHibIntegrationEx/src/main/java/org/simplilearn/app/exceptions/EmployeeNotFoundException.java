package org.simplilearn.app.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String desc) {
		super(desc);
	}
}
