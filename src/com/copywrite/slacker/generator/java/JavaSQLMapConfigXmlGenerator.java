package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.SQLMapConfigXmlGenerator;
import com.copywrite.slacker.storage.SettingManager;

import java.util.Map;

public class JavaSQLMapConfigXmlGenerator extends BaseGenerator implements SQLMapConfigXmlGenerator {
    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.SQLMapConfigXml;
    }

    @Override
    public String generate(String tableName) {
        Map<String,Object> map = initMap();
        map.put("tableName",tableName);
        Setting setting = SettingManager.get();
        map.put("encoding", setting.getEncoding());
        return generate("tpl/java/sqlmapconfig.ftl", map);
    }
}
