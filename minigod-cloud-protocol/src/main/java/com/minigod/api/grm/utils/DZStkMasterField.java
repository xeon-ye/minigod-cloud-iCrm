package com.minigod.api.grm.utils;

import com.minigod.api.grm.utils.EStkType;
import com.minigod.api.grm.utils.ESubStkType;
import com.minigod.api.quotmonitor.vo.enums.EMarket;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by CaiJianbo on 2016/4/30 18:48.
 * minigod
 */
public class DZStkMasterField {

    public static final Map<Integer, EStkType> dzMktCodeToStkType;
    public static final Map<Integer, ESubStkType> dzMktCodeToSubStkType;
    public static final Map<Integer, EMarket> dzMktCodeToEMarket;


    static {
        dzMktCodeToStkType = new HashMap<>();
        dzMktCodeToSubStkType = new HashMap<>();
        //港股
        dzMktCodeToStkType.put(Market.CODE_HKSE_STOCK, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_HKSE_CBBC, EStkType.CBBC);
        dzMktCodeToStkType.put(Market.CODE_HKSE_EFF, EStkType.FUND);
        dzMktCodeToStkType.put(Market.CODE_HKSE_WARRANT, EStkType.WARRANT);
        dzMktCodeToStkType.put(Market.CODE_HKSE_INDEX, EStkType.INDEX);

        dzMktCodeToSubStkType.put(Market.CODE_HKSE_EFF, ESubStkType.HK_FUND_ETF);
        dzMktCodeToSubStkType.put(Market.CODE_HKSE_CBBC, ESubStkType.HK_OTHER_CBBC);
        dzMktCodeToSubStkType.put(Market.CODE_HKSE_STOCK, ESubStkType.HK_OTHER_STOCK);
        dzMktCodeToSubStkType.put(Market.CODE_HKSE_WARRANT, ESubStkType.HK_OTHER_WARRANT);
        dzMktCodeToSubStkType.put(Market.CODE_HKSE_INDEX, ESubStkType.HK_INDEX);
        //AB股
        dzMktCodeToStkType.put(Market.CODE_SHANGHAI_A, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_SHANGHAI_B, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_SHANGHAI_INDEX, EStkType.INDEX);
        dzMktCodeToStkType.put(Market.CODE_SHENZHEN_A, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_SHENZHEN_B, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_SHENZHEN_CYB, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_SHENZHEN_QYB, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_SHENZHENI_INDEX, EStkType.INDEX);

        dzMktCodeToSubStkType.put(Market.CODE_SHANGHAI_A, ESubStkType.SH_SHARE_A);
        dzMktCodeToSubStkType.put(Market.CODE_SHANGHAI_B, ESubStkType.SH_SHARE_B);
        dzMktCodeToSubStkType.put(Market.CODE_SHANGHAI_INDEX, ESubStkType.SH_SHARE_OTHER);
        dzMktCodeToSubStkType.put(Market.CODE_SHENZHEN_A, ESubStkType.SZ_SHARE_A);
        dzMktCodeToSubStkType.put(Market.CODE_SHENZHEN_B, ESubStkType.SZ_SHARE_B);
        dzMktCodeToSubStkType.put(Market.CODE_SHENZHEN_CYB, ESubStkType.SZ_SHARE_CYB);
        dzMktCodeToSubStkType.put(Market.CODE_SHENZHEN_QYB, ESubStkType.SZ_SHARE_QYB);
        dzMktCodeToSubStkType.put(Market.CODE_SHENZHENI_INDEX, ESubStkType.SZ_INDEX_SHARE);

        //美股
        dzMktCodeToStkType.put(Market.CODE_US_STOCK, EStkType.STOCK);
        dzMktCodeToStkType.put(Market.CODE_US_IDX, EStkType.INDEX);
        dzMktCodeToSubStkType.put(Market.CODE_US_STOCK, ESubStkType.US_STOCK);
        dzMktCodeToSubStkType.put(Market.CODE_US_IDX, ESubStkType.US_INDEX);

        dzMktCodeToEMarket = new HashMap<>();
        dzMktCodeToEMarket.put(BigMarket.CODE_HONGKONG,EMarket.HK);
        dzMktCodeToEMarket.put(BigMarket.CODE_SHANGHAI,EMarket.SH);
        dzMktCodeToEMarket.put(BigMarket.CODE_SHENZHEN,EMarket.SZ);
        dzMktCodeToEMarket.put(BigMarket.CODE_US_STOCK,EMarket.US);
    }

    public static class NodeName {
        public static final String NODE_BIG_MARKET = "BigMarket";
        public static final String NOD_MARKET = "Market";
        public static final String NOD_SYM = "Sym";
    }

    public static class Sym {
        public static final String FIELD_MARKET = "M";
        public static final String FIELD_CODE = "C";
        public static final String FIELD_DATA_CODE = "DC";
        public static final String FIELD_CONTRACT_CODE = "TC";
        public static final String FIELD_SIMP_NAME = "N";
        public static final String FIELD_SHORT_SIMP_NAME = "SN";
        public static final String FIELD_TRAD_NAME = "TW";
        public static final String FIELD_SHORT_TRAD_NAME = "TWS";
        public static final String FIELD_ENG_NAME = "En";
        public static final String FIELD_SHORT_ENG_NAME = "EnS";
        public static final String FIELD_DECI_NUM = "Di";

