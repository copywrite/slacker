package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.PersistenceXmlGenerator;
import com.copywrite.slacker.storage.SettingManager;
import com.copywrite.slacker.util.NameUtil;

import java.util.Map;

/**
 * User: duxing
 * Date: 2015-08-17 00:39
 */
public class JavaPersistenceXmlGenerator extends BaseGenerator implements PersistenceXmlGenerator {

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.PersistenceXml;
    }

    @Override
    public String generate(String tableName) {
        Map<String,Object> map = initMap();
        map.put("tableName",tableName);
        map.put("tablePropertyName", NameUtil.propertyName(tableName));
        Setting setting = SettingManager.get();
        map.put("encoding", setting.getEncoding());
        return generate("tpl/java/persistence.ftl", map);
    }
}
