package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaManagerGenerator;

public class ScalaManagerGenerator extends JavaManagerGenerator {

    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
