package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaDoGenerator;

public class ScalaDoGenerator extends JavaDoGenerator {
    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
