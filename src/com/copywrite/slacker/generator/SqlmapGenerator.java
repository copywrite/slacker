package com.copywrite.slacker.generator;


import com.copywrite.slacker.domain.Column;

import java.util.List;

public interface SqlmapGenerator {
    public String generate(String tableName, Column primaryKeyColumn, String doClassName, String daoClassName, List<Column> columnList, List<Column> columnQueryList);
}
