package com.bsil.calculator.commandstore;

public interface ICommand {
	
	commandResponse execute(String param1, String param2);
}

