package com.sunline.mutidatasource;

/**
 * datasource的上下文
 *
 * @author
 * @date
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> currentLookupKey = new ThreadLocal<String>();

//    /**
//     * 设置数据源类型
//     *
//     * @param dataSourceType 数据库类型
//     */
//    public static void setDataSourceType(String dataSourceType) {
//        currentLookupKey.set(dataSourceType);
//    }

    /**
     * 设置数据源类型
     *
     * @param dataSourceType
     * @return
     */
    public static String setDataSourceType(String dataSourceType) {
        String oldLookupKey = currentLookupKey.get();
        if (dataSourceType != null) {
            currentLookupKey.set(dataSourceType);
        } else {
            currentLookupKey.remove();
        }

        return oldLookupKey;
    }

    /**
     * 获取数据源类型
     */
    public static String getDataSourceType() {
        return currentLookupKey.get();
    }

    /**
     * 清除数据源类型
     */
    public static void clearDataSourceType() {
        currentLookupKey.remove();
    }
}
