package com.bsil.calculator.compute;

import java.util.Arrays;

public class interpreter implements IInterpreter {

	String[] inputoperations = {  "7", "8", "9", "4", "5", "6",
			"3", "2", "1", "0", "." };

	String[] arithmeticoperations = {  "+/-",
			"Sq. Rt", "/", "*", "-", "+" };
		
	public operation interpret(String value) {
		
		if(value.equals("="))
			return operation.YELIDOPERATION;
		else if(Arrays.asList(inputoperations).indexOf(value) != -1)
			return operation.INPUT;
		else if(Arrays.asList(arithmeticoperations).indexOf(value) != -1)
		{
			switch(value)
			{
			default : 
				return operation.UNKNOWN;
			case "+" : 
				return operation.PLUS;
			}
		}
		else
			return operation.UNKNOWN;
	}

}
