package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;
import com.copywrite.slacker.generator.java.*;

import java.util.List;

public class JavaGenerator extends CodeAbstractGenerator {
    @Override
    public String space() {
        return "    ";
    }

    @Override
    public String generateDO(String doClassName, List<Column> columnList) {
        return new JavaDoGenerator().generate(doClassName, columnList);
    }

    @Override
    public String generateDAO(String doClassName, String queryClassName, String daoClassName, Column primaryKeyColumn) {
        return new JavaDaoGenerator().generate(doClassName, queryClassName,daoClassName,primaryKeyColumn);
    }

    @Override
    public String generateDAOImpl(String doClassName, String queryClassName, String daoClassName, String daoImplClassName, Column primaryKeyColumn, String tableName) {
        return new JavaDaoImplGenerator().generate(doClassName, queryClassName,daoClassName,daoImplClassName, primaryKeyColumn,tableName);
    }

    @Override
    public String generateQuery(String queryClassName, List<Column> columnQueryList) {
        return new JavaQueryGenerator().generate(queryClassName, columnQueryList);
    }

    @Override
    public String generateBO(String boClassName, List<Column> columnList) {
        return new JavaBoGenerator().generate(boClassName, columnList);
    }

    @Override
    public String generateManager(String objClassName, String queryClassName, String managerClassName, Column primaryKeyColumn) {
        return new JavaManagerGenerator().generate(objClassName, queryClassName,managerClassName,primaryKeyColumn);
    }

    @Override
    public String generateManagerImpl(String doClassName, String boClassName, String queryClassName, String transferClassName, String daoClassName, String managerClassName, String managerImplClassName, Column primaryKeyColumn) {
        return new JavaManagerImplGenerator().generate(doClassName, boClassName, queryClassName,transferClassName, daoClassName, managerClassName, managerImplClassName, primaryKeyColumn);
    }

    @Override
    public String generateTransfer(String doClassName, String boClassName, String transferClassName, List<Column> columnList) {
        return new JavaTransferGenerator().generate(doClassName, boClassName, transferClassName, columnList);
    }

    @Override
    public String generateSqlmap(String tableName, Column primaryKeyColumn, String doClassName, String daoClassName, List<Column> columnList, List<Column> columnQueryList) {
        return new JavaSqlmapGenerator().generate(tableName, primaryKeyColumn, doClassName, daoClassName, columnList, columnQueryList);
    }

    @Override
    public String generateBaseDAO() {
        return new JavaBaseDAOGenerator().generate();
    }

    @Override
    public String generateBaseQuery() {
        return new JavaBaseQueryGenerator().generate();
    }

    @Override
    public String generateDAOXml(String daoClassName, String daoImplClassName) {
        return new JavaDAOXmlGenerator().generate(daoClassName,daoImplClassName);
    }

    @Override
    public String generateSQLMapConfigXml(String tableName) {
        return new JavaSQLMapConfigXmlGenerator().generate(tableName);
    }

    @Override
    public String generatePersistenceXml(String tableName) {
        return new JavaPersistenceXmlGenerator().generate(tableName);
    }
}
