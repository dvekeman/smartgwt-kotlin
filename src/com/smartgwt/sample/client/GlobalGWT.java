package com.smartgwt.sample.client;

import java.util.HashMap;
import java.util.Map;

import jsinterop.annotations.JsType;

@JsType(namespace = "globalgwt")
public class GlobalGWT {
	
	private static Map<String, Object> shared = new HashMap<>();

	public static void register(String name, Object o) {
		shared.put(name, o);
	}

	public static Object lookup(String name) {
		return shared.get(name);
	}
	
}
