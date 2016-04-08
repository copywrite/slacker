package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;

public interface DaoGenerator {
    public String generate(String doClassName, String queryClassName, String daoClassName, Column primaryKeyColumn);
}
