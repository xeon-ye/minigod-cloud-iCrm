package com.sunline.modules.account.online.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 * @description: 简繁转换器（支持香港/台湾字体库）
 * @author: Larry Lai
 * @date: 2019/1/28 12:48
 * @version: v1.0
 */

public class ChineseConverterHelper {

    private static final Logger logger = LoggerFactory.getLogger(ChineseConverterHelper.class);

    /**
     * 所有词汇
     */
    private Properties charMap = new Properties();

    /**
     * 高频词汇
     */
    private Set<String> conflictingSets = new HashSet<String>();

    /**
     * 繁体_台湾
     */
    public static final int TAIWAN = 0;

    /**
     * 繁体_香港
     */
    public static final int HONGKONG = 1;

    /**
     * 简体
     */
    public static final int SIMPLE = 2;

    private static final int NUM_OF_CONVERTERS = 3;
    private static final ChineseConverterHelper[] CONVERTERS = new ChineseConverterHelper[NUM_OF_CONVERTERS];
    private static final String[] PROPERTY_FILES = new String[NUM_OF_CONVERTERS];

    static {
        // 台湾
        PROPERTY_FILES[TAIWAN] = "fontlib/CHT-TWN.properties";
        // 香港
        PROPERTY_FILES[HONGKONG] = "fontlib/CHT-HK.properties";
        // 简体
        PROPERTY_FILES[SIMPLE] = "fontlib/CHS-CN.properties";
    }

    public static void main(String[] args) {
        String str = "汇川路";
        // 转台湾繁体
        String convert = ChineseConverterHelper.convert(str, ChineseConverterHelper.TAIWAN);
        System.out.println(convert);

        // 转香港繁体
        convert = ChineseConverterHelper.convert(str, ChineseConverterHelper.HONGKONG);
        System.out.println(convert);

        // 繁体转简体
        String convert2 = ChineseConverterHelper.convert("匯川路", ChineseConverterHelper.SIMPLE);
        System.out.println(convert2);
    }

    /**
     * 获取转换器
     *
     * @param converterType 0 for traditional and 1 for simplified
     * @return
     */
    public static ChineseConverterHelper getInstance(int converterType) {
        if (converterType >= 0 && converterType < NUM_OF_CONVERTERS) {
            if (CONVERTERS[converterType] == null) {
                synchronized (ChineseConverterHelper.class) {
                    if (CONVERTERS[converterType] == null) {
                        CONVERTERS[converterType] = new ChineseConverterHelper(
                                PROPERTY_FILES[converterType]);
                    }
                }
            }
            return CONVERTERS[converterType];
        } else {
            return null;
        }
    }

    /**
     * 转换对应字体
     *
     * @param text
     * @param converterType 0 for traditional and 1 for simplified
     * @return
     */
    public static String convert(String text, int converterType) {
        ChineseConverterHelper instance = getInstance(converterType);

        if (null != instance) {
            return instance.convert(text);
        }

        return null;
    }

    private ChineseConverterHelper(String propertyFile) {

        InputStream is = this.getClass().getClassLoader().getResourceAsStream(propertyFile);

        if (is != null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(is));
                charMap.load(reader);
            } catch (FileNotFoundException e) {
                logger.error("文件找不到", e);
            } catch (IOException e) {
                logger.error("加载配置文件数据失败", e);
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                    is.close();
                } catch (IOException e) {
                    logger.error("关闭流异常", e);
                }
            }
        }

        initializeHelper();
    }

    @SuppressWarnings("rawtypes")
    private void initializeHelper() {
        Map<String, Integer> stringPossibilities = new HashMap<String, Integer>();
        Iterator iter = charMap.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            if (key.length() >= 1) {
                for (int i = 0; i < (key.length()); i++) {
                    String keySubstring = key.substring(0, i + 1);
                    if (stringPossibilities.containsKey(keySubstring)) {
                        Integer integer = (Integer) (stringPossibilities
                                .get(keySubstring));
                        stringPossibilities.put(keySubstring, integer + 1);
                    } else {
                        stringPossibilities.put(keySubstring, 1);
                    }
                }
            }
        }
        iter = stringPossibilities.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            if ((Integer) (stringPossibilities.get(key)) > 1) {
                conflictingSets.add(key);
            }
        }
    }

    public String convert(String in) {
        StringBuilder outString = new StringBuilder();
        StringBuilder stackString = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            String key = "" + c;
            stackString.append(key);
            if (conflictingSets.contains(stackString.toString())) {
            } else if (charMap.containsKey(stackString.toString())) {
                outString.append(charMap.get(stackString.toString()));
                stackString.setLength(0);
            } else {
                CharSequence sequence = stackString.subSequence(0,
                        stackString.length() - 1);
                stackString.delete(0, stackString.length() - 1);
                flushStack(outString, new StringBuilder(sequence));
            }
        }
        flushStack(outString, stackString);
        return outString.toString();
    }

    private void flushStack(StringBuilder outString, StringBuilder stackString) {
        while (stackString.length() > 0) {
            if (charMap.containsKey(stackString.toString())) {
                outString.append(charMap.get(stackString.toString()));
                stackString.setLength(0);
            } else {
                outString.append("").append(stackString.charAt(0));
                stackString.delete(0, 1);
            }
        }
    }

    String parseOneChar(String c) {
        if (charMap.containsKey(c)) {
            return (String) charMap.get(c);

        }
        return c;
    }
}
