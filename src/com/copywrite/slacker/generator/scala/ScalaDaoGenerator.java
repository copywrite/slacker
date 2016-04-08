package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaDaoGenerator;

public class ScalaDaoGenerator extends JavaDaoGenerator {

    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
