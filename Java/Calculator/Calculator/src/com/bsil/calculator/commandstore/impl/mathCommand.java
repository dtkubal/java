package com.bsil.calculator.commandstore.impl;

import com.bsil.calculator.commandstore.ICommand;
import com.bsil.calculator.commandstore.commandResponse;
import com.bsil.calculator.compute.operation;

public class mathCommand implements ICommand {

	private operation m_operation;

	public mathCommand(operation opr) {
		m_operation = opr;
	}

	public commandResponse execute(String param1, String param2) {
		Long value = Math.addExact(Long.parseLong(param1),
				Long.parseLong(param2));
		return new commandResponse(value.toString(), "");
	}
}
