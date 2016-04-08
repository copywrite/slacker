package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;

public class JavaBoGenerator extends JavaDoGenerator {

    @Override
    public GenerateType generateType() {
        return GenerateType.BO;
    }
}
