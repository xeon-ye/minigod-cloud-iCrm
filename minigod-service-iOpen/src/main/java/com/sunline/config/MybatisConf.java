package com.sunline.config;//package com.sunline.config;
//
//import com.sunline.modules.common.page.PageHelper;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Properties;
//
//@Configuration
//public class MybatisConf {
//        @Bean
//        public PageHelper pageHelper() {
//           System.out.println("MyBatisConfiguration.pageHelper()");
//            PageHelper pageHelper = new PageHelper();
//            Properties p = new Properties();
////            p.setProperty("dialect", "mysql");
//            p.setProperty("offsetAsPageNum", "tru/**/e");
//            p.setProperty("rowBoundsWithCount", "true");
//            p.setProperty("reasonable", "true");
//            pageHelper.setProperties(p);
//            return pageHelper;
//        }
//}