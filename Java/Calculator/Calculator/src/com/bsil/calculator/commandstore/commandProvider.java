package com.bsil.calculator.commandstore;

import java.util.HashMap;
import java.util.Map;

import com.bsil.calculator.commandstore.impl.addCommand;
import com.bsil.calculator.commandstore.impl.nullCommand;
import com.bsil.calculator.compute.operation;

public class commandProvider implements ICommandProvider {
	Map<String, ICommand> m_commands = new HashMap<String, ICommand>();
	public ICommand GetCommand(operation opr) {
		if (!m_commands.containsKey(opr.toString())) {
			switch (opr) {
			default:
				m_commands.putIfAbsent(opr.toString(), new nullCommand());
				break;
			case PLUS:
				m_commands.putIfAbsent(opr.toString(), new addCommand());
				break;
			}
		}
		return m_commands.get(opr.toString());
	}
}
