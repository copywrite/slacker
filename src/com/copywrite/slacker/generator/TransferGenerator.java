package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;

import java.util.List;

public interface TransferGenerator {
    public String generate(String doClassName, String boClassName, String transferClassName, List<Column> columnList);
}
