package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Column;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.DoGenerator;
import com.copywrite.slacker.storage.SettingManager;
import com.copywrite.slacker.util.PathHolder;

import java.util.List;
import java.util.Map;

public class JavaDoGenerator extends BaseGenerator implements DoGenerator {

    public String generate(String className, List<Column> columnList) {
        Map<String,Object> map = initMap();
        map.put("className",className);
        map.put("columnList", columnList);
        List<String> importList = getImportList(columnList, true);
        if(generateType().equals(GenerateType.Query)){
            Setting setting = SettingManager.get();
            map.put("pagerQuery",setting.isPagerQuery());
            importList.add(PathHolder.impt(GenerateType.BaseQuery, GenerateType.BaseQuery.getName()));
        }else{
            map.put("pagerQuery",false);
        }
        map.put("importList", importList);
        return generate("tpl/"+getCode().getTplPath()+"/do.ftl", map);
    }

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.DO;
    }
}
