package com.bsil.calculator;

import java.awt.Event;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.bsil.calculator.commandstore.commandProvider;
import com.bsil.calculator.di.depedancyregister;

public class startup {

	public static void main(String[] args) {
		System.out.println("Started");
		CalculatorFrame myWindow = new CalculatorFrame("My first window");
		myWindow.setSize(350, 100);
		myWindow.setVisible(true);
		/*depedancyregister.instance().register(new commandProvider());
		commandProvider cmdprov =    depedancyregister.instance().reslove(commandProvider.class.getName());*/
	}
}