        public static final String FIELD_CURRENCY_CODE = "CC";
        public static final String FIELD_SHORT_SELL = "SS";
        public static final String FIELD_SUSPENSION = "Sus";
        public static final String FIELD_TEST_STOCK = "TS";
        public static final String FIELD_SPREAD_TABLE_CODE = "SPC";
        public static final String FIELD_INSTRUMENT_CODE = "Ins";
        public static final String FIELD_EXPIRE_DATE = "ED";
    }

    public static class BigMarket {
        public static final String FIELD_BIG_MARKET_CODE = "Code";
        public static final String FIELD_BIG_MARKET_NAME = "Name";

        public static final Integer CODE_SHANGHAI = 0;
        public static final Integer CODE_SHENZHEN = 1;
        public static final Integer CODE_HONGKONG = 2;
        public static final Integer CODE_A_H = 20;
        public static final Integer CODE_GLOAB_INDEX = 30;
        public static final Integer CODE_US_STOCK = 40;
        public static final Integer CODE_CST = 41;
    }



    public static class Market {
        public static final String FIELD_BIG_MARKET = "BigMarket";
        public static final String FIELD_MARKET_CODE = "Code";
        public static final String FIELD_MARKET_ENG_NAME = "EnName";
        public static final String FIELD_MARKET_CHN_NAME = "CnName";
        public static final String FIELD_SEND_MARKET = "SendMarket";
        public static final String FIELD_TIMZ_ZONE = "TimeZone";
        public static final String FIELD_BTIME = "BTime";
        public static final String FIELD_ETIME = "ETime";
        public static final String FIELD_ALL_DAY_TRAD = "AllDayTrade";
        public static final String FIELD_SYM_TYPE = "SymType";
        public static final String FIELD_AVG_CALC_TYPE = "AvgCalcType";
        public static final String FIELD_TRADE_CALC_TYPE = "TradeCalcType";
        public static final String FIELD_ORDER_TYPE = "OrderType";
        public static final String FIELD_SHOW_UNIT = "ShowUnit";
        public static final String FIELD_DECI = "Deci";
        public static final String FIELD_ADD_SYM_ORDER = "AddSymOrder";
        public static final String FIELD_MASK = "Mask";
        public static final String FIELD_TRADE_TIME = "TradeTime";


        public static final Integer CODE_SHANGHAI_A = 1;
        public static final Integer CODE_SHANGHAI_B = 2;
        public static final Integer CODE_SHANGHAI_INDEX = 0;

        public static final Integer CODE_SHENZHENI_INDEX = 1000;
        public static final Integer CODE_SHENZHEN_A = 1001;
        public static final Integer CODE_SHENZHEN_B = 1002;
        public static final Integer CODE_SHENZHEN_QYB = 1004;
        public static final Integer CODE_SHENZHEN_CYB = 1008;

        public static final Integer CODE_HKSE_EFF = 2000;
        public static final Integer CODE_HKSE_STOCK = 2002;
        public static final Integer CODE_HKSE_WARRANT = 2003;
        public static final Integer CODE_HKSE_CBBC = 2004;
        public static final Integer CODE_HKSE_INDEX = 2005;

        public static final Integer CODE_US_STOCK = 40000;
        public static final Integer CODE_US_IDX = 30000;


    }

    public static class IndexMktCode {
        public static final Set<Integer> indexMktCodes;

        static {
            indexMktCodes = new HashSet<>();
            indexMktCodes.add(0); //上证指数
            indexMktCodes.add(1000); //深圳指数
            indexMktCodes.add(2005); //香港指数
            indexMktCodes.add(30000); //美洲指数
        }
    }

    public static final Set<Integer> hkStkMktCode;

    static {
        hkStkMktCode = new HashSet<>();
        hkStkMktCode.add(Market.CODE_HKSE_EFF);
        hkStkMktCode.add(Market.CODE_HKSE_STOCK);
        hkStkMktCode.add(Market.CODE_HKSE_WARRANT);
        hkStkMktCode.add(Market.CODE_HKSE_CBBC);
        hkStkMktCode.add(Market.CODE_HKSE_INDEX);
    }

    public static final Set<Integer> shStkMktCode;

    static {
        shStkMktCode = new HashSet<>();
        shStkMktCode.add(Market.CODE_SHANGHAI_A);
        shStkMktCode.add(Market.CODE_SHANGHAI_B);
        shStkMktCode.add(Market.CODE_SHANGHAI_INDEX);
    }

    public static final Set<Integer> szStkMktCode;

    static {
        szStkMktCode = new HashSet<>();
        szStkMktCode.add(Market.CODE_SHENZHENI_INDEX);
        szStkMktCode.add(Market.CODE_SHENZHEN_A);
        szStkMktCode.add(Market.CODE_SHENZHEN_B);
        szStkMktCode.add(Market.CODE_SHENZHEN_QYB);
        szStkMktCode.add(Market.CODE_SHENZHEN_CYB);
    }

    public static String formatToAssetId(String stockCode,Integer dzMarketCode,String mktCode){
        if(StringUtils.isNotEmpty(stockCode)){
            if(IndexMktCode.indexMktCodes.contains(dzMarketCode)){
                return new StringBuilder().append(stockCode).append(".").append("IDX").append(".").append(mktCode).toString();
            }
            else
                return new StringBuilder().append(stockCode).append(".").append(mktCode).toString();
        }
        return stockCode;
    }
}
