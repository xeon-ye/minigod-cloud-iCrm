package com.sunline.modules.common.utils;

import java.util.Random;

/**
 * @author LiYangFeng
 * @createDate 2017/4/1
 * @description
 * @email justbelyf@gmail.com
 */
public class CharacterStringGenerate {
    /**
     * 生成随机字符串
     *
     * @param len 字符串长度
     * @return
     */
    public static String generate(int len) {
        String letterCharacters = generateLetters(4);
        String numberCharacters = generateNumber(4);

        return letterCharacters + numberCharacters;
    }

    public static String generate2(int len) {
        int i;
        int count = 0;
        // 字符串字典
        char[] str = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random r = new Random();
        while (count < len) {
            // 生成 0 ~ 密码字典-1之间的随机数
            i = r.nextInt(str.length - 1);
            stringBuffer.append(str[i]);
            count++;
        }
        return stringBuffer.toString();
    }

    private static String generateLetters(int len) {
        int i;
        int count = 0;
        // 字符串字典
        char[] str = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random r = new Random();
        while (count < len) {
            // 生成 0 ~ 密码字典-1之间的随机数
            i = r.nextInt(str.length - 1);
            stringBuffer.append(str[i]);
            count++;
        }
        return stringBuffer.toString();
    }

    private static String generateNumber(int len) {
        int i;
        int count = 0;
        // 字符串字典
        char[] str = {'2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random r = new Random();
        while (count < len) {
            // 生成 0 ~ 密码字典-1之间的随机数
            i = r.nextInt(str.length - 1);
            stringBuffer.append(str[i]);
            count++;
        }
        return stringBuffer.toString();
    }

    public static String generateCaSn(int len) {
        int i;
        int count = 0;
        // 字符串字典
        char[] str = {
                'A', 'B', 'C', 'D', 'E', 'F', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random r = new Random();
        while (count < len) {
            i = r.nextInt(str.length - 1);
            stringBuffer.append(str[i]);
            count++;
        }
        return stringBuffer.toString();
    }

    public static String generateCaHashNo(int len) {
        int i;
        int count = 0;
        // 字符串字典
        char[] str = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        StringBuffer stringBuffer = new StringBuffer("");
        Random r = new Random();
        while (count < len) {
            i = r.nextInt(str.length - 1);
            stringBuffer.append(str[i]);
            count++;
        }
        return stringBuffer.toString();
    }

}
