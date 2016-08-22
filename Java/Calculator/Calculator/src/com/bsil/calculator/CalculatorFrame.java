package com.bsil.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import com.bsil.calculator.commandstore.commandProvider;
import com.bsil.calculator.compute.ICompute;
import com.bsil.calculator.compute.computeEnvironment;
import com.bsil.calculator.compute.interpreter;

import java.awt.Component;
import java.awt.Container;

public class CalculatorFrame 
extends JFrame 
implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String[] buttonList = { "MC", "MR", "M+", "M-",  "CE", "C", "+/-",
			"Sq. Rt", "/", "*", "-", "+", "=", "7", "8", "9", "4", "5", "6",
			"3", "2", "1", "0", "." };
	JButton b;
	JTextField txtinput = new JTextField("                 ");
	int rows = 10;
	int cols = 10;
	ICompute m_compute;
		
	public CalculatorFrame(String title) {
		super(title);
		setSize(1600,1550); 
		setLayout(new SpringLayout());
		addWindowListener(this);
		add(txtinput);
		JPanel panel = new JPanel(new SpringLayout());		
		for(String btnName: buttonList)
		{
			JButton btnControl = new JButton(btnName);
			btnControl.addActionListener(this);
			panel.add(btnControl);			
		}
	
		add(panel);
		SpringUtilities.makeGrid(panel, 6, 4, // rows, cols
				5, 40, // initialX, initialY
				5, 5);// xPad, yPad		
		m_compute = new computeEnvironment(new interpreter(), new commandProvider());
	}
	
	public void actionPerformed(ActionEvent e) {
		txtinput.setText(m_compute.compute(e.getActionCommand()));
	}

	public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

}
