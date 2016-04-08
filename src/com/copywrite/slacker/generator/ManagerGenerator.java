package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;

public interface ManagerGenerator {
    public String generate(String objClassName, String queryClassName, String managerClassName, Column primaryKeyColumn);
}
