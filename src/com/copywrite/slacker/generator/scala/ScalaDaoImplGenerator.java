package com.copywrite.slacker.generator.scala;


import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaDaoImplGenerator;

public class ScalaDaoImplGenerator extends JavaDaoImplGenerator {

    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
