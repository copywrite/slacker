package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaSqlmapGenerator;

public class ScalaSqlmapGenerator extends JavaSqlmapGenerator {
    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
