package com.copywrite.slacker.generator.scala;


import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaManagerImplGenerator;

public class ScalaManagerImplGenerator extends JavaManagerImplGenerator {
    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
