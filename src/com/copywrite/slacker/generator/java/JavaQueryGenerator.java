package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;

public class JavaQueryGenerator extends JavaDoGenerator {
    @Override
    public GenerateType generateType() {
        return GenerateType.Query;
    }
}
