package com.copywrite.slacker.generator.scala;

import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.java.JavaTransferGenerator;

public class ScalaTransferGenerator extends JavaTransferGenerator {
    @Override
    public Code getCode() {
        return Code.SCALA;
    }

}
