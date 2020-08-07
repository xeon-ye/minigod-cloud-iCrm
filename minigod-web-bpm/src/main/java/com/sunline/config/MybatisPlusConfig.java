package com.sunline.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Maps;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DynamicDataSource;
import com.sunline.mutidatasource.config.DruidProperties;
import com.sunline.mutidatasource.config.SlaveDataSourceProp;
//import com.sunline.mutidatasource.config.SunlineDataSourceProp;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

/**
 * MybatisPlus配置
 *
 * @author stylefeng
 * @Date 2017/5/20 21:58
 */
@Configuration
// 由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@EnableTransactionManagement(order = 2)
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;
    @Autowired
    SlaveDataSourceProp slaveDataSourceProp;
//    @Autowired
//    SunlineDataSourceProp sunlineDataSourceProp;

    /**
     * 主数据源
     */
    private DruidDataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 从数据源
     */
    private DruidDataSource slaveDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        slaveDataSourceProp.config(dataSource);
        return dataSource;
    }

    /**
     * sunline数据源
     */
    private DruidDataSource sunlineDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
//        sunlineDataSourceProp.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "master", name = "muti-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource() {
        return masterDataSource();
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "master", name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource() {

        DruidDataSource masterDataSource = masterDataSource();
        DruidDataSource slaveDataSource = slaveDataSource();
//        DruidDataSource sunlineDataSource = sunlineDataSource();

        try {
            masterDataSource.init();
            slaveDataSource.init();
//            sunlineDataSource.init();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put(DataSourceEnum.DATA_SOURCE_MASTER, masterDataSource);
        hashMap.put(DataSourceEnum.DATA_SOURCE_SALVE, slaveDataSource);
//        hashMap.put(DataSourceEnum.DATA_SOURCE_SUNLINE, sunlineDataSource);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        return dynamicDataSource;
    }

    @Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
//        p.setProperty("dialect", "mysql");
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

//    /**
//     * mybatis-plus分页插件
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
//
//    /**
//     * 数据范围mybatis插件
//     */
//    @Bean
//    public DataScopeInterceptor dataScopeInterceptor() {
//        return new DataScopeInterceptor();
//    }
//
//
//    /**
//     * 乐观锁mybatis插件
//     */
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }

}
