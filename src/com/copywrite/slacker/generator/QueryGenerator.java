package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;

import java.util.List;

public interface QueryGenerator {
    public String generate(String queryClassName, List<Column> columnQueryList);
}
