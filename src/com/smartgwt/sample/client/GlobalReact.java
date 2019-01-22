package com.smartgwt.sample.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class GlobalReact {

	@JsMethod(namespace = JsPackage.GLOBAL)
	public static native void startApp();

}
