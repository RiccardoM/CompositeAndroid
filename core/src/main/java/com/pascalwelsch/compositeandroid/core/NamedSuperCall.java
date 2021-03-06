package com.pascalwelsch.compositeandroid.core;

public abstract class NamedSuperCall {

    private final String mMethodName;

    public NamedSuperCall(final String methodName) {
        mMethodName = methodName;
    }

    public String getMethodName() {
        return mMethodName;
    }
}
