package com.task.algoritms;

import com.task.finterface.A;

public class ClassC implements ClassA, ClassB {

    @Override
    public void method() {
        ClassA.super.method();
    }
}
