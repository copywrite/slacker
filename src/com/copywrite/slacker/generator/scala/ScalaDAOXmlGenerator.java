package com.copywrite.slacker.generator.scala;


import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaDAOXmlGenerator;

public class ScalaDAOXmlGenerator extends JavaDAOXmlGenerator {

    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
