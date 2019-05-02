package com.smartgwt.sample.client;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(namespace = "globalkt")
public class GlobalKt {

    @JsMethod(namespace = "app.main", name = "startApp")
    public static native void startApp();

}
