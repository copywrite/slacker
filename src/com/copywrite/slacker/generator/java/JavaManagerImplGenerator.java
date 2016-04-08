package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Column;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.ManagerImplGenerator;
import com.copywrite.slacker.storage.SettingManager;
import com.copywrite.slacker.util.NameUtil;
import com.copywrite.slacker.util.PathHolder;

import java.util.List;
import java.util.Map;

public class JavaManagerImplGenerator extends BaseGenerator implements ManagerImplGenerator {
    @Override
    public String generate(String doClassName, String boClassName, String queryClassName, String transferClassName, String daoClassName, String managerClassName, String managerImplClassName, Column primaryKeyColumn) {
        Setting setting = SettingManager.get();
        List<String> importList = getImportList(primaryKeyColumn,false,true);
        importList.add(PathHolder.impt(GenerateType.Manager, managerClassName));
        importList.add(PathHolder.impt(GenerateType.DAO,daoClassName));
        importList.add(PathHolder.impt(GenerateType.Query,queryClassName));
        Map<String,Object> map = initMap();
        map.put("className", managerImplClassName);
        map.put("doClassName", doClassName);
        map.put("boClassName", boClassName);
        map.put("managerClassName", managerClassName);
        map.put("managerPropertyName", NameUtil.lowFirst(managerClassName));
        map.put("managerUseBO", setting.isManagerUseBO());
        if(setting.isManagerUseBO()){
            map.put("objClassName",boClassName);
            map.put("objPropertyName", NameUtil.lowFirst(boClassName));
            importList.add(PathHolder.impt(GenerateType.BO, boClassName));
            importList.add(PathHolder.impt(GenerateType.Transfer, transferClassName));
        }else{
            map.put("objClassName",doClassName);
            map.put("objPropertyName", NameUtil.lowFirst(doClassName));
            importList.add(PathHolder.impt(GenerateType.DO, doClassName));
        }
        map.put("queryClassName", queryClassName);
        map.put("queryPropertyName", NameUtil.lowFirst(queryClassName));
        map.put("transferClassName", transferClassName);
        map.put("daoClassName", daoClassName);
        map.put("daoPropertyName", NameUtil.lowFirst(daoClassName));
        try{
            map.put("primaryKeyName", primaryKeyColumn.getProperty());
            map.put("primaryKeyType", primaryKeyColumn.getType());
        }catch (Exception e){
            map.put("primaryKeyName", "id");
            map.put("primaryKeyType", "Long");
        }

        map.put("importList", importList);
        return generate("tpl/" + getCode().getTplPath() + "/managerimpl.ftl", map);
    }

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.ManagerImpl;
    }
}
