package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.DAOXmlGenerator;
import com.copywrite.slacker.storage.SettingManager;
import com.copywrite.slacker.util.NameUtil;

import java.util.Map;

public class JavaDAOXmlGenerator extends BaseGenerator implements DAOXmlGenerator {

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.DAOXml;
    }

    @Override
    public String generate(String daoClassName, String daoImplClassName) {
        Map<String,Object> map = initMap();
        map.put("daoClassName",daoClassName);
        map.put("daoPropertyName", NameUtil.lowFirst(daoClassName));
        map.put("daoImplClassName",daoImplClassName);
        Setting setting = SettingManager.get();
        map.put("encoding", setting.getEncoding());
        return generate("tpl/java/daoxml.ftl", map);
    }
}
