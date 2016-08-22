package com.bsil.calculator.compute;

import com.bsil.calculator.commandstore.ICommand;
import com.bsil.calculator.commandstore.ICommandProvider;
import com.bsil.calculator.commandstore.commandResponse;
import com.bsil.calculator.utils.constants;

public class computeEnvironment implements ICompute {

	private IInterpreter m_interpreter;
	private ICommand m_command = null;
	private ICommandProvider m_cmdprovider = null;
	private String m_memory = constants.EMPTY_STRING;
	private String m_param1 = constants.EMPTY_STRING;
	private String m_param2 = constants.EMPTY_STRING;
	private String m_result = constants.EMPTY_STRING;

	public computeEnvironment(IInterpreter interpreter,
			ICommandProvider cmdprovider) {
		m_interpreter = interpreter;
		m_cmdprovider = cmdprovider;
	}

	public String compute(String value) {
		String out = constants.EMPTY_STRING;
		operation result = m_interpreter.interpret(value);
		if (result == operation.INPUT) {
			if (m_command == null)
				{
					m_param1 += value;
					out = m_param1;
				}
			else
				{
					m_param2 += value;
					out = m_param2;
				}
		}
		else if (result == operation.YELIDOPERATION && m_command != null){			
			commandResponse resp = m_command.execute(m_param1, m_param2);
			if(resp.success())
				{
					m_param1 = resp.retValue;
					out = resp.retValue;
				}
		}
		else  {
			m_command = m_cmdprovider.GetCommand(result);
		}		
		return out;
	}

	// TODO: I didn't like the way it is manipluating the result
	public String result() {
		if (m_result != constants.EMPTY_STRING)
			return m_result;

		if (m_param2 != constants.EMPTY_STRING)
			return m_param2;

		if (m_param2 != constants.EMPTY_STRING)
			return m_param2;

		return constants.EMPTY_STRING;

	}

}
