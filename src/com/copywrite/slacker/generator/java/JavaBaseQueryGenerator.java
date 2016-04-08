package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.generator.BaseGenerator;

import java.util.Map;

public class JavaBaseQueryGenerator extends BaseGenerator {
    public String generate() {
        Map<String,Object> map = initMap();
        return generate("tpl/java/basequery.ftl", map);
    }

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.BaseQuery;
    }
}
