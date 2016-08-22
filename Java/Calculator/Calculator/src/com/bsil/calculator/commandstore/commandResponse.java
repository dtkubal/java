package com.bsil.calculator.commandstore;

import com.bsil.calculator.utils.constants;

public class commandResponse {
	
	public commandResponse(String retValue, String error ) {
		
		this.retValue = retValue;
		this.error = error; 
	}

	public String retValue;
	
	public boolean success() {
		return (error == null || error == constants.EMPTY_STRING);		
	};	
	
	public String  error;	
}
