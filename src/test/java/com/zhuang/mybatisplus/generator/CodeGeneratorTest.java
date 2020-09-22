package com.zhuang.mybatisplus.generator;

import org.junit.Test;

public class CodeGeneratorTest {

    @Test
    public void generate() {
        new CodeGenerator().generate();
    }

    public static void main(String[] args) {
        new CodeGenerator().generate();
    }
}
