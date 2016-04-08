package com.copywrite.slacker.generator;


import com.copywrite.slacker.domain.Column;

import java.util.List;

public interface DoGenerator {
    public String generate(String className, List<Column> columnList);
}
