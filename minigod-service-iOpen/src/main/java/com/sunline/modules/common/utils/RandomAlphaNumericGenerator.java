package com.sunline.modules.common.utils;

import java.util.Random;

/**
 * @description: 随机数工具类
 * @author: Larry Lai
 * @date: 2019/9/3 13:27
 * @version: v1.0
 */

public class RandomAlphaNumericGenerator {

    private static final char[] symbols;

    private final Random random = new Random();

    private final char[] buf;

    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch) {
            tmp.append(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            tmp.append(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            tmp.append(ch);
        }

        // 添加一些特殊字符
//        tmp.append("!@#$%");
        symbols = tmp.toString().toCharArray();
    }

    private RandomAlphaNumericGenerator(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length < 1: " + length);
        }

        buf = new char[length];
    }

    private String nextString() {
        for (int idx = 0; idx < buf.length; ++idx) {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }
        return new String(buf);
    }

    public static void main(String[] args) {
        RandomAlphaNumericGenerator randomTest = new RandomAlphaNumericGenerator(8);
        for (int i = 0; i < 1; i++) {
            String result = null;
            do {
                result = randomTest.nextString();
            } while (!result.matches(".*(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*"));
            System.out.println(result);
        }
    }
}
