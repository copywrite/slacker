package com.copywrite.slacker.generator.java;

import com.copywrite.slacker.constant.GenerateType;
import com.copywrite.slacker.domain.Code;
import com.copywrite.slacker.domain.Column;
import com.copywrite.slacker.domain.Setting;
import com.copywrite.slacker.generator.BaseGenerator;
import com.copywrite.slacker.generator.DaoGenerator;
import com.copywrite.slacker.storage.SettingManager;
import com.copywrite.slacker.util.NameUtil;
import com.copywrite.slacker.util.PathHolder;

import java.util.List;
import java.util.Map;

public class JavaDaoGenerator extends BaseGenerator implements DaoGenerator {
    @Override
    public String generate(String doClassName, String queryClassName, String daoClassName, Column primaryKeyColumn) {
        Map<String,Object> map = initMap();
        map.put("objClassName",doClassName);
        map.put("objPropertyName", NameUtil.lowFirst(doClassName));
        map.put("className", daoClassName);
        map.put("queryClassName", queryClassName);
        map.put("queryPropertyName", NameUtil.lowFirst(queryClassName));
        try{
            map.put("primaryKeyName", primaryKeyColumn.getProperty());
            map.put("primaryKeyType", primaryKeyColumn.getType());
        }catch (Exception e){
            map.put("primaryKeyName", "id");
            map.put("primaryKeyType", "Long");
        }
        List<String> importList = getImportList(primaryKeyColumn, false, true);
        importList.add(PathHolder.impt(GenerateType.DO, doClassName));
        importList.add(PathHolder.impt(GenerateType.Query,queryClassName));
//        importList.add(PathHolder.impt(GenerateType.BaseDAO, GenerateType.BaseDAO.getName()));
        map.put("importList", importList);
        Setting setting = SettingManager.get();
        map.put("daoLogicDelete", setting.isDaoLogicDelete());
        return generate("tpl/" + getCode().getTplPath() + "/dao.ftl", map);
    }

    @Override
    public Code getCode() {
        return Code.JAVA;
    }

    @Override
    public GenerateType generateType() {
        return GenerateType.DAO;
    }
}
