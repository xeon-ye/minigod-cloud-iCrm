package com.sunline.modules.account.online.helper;

import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2017/10/27
 * @description
 * @email justbelyf@gmail.com
 */
public class IdCardHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(IdCardHelper.class);
    private static final int INDEX_NOT_FOUND = -1;
    // 省会城市映射
    private static Map<String, String> provincialCapitalMap;
    // 身份证地址的自治区关键字
    private static List<String> autonomousRegionsKeywords;


    /**
     * 获取省份
     *
     * @param fullAddress
     * @return
     */
    public static String getProvinceName(String fullAddress) {
        JSONObject addressJson = idCardAddressSplit(fullAddress);
        if (null == addressJson || null == addressJson.get("provinceName")) {
            return "";
        }

        return addressJson.get("provinceName").toString();
    }


    /**
     * 获取城市
     *
     * @param fullAddress
     * @return
     */
    public static String getCityName(String fullAddress) {
        JSONObject addressJson = idCardAddressSplit(fullAddress);
        if (null == addressJson) {
            return "";
        }

        if (null != addressJson.get("cityName") && StringUtils.isNoneBlank(addressJson.get("cityName").toString())) {
            return addressJson.get("cityName").toString();
        }else {
            if (null != addressJson.get("countyName") && StringUtils.isNoneBlank(addressJson.get("countyName").toString())) {
                return addressJson.get("countyName").toString();
            }
        }

        return "";
    }


    /**
     * 获取区/县/镇
     *
     * @param fullAddress
     * @return
     */
    public static String getCountyName(String fullAddress) {
        JSONObject addressJson = idCardAddressSplit(fullAddress);
        if (null == addressJson) {
            return "";
        }
        if (null != addressJson.get("countyName")) {
            return addressJson.get("countyName").toString();
        }

        return addressJson.get("cityName").toString();
    }


    /**
     * 获取具体街道
     *
     * @param fullAddress
     * @return
     */
    public static String getAddressDetailName(String fullAddress) {
        JSONObject addressJson = idCardAddressSplit(fullAddress);
        if (null == addressJson || null == addressJson.get("detailAddressName")) {
            return "";
        }

        return addressJson.get("detailAddressName").toString();
    }


    /**
     * 身份证地址拆分
     * 身份证地址规则:直辖市的省名和市民一致，省会城市不含省名,县级单位不含市名
     *
     * @param fullAddress
     */
    private static JSONObject idCardAddressSplit(String fullAddress) {
        JSONObject addressJson = new JSONObject();
        // 去空格后转为简体字
        String provinceName = "";
        String cityName = "";
        String countyName = "";
        String detailAddressName="";

        try {
            String tempFullAddress = ChineseHelper.convertToSimplifiedChinese(fullAddress.trim());
            int provinceEndIndex = getProvinceEndIndex(tempFullAddress);
            if (INDEX_NOT_FOUND != provinceEndIndex) {
                provinceName = tempFullAddress.substring(0, provinceEndIndex + 1);
                tempFullAddress = updateAddress(provinceEndIndex, tempFullAddress);
            }

            int cityEndIndex = tempFullAddress.indexOf("市");
            if (INDEX_NOT_FOUND != cityEndIndex) {
                cityName = tempFullAddress.substring(0, cityEndIndex + 1);
                tempFullAddress = updateAddress(cityEndIndex, tempFullAddress);
//                if (StringUtils.isBlank(provinceName)) {
//                    provinceName = getProvinceNameByProvincialCapitalName(cityName);
//                }
            }

            int countyEndIndex = INDEX_NOT_FOUND;
            List<String> countyKeywordSort = Lists.newLinkedList();
            // 城市地址:XXX市XXX区,非城市地址:XXX县/XXX镇
            if (StringUtils.isNoneBlank(cityName)) {
                countyKeywordSort.add("区");
                countyKeywordSort.add("县");
                countyKeywordSort.add("镇");
            } else {
                countyKeywordSort.add("县");
                countyKeywordSort.add("镇");
                countyKeywordSort.add("区");
            }
            for (int i = 0; i < countyKeywordSort.size(); i++) {
                countyEndIndex = tempFullAddress.indexOf(countyKeywordSort.get(i));
                if (INDEX_NOT_FOUND != countyEndIndex) {
                    break;
                }
            }

            if (INDEX_NOT_FOUND != countyEndIndex) {
                countyName = tempFullAddress.substring(0, countyEndIndex + 1);
                tempFullAddress = updateAddress(countyEndIndex, tempFullAddress);
            }
            if (StringUtils.isNoneBlank(countyName) && StringUtils.isBlank(cityName)) {
                cityName = countyName;
            }

            detailAddressName = tempFullAddress;

            addressJson.put("provinceName", provinceName);
            addressJson.put("cityName", cityName);
            addressJson.put("countyName", countyName);
            addressJson.put("detailAddressName", detailAddressName);
        } catch (Exception e) {
            LOGGER.error("身份证地址拆分异常", e);
        }

        return addressJson;
    }


    /**
     * 获取身份证身份的索引
     *
     * @param fullAddress
     * @return
     */
    private static int getProvinceEndIndex(String fullAddress) {
        int provinceEndIndex = INDEX_NOT_FOUND;
        for (String autonomousRegionsKeyword : autonomousRegionsKeywords) {
            if (fullAddress.startsWith(autonomousRegionsKeyword)) {
                provinceEndIndex = autonomousRegionsKeyword.length() - 1;
                break;
            }
        }
        if (INDEX_NOT_FOUND == provinceEndIndex) {
            provinceEndIndex = fullAddress.indexOf("省");
        }

        return provinceEndIndex;
    }


    /**
     * 更新地址，每次处理后都需要将已处理的数据删除
     *
     * @param index
     * @param oldAddress
     * @return
     */
    private static String updateAddress(int index, String oldAddress) {
        return oldAddress.substring(index + 1, oldAddress.length());
    }


    /**
     * 获取姓氏
     *
     * @param fullName
     * @return
     */
    public static String getFamilyName(String fullName) {
        JSONObject nameJson = idCardNameSplit(fullName);
        if (null == nameJson || null == nameJson.get("familyName")) {
            return "";
        }

        return nameJson.get("familyName").toString();
    }


    /**
     * 获取名字
     *
     * @param fullName
     * @return
     */
    public static String getGivenName(String fullName) {
        JSONObject nameJson = idCardNameSplit(fullName);
        if (null == nameJson || null == nameJson.get("givenName")) {
            return "";
        }

        return nameJson.get("givenName").toString();
    }


    /**
     * 姓名拆分，2个和3个字的姓名，取第一个为姓氏，超过3个字的名字取前2个为姓氏。姓氏后面的为名字
     *
     * @param fullName
     * @return
     */
    private static JSONObject idCardNameSplit(String fullName) {
        JSONObject nameJson = new JSONObject();
        try {
            // 去空格后转为简体字
            fullName = ChineseHelper.convertToSimplifiedChinese(fullName.trim());
            if (StringUtils.isBlank(fullName) || fullName.length() < 1) {
                return nameJson;
            }

            int splitIndex;
            int length = fullName.length();

            if (1 < length && 3 >= length) {
                splitIndex = 1;
            } else {
                splitIndex = 2;
            }

            String familyName = fullName.substring(0, splitIndex);
            String givenName = fullName.substring(splitIndex);

            nameJson.put("familyName", familyName);
            nameJson.put("givenName", givenName);
        } catch (Exception e) {
            LOGGER.error("姓名拆分异常", e);
        }

        return nameJson;
    }


    /**
     * 获取省会城市的省份名称
     *
     * @param cityName
     * @return
     */
    public static String getProvinceNameByProvincialCapitalName(String cityName) {

        return provincialCapitalMap.get(cityName);
    }


    static {
        provincialCapitalMap = Maps.newHashMap();
        provincialCapitalMap.put("北京市", "");
        provincialCapitalMap.put("天津市", "");
        provincialCapitalMap.put("上海市", "");
        provincialCapitalMap.put("重庆市", "");
        provincialCapitalMap.put("石家庄市", "河北省");
        provincialCapitalMap.put("郑州市", "河南省");
        provincialCapitalMap.put("武汉市", "湖北省");
        provincialCapitalMap.put("长沙市", "湖南省");
        provincialCapitalMap.put("南京市", "江苏省");
        provincialCapitalMap.put("南昌市", "江西省");
        provincialCapitalMap.put("沈阳市", "辽宁省");
        provincialCapitalMap.put("长春市", "吉林省");
        provincialCapitalMap.put("哈尔滨市", "黑龙江省");
        provincialCapitalMap.put("西安市", "陕西省");
        provincialCapitalMap.put("太原市", "山西省");
        provincialCapitalMap.put("济南市", "山东省");
        provincialCapitalMap.put("成都市", "四川省");
        provincialCapitalMap.put("西宁市", "青海省");
        provincialCapitalMap.put("合肥市", "安徽省");
        provincialCapitalMap.put("海口市", "海南省");
        provincialCapitalMap.put("广州市", "广东省");
        provincialCapitalMap.put("贵阳市", "贵州省");
        provincialCapitalMap.put("杭州市", "浙江省");
        provincialCapitalMap.put("福州市", "福建省");
        provincialCapitalMap.put("台北市", "台湾省");
        provincialCapitalMap.put("兰州市", "甘肃省");
        provincialCapitalMap.put("昆明市", "云南省");
        provincialCapitalMap.put("拉萨市", "西藏");
        provincialCapitalMap.put("银川市", "宁夏");
        provincialCapitalMap.put("南宁市", "广西");
        provincialCapitalMap.put("乌鲁木齐市", "新疆");
        provincialCapitalMap.put("呼和浩特市", "内蒙古");

        autonomousRegionsKeywords = Lists.newArrayList();
        autonomousRegionsKeywords.add("西藏");
        autonomousRegionsKeywords.add("广西");
        autonomousRegionsKeywords.add("宁夏");
        autonomousRegionsKeywords.add("新疆");
        autonomousRegionsKeywords.add("内蒙古");
    }

}
