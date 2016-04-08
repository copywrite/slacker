package com.copywrite.slacker.constant;

/**
 * Created by houmikado on 16/4/8.
 */

import com.copywrite.slacker.storage.Env;

/**
 * User: duxing
 * Date: 2015.08.14 1:25
 */

public enum GenerateType {
    DO("DO","DO","do/","do",TypePath.SRC),
    BO("BO","BO","bo/","bo",TypePath.SRC),
    Query("Query","Query","query/","query",TypePath.SRC),
    SQLMap("SQLMap","sqlmap","sqlmap/","dataobject",TypePath.RESOURCES),
    DAO("DAO","DAO","dao/","dao",TypePath.SRC),
    DAOImpl("DAO","DAO","dao/","dao",TypePath.SRC),
    Manager("Manager","Manager","manager/","manager",TypePath.SRC),
    ManagerImpl("Manager","Manager","manager/","manager",TypePath.SRC),
    Transfer("Transfer","Transfer","transfer/","transfer",TypePath.SRC),
    BaseDAO("BaseDAO","BaseDAO","dao/","dao",TypePath.SRC),
    BaseQuery("BaseQuery","BaseQuery","query/","query",TypePath.SRC),
    DAOXml("DAO.Xml","dao-sample","/","dao.impl",TypePath.RESOURCES),
    SQLMapConfigXml("SQLMap-Config.Xml","sqlmap-config-sample","/","/",TypePath.RESOURCES),
    PersistenceXml("Persistence.Xml","persistence-sample","/","dao",TypePath.RESOURCES),
    ALL("All","All","","",null);
    private String name;
    private String suffix;
    private String path;
    private String pkg;
    private TypePath typePath;

    GenerateType(String name, String suffix, String path, String pkg,TypePath typePath) {
        this.name = name;
        this.suffix = suffix;
        this.path = path;
        this.pkg = pkg;
        this.typePath = typePath;
    }

    public static GenerateType get(String name){
        if(name==null)return null;
        for(GenerateType c: GenerateType.values()){
            if(name.toLowerCase().equals(c.getName().toLowerCase())){
                return c;
            }
        }
        return null;
    }

    public static GenerateType getBySuffix(String suffix){
        if(suffix==null)return null;
        for(GenerateType c: GenerateType.values()){
            if(c.getSuffix().toLowerCase().equals(suffix.toLowerCase())){
                return c;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPath() {
        if("/".equals(Env.sp)){ //mac linux
            return path;
        }else{ //widows
            return path.replaceAll("\\/","\\"+Env.sp);
        }
    }

    public String getPkg() {
        return pkg;
    }

    public TypePath getTypePath() {
        return typePath;
    }
}

