package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaBaseDAOGenerator;

public class ScalaBaseDAOGenerator extends JavaBaseDAOGenerator {

    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
