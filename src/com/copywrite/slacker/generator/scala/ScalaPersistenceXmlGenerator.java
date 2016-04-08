package com.copywrite.slacker.generator.scala;


import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaPersistenceXmlGenerator;

public class ScalaPersistenceXmlGenerator extends JavaPersistenceXmlGenerator {

    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
