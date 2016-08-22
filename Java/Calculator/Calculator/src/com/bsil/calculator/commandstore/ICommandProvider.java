package com.bsil.calculator.commandstore;

import com.bsil.calculator.compute.operation;

public interface ICommandProvider {

	ICommand GetCommand(operation opr);

}
