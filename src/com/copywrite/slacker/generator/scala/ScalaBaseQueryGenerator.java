package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaBaseQueryGenerator;

public class ScalaBaseQueryGenerator extends JavaBaseQueryGenerator {
    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
