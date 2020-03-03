package com.minigod.api.grm.utils;

/**
 * Created by CaiJianbo on 2016/5/3 13:29.
 * 证券分类子类
 * minigod
 */
public enum ESubStkType {
    SZ_SHARE_A(0),
    SZ_SHARE_B(1),
    SZ_SHARE_OTHER_TYPE(2), //深圳其他股票
    SZ_INDEX_SHARE(3), //深圳股票指数
    SZ_INDEX_FUND(4), //深圳基金指数
    SZ_SHARE_CYB(5), // APP端定义为：深圳复合指数
    SZ_SHARE_QYB(6), // APP端定义为：深圳债券指数
    SZ_INDEX_OTHER(7), //深圳其他指数
    SZ_FUND_ETF(8),
    SZ_FUND_LOF(9),
    //契约性封闭式
    SZ_FUND_CLOSE_END(10),
    //契约型开放式
    SZ_FUND_OPEN_END(11),
    SZ_FUND_OTHER_TYPE(12),
    //中小企业私募债
    SZ_BOND_ENTERPRISE_PRIVATE(13),
    //中小企业集合私募债
    SZ_BOND_ENTERPRICE_COLLECTION_PRIVATE(14),
    //企业债
    SZ_BOND_ENTERPRISE(15),
    //可交换债券债
    SZ_BOND_EXCHANGEABLE(16),
    //国债
    SZ_BOND_NATIONAL(17),
    //地方债
    SZ_BOND_LOCAL(18),
    //非银行金融债
    SZ_BOND_NON_BANK_FINANCIAL(19),
    //回购债券
    SZ_BOND_BUYBACK(20),
    //其他债券
    SZ_BOND_OTHER_TYPE(21),

    //买断式回购
    SZ_BUYOUT_REPO(25),
    //抵押式回购
    SZ_BUYOUT_PLEDGED(26),
    //其他类型回购
    SZ_BUYOUT_OTHER_TYPE(27),


    SH_SHARE_A(28),
    SH_SHARE_B(29),
    SH_SHARE_OTHER(30),
    SH_INDEX_SHARE(31),
    SH_INDEX_FUND(32),
    SH_INDEX_OTHER(35),
    SH_FUND_ETF(36),
    SH_FUND_LOF(37),
    //契约性封闭式
    SH_FUND_CLOSE_END(38),
    SH_FUND_OPEN_END(39),
    SH_FUND_OTHER(40),
    //中小企业私募债
    SH_BOND_ENTERPRISE_PRIVATE(41),
    //中小企业集合私募债
    SH_BOND_ENTERPRICE_COLLECTION_PRIVATE(42),
    //可交换债券债
    SH_BOND_EXCHANGEABLE(44),
    //国债
    SH_BOND_NATIONAL(45),

    //地方债
    SH_BOND_LOCAL(46),
    //非银行金融债
    SH_BOND_NON_BANK_FINANCIAL(47),
    SH_BOND_BUY_BACK(48),
    SH_BOND_OTHER_TYPE(49),
    SH_ENTERPRISE_BOND(43),
    SH_BUYOUT_REPO(53),
    SH_PLEDGED_REPO(54),
    //其他类型回购
    SH_BUYOUT_OTHER_TYPE(55),

    HK_SHARE_MAIN_BOARD(60),
    HK_SHARE_GEM(61),
    HK_SHARE_OTHER_TYPE(62),
    //预托政权
    HK_SHARE_DEPOSITARY_RECP(63),
    HK_OTHER_STOCK(64),
    HK_INDEX(70),
    //恒生指数
    HK_INDEX_HANGSENG(71),
    HK_FUND_ETF(80),
    HK_OTHER_WARRANT(90),
    //认购
    HK_CALL_WARRANT(91),
    //认沽
    HK_PUT_WARRANT(92),
    HK_OTHER_CBBC(100),
    //牛证
    HK_BULL_CBBC(101),
    //熊证
    HK_BEAR_CBBC(102),

    HK_BOND(110),

    US_STOCK(120),
    US_INDEX(130);
    private int subType;

    private ESubStkType(int subType){
        this.subType = subType;
    }

    public int getSubType(){
        return this.subType;
    }
}
