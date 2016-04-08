package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.constant.GenerateType;

public class ScalaBoGenerator extends ScalaDoGenerator{
    @Override
    public GenerateType generateType() {
        return GenerateType.BO;
    }
}
