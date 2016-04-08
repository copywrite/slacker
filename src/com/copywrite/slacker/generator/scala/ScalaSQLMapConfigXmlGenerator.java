package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaSQLMapConfigXmlGenerator;

public class ScalaSQLMapConfigXmlGenerator  extends JavaSQLMapConfigXmlGenerator {
    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
