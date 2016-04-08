package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Column;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.ManagerGenerator;
import com.copywrite.slacker.storage.SettingManager;
import com.copywrite.slacker.util.NameUtil;
import com.copywrite.slacker.util.PathHolder;

import java.util.List;
import java.util.Map;

public class JavaManagerGenerator extends BaseGenerator implements ManagerGenerator {
    @Override
    public String generate(String objClassName, String queryClassName, String managerClassName, Column primaryKeyColumn) {
        Setting setting = SettingManager.get();
        List<String> importList = getImportList(primaryKeyColumn, false, true);
        importList.add(PathHolder.impt(GenerateType.Query, queryClassName));
        if(setting.isManagerUseBO()) {
            importList.add(PathHolder.impt(GenerateType.BO, objClassName));
        }else{
            importList.add(PathHolder.impt(GenerateType.DO, objClassName));
        }
        Map<String,Object> map = initMap();
        map.put("className", managerClassName);
        map.put("objClassName", objClassName);
        map.put("objPropertyName", NameUtil.lowFirst(objClassName));
        map.put("queryClassName", queryClassName);
        map.put("queryPropertyName", NameUtil.lowFirst(queryClassName));
//        map.put("primaryKeyColumn", primaryKeyColumn);
        try{
            map.put("primaryKeyName", primaryKeyColumn.getProperty());
            map.put("primaryKeyType", primaryKeyColumn.getType());
        }catch (Exception e){
            map.put("primaryKeyName", "id");
            map.put("primaryKeyType", "Long");
        }
        map.put("importList", importList);
        return generate("tpl/" + getCode().getTplPath() + "/manager.ftl", map);
    }

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.Manager;
    }
}
