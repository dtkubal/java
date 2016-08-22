package com.bsil.calculator.di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Flywheel Implementation
public class depedancyregister implements idepedancyregistr {

	private static final Map<String, Object> m_objectMap = new HashMap<String, Object>();

	private depedancyregister() {
	}

	private static depedancyregister m_obj;

	public static synchronized idepedancyregistr instance() {
		if (m_obj == null)
			m_obj = new depedancyregister();
		return m_obj;
	}

	@Override
	public <T> void register(T object) {
		if(!m_objectMap.containsKey(object.getClass().getName()))
			m_objectMap.put(object.getClass().getName(), object);

	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T reslove(String type) {
		if(m_objectMap.containsKey(type))
			return (T) m_objectMap.get(type);			
		return null;
	}

}
