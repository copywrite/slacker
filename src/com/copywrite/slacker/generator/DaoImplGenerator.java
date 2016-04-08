package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;

public interface DaoImplGenerator {
    public String generate(String doClassName, String queryClassName, String daoClassName, String daoImplClassName, Column primaryKeyColumn, String tableName);
}
