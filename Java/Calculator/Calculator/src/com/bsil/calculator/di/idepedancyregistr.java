package com.bsil.calculator.di;

public interface idepedancyregistr {
	
	
	
	<T> void register(T object);
	
	<T> T reslove(String type);

}
