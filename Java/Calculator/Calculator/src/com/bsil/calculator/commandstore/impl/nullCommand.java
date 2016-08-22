package com.bsil.calculator.commandstore.impl;

import com.bsil.calculator.commandstore.ICommand;
import com.bsil.calculator.commandstore.commandResponse;
import com.bsil.calculator.utils.constants;

public class nullCommand implements ICommand {

	@Override
	public commandResponse execute(String param1, String param2) {		
		return new commandResponse(constants.EMPTY_STRING,constants.EMPTY_STRING);
	}

}
