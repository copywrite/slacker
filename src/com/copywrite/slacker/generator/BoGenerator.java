package com.copywrite.slacker.generator;

import com.copywrite.slacker.domain.Column;

import java.util.List;

public interface BoGenerator {
    public String generate(String boClassName, List<Column> columnList);
}
